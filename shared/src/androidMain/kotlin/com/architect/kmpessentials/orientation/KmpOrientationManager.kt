package com.architect.kmpessentials.orientation

import android.content.res.Configuration
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.orientation.internal.OrientationListener


actual class KmpOrientationManager {
    actual companion object {
        actual fun getCurrentOrientation(): OrientationState {
            return when (KmpAndroid.clientAppContext.resources.configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> OrientationState.Portrait
                Configuration.ORIENTATION_LANDSCAPE -> OrientationState.Landscape
                else -> OrientationState.Unknown
            }
        }

        actual fun startListening(orientationChange: OrientationListener) {

        }

        actual fun stopListening() {

        }
    }
}

