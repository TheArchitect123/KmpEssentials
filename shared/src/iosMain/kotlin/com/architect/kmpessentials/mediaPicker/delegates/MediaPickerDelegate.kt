package com.architect.kmpessentials.mediaPicker.delegates

import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mediaPicker.KmpMediaPicker
import platform.Foundation.NSURL
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerMediaURL
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.darwin.NSObject

class MediaPickerDelegate : NSObject(),
    UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
    override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
        picker.dismissViewControllerAnimated(true, null)
    }

    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo: Map<Any?, *>
    ) {
        val didFinishPickingMedia =
            didFinishPickingMediaWithInfo[UIImagePickerControllerMediaURL] as NSURL
        picker.dismissViewControllerAnimated(true) {
            if (!didFinishPickingMedia.absoluteString.isNullOrBlank()) {
                KmpMediaPicker.videoActionResult(didFinishPickingMedia.absoluteString!!)
            }
        }
    }
}


