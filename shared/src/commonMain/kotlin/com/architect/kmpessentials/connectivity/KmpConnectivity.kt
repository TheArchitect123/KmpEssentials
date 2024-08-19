package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams
import dev.tmapps.konnection.Konnection

class KmpConnectivity {
    companion object {
        private val konnection = Konnection.instance
        fun isConnected(): Boolean {
            return konnection.isConnected()
        }

        fun getCurrentNetworkName(): String? {
            return konnection.getCurrentNetworkConnection()?.name
        }

        suspend fun listenToConnectionChange(connectionState: ActionBoolParams) {
            konnection.observeHasConnection().collect { hasConnection ->
                connectionState(hasConnection)
            }
        }
    }
}