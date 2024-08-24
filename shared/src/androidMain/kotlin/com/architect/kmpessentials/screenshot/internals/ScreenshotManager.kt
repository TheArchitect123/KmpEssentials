package com.architect.kmpessentials.screenshot.internals

import android.app.Activity
import android.graphics.Bitmap
import android.media.MediaActionSound
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.view.PixelCopy
import androidx.core.view.drawToBitmap
import java.io.File

internal class ScreenshotManager(private val appCompatActivity: Activity?) {
    interface OnResultListener {
        fun result(success: Boolean, bitmap: Bitmap?)
    }

    fun captureScreenshot(onResultListener: OnResultListener?) {
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PixelCopy.request(
                appCompatActivity.window, bitmap,
                {
                    val success = it == PixelCopy.SUCCESS
                    onResultListener?.result(success = success, bitmap = bitmap)

                    if (success) {
                        MediaActionSound().apply {
                            load(MediaActionSound.SHUTTER_CLICK)
                            play(MediaActionSound.SHUTTER_CLICK)
                        }

                        bitmap.saveScreenshotToAppDirectory()
                    }
                }, Handler(Looper.getMainLooper())
            )
        }
    }

    private fun getFileObject(): File {
        return File(
            appCompatActivity!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
            "defaultScreenshot.png"
        )
    }

    private fun Bitmap?.saveScreenshotToAppDirectory() {
        this ?: return
        getFileObject().writeBitmap(this)
    }

    private fun File.writeBitmap(bitmap: Bitmap) {
        outputStream().use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
        }
    }
}