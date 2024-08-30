package com.architect.kmpessentials.textToSpeech

import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioEngine
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryOptionDuckOthers
import platform.AVFAudio.AVAudioSessionCategoryRecord
import platform.AVFAudio.AVAudioSessionModeMeasurement
import platform.AVFAudio.AVSpeechSynthesizer
import platform.AVFAudio.AVSpeechUtterance
import platform.AVFAudio.setActive
import platform.Speech.SFSpeechAudioBufferRecognitionRequest
import platform.Speech.SFSpeechRecognitionTask
import platform.Speech.SFSpeechRecognizer

actual class KmpTextToSpeech {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun stopSpeechEngine() {
            recognitionTask?.cancel()
            recognitionTask = null
            audioEngine.stop()
            audioEngine.inputNode.removeTapOnBus(0u)

            AVAudioSession.sharedInstance().setActive(false, null)
        }

        private var recognitionTask: SFSpeechRecognitionTask? = null
        private val audioEngine = AVAudioEngine()

        // all speech to text, must be done offline, otherwise users will need internet connection for it to work
        @OptIn(ExperimentalForeignApi::class)
        actual fun convertSpeechToText(response: SpeechActionResult) {
            val speechService = SFSpeechRecognizer()
            if (speechService.isAvailable() && KmpPermissionsManager.isPermissionGranted(Permission.Speech)) {
                val recognitionRequest =
                    SFSpeechAudioBufferRecognitionRequest()
                recognitionRequest.setRequiresOnDeviceRecognition(true)

                val inputNode = audioEngine.inputNode
                val audioSession = AVAudioSession.sharedInstance()
                audioSession.setCategory(
                    AVAudioSessionCategoryRecord,
                    AVAudioSessionModeMeasurement,
                    AVAudioSessionCategoryOptionDuckOthers,
                    null
                )

                audioSession.setActive(true, null)

                val recordingFormat = inputNode.outputFormatForBus(0u)
                inputNode.installTapOnBus(0u, 1024u, recordingFormat) { res, error ->

                }

                recognitionTask =
                    speechService.recognitionTaskWithRequest(recognitionRequest) { res, error ->
                        if (res != null && error == null) {
                            response(res.bestTranscription().formattedString)
                        }
                    }

                audioEngine.prepare()
                audioEngine.startAndReturnError(null) // boot audio Engine
            }
        }

        actual fun convertTextToSpeech(message: String) {
            KmpMainThread.runViaMainThread {
                val speechSynth = AVSpeechSynthesizer()
                val textToSpeak = AVSpeechUtterance(string = message)
                speechSynth.speakUtterance(textToSpeak)
            }
        }
    }
}