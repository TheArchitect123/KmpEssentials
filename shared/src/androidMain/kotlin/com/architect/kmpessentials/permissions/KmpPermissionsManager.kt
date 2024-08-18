package com.architect.kmpessentials.permissions

import android.Manifest
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
        lateinit var resultLauncher: ActivityResultLauncher<String>
        lateinit var resultManyLauncher: ActivityResultLauncher<Array<String>>
        lateinit var successAction: ActionNoParams

        actual fun isPermissionGranted(permission: Permission): Boolean {
            return when (permission) {
                Permission.Camera -> {
                    KmpAndroid.clientAppContext.checkPermission(
                        Manifest.permission.CAMERA,
                        0,
                        0
                    ) == PackageManager.PERMISSION_GRANTED
                }

                else -> {
                    false
                }
            }
        }

        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) { // requests the runtime permission popup
            if (permission == Permission.Location) { // requires multiple permissions
                requestPermissions(permission, runAction)
            } else {
                successAction = runAction
                if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                    val cpermission = PermissionsTransformer.getPermissionFromEnum(permission)
                    if (KmpAndroid.clientAppContext.checkSelfPermission(
                            cpermission,
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
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