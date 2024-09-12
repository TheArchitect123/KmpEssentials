package com.architect.kmpessentials.textToSpeech

import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVSpeechSynthesizer
import platform.AVFAudio.AVSpeechUtterance

actual class KmpTextToSpeech {
    actual companion object {
        actual fun stopSpeechEngine() {

        }

        // all speech to text, must be done offline, otherwise users will need internet connection for it to work
        actual fun convertSpeechToText(response: SpeechActionResult) {

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