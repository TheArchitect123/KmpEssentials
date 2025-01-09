package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.secureStorage.KmpPublicStorage
import platform.StoreKit.SKStoreReviewController
import platform.UIKit.UIApplication
import platform.Foundation.*

actual class KmpPromptReview {
    actual companion object {

        private var appStoreLinkId: Long? = null
        private var appStoreAppName: String = ""
        private const val LAST_REQUEST_TIME_KEY = "last_request_time"

        // Save the current timestamp
        private fun saveCurrentTime() {
            val currentTimeMillis = getCurrentTimeMillis()
            KmpPublicStorage.persistData(LAST_REQUEST_TIME_KEY, currentTimeMillis)
        }

        // Check if 6 hours have passed since the last saved timestamp
        private fun hasSixHoursPassed(): Boolean {
            val lastRequestTime = KmpPublicStorage.getLongFromKey(LAST_REQUEST_TIME_KEY)
            val currentTimeMillis = getCurrentTimeMillis()
            val sixHoursInMillis: Long = 6 * 60 * 60 * 1000 // 6 hours in milliseconds

            return if (lastRequestTime == null) {
                true // If no timestamp exists, allow the request
            } else {
                (currentTimeMillis - lastRequestTime) >= sixHoursInMillis
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

        actual fun checkInAppReviewCapability(onResult: (Boolean) -> Unit) {
            onResult(hasSixHoursPassed())
        }

        actual fun promptReviewInApp(
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams?
        ) {
            KmpMainThread.runViaMainThread {
                val windowScene = UIApplication.sharedApplication.keyWindow?.windowScene
                val viewController = KmpiOS.getTopViewController()

                if (viewController != null && windowScene != null) {
                    saveCurrentTime() // saves and persists
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