package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.internal.ActionTripleFloatParams

expect class KmpGyroscope {
    companion object {
        fun startListening(
            gyroScopeVal: ActionTripleFloatParams
        )

        fun stopListening()
    }
}