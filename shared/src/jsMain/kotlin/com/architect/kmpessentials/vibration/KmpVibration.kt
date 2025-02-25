package com.architect.kmpessentials.vibration

import kotlinx.browser.window

actual class KmpVibration {
    actual companion object {
        actual fun startVibrating(durationMs: Long) {
            window.navigator.vibrate(durationMs)
        }

        actual fun stopVibrating() {
            window.navigator.vibrate(0)
        }
    }
}