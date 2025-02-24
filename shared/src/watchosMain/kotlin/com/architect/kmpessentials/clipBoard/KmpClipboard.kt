package com.architect.kmpessentials.clipBoard

import com.architect.kmpessentials.internal.ActionStringParams

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

        actual suspend fun copyTextIntoClipboardAsync(textToCopy: ActionStringParams) {
            textToCopy("")
        }
    }
}