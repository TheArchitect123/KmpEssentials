package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.internal.ActionDoubleParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpMagnometer {
    actual companion object {
        actual fun startListening(
            magnetometerEvent: ActionStringParams,
            magScopeVal: ActionDoubleParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}