package com.architect.kmpessentials.camera

import com.architect.kmpessentials.KmpiOS
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

        private fun getCameraDevice(): UIImagePickerController {
            val camera = UIImagePickerController()
            camera.sourceType =
                UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
            camera.allowsEditing = true
            return camera
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                val camera = getCameraDevice()
                camera.cameraCaptureMode =
                    UIImagePickerControllerCameraCaptureMode.UIImagePickerControllerCameraCaptureModePhoto

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }

        actual fun captureVideo(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                val camera = getCameraDevice()
                camera.cameraCaptureMode =
                    UIImagePickerControllerCameraCaptureMode.UIImagePickerControllerCameraCaptureModeVideo

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }
    }

}