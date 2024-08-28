package com.architect.kmpessentials.camera

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.camera.internal.CameraControlDelegate
import com.architect.kmpessentials.camera.internal.VideoCameraControlDelegate
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerCameraCaptureMode
import platform.UIKit.UIImagePickerControllerSourceType

actual class KmpCamera {
    actual companion object {
        actual fun isSupported(): Boolean {
            return true
        }

        internal lateinit var videoActionResult: ActionStringParams
        private val videoDelegate = VideoCameraControlDelegate()

        internal lateinit var photoActionResult: ActionStringParams
        private val photoDelegate = CameraControlDelegate()

        private fun getCameraDevice(): UIImagePickerController {
            val camera = UIImagePickerController()
            camera.sourceType =
                UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
            camera.allowsEditing = true
            return camera
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                photoActionResult = actionResult
                val camera = getCameraDevice()
                camera.cameraCaptureMode =
                    UIImagePickerControllerCameraCaptureMode.UIImagePickerControllerCameraCaptureModePhoto
                camera.delegate = photoDelegate

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }

        actual fun captureVideo(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                videoActionResult = actionResult

                val camera = getCameraDevice()
                camera.mediaTypes = listOf("public.movie")
                camera.cameraCaptureMode =
                    UIImagePickerControllerCameraCaptureMode.UIImagePickerControllerCameraCaptureModeVideo
                camera.delegate = videoDelegate

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }
    }

}