package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpPromptReview {
    companion object{
        /**
         *  Checks if in app prompts can be invoked
         * */
        fun checkInAppReviewCapability(onResult: (Boolean) -> Unit)

        /**
         *  Prompts the user using the in-app review api.
         *  Internally checks if the user has been prompted. Allows a review only once per month.
         *  optional action to run after user has completed their review
         *  You can present a thank you message
         * */
        fun promptReviewInApp(errorPromptingDialog: ActionStringParams, actionAfterClosing : ActionNoParams? = null)

        /**
         *  Prompts the user with an external dialog that users can then provide for
         * */
        fun promptReviewViaExternal()

        /**
         *  Opens the app store link for the running app
         * */
        fun openAppStoreLink()
    }
}