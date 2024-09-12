package com.architect.kmpessentials.deviceDisplay

import platform.WatchKit.WKApplication
import platform.WatchKit.WKInterfaceDevice

actual class KmpDeviceDisplay {
    actual companion object {
        actual fun keepScreenOnActive() {

            WKApplication.sharedApplication().
        }

        actual fun disableScreenOnActive() {

        }

        actual fun adjustScreenBrightness(brightness: Double) {

        }
    }
}