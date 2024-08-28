package com.architect.kmpessentials.mediaPicker

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.mediaPicker.delegates.ImageMediaPickerDelegate
import com.architect.kmpessentials.mediaPicker.delegates.MediaPickerDelegate
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerSourceType

actual class KmpMediaPicker {
    actual companion object {
        private val photoDelegate = ImageMediaPickerDelegate()
        internal lateinit var photoActionResult: ActionStringParams

        private val videoDelegate = MediaPickerDelegate()
        internal lateinit var videoActionResult: ActionStringParams

        private fun getCameraPicker(): UIImagePickerController {
            val camera = UIImagePickerController()
            camera.sourceType =
                UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary
            camera.allowsEditing = true
            return camera
        }

        actual fun pickPhotoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                photoActionResult = actionResult
                val camera = getCameraPicker()
                camera.mediaTypes = listOf("public.png", "public.jpeg", "public.gif")
                camera.setDelegate(photoDelegate)
                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }

        actual fun pickVideoFromGallery(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                videoActionResult = actionResult

                val camera = getCameraPicker()
                camera.mediaTypes = listOf("public.movie", "public.mpeg-4", "public.mpeg-2-video")
                camera.setDelegate(videoDelegate)

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }
    }
}