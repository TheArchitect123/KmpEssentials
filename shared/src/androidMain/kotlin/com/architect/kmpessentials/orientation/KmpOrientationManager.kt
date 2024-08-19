package com.architect.kmpessentials.orientation

import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.orientation.internal.OrientationListener
import com.architect.kmpessentials.orientation.receiver.OrientationChangeReceiver

actual class KmpOrientationManager {
    actual companion object {
        private var orientationChangeReceiver: OrientationChangeReceiver? = null
        actual fun getCurrentOrientation(): OrientationState {
            return when (KmpAndroid.clientAppContext.resources.configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> OrientationState.Portrait
                Configuration.ORIENTATION_LANDSCAPE -> OrientationState.Landscape
                else -> OrientationState.Unknown
            }
        }

        actual fun startListening(orientationChange: OrientationListener) {
            orientationChangeReceiver = OrientationChangeReceiver {
                orientationChange(it)
            }

            val filter = IntentFilter().apply {
                addAction(Intent.ACTION_CONFIGURATION_CHANGED)
            }
            KmpAndroid.applicationContext.registerReceiver(orientationChangeReceiver, filter)
        }

        actual fun stopListening() {
            if(orientationChangeReceiver != null) {
                KmpAndroid.applicationContext.unregisterReceiver(orientationChangeReceiver)
            }
        }
    }
}

