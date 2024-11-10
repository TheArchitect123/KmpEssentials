package com.architect.kmpessentials.permissions

import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.services.PermissionsTransformer
import com.architect.kmpessentials.secureStorage.KmpPublicStorage

actual class KmpPermissionsManager {
    actual companion object {
        internal lateinit var resultLauncher: ActivityResultLauncher<String>
        internal lateinit var resultManyLauncher: ActivityResultLauncher<Array<String>>
        internal lateinit var successAction: ActionNoParams

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                    actionResult(
                        KmpAndroid.applicationContext?.checkSelfPermission(
                            PermissionsTransformer.getPermissionFromEnum(permission)
                        ) == PackageManager.PERMISSION_GRANTED
                    )
                } else {
                    actionResult(true)
                }
            }
        }

        actual fun isPermissionGranted(permission: Permission): Boolean {
            if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                return KmpAndroid.applicationContext?.checkSelfPermission(
                    PermissionsTransformer.getPermissionFromEnum(permission)
                ) == PackageManager.PERMISSION_GRANTED
            }

            return true
        }


        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            KmpMainThread.runViaMainThread {
                if (permission == Permission.Location) { // requires multiple permissions
                    requestPermissions(permission, runAction)
                } else {
                    successAction = runAction
                    if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                        try {
                            val cpermission =
                                PermissionsTransformer.getPermissionFromEnum(permission)
                            if(cpermission.isNotBlank()) {
                                isPermissionGranted(permission) {
                                    if (it) {
                                        successAction()
                                    } else {
                                        resultLauncher.launch(cpermission)
                                    }
                                }
                            }
                            else {
                                successAction()
                            }
                        }
                        catch (ex: Exception){
                            KmpLogging.writeErrorWithCode(ex.stackTraceToString())
                        }
                    } else {
                        successAction()
                    }
                }
            }
        }

        // check if using location permission
        private fun requestPermissions(
            permission: Permission,
            runAction: DefaultAction
        ) { // requests the runtime permission popup
            KmpMainThread.runViaMainThread {
                successAction = runAction
                if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                    try {
                        val cpermission = PermissionsTransformer.getPermissionsFromEnum(permission)
                        if (cpermission.isNotEmpty()) {
                            val deniedPermissions = cpermission.filter {
                                KmpAndroid.clientAppContext?.checkSelfPermission(
                                    it,
                                ) != PackageManager.PERMISSION_GRANTED
                            }

                            if (deniedPermissions.isNotEmpty()) {
                                resultManyLauncher.launch(deniedPermissions.toTypedArray())
                            } else {
                                successAction()
                            }
                        } else {
                            successAction()
                        }
                    }
                    catch (ex: Exception) {
                        KmpLogging.writeErrorWithCode(ex.stackTraceToString())
                    }
                } else {
                    successAction()
                }
            }
        }

        actual fun canShowPromptDialog(permission: Permission, actionResult: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
                    val cpermission = PermissionsTransformer.getPermissionFromEnum(permission)
                    val hasRequestedPermission =
                       if(cpermission.isNotBlank()) KmpPublicStorage.getBooleanFromKey(cpermission) ?: false else false

                    var isDenied = !isPermissionGranted(permission)
                    if (isDenied && hasRequestedPermission) {
                        if(KmpAndroid.clientAppContext != null) {
                            isDenied = ActivityCompat.shouldShowRequestPermissionRationale(
                                KmpAndroid.clientAppContext!!,
                                cpermission
                            )
                        }
                    }

                    KmpPublicStorage.persistData(cpermission, true)
                    actionResult(
                        isDenied
                    )
                } else {
                    actionResult(true)
                }
            }
        }
    }
}