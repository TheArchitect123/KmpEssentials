package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import platform.BackgroundTasks.BGTaskScheduler
import platform.UIKit.UIApplication
import platform.UIKit.UIBackgroundTaskIdentifier
import platform.UIKit.UIImage

actual class KmpBackgrounding {
    actual companion object {
        private const val appleDefaultId = "com.kmpessentials.default.backgrounding"
        private val identifiers = mutableListOf<UIBackgroundTaskIdentifier>()
        private val foregroundServices = mutableListOf<String>()

        var foregroundIcon: UIImage? = null
        fun setForegroundIcon(foregroundIcon: UIImage?) {
            this.foregroundIcon = foregroundIcon
        }

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

            if (foregroundServices.isNotEmpty()) {
                foregroundServices.forEach {
                    BGTaskScheduler.sharedScheduler.cancelTaskRequestWithIdentifier(it)
                }
            }

            identifiers.clear()
            KmpForegroundService.stopNotificationService()
        }

        actual fun createAndStartForegroundWorker(
            title: String,
            message: String,
            action: DefaultActionAsync,
        ) {
            KmpForegroundService.startNotificationService(title, message, action)
        }
    }
}