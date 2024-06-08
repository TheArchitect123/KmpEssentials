package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpConnectivity {
    actual companion object {
        actual fun isConnected(): Boolean {
            return true
        }

        actual fun scanForNetworks(network: ActionStringParams) {

        }

        actual fun disconnectFromNetwork() {

        }

        actual fun startListening(connectionState: ActionBoolParams) {

        }

        actual fun stopListening() {

        }
    }
}