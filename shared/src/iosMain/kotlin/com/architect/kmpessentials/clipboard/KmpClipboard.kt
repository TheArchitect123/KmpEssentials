package com.architect.kmpessentials.clipBoard

import com.architect.kmpessentials.internal.ActionStringParams
import platform.UIKit.UIPasteboard

actual class KmpClipboard {
    actual companion object {
        actual fun getTextFromClipboard(): String {
            return UIPasteboard.generalPasteboard.string ?: ""
        }

        actual fun isSupported(): Boolean {
            return true
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {
            UIPasteboard.generalPasteboard.setString(textToCopy)
        }

        actual suspend fun copyTextIntoClipboardAsync(textToCopy: ActionStringParams) {
            textToCopy(UIPasteboard.generalPasteboard.string ?: "")
        }
    }
}