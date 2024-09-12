package com.architect.kmpessentials.clipBoard

actual class KmpClipboard {
    actual companion object {
        actual fun getTextFromClipboard(): String {
            return ""
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {

        }

        actual fun isSupported(): Boolean {
            return false
        }
    }
}