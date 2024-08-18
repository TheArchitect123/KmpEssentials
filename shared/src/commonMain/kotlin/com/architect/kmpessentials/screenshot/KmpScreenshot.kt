package com.architect.kmpessentials.screenshot

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpScreenshot {
    companion object{
        fun getScreenshot(action: ActionStringParams, shareDialogTitle: String = "", shareImage: Boolean = true) // generates a screenshot from the user's device, and returns the file path of the screenshot,
        // from the user's media library
        fun isSupported(): Boolean
    }
}