package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener

actual class KmpOrientationManager {
    actual companion object {
        actual fun getCurrentOrientation(): OrientationState {
            return OrientationState.Landscape
        }

        actual fun startListening(orientationChange: OrientationListener) {

        }

        actual fun stopListening() {

        }
    }
}

