package com.architect.kmpessentials.permissions.services

import android.Manifest
import com.architect.kmpessentials.permissions.Permission

internal object PermissionsTransformer {
    fun getPermissionFromEnum(permission: Permission): String {
        return when (permission) {
            Permission.Camera -> Manifest.permission.CAMERA
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