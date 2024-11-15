package com.architect.kmpessentials.mediaPicker

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.filePicker.internals.models.PickMediaConfig
import com.architect.kmpessentials.filePicker.internals.models.PickMediaType
import com.architect.kmpessentials.filePicker.internals.ui.FilePicker
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpMediaPicker {
    actual companion object {
        internal lateinit var imagePickerResult: ActionStringParams
        internal lateinit var galleryLauncher: ActivityResultLauncher<Intent>

        actual fun pickPhotoFromGallery(actionResult: ActionStringParams) {
            imagePickerResult = actionResult
            KmpMainThread.runViaMainThread {
                galleryLauncher.launch(
                    FilePicker.Builder(KmpAndroid.clientAppContext!!)
                        .pickMediaBuild(
                            PickMediaConfig(
                                mPickMediaType = PickMediaType.ImageOnly
                            )
                        )
                )
            }
        }

        actual fun pickVideoFromGallery(actionResult: ActionStringParams) {
            imagePickerResult = actionResult
            KmpMainThread.runViaMainThread {
                galleryLauncher.launch(
                    FilePicker.Builder(KmpAndroid.clientAppContext!!)
                        .pickMediaBuild(
                            PickMediaConfig(
                                mPickMediaType = PickMediaType.VideoOnly
                            )
                        )
                )
            }
        }
    }
}