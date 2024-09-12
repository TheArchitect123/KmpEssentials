package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.connectivity.internals.ConnectionType
import com.architect.kmpessentials.connectivity.internals.NWWatchPathMonitor
import com.architect.kmpessentials.internal.ActionBoolParams

actual class KmpConnectivity {
    actual companion object {
        internal val connectionMonitor = NWWatchPathMonitor()
        actual fun isConnected(): Boolean {
            return connectionMonitor.isConnected()
        }

        actual fun getCurrentNetworkName(): String? {
            return connectionMonitor.getCurrentNetworkConnection()?.name ?: ""
        }

        actual suspend fun listenToConnectionChange(connectionState: ActionBoolParams) {
            connectionMonitor.observeNetworkConnection().collect {
                connectionState(it != null && it != ConnectionType.UNKNOWN_CONNECTION_TYPE)
            }
        }
    }
}