package com.architect.kmpessentials.share

expect class KmpShare {
    companion object{
        /**
         * Allows users to choose which app to share the text to
         * */
        fun shareTextWithAnyApp(text: String, optionalTitle: String = "")

        /**
         * Allows users to choose which app to share the file to
         * */
        fun shareFileWithAnyApp(filePath: String, optionalTitle: String = "")
    }
}