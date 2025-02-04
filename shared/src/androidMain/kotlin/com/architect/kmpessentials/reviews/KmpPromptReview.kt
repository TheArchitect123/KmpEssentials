package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.KmpAndroid
import com.google.android.play.core.review.ReviewManagerFactory
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.secureStorage.KmpPublicStorage
import com.google.android.play.core.review.ReviewManager

actual class KmpPromptReview {
    actual companion object {
        private var hoursPassed = 0L
        private const val LAST_REQUEST_TIME_KEY = "last_request_time"
        private var reviewManager: ReviewManager? = null

        actual fun checkInAppReviewCapability(
            showInitial: Boolean,
            onResult: (Boolean) -> Unit
        ) {
            if (!showInitial) {
                saveCurrentTime()
            }

            onResult(hasExpiryTimePassed())
        }

        actual fun promptReviewInApp(
            forceExternalIfFailed: Boolean,
            errorPromptingDialog: ActionStringParams, actionAfterClosing: ActionNoParams?
        ) {
            saveCurrentTime()
            reviewManager = ReviewManagerFactory.create(KmpAndroid.getCurrentApplicationContext())

            // Start the review flow
            reviewManager!!.requestReviewFlow().addOnCompleteListener { request ->
                if (request.isSuccessful) {
                    val reviewInfo = request.result
                    val flow = reviewManager?.launchReviewFlow(
                        KmpAndroid.getCurrentActivityContext(),
                        reviewInfo
                    )

                    flow?.addOnSuccessListener {
                        // Review flow completed (success or failure)
                        // Note: The Play Store decides if the dialog is shown
                        if (actionAfterClosing != null) {
                            actionAfterClosing()
                        }
                    }
                    flow?.addOnFailureListener {
                        invokeErrorAction(
                            "${it.message}\n" +
                                    " ${it.cause}", errorPromptingDialog
                        )

                        if (forceExternalIfFailed) {
                            promptReviewViaExternal()
                        }
                    }

                    flow?.addOnCompleteListener { r ->
                        if (!r.isSuccessful && forceExternalIfFailed) {
                            promptReviewViaExternal()
                        }
                    }
                } else {
                    invokeErrorAction(
                        "${request.exception?.message}\n" +
                                " ${request.exception?.cause}", errorPromptingDialog
                    )

                    if (forceExternalIfFailed) {
                        promptReviewViaExternal()
                    }
                }
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
            KmpLauncher.launchExternalUrlViaBrowser("https://play.google.com/store/apps/details?id=${KmpAndroid.getCurrentApplicationContext().packageName}&reviewId=0")
        }

        actual fun openAppStoreLink() {
            KmpLauncher.launchExternalUrlViaBrowser("https://play.google.com/store/apps/details?id=${KmpAndroid.getCurrentApplicationContext().packageName}")
        }

        actual fun allowReviewRequestAfterHours(hoursToConfigure: Long) {
            hoursPassed = hoursToConfigure
        }

        // Save the current timestamp
        private fun saveCurrentTime() {
            val currentTimeMillis = getCurrentTimeMillis()
            KmpPublicStorage.persistData(LAST_REQUEST_TIME_KEY, currentTimeMillis)
        }

        // Check if 6 hours have passed since the last saved timestamp
        private fun hasExpiryTimePassed(): Boolean {
            val lastRequestTime = KmpPublicStorage.getLongFromKey(LAST_REQUEST_TIME_KEY)
            val currentTimeMillis = getCurrentTimeMillis()
            val hoursInMillis = hoursPassed * 60 * 60 * 1000L // 6 hours in milliseconds

            return if (lastRequestTime == 0L || lastRequestTime == null || hoursInMillis == 0L) {
                true // If no timestamp exists, allow the request
            } else {
                (currentTimeMillis - lastRequestTime) >= hoursInMillis
            }
        }

        // Helper to get the current time in milliseconds
        private fun getCurrentTimeMillis(): Long {
            return System.currentTimeMillis()
        }
    }
}