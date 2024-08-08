package com.architect.kmpessentials.deviceDisplay

import android.view.WindowManager
import com.architect.kmpessentials.KmpAndroid

actual class KmpDeviceDisplay {
    actual companion object {
        actual fun keepScreenOnActive() {
            KmpAndroid.clientAppContext.runOnUiThread {
                KmpAndroid.clientAppContext.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
        }

        actual fun disableScreenOnActive() {
            KmpAndroid.clientAppContext.runOnUiThread {
                KmpAndroid.clientAppContext.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            if(brightness in 0.0..1.0) {
                KmpAndroid.clientAppContext.runOnUiThread {
                    KmpAndroid.clientAppContext.window.attributes.screenBrightness =
                        brightness.toFloat()
                }
            }
            else {
                throw Exception("Screen brightness must be between 0 and 1")
            }
        }
    }
}