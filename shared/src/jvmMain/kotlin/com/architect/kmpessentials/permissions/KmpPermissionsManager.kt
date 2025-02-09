package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionPermissionStatusParams
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.permissions.helpers.CameraPermissionHandler
import com.architect.kmpessentials.permissions.helpers.LocationPermissionHandler
import com.architect.kmpessentials.permissions.helpers.MicrophonePermissionHandler
import com.architect.kmpessentials.permissions.helpers.PermissionsHandler
import com.architect.kmpessentials.permissions.helpers.PhotoGalleryPermission

actual class KmpPermissionsManager {
    actual companion object {
        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            when (permission) {
                Permission.Camera -> {
                    CameraPermissionHandler.requestCameraPermission()
                }

                Permission.PhotoGallery -> {
                    PhotoGalleryPermission.requestPhotoGalleryPermission()
                }

                Permission.Location -> {
                    LocationPermissionHandler.requestLocationPermission()
                }

                Permission.Microphone -> {
                    MicrophonePermissionHandler.requestMicrophonePermission()
                }

                else -> KmpLogging.writeError(
                    "JVM_APIS",
                    "Permission request not supported for $permission on JVM."
                )
            }
        }

        actual fun isPermissionGranted(permission: Permission): Boolean {
            return PermissionsHandler.isPermissionAutomaticallyGranted(permission)
        }

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {
            actionResult(PermissionsHandler.isPermissionAutomaticallyGranted(permission))
        }

        actual fun canShowPromptDialog(permission: Permission, actionResult: ActionBoolParams) {
            actionResult(true)
        }

        actual fun getCurrentPermissionState(
            permission: Permission,
            actionResult: ActionPermissionStatusParams
        ) {

        }
    }
}
