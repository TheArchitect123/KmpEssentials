package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.logging.KmpLogging

actual class KmpPromptReview {
    actual companion object {
        private var appId = ""
        fun setAppIdentifer(appId: String) {
            this.appId = appId
        }

        actual fun allowReviewRequestAfterHours(hoursToConfigure: Long) {

        }

        actual fun promptReviewInApp(
            forceExternalIfFailed: Boolean,
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams?
        ) {

        }

        actual fun promptReviewViaExternal() {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        ProcessBuilder(
                            "cmd",
                            "/c",
                            "start ms-windows-store://review/?ProductId=$appId"
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error opening Microsoft Store for review: ${e.stackTraceToString()}"
                        )
                    }
                }

                else -> {
                    try {
                        ProcessBuilder(
                            "open",
                            "macappstore://apps.apple.com/app/id$appId?action=write-review"
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error opening Mac App Store for review: ${e.stackTraceToString()}"
                        )
                    }
                }
            }
        }

        actual fun openAppStoreLink() {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        ProcessBuilder(
                            "cmd",
                            "/c",
                            "start ms-windows-store://pdp/?ProductId=$appId"
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error opening Microsoft Store for review: ${e.stackTraceToString()}"
                        )
                    }
                }

                else -> {
                    try {
                        ProcessBuilder(
                            "open",
                            "macappstore://apps.apple.com/app/id$appId"
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error opening Mac Store: ${e.stackTraceToString()}"
                        )
                    }
                }
            }
        }

        /**
         *  Checks if in app prompts can be invoked
         * */
        actual fun checkInAppReviewCapability(
            showInitial: Boolean,
            onResult: (Boolean) -> Unit
        ) {
        }
    }
}