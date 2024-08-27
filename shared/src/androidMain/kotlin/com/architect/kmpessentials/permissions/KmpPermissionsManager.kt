package com.architect.kmpessentials.permissions

import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.permissions.services.PermissionsTransformer

actual class KmpPermissionsManager {
    actual companion object {
        internal lateinit var resultLauncher: ActivityResultLauncher<String>
        internal lateinit var resultManyLauncher: ActivityResultLauncher<Array<String>>
        internal lateinit var successAction: ActionNoParams

        actual fun isPermissionGranted(permission: Permission): Boolean {
            if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                return KmpAndroid.applicationContext.checkSelfPermission(
                    PermissionsTransformer.getPermissionFromEnum(permission)
                ) == PackageManager.PERMISSION_GRANTED
            }

            return true
        }

        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            if (permission == Permission.Location) { // requires multiple permissions
                requestPermissions(permission, runAction)
            } else {
                successAction = runAction
                if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                    val cpermission = PermissionsTransformer.getPermissionFromEnum(permission)
                    if (isPermissionGranted(permission)) {
                        successAction()
                    } else {
                        resultLauncher.launch(cpermission)
                    }
                } else {
                    successAction()
                }
            }
        }

        // check if using location permission
        private fun requestPermissions(
            permission: Permission,
            runAction: DefaultAction
        ) { // requests the runtime permission popup
            successAction = runAction
            if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                val cpermission = PermissionsTransformer.getPermissionsFromEnum(permission)
                val deniedPermissions = cpermission.filter {
                    KmpAndroid.clientAppContext.checkSelfPermission(
                        it,
                    ) != PackageManager.PERMISSION_GRANTED
                }.toTypedArray()

                if (deniedPermissions.isNotEmpty()) {
                    resultManyLauncher.launch(deniedPermissions)
                } else {
                    successAction()
                }
            } else {
                successAction()
            }
        }
    }
}