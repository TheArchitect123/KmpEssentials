package com.architect.kmpessentials.accelerometer

import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpAccelerometer {
    actual companion object {
        actual fun startListening(
            accelerometerEvent: ActionStringParams,
            accScopeVal: ActionDoubleParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}