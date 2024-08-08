package com.architect.kmpessentials.deviceDisplay

import platform.UIKit.UIApplication
import platform.UIKit.UIScreen
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

actual class KmpDeviceDisplay {
    actual companion object {
        actual fun keepScreenOnActive() {
            dispatch_async(dispatch_get_main_queue()) {
                UIApplication.sharedApplication.setIdleTimerDisabled(true)
            }
        }

        actual fun disableScreenOnActive() {
            UIApplication.sharedApplication.setIdleTimerDisabled(false)
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            dispatch_async(dispatch_get_main_queue()) {
                UIScreen.mainScreen.setBrightness(brightness)
            }
        }
    }
}