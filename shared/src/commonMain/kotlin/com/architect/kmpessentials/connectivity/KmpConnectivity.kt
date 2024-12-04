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
         * Gets the current IPv4 address of the device
         * */
        suspend fun getCurrentNetworkIPv4(): String?

        /**
         * Gets the current IPv6 address of the device
         * */
        suspend fun getCurrentNetworkIPv6(): String?

        /**
         * Listens and broadcasts to connectivity state changes (True if connected, False if not)
         * */
        suspend fun listenToConnectionChange(connectionState: ActionBoolParams)
    }
}