package com.architect.kmpessentials.reviews

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.UnsafeNumber
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import platform.Foundation.NSBundle

import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual class KmpPromptReview {
    actual companion object {
        actual fun allowReviewRequestAfterHours(hoursToConfigure: Long){

        }

        private var appStoreLink: String = ""

        actual fun promptReviewInApp(
            errorPromptingDialog: ActionStringParams,
            actionAfterClosing: ActionNoParams?
        ) {
            // NOT AVAILABLE ON WATCH OS
        }

        actual fun promptReviewViaExternal() {
            if (appStoreLink.isNotBlank()) {
                KmpMainThread.runViaMainThread {
                    val reviewUrl = "$appStoreLink?action=write-review"
                    KmpLauncher.launchExternalUrlViaBrowser(reviewUrl)
                }
            } else {
                fetchingAppleLink {
                    promptReviewViaExternal()
                }
            }
        }

        private fun fetchingAppleLink(action: DefaultAction) {
            GlobalScope.launch {
                try {
                    KmpLogging.writeInfo(
                        "KmpEssentials",
                        "Attempting to fetch app store link from Apple"
                    )
                    appStoreLink =
                        fetchAppStoreLink(NSBundle.mainBundle.bundleIdentifier ?: "") ?: ""

                    if (appStoreLink.isNotBlank()) {
                        action()
                    }
                } catch (ex: Exception) {
                    KmpLogging.writeError(
                        "KmpEssentials",
                        ex.message + "\n" + ex.stackTraceToString()
                    )
                }
            }
        }

        actual fun openAppStoreLink() {
            if (appStoreLink.isNotBlank()) {
                KmpMainThread.runViaMainThread {
                    KmpMainThread.runViaMainThread {
                        KmpLauncher.launchExternalUrlViaBrowser(appStoreLink)
                    }
                }
            } else {
                fetchingAppleLink {
                    openAppStoreLink()
                }
            }
        }

        @OptIn(UnsafeNumber::class)
        private suspend fun fetchAppStoreLink(bundleId: String): String? {
            return suspendCancellableCoroutine { continuation ->
                val urlString = "https://itunes.apple.com/lookup?bundleId=$bundleId"
                val url = NSURL(string = urlString) ?: run {
                    continuation.resumeWithException(Exception("Invalid URL: $urlString"))
                    return@suspendCancellableCoroutine
                }

                val request = NSMutableURLRequest(url).apply {
                    HTTPMethod = "GET"
                }

                val task =
                    NSURLSession.sharedSession.dataTaskWithRequest(request) { data, response, error ->
                        when {
                            error != null -> {
                                continuation.resumeWithException(Exception(error.localizedDescription))
                            }

                            data != null -> {
                                val responseString =
                                    NSString.create(data, NSUTF8StringEncoding)?.toString()
                                continuation.resume(responseString ?: "")
                            }

                            else -> {
                                continuation.resumeWithException(Exception("Unknown error occurred"))
                            }
                        }
                    }

                continuation.invokeOnCancellation { task.cancel() }
                task.resume()
            }
        }

        /**
         *  Checks if in app prompts can be invoked
         * */
        actual fun checkInAppReviewCapability(onResult: (Boolean) -> Unit) {
        }
    }
}