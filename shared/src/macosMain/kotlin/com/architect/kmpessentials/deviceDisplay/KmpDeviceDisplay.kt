package com.architect.kmpessentials.deviceDisplay

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.AppKit.NSApplication
import platform.AppKit.NSScreen
import platform.Foundation.NSFileManager


actual class KmpDeviceDisplay {
    actual companion object {
        actual fun keepScreenOnActive() {
            KmpMainThread.runViaMainThread {
                //NSScreen.mainScreen.set(true)
            }
        }

        actual fun disableScreenOnActive() {
            KmpMainThread.runViaMainThread {
                //NSApplication.sharedApplication.setIdleTimerDisabled(false)
            }
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            KmpMainThread.runViaMainThread {
           //     NSScreen.mainScreen. .(brightness)
            }
        }
    }
}