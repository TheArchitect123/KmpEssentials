package com.architect.kmpessentials.camera

import android.content.ContentValues
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

        actual fun isSupported(): Boolean {
            return PermissionsHelper.hasHardwareFeature(PackageManager.FEATURE_CAMERA)
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                this.actionResult = actionResult

                val storeValues = ContentValues()
                storeValues.put(MediaStore.Images.Media.TITLE, "CapturePhoto")

                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                    KmpAndroid.applicationContext.contentResolver.insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        storeValues
                    )
                }

                if (takePictureIntent.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                    resultLauncher.launch(takePictureIntent)
                }
            }
        }

        actual fun captureVideo(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                this.actionResult = actionResult

                val storeValues = ContentValues()
                storeValues.put(MediaStore.Images.Media.TITLE, "CaptureVideo")

                val takeVideoIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE).apply {
                    KmpAndroid.applicationContext.contentResolver.insert(
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                        storeValues
                    )
                }
                if (takeVideoIntent.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                    resultLauncher.launch(takeVideoIntent)
                }
            }
        }
    }
}