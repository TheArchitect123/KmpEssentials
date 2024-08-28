package com.architect.kmpessentials.camera.internal

import com.architect.kmpessentials.camera.KmpCamera
import platform.AssetsLibrary.ALAssetsLibrary
import platform.Foundation.NSURL
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerMediaURL
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.darwin.NSObject

internal class VideoCameraControlDelegate : NSObject(),
    UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
    override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
        picker.dismissViewControllerAnimated(true, null)
    }

    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo: Map<Any?, *>
    ) {
        val didFinishPickingVideo =
            didFinishPickingMediaWithInfo[UIImagePickerControllerMediaURL] as NSURL
        picker.dismissViewControllerAnimated(true) {
            ALAssetsLibrary().writeVideoAtPathToSavedPhotosAlbum(didFinishPickingVideo){ res, error ->
                if(error == null && !res?.absoluteString.isNullOrBlank()){
                    KmpCamera.videoActionResult(res!!.absoluteString!!)
                }
            }
        }
    }
}