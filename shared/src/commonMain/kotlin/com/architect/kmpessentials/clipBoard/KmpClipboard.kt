package com.architect.kmpessentials.clipBoard

import com.architect.kmpessentials.internal.ActionStringParams

/**
 * Use this for copying/fetching texts from your device's clipboard
 * */
expect class KmpClipboard {
    companion object {
        fun getTextFromClipboard(): String
        fun copyTextIntoClipboard(textToCopy: String)
        suspend fun copyTextIntoClipboardAsync(textToCopy: ActionStringParams)
        fun isSupported(): Boolean
    }
}