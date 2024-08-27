package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionNoParams

expect class KmpPermissionsManager {
    companion object {
        /**
         * Requests a runtime permission based on the "permission" parameter specified
         * Must be invoked on the main thread (otherwise could cause a crash)
         * */
        fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        )

        /**
         * Must be invoked on the main thread (otherwise could cause a crash)
         * @return True if the permission is granted, False if Denied
         * */
        fun isPermissionGranted(permission: Permission): Boolean
    }
}