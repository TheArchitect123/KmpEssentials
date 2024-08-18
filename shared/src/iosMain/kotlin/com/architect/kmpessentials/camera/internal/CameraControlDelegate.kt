package com.architect.kmpessentials.camera.internal

import com.architect.kmpessentials.internal.ActionStringParams
import platform.UIKit.UIImage
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.darwin.NSObject

class CameraControlDelegate(val actionResult: ActionStringParams) : NSObject(),
    UIImagePickerControllerDelegateProtocol {
    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo: Map<Any?, *>
    ) {
        picker.dismissModalViewControllerAnimated(true)

        val image =
            didFinishPickingMediaWithInfo.firstNotNullOf { it.key == "editedImage" } as UIImage
    }
}