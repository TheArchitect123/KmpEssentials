package com.architect.kmpessentials.deviceDisplay

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UIKit.UIApplication
import platform.UIKit.UIScreen

actual class KmpDeviceDisplay {
    actual companion object {
        actual fun keepScreenOnActive() {
            KmpMainThread.runViaMainThread {
                UIApplication.sharedApplication.setIdleTimerDisabled(true)
            }
        }

        actual fun disableScreenOnActive() {
            KmpMainThread.runViaMainThread {
                UIApplication.sharedApplication.setIdleTimerDisabled(false)
            }
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            KmpMainThread.runViaMainThread {
                UIScreen.mainScreen.setBrightness(brightness)
            }
        }
    }
}