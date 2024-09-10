package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction
import platform.UIKit.UIApplication

actual class KmpBackgrounding {
    actual companion object {
        private const val appleDefaultId = "com.kmpessentials.default.backgrounding"

        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultAction) {
            val backgroundId =
                UIApplication.sharedApplication.beginBackgroundTaskWithName(appleDefaultId) {
                    // expiration
                }

            action()
            UIApplication.sharedApplication.endBackgroundTask(backgroundId)
        }
    }
}