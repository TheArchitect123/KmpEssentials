package com.architect.kmpessentials.textToSpeech

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo.Companion.getRunningPlatform
import com.architect.kmpessentials.logging.KmpLogging
import java.io.File
import javax.sound.sampled.AudioFileFormat.Type.WAVE
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

actual class KmpTextToSpeech {
    actual companion object {

        actual fun stopSpeechEngine() {
        }

        actual fun convertSpeechToText(response: SpeechActionResult) {
            val audioFormat = AudioFormat(16000F, 16, 1, true, true)
            val file = File("speech_generated.wav")
            val microphone = AudioSystem.getTargetDataLine(audioFormat)
            microphone.open(audioFormat)
            microphone.start()

            Thread {
                AudioSystem.write(AudioInputStream(microphone), WAVE, file)
            }.start()

            readLine()
            microphone.stop()
            microphone.close()

            println("Recording saved: ${file.absolutePath}")
            processRecordedAudioFile(response)
        }

        private fun processRecordedAudioFile(response: (String) -> Unit) {
            when (getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    val scriptContent = """
        Dim speech, result
        Set speech = CreateObject("SAPI.SpVoice")
        Set recognizer = CreateObject("SAPI.SpInProcRecoContext")
        Set grammar = recognizer.CreateGrammar(1)
        grammar.DictationSetState(1)
        
        WScript.Echo "Say something now..."
        Set result = recognizer.Recognition(1)
        WScript.Echo result.PhraseInfo.GetText
    """.trimIndent()

                    try {
                        val scriptFile = File.createTempFile("speech_recognition", ".vbs")
                        scriptFile.writeText(scriptContent)

                        val process = ProcessBuilder("wscript", scriptFile.absolutePath).start()

                        val recognizedText = process.inputStream.bufferedReader().readText()
                            .trim() // once output speech is done, delete the temp file
                        response(recognizedText)
                        scriptFile.delete()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", e.stackTraceToString()
                        )
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        val process = ProcessBuilder(
                            "sh",
                            "-c",
                            "say 'Recording done'; dictation 'recorded_audio.wav'"
                        ).start()
                        response(process.inputStream.bufferedReader().readText())
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", e.stackTraceToString()
                        )
                    }
                }

                else -> {
                    try {
                        val process = ProcessBuilder(
                            "pocketsphinx_continuous",
                            "-infile",
                            "recorded_audio.wav"
                        ).start()
                        response(process.inputStream.bufferedReader().readText())
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", e.stackTraceToString()
                        )
                    }
                }
            }
        }

        actual fun convertTextToSpeech(message: String) {
            when (getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        ProcessBuilder(
                            "powershell",
                            "-Command",
                            "Add-Type –AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('$message')"
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", e.stackTraceToString()
                        )
                    }
                }

                DevicePlatform.MacOS -> ProcessBuilder("say", message).start()
                else -> ProcessBuilder("espeak", message).start()
            }
        }
    }
}