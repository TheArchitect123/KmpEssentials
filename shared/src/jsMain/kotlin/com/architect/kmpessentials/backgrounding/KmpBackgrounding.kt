package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.backgrounding.helpers.WebWorkers

actual class KmpBackgrounding {
    actual companion object {
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {
            WebWorkers.registerServiceWorker(action)
        }

        actual fun createAndStartWorkerWithoutCancel(
            options: BackgroundOptions?,
            action: DefaultActionAsync
        ) {
            WebWorkers.registerServiceWorker(action)
        }

        actual fun cancelAllRunningWorkers() {
            WebWorkers.cancellAllTasks()
        }

        actual fun createAndStartForegroundWorker(
            title: String,
            message: String,
            action: DefaultActionAsync,
        ) {
            WebWorkers.registerWebWorker(action)
        }
    }
}