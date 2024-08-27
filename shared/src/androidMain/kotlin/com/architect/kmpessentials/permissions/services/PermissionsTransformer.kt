package com.architect.kmpessentials.permissions.services

import android.Manifest
import android.os.Build
import com.architect.kmpessentials.permissions.Permission

internal object PermissionsTransformer {
    fun getPermissionFromEnum(permission: Permission): String {
        return when (permission) {
            Permission.Sms -> Manifest.permission.SEND_SMS
            Permission.Microphone -> Manifest.permission.RECORD_AUDIO
            Permission.Camera -> Manifest.permission.CAMERA
            Permission.Location -> Manifest.permission.ACCESS_FINE_LOCATION
            Permission.CoarseLocation -> Manifest.permission.ACCESS_COARSE_LOCATION
            Permission.PushNotifications -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Manifest.permission.POST_NOTIFICATIONS
            } else {
                ""
            }
            Permission.ExternalStorage -> Manifest.permission.READ_EXTERNAL_STORAGE
            else -> ""
        }
    }

    fun getPermissionsFromEnum(permission: Permission): Array<String> {
        if (permission == Permission.Location) {
            return arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        }

        return arrayOf("")
    }
}