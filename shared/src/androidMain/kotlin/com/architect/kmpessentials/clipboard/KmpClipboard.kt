package com.architect.kmpessentials.clipBoard

actual class KmpClipboard {
    actual companion object {
        actual fun getTextFromClipboard(): String {
            return ""
        }

        actual fun copyTextIntoClipboard(showToast: Boolean): String {
            return ""
        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}