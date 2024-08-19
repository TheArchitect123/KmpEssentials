package com.architect.kmpessentials.clipBoard

/**
 * Use this for copying/fetching texts from your device's clipboard
 * */
expect class KmpClipboard {
    companion object {
        fun getTextFromClipboard(): String
        fun copyTextIntoClipboard(textToCopy: String)
        fun isSupported(): Boolean
    }
}