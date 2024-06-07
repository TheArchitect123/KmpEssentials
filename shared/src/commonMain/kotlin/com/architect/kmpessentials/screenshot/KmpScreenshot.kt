package com.architect.kmpessentials.screenshot

expect class KmpScreenshot {
    companion object{
        fun getScreenshot(): String // generates a screenshot from the user's device, and returns the file path of the screenshot,
        // from the user's media library
        fun isSupported(): Boolean
    }
}