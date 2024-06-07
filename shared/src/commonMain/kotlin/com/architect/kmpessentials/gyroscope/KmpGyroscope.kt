package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpGyroscope {
    companion object{
        fun startListening(gyroscopeEvent: ActionStringParams, gyroScopeVal: ActionDoubleParams)
        fun stopListening()
    }
}