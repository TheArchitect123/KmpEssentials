package com.architect.kmpessentials.vibration

import android.annotation.SuppressLint
import android.content.Context
import android.os.Vibrator
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission

actual class KmpVibration {
    actual companion object {
        private val vibrator by lazy {
            KmpAndroid.applicationContext?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }

        @SuppressLint("MissingPermission")
        actual fun startVibrating(durationMs: Long) {
            KmpPermissionsManager.isPermissionGranted(Permission.Vibrator) {
                if (it) {
                    vibrator.vibrate(durationMs)
                } else {
                    KmpLogging.writeErrorWithCode(ErrorCodes.MISSING_PERMISSION_CONFIGURATION)
                }
            }
        }

        @SuppressLint("MissingPermission")
        actual fun stopVibrating() {
            KmpPermissionsManager.isPermissionGranted(Permission.Vibrator) {
                if (it) {
                    vibrator.cancel()
                } else {
                    KmpLogging.writeErrorWithCode(ErrorCodes.MISSING_PERMISSION_CONFIGURATION)
                }
            }
        }
    }
}