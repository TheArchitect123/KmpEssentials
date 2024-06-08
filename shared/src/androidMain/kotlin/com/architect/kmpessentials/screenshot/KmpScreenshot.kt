package com.architect.kmpessentials.screenshot

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(): String // generates a screenshot from the user's device, and returns the file path of the screenshot,
        // from the user's media library
        {
            return ""
        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}