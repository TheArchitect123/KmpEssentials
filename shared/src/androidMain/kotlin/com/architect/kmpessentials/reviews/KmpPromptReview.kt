package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.KmpAndroid
import com.google.android.play.core.review.ReviewManagerFactory
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.secureStorage.KmpSecureStorage

actual class KmpPromptReview {
    actual companion object {
        private var hoursPassed = 0L
        private const val LAST_REQUEST_TIME_KEY = "last_request_time"

        actual fun checkInAppReviewCapability(onResult: (Boolean) -> Unit) {
            val reviewManager = ReviewManagerFactory.create(KmpAndroid.getCurrentApplicationContext())
            val request = reviewManager.requestReviewFlow()

            request.addOnCompleteListener { task ->
                onResult(task.isSuccessful && hasExpiryTimePassed())
            }
        }

        actual fun promptReviewInApp(
            errorPromptingDialog: ActionStringParams, actionAfterClosing: ActionNoParams?
        ) {
            saveCurrentTime()
            val reviewManager = ReviewManagerFactory.create(KmpAndroid.getCurrentApplicationContext())

            // Start the review flow
            val request = reviewManager.requestReviewFlow()
            if (request.isSuccessful) {
                val reviewInfo = request.result
                val flow = reviewManager.launchReviewFlow(KmpAndroid.getCurrentActivityContext(), reviewInfo)
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
            KmpLauncher.launchExternalUrlViaBrowser("https://play.google.com/store/apps/details?id=${KmpAndroid.getCurrentApplicationContext().packageName}&reviewId=0")
        }

        actual fun openAppStoreLink() {
            KmpLauncher.launchExternalUrlViaBrowser("https://play.google.com/store/apps/details?id=${KmpAndroid.getCurrentApplicationContext().packageName}")
        }

        actual fun allowReviewRequestAfterHours(hoursToConfigure: Long){
            hoursPassed = hoursToConfigure
        }

        // Save the current timestamp
        private fun saveCurrentTime() {
            val currentTimeMillis = getCurrentTimeMillis()
            KmpSecureStorage.persistData(LAST_REQUEST_TIME_KEY, currentTimeMillis)
        }

        // Check if 6 hours have passed since the last saved timestamp
        private fun hasExpiryTimePassed(): Boolean {
            val lastRequestTime = KmpSecureStorage.getLongFromKey(LAST_REQUEST_TIME_KEY)
            val currentTimeMillis = getCurrentTimeMillis()
            val hoursInMillis = hoursPassed * 60 * 60 * 1000L // 6 hours in milliseconds

            // Log the calculated duration (optional logging)
            android.util.Log.i("TIMER_REVIEW", "$hoursInMillis")

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