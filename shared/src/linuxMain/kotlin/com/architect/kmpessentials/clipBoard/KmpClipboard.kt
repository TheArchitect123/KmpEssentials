package com.architect.kmpessentials.clipBoard

actual class KmpClipboard {
    actual companion object {
        actual fun getTextFromClipboard(): String {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {

        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}