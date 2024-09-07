package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams

/**
 * Manage your device's connectivity state, listen to network connectivity changes, gets network name
 * */
expect class KmpConnectivity {
    companion object {

        /**
         * @return True if your device has an active internet connection, False if not
         * */
        fun isConnected(): Boolean

        /**
         * Gets the current SSID of the network connected
         * */
        fun getCurrentNetworkName(): String?
        /**
         * Listens and broadcasts to connectivity state changes (True if connected, False if not)
         * */
        suspend fun listenToConnectionChange(connectionState: ActionBoolParams)
    }
}