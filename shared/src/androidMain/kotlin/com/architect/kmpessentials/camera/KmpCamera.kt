package com.architect.kmpessentials.camera

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.permissions.PermissionsHelper

actual class KmpCamera {
    actual companion object {
        lateinit var resultLauncher: ActivityResultLauncher<Intent>

        actual fun isSupported(): Boolean {
            return PermissionsHelper.hasHardwareFeature(PackageManager.FEATURE_CAMERA)
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(KmpAndroid.clientAppContext.packageManager) != null) {
                KmpAndroid.clientAppContext.startActivity(takePictureIntent)
            }
        }
    }
}