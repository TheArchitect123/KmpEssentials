package com.architect.kmpessentials.mediaPicker

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UniformTypeIdentifiers.UTTypeImage
import platform.UniformTypeIdentifiers.UTTypeVideo

actual class KmpMediaPicker {
    actual companion object {
        lateinit var imagePickerResult: ActionStringParams

        private fun getCameraPicker(): UIImagePickerController {
            val camera = UIImagePickerController()
            camera.sourceType =
                UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeSavedPhotosAlbum
            camera.allowsEditing = true
            return camera
        }

        actual fun pickPhotoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                val camera = getCameraPicker()
                camera.mediaTypes = listOf(UTTypeImage)

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }

        actual fun pickVideoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                val camera = getCameraPicker()
                camera.mediaTypes = listOf(UTTypeVideo)

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }
    }
}