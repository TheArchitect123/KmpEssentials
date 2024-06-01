package com.architect.kmpessentials.vibration

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Vibrator
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.permissions.PermissionStatus
import com.architect.kmpessentials.permissions.PermissionsHelper

actual class KmpVibration {
    actual companion object {
        private val vibrator by lazy {
            KmpAndroid.clientAppContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }

        @SuppressLint("MissingPermission")
        actual fun startVibrating(durationMs: Long) {
            if (PermissionsHelper.checkSelfPermission(Manifest.permission.VIBRATE) == PermissionStatus.Granted) {
                vibrator.vibrate(durationMs)
            }
        }

        @SuppressLint("MissingPermission")
        actual fun stopVibrating() {
            if (PermissionsHelper.checkSelfPermission(Manifest.permission.VIBRATE) == PermissionStatus.Granted) {
                vibrator.cancel()
            }
        }
    }
}