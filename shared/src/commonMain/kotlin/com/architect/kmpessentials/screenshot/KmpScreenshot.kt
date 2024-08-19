package com.architect.kmpessentials.screenshot

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpScreenshot {
    companion object{
        /**
         * Takes a screenshot of your screen, saves to your photo album, and returns the Url
         * @param action returns the Url of the newly generated screenshot
         * @param shareImage prompts users to share the image with any of their applications
         * */
        fun getScreenshot(action: ActionStringParams, shareDialogTitle: String = "", shareImage: Boolean = true) // generates a screenshot from the user's device, and returns the file path of the screenshot,

        fun isSupported(): Boolean
    }
}