package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionPermissionStatusParams

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

        actual fun canShowPromptDialog(permission: Permission, actionResult: ActionBoolParams) {

        }

        actual fun getCurrentPermissionState(permission: Permission, actionResult: ActionPermissionStatusParams){

        }
    }
}