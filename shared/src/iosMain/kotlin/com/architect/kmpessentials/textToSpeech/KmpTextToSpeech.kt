package com.architect.kmpessentials.textToSpeech

import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioEngine
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryOptionDefaultToSpeaker
import platform.AVFAudio.AVAudioSessionCategoryOptionDuckOthers
import platform.AVFAudio.AVAudioSessionCategoryPlayAndRecord
import platform.AVFAudio.AVAudioSessionCategoryRecord
import platform.AVFAudio.AVAudioSessionMode
import platform.AVFAudio.AVAudioSessionModeMeasurement
import platform.AVFAudio.AVAudioSessionSetActiveOptionNotifyOthersOnDeactivation
import platform.AVFAudio.AVSpeechSynthesisVoice
import platform.AVFAudio.AVSpeechSynthesizer
import platform.AVFAudio.AVSpeechUtterance
import platform.AVFAudio.setActive
import platform.Speech.SFSpeechAudioBufferRecognitionRequest
import platform.Speech.SFSpeechRecognitionTask
import platform.Speech.SFSpeechRecognizer
import platform.Speech.SFSpeechURLRecognitionRequest

actual class KmpTextToSpeech {
    actual companion object {
//        private val audioEngine: AVAudioEngine?
//        private val request: SFSpeechAudioBufferRecognitionRequest?
//        private val task: SFSpeechRecognitionTask = SF
//        private val recognizer: SFSpeechRecognizer = SFSpeechRecognizer()
//
//        @OptIn(ExperimentalForeignApi::class)
//        private fun prepareSpeechEngine() : Pair<AVAudioEngine, SFSpeechAudioBufferRecognitionRequest> {
//            val audioEngine = AVAudioEngine()
//            val request = SFSpeechAudioBufferRecognitionRequest()
//            request.shouldReportPartialResults = true
//
//            val audioSession = AVAudioSession.sharedInstance()
//            audioSession.setCategory(AVAudioSessionCategoryPlayAndRecord)
//            audioSession.setActive(true, AVAudioSessionSetActiveOptionNotifyOthersOnDeactivation)
//
//
//        }
//
//
        actual fun convertSpeechToText(response: SpeechActionResult) {
            val speechHandler = SFSpeechRecognizer()
            val request = SFSpeechURLRecognitionRequest()


        }

        actual fun convertTextToSpeech(message: String) {
            KmpMainThread.runViaMainThread {
                val speechSynth = AVSpeechSynthesizer()
                val textToSpeak = AVSpeechUtterance(message)
                speechSynth.speakUtterance(textToSpeak)
            }
        }
    }
}