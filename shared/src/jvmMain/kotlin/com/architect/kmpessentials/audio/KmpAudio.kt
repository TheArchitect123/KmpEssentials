package com.architect.kmpessentials.audio

import com.architect.kmpessentials.internal.ActionStringParams
import java.io.File
import javax.sound.sampled.AudioFileFormat
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine
import javax.sound.sampled.TargetDataLine

actual class KmpAudio {
    actual companion object {
        actual fun playAudioFileWithPath(filePath: String) {
            try {
                val clip = AudioSystem.getClip()
                clip.open(AudioSystem.getAudioInputStream(File(filePath)))
                clip.start()

                // forces thread to wait until the entire clip has finished before closing it
                Thread.sleep(clip.microsecondLength / 1000)

                clip.close()
            } catch (e: Exception) {

            }
        }

        actual fun recordVoiceAndReturnFilePath(actionParams: ActionStringParams) {
            val format = AudioFormat(44100f, 16, 2, true, true)
            val dataLineInfo = DataLine.Info(TargetDataLine::class.java, format)
            val line = AudioSystem.getLine(dataLineInfo) as TargetDataLine

            val outputFile = File("kmp_essentials.wav")

            Thread {
                try {
                    line.open(format)
                    line.start()

                    val audioInputStream = AudioInputStream(line)
                    AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile)

                    line.stop()
                    line.close()

                    actionParams(outputFile.absolutePath)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }.start()
        }
    }
}