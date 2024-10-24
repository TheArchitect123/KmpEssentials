package com.architect.kmpessentials.share

import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.Foundation.NSData
import platform.Foundation.NSFileManager
import platform.Foundation.dataWithContentsOfFile
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication

actual class KmpShare {
    actual companion object {
        private var fileType = ""

        actual fun setFileType(cFileType: String): Companion {
            fileType = cFileType
            return this
        }

        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val activityController = UIActivityViewController(listOf(text), null)
                UIApplication.sharedApplication.keyWindow?.rootViewController()
                    ?.presentViewController(activityController, true) {
                        com.architect.kmpessentials.share.KmpShare.Companion.resetFileSettings()
                    }
            }
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            if (filePath.isNotBlank() && NSFileManager.defaultManager.fileExistsAtPath(filePath)) {
                KmpMainThread.runViaMainThread {
                    val physicalFile = NSData.dataWithContentsOfFile(filePath)
                    val activityController = UIActivityViewController(listOf(physicalFile), null)

                    UIApplication.sharedApplication.keyWindow?.rootViewController()
                        ?.presentViewController(activityController, true) {
                            resetFileSettings()
                        }
                }
            } else {
                KmpLogging.writeErrorWithCode(ErrorCodes.FILE_NOT_FOUND)
            }
        }

        private fun resetFileSettings() {
            fileType = ""
        }
    }
}