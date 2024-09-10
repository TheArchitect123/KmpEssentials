package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotification
import platform.darwin.NSObject

actual class KmpOrientationManager {
    actual companion object {
        private lateinit var corientationChange: OrientationListener

        @OptIn(BetaInteropApi::class)
        private val orientationListener = object : NSObject() {
            @Suppress("unused")
            @ObjCAction
            fun orientationTriggered(arg: NSNotification) {
                corientationChange.invoke(getCurrentOrientation())
            }
        }

        actual fun getCurrentOrientation(): OrientationState {
           TODO()
        }


        actual fun startListening(orientationChange: OrientationListener) {

        }

        actual fun stopListening() {

        }
    }
}

