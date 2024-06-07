package com.architect.kmpessentials.clipBoard

expect class KmpClipboard {
    companion object{
        fun getTextFromClipboard(): String
        fun copyTextIntoClipboard(showToast: Boolean = true): String
        fun isSupported(): Boolean
    }
}