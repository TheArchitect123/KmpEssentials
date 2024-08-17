package com.architect.kmpessentials.share

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.Foundation.NSData
import platform.Foundation.NSFileManager
import platform.Foundation.dataWithContentsOfFile
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication

actual class KmpShare {
    actual companion object {
        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val activityController = UIActivityViewController(listOf(text), null)
                UIApplication.sharedApplication.keyWindow?.rootViewController()
                    ?.presentViewController(activityController, true, null)
            }
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            if (filePath.isNotBlank() && NSFileManager.defaultManager.fileExistsAtPath(filePath)) {
                KmpMainThread.runViaMainThread {
                    val physicalFile = NSData.dataWithContentsOfFile(filePath)
                    val activityController = UIActivityViewController(listOf(physicalFile), null)

                    UIApplication.sharedApplication.keyWindow?.rootViewController()
                        ?.presentViewController(activityController, true, null)
                }
            }
        }
    }
}