package com.architect.kmpessentials.magnotometer

import KmpWatchKit
import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.Foundation.NSOperationQueue

actual class KmpMagnometer {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            magScopeVal: ActionTripleFloatParams
        ) {
            KmpWatchKit.motionManager.startMagnetometerUpdatesToQueue(
                NSOperationQueue.currentQueue ?: NSOperationQueue.mainQueue
            ) { result, error ->
                if (error == null) {
                    result!!.magneticField.useContents {
                        magScopeVal(Triple(x.toFloat(), y.toFloat(), z.toFloat()))
                    }
                }
            }
        }

        actual fun stopListening() {
            KmpWatchKit.motionManager.stopMagnetometerUpdates()
        }
    }
}