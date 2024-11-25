package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.cinterop.ExperimentalForeignApi

actual class KmpGyroscope {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            gyroScopeVal: ActionTripleFloatParams
        ) {

        }

        actual fun stopListening() {
         //   KmpWatchKit.motionManager.stopGyroUpdates()
        }
    }
}