package com.architect.kmpessentials.vibration

actual class KmpVibration {
    actual companion object {
        actual fun startVibrating(durationMs: Long) {
         //   AudioServ(kSystemSoundID_Vibrate)
        }

        actual fun stopVibrating() {

        }
    }
}