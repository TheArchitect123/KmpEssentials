package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

actual class KmpBackgrounding {
    actual companion object {
        private val jobCollection = mutableListOf<Job>()
        actual fun createAndStartWorker(options: BackgroundOptions?, action: DefaultActionAsync) {
            jobCollection.add(GlobalScope.launch {
                action()
            })
        }

        actual fun createAndStartWorkerWithoutCancel(
            options: BackgroundOptions?,
            action: DefaultActionAsync
        ) {
            GlobalScope.launch {
                action()
            }
        }

        actual fun cancelAllRunningWorkers() {
            jobCollection.forEach {
                it.cancel()
            }

            jobCollection.clear()
        }

        actual fun createAndStartForegroundWorker(
            title: String,
            message: String,
            action: DefaultActionAsync,
        ) {
            createAndStartWorker(null, action)
        }
    }
}