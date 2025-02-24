package com.architect.kmpessentials.clipBoard

import com.architect.kmpessentials.internal.ActionStringParams

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
        actual suspend fun copyTextIntoClipboardAsync(textToCopy: ActionStringParams) {
            textToCopy("")
        }
    }
}