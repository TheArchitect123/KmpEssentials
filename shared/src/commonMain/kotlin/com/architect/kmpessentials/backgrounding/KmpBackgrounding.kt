package com.architect.kmpessentials.backgrounding

import com.architect.kmpessentials.aliases.DefaultActionAsync

expect class KmpBackgrounding {
    companion object {
        fun createAndStartWorker(options: BackgroundOptions, action: DefaultActionAsync)
    }
}

data class BackgroundOptions(
    val requiresInternet: Boolean = false,
    val requiresStorage: Boolean = false,
    val requiresSufficientBattery: Boolean = false
)