package com.architect.kmpessentials.screenshot

import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.share.KmpShare

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(
            action: ActionStringParams,
            shareDialogTitle: String,
            shareImage: Boolean
        ) // generates a screenshot from the user's device, and returns the file path of the screenshot,
        {
//            KmpMainThread.runViaMainThread {
//                val root = KmpWatchKit.getRootWatchController()!!.
//
//                val renderer = UIGraphicsImageRenderer(root.bounds)
//                val screenShot = renderer.imageWithActions {
//                    root.drawViewHierarchyInRect(root.bounds, true)
//                }
//
//                ALAssetsLibrary().writeImageToSavedPhotosAlbum(
//                    screenShot.CGImage,
//                    when (screenShot.imageOrientation) {
//                        UIImageOrientation.UIImageOrientationUp -> ALAssetOrientation.ALAssetOrientationUp
//                        UIImageOrientation.UIImageOrientationDown -> ALAssetOrientation.ALAssetOrientationDown
//                        UIImageOrientation.UIImageOrientationLeft -> ALAssetOrientation.ALAssetOrientationLeft
//                        UIImageOrientation.UIImageOrientationRight -> ALAssetOrientation.ALAssetOrientationRight
//                        UIImageOrientation.UIImageOrientationUpMirrored -> ALAssetOrientation.ALAssetOrientationUpMirrored
//                        UIImageOrientation.UIImageOrientationDownMirrored -> ALAssetOrientation.ALAssetOrientationDownMirrored
//                        UIImageOrientation.UIImageOrientationLeftMirrored -> ALAssetOrientation.ALAssetOrientationLeftMirrored
//                        else -> ALAssetOrientation.ALAssetOrientationRightMirrored
//                    }
//                ) { path, error ->
//                    if (error == null) {
//                        val pathFile = path?.absoluteString!!
//                        action(pathFile)
//
//                        if (shareImage) {
//                            KmpShare.shareFileWithAnyApp(pathFile, shareDialogTitle)
//                        }
//                    }
//                }
//            }
        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}