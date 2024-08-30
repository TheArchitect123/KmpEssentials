package com.architect.kmpessentials.textToSpeech

typealias SpeechActionResult = (String) -> Unit
expect class KmpTextToSpeech {
    companion object{
        /**
         * Stops the TextToSpeech service from Running
         * */
        fun stopSpeechEngine()

        /**
         * Listens to user's microphone, and converts Speech to Text
         * */
        fun convertSpeechToText(response: SpeechActionResult)

        /**
         * Converts the specified Text into Speech
         * */
        fun convertTextToSpeech(message: String)
    }
}