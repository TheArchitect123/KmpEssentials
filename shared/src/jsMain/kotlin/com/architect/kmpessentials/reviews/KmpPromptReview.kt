package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpPromptReview {
    actual companion object {
        actual fun allowReviewRequestAfterHours(hoursToConfigure: Long){

        }

        actual fun promptReviewInApp(
            forceExternalIfFailed : Boolean,
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams?
        ) {

        }

        actual fun promptReviewViaExternal() {

        }

        actual fun openAppStoreLink() {

        }

        /**
         *  Checks if in app prompts can be invoked
         * */
        actual fun checkInAppReviewCapability(
            showInitial: Boolean,
            onResult: (Boolean) -> Unit) {
        }
    }
}