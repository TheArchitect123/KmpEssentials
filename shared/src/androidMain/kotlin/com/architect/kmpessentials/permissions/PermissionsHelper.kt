package com.architect.kmpessentials.permissions

import android.content.pm.PackageManager
import com.architect.kmpessentials.KmpAndroid

internal object PermissionsHelper {
    fun checkSelfPermission(permission: String): PermissionStatus {
        return when (KmpAndroid.clientAppContext.packageManager.checkPermission(
            permission,
            KmpAndroid.clientAppContext.packageName
        )) {
            PackageManager.PERMISSION_GRANTED -> PermissionStatus.Granted
            PackageManager.PERMISSION_DENIED -> PermissionStatus.Denied
            else -> PermissionStatus.Idle
        }
    }

    fun hasHardwareFeature(feature: String) : Boolean{
        return KmpAndroid.clientAppContext.packageManager.hasSystemFeature(feature)
    }
}