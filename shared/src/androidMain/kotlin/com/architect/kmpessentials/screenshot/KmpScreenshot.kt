package com.architect.kmpessentials.screenshot

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.screenshot.internals.ScreenshotManager

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(
            action: ActionStringParams,
            shareDialogTitle: String,
            shareImage: Boolean
        ) // generates a screenshot from the user's device, and returns the file path of the screenshot,
        // from the user's media library
        {
            val screenshotManager = ScreenshotManager(KmpAndroid.clientAppContext)
            screenshotManager.captureScreenshot(object : ScreenshotManager.OnResultListener {
                override fun result(success: Boolean, bitmap: Bitmap?) {
                    // do whatever you want
                    if (success) {
                        KmpMainThread.runViaMainThread {
                            try {
                                // write file to cache directory
                                val mediaStore = MediaStore.Images.Media.insertImage(
                                    KmpAndroid.applicationContext.contentResolver,
                                    bitmap,
                                    shareDialogTitle,
                                    ""
                                )
                                val photoForScreen = Uri.parse(mediaStore)
                                if (shareImage) { // share image with Intent Chooser
                                    KmpAndroid.clientAppContext.startActivity(Intent(Intent.ACTION_SEND).apply {
                                        putExtra(Intent.EXTRA_STREAM, photoForScreen)
                                        type = "image/*"
                                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                    })
                                }

                                action(mediaStore)
                            } catch (ex: Exception) {
                                // failed to parse uri for media screen -- need to add internal telemetry
                            }
                        }
                    }
                }
            })
        }

        actual fun isSupported(): Boolean {
            return true
        }
    }
}