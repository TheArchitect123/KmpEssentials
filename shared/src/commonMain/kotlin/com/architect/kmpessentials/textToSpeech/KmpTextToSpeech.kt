package com.architect.kmpessentials.textToSpeech

expect class KmpTextToSpeech {
    companion object{
        fun convertSpeechToText(): String
        fun convertTextToSpeech(message: String)
    }
}