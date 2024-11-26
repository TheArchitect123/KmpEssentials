package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AppKit.NSApplication

actual class KmpBackgrounding {
    actual companion object {
        private const val appleDefaultId = "com.kmpessentials.default.backgrounding"

       // private val identifiers = mutableListOf<NSBackgroundTas>()

        @OptIn(ExperimentalForeignApi::class)
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {
//            var backgroundId: UIBackgroundTaskIdentifier? = null
//            backgroundId =
//                NSApplication.sharedApplication.aler (appleDefaultId) {
//
//                }
//
//            identifiers.add(backgroundId)
//
//            action()
//            UIApplication.sharedApplication.endBackgroundTask(backgroundId)
        }

        actual fun createAndStartWorkerWithoutCancel(options: BackgroundOptions?, action: DefaultActionAsync){

        }

        actual fun cancelAllRunningWorkers() {
//            if (identifiers.isNotEmpty()) {
//                identifiers.forEach {
//                    UIApplication.sharedApplication.endBackgroundTask(it)
//                }
//            }
//
//            identifiers.clear()
        }

        actual fun createAndStartForegroundWorker(
            title: String,
            message: String,
            action: DefaultActionAsync,
        ) {
        }
    }
}