package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.BackgroundTasks.BGProcessingTaskRequest
import platform.BackgroundTasks.BGTaskScheduler

actual class KmpBackgrounding {
    actual companion object {
        private const val appleDefaultId = "com.kmpessentials.default.backgrounding"
        private var backgroundTask: DefaultAction? = null

        fun registerBackgroundService() {
            KmpMainThread.runViaMainThread {
                BGTaskScheduler.sharedScheduler.registerForTaskWithIdentifier(
                    appleDefaultId,
                    null
                ) {
                    backgroundTask?.invoke()
                }
            }
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultAction) {
            backgroundTask = action
            KmpMainThread.runViaMainThread {
                // Schedule the background task
                val processor = BGProcessingTaskRequest(appleDefaultId)
                if (options != null) {
                    if (options.requiresInternet) {
                        processor.requiresNetworkConnectivity = true
                    }
                    if (options.requiresSufficientBattery) {
                        processor.requiresExternalPower = true
                    }
                }

                BGTaskScheduler.sharedScheduler.submitTaskRequest(processor, null)
            }
        }
    }
}