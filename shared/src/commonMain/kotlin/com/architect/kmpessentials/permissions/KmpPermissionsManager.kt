package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionNoParams

expect class KmpPermissionsManager {
    companion object {
        fun requestPermissions(permissions: List<Permission>, successfulResponse: ActionNoParams)
        fun requestPermission(permission: Permission, successfulResponse: ActionNoParams)
        fun openAppPermissionsSettings()
    }
}

