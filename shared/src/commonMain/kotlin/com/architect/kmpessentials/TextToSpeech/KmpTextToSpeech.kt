package com.architect.kmpessentials.TextToSpeech

expect class KmpTextToSpeech {
    companion object{
        fun convertSpeechToText(): String
        fun convertTextToSpeech(message: String)
    }
}