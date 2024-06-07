package com.architect.kmpessentials.accelerometer

import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpAccelerometer {
    companion object{
        fun startListening(accelerometerEvent: ActionStringParams, accScopeVal: ActionDoubleParams)
        fun stopListening()
    }
}