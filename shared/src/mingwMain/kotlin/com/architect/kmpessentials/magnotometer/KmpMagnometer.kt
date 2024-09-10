package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.cinterop.ExperimentalForeignApi

actual class KmpMagnometer {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            magScopeVal: ActionTripleFloatParams
        ) {

        }

        actual fun stopListening() {

        }
    }
}