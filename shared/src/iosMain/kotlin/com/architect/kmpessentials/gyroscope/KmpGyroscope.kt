package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpGyroscope {
    actual companion object {
        actual fun startListening(
            gyroscopeEvent: ActionStringParams,
            gyroScopeVal: ActionDoubleParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}