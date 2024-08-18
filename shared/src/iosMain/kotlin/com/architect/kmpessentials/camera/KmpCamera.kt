package com.architect.kmpessentials.camera

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.camera.internal.CameraControlDelegate
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerSourceType

actual class KmpCamera {
    actual companion object {
        actual fun isSupported(): Boolean {
            return true
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            KmpMainThread.runViaMainThread {
                val camera = UIImagePickerController()
                camera.sourceType =
                    UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
                camera.allowsEditing = true

                KmpiOS.getTopViewController()?.presentViewController(camera, true, null)
            }
        }
    }

}