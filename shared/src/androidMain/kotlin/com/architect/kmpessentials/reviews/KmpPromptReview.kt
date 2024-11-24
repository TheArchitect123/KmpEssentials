package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.KmpAndroid
import com.google.android.play.core.review.ReviewManagerFactory
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.logging.KmpLogging

actual class KmpPromptReview {
    actual companion object {
        actual fun promptReviewInApp(
            errorPromptingDialog: ActionStringParams, actionAfterClosing: ActionNoParams?
        ) {
            val reviewManager = ReviewManagerFactory.create(KmpAndroid.applicationContext!!)

            // Start the review flow
            val request = reviewManager.requestReviewFlow()
            if (request.isSuccessful) {
                val reviewInfo = request.result
                val flow = reviewManager.launchReviewFlow(KmpAndroid.clientAppContext!!, reviewInfo)
                flow.addOnSuccessListener {
                    // Review flow completed (success or failure)
                    // Note: The Play Store decides if the dialog is shown
                    if (actionAfterClosing != null) {
                        actionAfterClosing()
                    }
                }
                flow.addOnFailureListener {
                    invokeErrorAction(
                        "${it.message}\n" +
                                " ${it.cause}", errorPromptingDialog
                    )
                }
            } else {
                invokeErrorAction(
                    "${request.exception?.message}\n" +
                            " ${request.exception?.cause}", errorPromptingDialog
                )
            }
        }

        private fun invokeErrorAction(
            errorMessage: String,
            errorPromptingDialog: ActionStringParams
        ) {
            val error =
                "Failed to open Google Play in App Review. Reasons: \n $errorMessage"
            KmpLogging.writeError("KMP_ESSENTIALS_GOOGLE_IN_APP", error)
            errorPromptingDialog(error)
        }

        actual fun promptReviewViaExternal() {
            KmpLauncher.launchExternalUrlViaBrowser("https://play.google.com/store/apps/details?id=${KmpAndroid.applicationContext!!.packageName}&reviewId=0")
        }

        actual fun openAppStoreLink() {
            KmpLauncher.launchExternalUrlViaBrowser("https://play.google.com/store/apps/details?id=${KmpAndroid.applicationContext!!.packageName}")
        }
    }
}