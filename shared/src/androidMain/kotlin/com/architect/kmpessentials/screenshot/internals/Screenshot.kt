package com.architect.kmpessentials.screenshot.internals

import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaActionSound
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.view.PixelCopy
import android.widget.Toast
import androidx.annotation.FloatRange
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.drawToBitmap
import java.io.File

class Screenshot(private val appCompatActivity: AppCompatActivity?) {

    private var lastFileObject: File? = null
    private var internalSaveScreenshot = true
    private var internalShutterSound = false
    private var internalPreview = true
    private var internalDimAmount = 0.5f
    private var internalFilename = "Screenshot.png"

    /**
     * If set to true a preview dialog of the screenshot will be shown.
     * Default is true.
     */
    var preview: Boolean
        get() {
            return internalPreview
        }
        set(enabled) {
            internalPreview = enabled
        }

    /**
     * If set to true a shutter sound will be played.
     * Default is false.
     */
    var shutterSound: Boolean
        get() {
            return internalShutterSound
        }
        set(enabled) {
            internalShutterSound = enabled
        }

    /**
     * If set to true the taken screenshot will be saved into the internal app directory.
     * Default is true.
     */
    var saveScreenshot: Boolean
        get() {
            return internalSaveScreenshot
        }
        set(enabled) {
            internalSaveScreenshot = enabled
        }

    /**
     * Set the amount of dim behind the preview dialog.
     * Use '0.0f' for no dim and '1.0f' for full dim.
     * Default is 0.5f.
     */
    var dimAmount: Float
        get() {
            return internalDimAmount
        }
        set(@FloatRange(from = 0.0, to = 1.0) amount) {
            internalDimAmount = amount
        }

    /**
     * The filename for the taken screenshot.
     * Default is "Screenshot.png".
     */
    var fileName: String
        get() {
            return internalFilename
        }
        set(name) {
            internalFilename = name
        }

    /**
     * The Screenshot OnResultListener.
     */
    interface OnResultListener {
        /**
         * The Screenshot OnResultListener.
         *
         * @param success Boolean
         * @param bitmap Bitmap?
         */
        fun result(success: Boolean, bitmap: Bitmap?)
    }

    /**
     * Takes a screenshot from the current users display.
     */
    fun takeScreenshot(onResultListener: OnResultListener?) {
        val view = appCompatActivity?.window?.decorView?.rootView
        if (appCompatActivity == null || view == null) {
            onResultListener?.result(success = false, bitmap = null)
            return
        }
        val bitmap = try {
            view.drawToBitmap()
        } catch (ignored: IllegalStateException) {
            null
        }
        if (bitmap == null) {
            onResultListener?.result(success = false, bitmap = null)
            return
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PixelCopy.request(
                appCompatActivity.window, bitmap,
                {
                    val success = it == PixelCopy.SUCCESS
                    onResultListener?.result(success = success, bitmap = bitmap)

                    if (success) {
                        if (internalShutterSound) {
                            MediaActionSound().apply {
                                load(MediaActionSound.SHUTTER_CLICK)
                                play(MediaActionSound.SHUTTER_CLICK)
                            }
                        }
                        if (saveScreenshot) {
                            bitmap.saveScreenshotToAppDirectory()
                        } else {
                            lastFileObject = null
                        }
                    }
                }, Handler(Looper.getMainLooper())
            )
        }
    }

    /**
     * Use this method to open the last taken screenshot file.
     *
     * @param showErrorToast Boolean = false
     */
    fun openLastScreenshot(showErrorToast: Boolean = false) {
        try {
            appCompatActivity ?: return
            lastFileObject?.let { lastFile ->
                val fileUri: Uri = FileProvider.getUriForFile(
                    appCompatActivity,
                    appCompatActivity.packageName + ".provider",
                    lastFile
                )

                val intent = Intent(Intent.ACTION_VIEW, fileUri).apply {
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                appCompatActivity.startActivity(intent)
            }
        } catch (e: Exception) {
            if (showErrorToast) {
                Toast.makeText(appCompatActivity, e.message ?: "Exception!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun getFileObject(): File? {
        val name = if (fileName.trim().isEmpty()) {
            "Screenshot.png"
        } else {
            fileName
        }

        lastFileObject = if (appCompatActivity == null) {
            null
        } else {
            File(
                appCompatActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "${name}.png"
            )
        }
        return lastFileObject
    }

    private fun Bitmap?.saveScreenshotToAppDirectory() {
        this ?: return
        getFileObject()?.writeBitmap(this)
    }

    private fun File.writeBitmap(bitmap: Bitmap) {
        outputStream().use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
        }
    }

}