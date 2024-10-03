package com.architect.kmpessentials.camera

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission
import com.architect.kmpessentials.permissions.PermissionsHelper
import com.nareshchocha.filepickerlibrary.models.ImageCaptureConfig
import com.nareshchocha.filepickerlibrary.models.VideoCaptureConfig
import com.nareshchocha.filepickerlibrary.ui.FilePicker

actual class KmpCamera {
    actual companion object {
        internal lateinit var resultLauncher: ActivityResultLauncher<Intent>
        internal lateinit var actionResult: ActionStringParams

        actual fun isSupported(): Boolean {
            return PermissionsHelper.hasHardwareFeature(PackageManager.FEATURE_CAMERA)
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            this.actionResult = actionResult
            KmpPermissionsManager.isPermissionGranted(Permission.Camera) {
                if (it) {
                    resultLauncher.launch(
                        FilePicker.Builder(KmpAndroid.clientAppContext)
                            .imageCaptureBuild(ImageCaptureConfig(isUseRearCamera = true))
                    )
                } else {
                    KmpLogging.writeErrorWithCode(ErrorCodes.PERMISSION_NOT_GRANTED_REQUESTING_NOW)
                    KmpPermissionsManager.requestPermission(Permission.Camera) {
                        capturePhoto(actionResult)
                    }
                }
            }
        }

        actual fun captureVideo(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                this.actionResult = actionResult
                KmpPermissionsManager.isPermissionGranted(Permission.Camera) {
                    if (it) {
                        resultLauncher.launch(
                            FilePicker.Builder(KmpAndroid.clientAppContext)
                                .videoCaptureBuild(VideoCaptureConfig(isHighQuality = true))
                        )
                    } else {
                        KmpLogging.writeErrorWithCode(ErrorCodes.PERMISSION_NOT_GRANTED_REQUESTING_NOW)
                        KmpPermissionsManager.requestPermission(Permission.Camera) {
                            captureVideo(actionResult)
                        }
                    }
                }
            }
        }
    }
}