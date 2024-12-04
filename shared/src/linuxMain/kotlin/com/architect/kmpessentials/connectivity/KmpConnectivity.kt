package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams

actual class KmpConnectivity {
    actual companion object {
        actual fun isConnected(): Boolean {
            return false
        }

        actual fun getCurrentNetworkName(): String? {
            return ""
        }

        actual suspend fun listenToConnectionChange(connectionState: ActionBoolParams) {

        }

        actual suspend  fun getCurrentNetworkIPv4(): String?{
            return ""
        }

        actual suspend  fun getCurrentNetworkIPv6(): String?{
            return ""
        }
    }
}