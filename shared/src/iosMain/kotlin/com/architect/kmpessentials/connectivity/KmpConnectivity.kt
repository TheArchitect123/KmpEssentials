package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams
import dev.tmapps.konnection.Konnection

actual class KmpConnectivity {
    actual companion object {
        private val konnection = Konnection.instance
        actual fun isConnected(): Boolean {
            return konnection.isConnected()
        }

        actual fun getCurrentNetworkName(): String? {
            return konnection.getCurrentNetworkConnection()?.name
        }

        actual suspend fun listenToConnectionChange(connectionState: ActionBoolParams) {
            konnection.observeHasConnection().collect { hasConnection ->
                connectionState(hasConnection)
            }
        }
    }
}