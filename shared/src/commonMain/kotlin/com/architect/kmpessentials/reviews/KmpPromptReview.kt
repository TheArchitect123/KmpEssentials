package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpPromptReview {
    companion object {
        /**
         *  Checks if in app prompts can be invoked
         * */
        fun checkInAppReviewCapability(
            showInitial: Boolean = true,
            onResult: (Boolean) -> Unit
        )

        /**
         *  Prompts the user using the in-app review api.
         *  Internally checks if the user has been prompted. Allows a review only once per month.
         *  optional action to run after user has completed their review
         *  You can present a thank you message
         * */
        fun promptReviewInApp(
            forceExternalIfFailed : Boolean = true,
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams? = null
        )

        /**
         *  Prompts the user with an external dialog that users can then provide for
         * */
        fun promptReviewViaExternal()

        /**
         *  Configures the number of hours that has passed before an app review request is allowed to run.
         *  After the request is finished, the lock resets, and expires again from the current time on the device
         *  to the number of houus set
         * */
        fun allowReviewRequestAfterHours(hoursToConfigure: Long)

        /**
         *  Opens the app store link for the running app
         * */
        fun openAppStoreLink()
    }
}