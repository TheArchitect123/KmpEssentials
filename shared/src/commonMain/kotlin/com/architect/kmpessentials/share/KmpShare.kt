package com.architect.kmpessentials.share

expect class KmpShare {
    companion object{
        fun shareTextWithAnyApp(text: String, optionalTitle: String = "")
        fun shareFileWithAnyApp(filePath: String, optionalTitle: String = "")
    }
}