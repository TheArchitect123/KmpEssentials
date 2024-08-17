package com.architect.kmpessentials.clipBoard

expect class KmpClipboard {
    companion object {
        fun getTextFromClipboard(): String
        fun copyTextIntoClipboard(textToCopy: String)
        fun isSupported(): Boolean
    }
}