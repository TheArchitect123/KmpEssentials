package com.architect.kmpessentials.screenshot

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.nmd.screenshot.Screenshot

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(
            action: ActionStringParams,
            shareDialogTitle: String,
            shareImage: Boolean
        ) // generates a screenshot from the user's device, and returns the file path of the screenshot,
        // from the user's media library
        {
            val screenshot = Screenshot(KmpAndroid.clientAppContext)
            screenshot.takeScreenshot(object : Screenshot.OnResultListener {
                override fun result(success: Boolean, bitmap: Bitmap?) {
                    // do whatever you want
                    if (success) {
                        KmpMainThread.runViaMainThread {
                            // write file to cache directory
                            val mediaStore = MediaStore.Images.Media.insertImage(
                                KmpAndroid.clientAppContext.contentResolver,
                                bitmap,
                                shareDialogTitle,
                                ""
                            )
                            val photoForScreen = Uri.parse(mediaStore)
                            if (shareImage) { // share image with Intent Chooser
                                KmpAndroid.clientAppContext.startActivity(Intent(Intent.ACTION_SEND).apply {
                                    putExtra(Intent.EXTRA_STREAM, photoForScreen)
                                    type = "image/*"
                                })
                            }

                            action(mediaStore)
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