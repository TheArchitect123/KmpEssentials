package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionNoParams

expect class KmpPermissionsManager {
    companion object {
        fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        )
        fun isPermissionGranted(permission: Permission): Boolean
    }
}