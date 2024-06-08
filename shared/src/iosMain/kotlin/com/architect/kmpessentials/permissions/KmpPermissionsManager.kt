package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionNoParams

actual class KmpPermissionsManager {
    actual companion object {
        actual fun requestPermissions(
            permissions: List<Permission>,
            successfulResponse: ActionNoParams
        ) {

        }

        actual fun requestPermission(permission: Permission, successfulResponse: ActionNoParams) {

        }

        actual fun openAppPermissionsSettings() {

        }
    }
}

