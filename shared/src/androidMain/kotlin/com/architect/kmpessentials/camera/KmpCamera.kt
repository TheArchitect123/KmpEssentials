package com.architect.kmpessentials.camera

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.PermissionsHelper

actual class KmpCamera {
    actual companion object {
        lateinit var resultLauncher: ActivityResultLauncher<Intent>
        lateinit var actionResult: ActionStringParams
        lateinit var imagePickerResult: ActionStringParams
        lateinit var galleryLauncher: ActivityResultLauncher<String>

        actual fun isSupported(): Boolean {
            return PermissionsHelper.hasHardwareFeature(PackageManager.FEATURE_CAMERA)
        }

        actual fun pickPhotoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                this.imagePickerResult = actionResult
                galleryLauncher.launch("image/*")
            }
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                this.actionResult = actionResult
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePictureIntent.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                    resultLauncher.launch(takePictureIntent)
                }
            }
        }
    }
}