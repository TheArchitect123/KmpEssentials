package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCAction

actual class KmpOrientationManager {
    actual companion object {
        private lateinit var corientationChange: OrientationListener

        actual fun getCurrentOrientation(): OrientationState {
           TODO()
        }


        actual fun startListening(orientationChange: OrientationListener) {

        }

        actual fun stopListening() {

        }
    }
}

