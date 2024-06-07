package com.architect.kmpessentials.connectivity

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpConnectivity {
    companion object{
        fun isConnected(): Boolean
        fun scanForNetworks(network: ActionStringParams)
        fun disconnectFromNetwork()
        fun startListening(connectionState: ActionBoolParams)
        fun stopListening()
    }
}