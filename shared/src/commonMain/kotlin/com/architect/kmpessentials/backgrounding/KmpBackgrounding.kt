package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultAction

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
        fun createAndStartWorker(options: BackgroundOptions, action: DefaultAction)
    }
}

data class BackgroundOptions(
    val requiresInternet: Boolean = false,
    val requiresStorage: Boolean = false,
    val requiresSufficientBattery: Boolean = false
)