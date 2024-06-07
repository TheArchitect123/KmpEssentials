package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpMagnometer {
    companion object{
        fun startListening(magnetometerEvent: ActionStringParams, magScopeVal: ActionDoubleParams)
        fun stopListening()
    }
}