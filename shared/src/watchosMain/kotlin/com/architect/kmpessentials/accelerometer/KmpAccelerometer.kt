package com.architect.kmpessentials.accelerometer

import KmpWatchKit
import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.Foundation.NSOperationQueue

actual class KmpAccelerometer {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            accScopeVal: ActionTripleFloatParams
        ) {
            KmpWatchKit.motionManager.startAccelerometerUpdatesToQueue(
                NSOperationQueue.currentQueue ?: NSOperationQueue.mainQueue
            ) { result, error ->
                if (error == null) {
                    result!!.acceleration.useContents {
                        accScopeVal(Triple(x.toFloat(), y.toFloat(), z.toFloat()))
                    }
                }
            }
        }

        actual fun stopListening() {
            KmpWatchKit.motionManager.stopAccelerometerUpdates()
        }
    }
}