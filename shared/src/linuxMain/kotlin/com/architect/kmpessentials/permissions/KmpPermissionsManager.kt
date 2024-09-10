package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams

actual class KmpPermissionsManager {
    actual companion object {
        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {

        }

        actual fun isPermissionGranted(permission: Permission): Boolean {
            return false
        }

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {

        }
    }
}