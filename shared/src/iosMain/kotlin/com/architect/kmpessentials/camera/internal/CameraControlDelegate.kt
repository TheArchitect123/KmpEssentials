package com.architect.kmpessentials.camera.internal

import com.architect.kmpessentials.camera.KmpCamera
import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AssetsLibrary.ALAssetOrientation
import platform.AssetsLibrary.ALAssetsLibrary
import platform.UIKit.UIImage
import platform.UIKit.UIImageOrientation
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerOriginalImage
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.darwin.NSObject

internal class CameraControlDelegate : NSObject(),
    UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
    override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
        picker.dismissViewControllerAnimated(true, null)
    }

    @OptIn(ExperimentalForeignApi::class)
    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo: Map<Any?, *>
    ) {
        val didFinishPickingImage =
            didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as UIImage
        picker.dismissViewControllerAnimated(true) {
            ALAssetsLibrary().writeImageToSavedPhotosAlbum(
                didFinishPickingImage.CGImage,
                when (didFinishPickingImage.imageOrientation) {
                    UIImageOrientation.UIImageOrientationUp -> ALAssetOrientation.ALAssetOrientationUp
                    UIImageOrientation.UIImageOrientationDown -> ALAssetOrientation.ALAssetOrientationDown
                    UIImageOrientation.UIImageOrientationLeft -> ALAssetOrientation.ALAssetOrientationLeft
                    UIImageOrientation.UIImageOrientationRight -> ALAssetOrientation.ALAssetOrientationRight
                    UIImageOrientation.UIImageOrientationUpMirrored -> ALAssetOrientation.ALAssetOrientationUpMirrored
                    UIImageOrientation.UIImageOrientationDownMirrored -> ALAssetOrientation.ALAssetOrientationDownMirrored
                    UIImageOrientation.UIImageOrientationLeftMirrored -> ALAssetOrientation.ALAssetOrientationLeftMirrored
                    else -> ALAssetOrientation.ALAssetOrientationRightMirrored
                }
            ) { path, error ->
                if (error == null) {
                    val pathFile = path?.absoluteString!!
                    KmpCamera.photoActionResult(pathFile)
                }
            }
        }
    }
}


