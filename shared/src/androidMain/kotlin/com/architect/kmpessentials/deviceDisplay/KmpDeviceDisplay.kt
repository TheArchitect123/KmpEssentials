package com.architect.kmpessentials.deviceDisplay

import android.view.WindowManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpDeviceDisplay {
    actual companion object {
        actual fun keepScreenOnActive() {
            KmpMainThread.runViaMainThread {
                KmpAndroid.clientAppContext.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
        }

        actual fun disableScreenOnActive() {
            KmpMainThread.runViaMainThread {
                KmpAndroid.clientAppContext.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            if(brightness in 0.0..1.0) {
                KmpMainThread.runViaMainThread {
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