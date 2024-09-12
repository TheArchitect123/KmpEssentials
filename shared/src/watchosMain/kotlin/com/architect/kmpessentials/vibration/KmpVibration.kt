package com.architect.kmpessentials.vibration

import platform.WatchKit.WKHapticType
import platform.WatchKit.WKInterfaceDevice

actual class KmpVibration {
    actual companion object {
        actual fun startVibrating(durationMs: Long) {
            WKInterfaceDevice.currentDevice().playHaptic(WKHapticType.WKHapticTypeNotification)
        }

        actual fun stopVibrating() {

        }
    }
}