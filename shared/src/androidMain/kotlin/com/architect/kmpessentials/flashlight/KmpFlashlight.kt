package com.architect.kmpessentials.flashlight

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import com.architect.kmpessentials.flashlight.components.FlashlightHardware
import com.architect.kmpessentials.permissions.KmpPermissions
import com.architect.kmpessentials.permissions.PermissionStatus
import com.architect.kmpessentials.permissions.PermissionsHelper

// APIs control flashlight & strength control
// verifies if permission and camera flash feature hardware exists on device.
// if conditions are not met, API does nothing
@TargetApi(Build.VERSION_CODES.M)
actual class KmpFlashlight {
    actual companion object {
        internal val flashLight by lazy {
            FlashlightHardware()
        }

        actual fun turnOnFlashlight() {
            if (PermissionsHelper.checkSelfPermission(KmpPermissions.FLASH_LIGHT) == PermissionStatus.Granted && PermissionsHelper.hasHardwareFeature(
                    PackageManager.FEATURE_CAMERA_FLASH
                )
            ) { // allow toggling of flash light ON
                flashLight.turnOnFlashLight()
            }
        }

        actual fun turnOffFlashlight() {
            if (PermissionsHelper.checkSelfPermission(KmpPermissions.FLASH_LIGHT) == PermissionStatus.Granted && PermissionsHelper.hasHardwareFeature(
                    PackageManager.FEATURE_CAMERA_FLASH
                )
            ) {
                flashLight.turnOffFlashLight()
            }
        }

        @TargetApi(Build.VERSION_CODES.TIRAMISU)
        actual fun turnOnFlashLightWithAdjustableStrength(strengthLevel: FlashLightMode) {
            if (PermissionsHelper.checkSelfPermission(KmpPermissions.FLASH_LIGHT) == PermissionStatus.Granted && PermissionsHelper.hasHardwareFeature(
                    PackageManager.FEATURE_CAMERA_FLASH
                )
            ) {
                flashLight.turnOnFlashLightWithStrengthLevel(strengthLevel)
            }
        }
    }
}