package com.architect.kmpessentials.textToSpeech

typealias SpeechActionResult = (String) -> Unit
expect class KmpTextToSpeech {
    companion object{
        fun convertSpeechToText(response: SpeechActionResult)
        fun convertTextToSpeech(message: String)
    }
}