package com.architect.kmpessentials.accelerometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams

expect class KmpAccelerometer {
    companion object {
        fun startListening(
            accScopeVal: ActionTripleFloatParams
        )

        fun stopListening()
    }
}