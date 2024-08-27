package com.architect.kmpessentials.camera.internal

import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.share.KmpShare
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AssetsLibrary.ALAssetOrientation
import platform.AssetsLibrary.ALAssetsLibrary
import platform.Foundation.NSURL
import platform.UIKit.UIImage
import platform.UIKit.UIImageOrientation
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImageWriteToSavedPhotosAlbum
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.darwin.NSObject

internal class CameraControlDelegate(val actionResult: ActionStringParams) : NSObject(),
    UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
    override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
        picker.dismissViewControllerAnimated(true, null)
    }

    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo: Map<Any?, *>
    ) {
        picker.dismissViewControllerAnimated(true) {
            // when picking a video file
            val videoMeta = didFinishPickingMediaWithInfo["mediaURL"] as? NSURL?
            if (videoMeta != null) {
                actionResult(videoMeta.absoluteString ?: "")
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingImage: UIImage,
        editingInfo: Map<Any?, *>?
    ) {
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
                    actionResult(pathFile)
                }
            }
        }
    }
}