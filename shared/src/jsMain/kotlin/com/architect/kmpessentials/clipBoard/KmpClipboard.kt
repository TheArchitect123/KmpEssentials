package com.architect.kmpessentials.clipBoard

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.browser.window
import kotlinx.coroutines.await

actual class KmpClipboard {
    actual companion object {
        actual suspend fun copyTextIntoClipboardAsync(textToCopy: ActionStringParams) {
            textToCopy(window.navigator.clipboard.readText().await())
        }

        actual fun getTextFromClipboard(): String {
            return ""
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {
            window.navigator.clipboard.writeText(textToCopy)
        }

        actual fun isSupported(): Boolean {
            return window.navigator.asDynamic().clipboard !== undefined
        }
    }
}