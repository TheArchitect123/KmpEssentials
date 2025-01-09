package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.secureStorage.KmpSecureStorage
import platform.StoreKit.SKStoreReviewController
import platform.UIKit.UIApplication
import platform.Foundation.*

actual class KmpPromptReview {
    actual companion object {
        private var hoursPassed = 0L
        private var appStoreLinkId: Long? = null
        private var appStoreAppName: String = ""
        private const val LAST_REQUEST_TIME_KEY = "last_request_time"

        // Save the current timestamp
        private fun saveCurrentTime() {
            val currentTimeMillis = getCurrentTimeMillis()
            KmpSecureStorage.persistData(LAST_REQUEST_TIME_KEY, currentTimeMillis)
        }

        // Check if 6 hours have passed since the last saved timestamp
        private fun hasExpiryTimePassed(): Boolean {
            val lastRequestTime = KmpSecureStorage.getLongFromKey(LAST_REQUEST_TIME_KEY)
            val currentTimeMillis = getCurrentTimeMillis()
            val hoursInMillis = hoursPassed * 60 * 60 * 1000 // 6 hours in milliseconds

            KmpLogging.writeInfo("TIMER_REVIEW", "$hoursInMillis")
            return if (lastRequestTime == 0L || lastRequestTime == null || hoursInMillis == 0L) {
                true // If no timestamp exists, allow the request
            } else {
                (currentTimeMillis - lastRequestTime) >= hoursInMillis
            }
        }

        // Helper to get the current time in milliseconds
        private fun getCurrentTimeMillis(): Long {
            return (NSDate().timeIntervalSince1970 * 1000).toLong()
        }

        /**
         * Sets the identifier of your deployed iOS App. You can find this by browsing to the link of your iOS app (on the app store), and pasting the id number at the end
         * @param id your app store identifier (Example: 10212532870)
         * @param appStoreAppName this is the name of your app in your itunes connect url.
         * Example: https://apps.apple.com/au/app/otr-app-coffee-fuel-deals/id1021882870
         * otr-app-coffee-fuel-deals is the "appStoreAppName", "1021882870" is the id
         * */
        fun setAppStoreIdentifier(id: Long, appStoreAppName: String) {
            appStoreLinkId = id
        }

        actual fun allowReviewRequestAfterHours(hoursToConfigure: Long){
            hoursPassed = hoursToConfigure
        }

        actual fun checkInAppReviewCapability(onResult: (Boolean) -> Unit) {
            onResult(hasExpiryTimePassed())
        }

        actual fun promptReviewInApp(
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams?
        ) {
            saveCurrentTime()

            KmpMainThread.runViaMainThread {
                val windowScene = UIApplication.sharedApplication.keyWindow?.windowScene
                val viewController = KmpiOS.getTopViewController()

                if (viewController != null && windowScene != null) {
                    SKStoreReviewController.requestReviewInScene(windowScene)
                } else {
                    errorPromptingDialog("Failed to prompt for in app review. Root Store Controller can't be found")
                }
            }
        }

        actual fun promptReviewViaExternal() {
            if (appStoreLinkId != null && appStoreLinkId != 0L) {
                KmpMainThread.runViaMainThread {
                    val reviewUrl =
                        "https://apps.apple.com/app/$appStoreAppName/id$appStoreLinkId?action=write-review"
                    KmpLauncher.launchExternalUrlViaBrowser(reviewUrl)
                }
            }
        }

        actual fun openAppStoreLink() {
            if (appStoreLinkId != null && appStoreLinkId != 0L) {
                KmpMainThread.runViaMainThread {
                    KmpMainThread.runViaMainThread {
                        KmpLauncher.launchExternalUrlViaBrowser("https://apps.apple.com/app/$appStoreAppName/id$appStoreLinkId")
                    }
                }
            }
        }
    }
}