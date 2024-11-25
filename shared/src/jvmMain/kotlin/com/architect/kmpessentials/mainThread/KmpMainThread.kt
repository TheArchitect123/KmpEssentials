package com.architect.kmpessentials.mainThread

import com.architect.kmpessentials.aliases.DefaultAction
import java.util.concurrent.Executors

object MainThreadDispatcher {
    private val mainThread = Thread.currentThread() // Capture the main thread
    private val mainExecutor = Executors.newSingleThreadExecutor { runnable ->
        Thread(runnable, "MainThread").apply { isDaemon = false }
    }

    fun runOnMainThread(action: () -> Unit) {
        if (Thread.currentThread() == mainThread) {
            // Already on the main thread
            action()
        } else {
            // Dispatch to the main thread executor
            mainExecutor.execute {
                action()
            }
        }
    }
}

actual class KmpMainThread {
    actual companion object {
        actual fun runViaMainThread(action: DefaultAction) {
            MainThreadDispatcher.runOnMainThread {
                action()
            }
        }
    }
}