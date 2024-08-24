package com.architect.kmpessentials.mediaPicker

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpMediaPicker {
    actual companion object {
        lateinit var imagePickerResult: ActionStringParams
        lateinit var galleryLauncher: ActivityResultLauncher<Intent>

        actual fun pickPhotoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                imagePickerResult = actionResult
                galleryLauncher.launch(Intent(Intent.ACTION_PICK).apply {
                    type = "image/*"
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
        }

        actual fun pickVideoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                imagePickerResult = actionResult
                galleryLauncher.launch(Intent(Intent.ACTION_PICK).apply {
                    type = "video/*"
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
        }
    }
}