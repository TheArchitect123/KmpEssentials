package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionNoParams

expect class KmpPermissionsManager {
    companion object {
        /**
         * Requests a runtime permission based on the "permission" parameter specified
         * */
        fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        )

        /**
         * @return True if the permission is granted, False if Denied
         * */
        fun isPermissionGranted(permission: Permission): Boolean
    }
}