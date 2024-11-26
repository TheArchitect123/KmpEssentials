package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultActionAsync

/**
 * Use this for running a background worker, to run your action in the background
 * */
expect class KmpBackgrounding {
    companion object {
        /**
         * Use this for running a background worker, to run your action in the background
         * @param options Configure if your worker requires network connectivity, or sufficient battery, etc
         * @param action your action to invoke in the background
         * */
        fun createAndStartWorker(options: BackgroundOptions? = null, action: DefaultActionAsync)

        /**
         * Use this for running a background worker, that cannot be cancelled
         * @param options Configure if your worker requires network connectivity, or sufficient battery, etc
         * @param action your action to invoke in the background
         * */
        fun createAndStartWorkerWithoutCancel(
            options: BackgroundOptions? = null,
            action: DefaultActionAsync
        )

        /**
         * Use this for running a foreground worker, to run your action in the background/foreground. This is a service that be bound to the app, and will close after the app is closed or the service is complete
         * It will also broadcast a live notification of itself running to the user
         * @param action the action that must be invoked by the foreground service
         * @param title the title of the live notification broadcasted to the user
         * @param message the message of the live notification broadcasted to the user
         * */
        fun createAndStartForegroundWorker(
            title: String,
            message: String,
            action: DefaultActionAsync,
        )

        /**
         * Use this for canceling all pending/running workers
         * */
        fun cancelAllRunningWorkers()
    }
}

data class BackgroundOptions(
    val requiresInternet: Boolean = false,
    val requiresStorage: Boolean = false,
    val requiresSufficientBattery: Boolean = false
)