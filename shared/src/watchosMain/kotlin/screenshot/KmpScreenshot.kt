package com.architect.kmpessentials.screenshot

import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(
            action: ActionStringParams,
            shareDialogTitle: String,
            shareImage: Boolean
        ) {

        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}