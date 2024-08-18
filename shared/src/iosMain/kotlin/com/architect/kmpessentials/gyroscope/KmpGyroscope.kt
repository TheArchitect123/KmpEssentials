package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.Foundation.NSOperationQueue

actual class KmpGyroscope {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            gyroScopeVal: ActionTripleFloatParams
        ) {
            KmpiOS.motionManager.startGyroUpdatesToQueue(
                NSOperationQueue.currentQueue ?: NSOperationQueue.mainQueue
            ) { result, error ->
                if (error == null) {
                    result!!.rotationRate.useContents {
                        gyroScopeVal(Triple(x.toFloat(), y.toFloat(), z.toFloat()))
                    }
                }
            }
        }

        actual fun stopListening() {
            KmpiOS.motionManager.stopGyroUpdates()
        }
    }
}