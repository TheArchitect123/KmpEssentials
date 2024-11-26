package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.backgrounding.services.KmpForegroundService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import platform.UIKit.UIApplication
import platform.UIKit.UIBackgroundTaskIdentifier

actual class KmpBackgrounding {
    actual companion object {
        private const val appleDefaultId = "com.kmpessentials.default.backgrounding"
        private val identifiers = mutableListOf<UIBackgroundTaskIdentifier>()

        actual fun createAndStartWorkerWithoutCancel(
            options: BackgroundOptions?,
            action: DefaultActionAsync
        ) {
            var backgroundId: UIBackgroundTaskIdentifier? = null
            backgroundId =
                UIApplication.sharedApplication.beginBackgroundTaskWithName(appleDefaultId) {

                }

            GlobalScope.launch {
                action()
            }

            UIApplication.sharedApplication.endBackgroundTask(backgroundId)
        }

        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {
            var backgroundId: UIBackgroundTaskIdentifier? = null
            backgroundId =
                UIApplication.sharedApplication.beginBackgroundTaskWithName(appleDefaultId) {

                }

            identifiers.add(backgroundId)

            GlobalScope.launch {
                action()
            }

            UIApplication.sharedApplication.endBackgroundTask(backgroundId)
        }

        actual fun cancelAllRunningWorkers() {
            if (identifiers.isNotEmpty()) {
                identifiers.forEach {
                    UIApplication.sharedApplication.endBackgroundTask(it)
                }
            }

            identifiers.clear()
        }

        actual fun createAndStartForegroundWorker(
            title: String,
            message: String,
            action: DefaultActionAsync,
        ) {
            KmpForegroundService.actionToInvoke = action
            KmpForegroundService.invokeBackgroundService()
        }
    }
}