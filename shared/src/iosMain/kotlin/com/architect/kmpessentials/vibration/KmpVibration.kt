package com.architect.kmpessentials.vibration

import platform.AudioToolbox.AudioServicesPlaySystemSound
import platform.AudioToolbox.kSystemSoundID_Vibrate

actual class KmpVibration {
    actual companion object {
        actual fun startVibrating(durationMs: Long) {
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate)
        }

        actual fun stopVibrating() {

        }
    }
}