package com.architect.kmpessentials.flashlight

import org.bytedeco.javacv.OpenCVFrameGrabber

actual class KmpFlashlight {
    actual companion object {
        // I need to write JNI Apis directly.
        // So I can access the native apis on each platform
        // currently this relies on the device determining whether (based on environment, lighting, etc), if flashlight needs to be turned on
        private var flashLight: OpenCVFrameGrabber? = null

        actual fun turnOnFlashlight() {
            flashLight = OpenCVFrameGrabber(0)
            flashLight!!.start()
        }

        actual fun turnOffFlashlight() {
            flashLight?.stop()
            flashLight?.release()
            flashLight = null
        }

        actual fun turnOnFlashLightWithAdjustableStrength(strengthLevel: FlashLightMode) {
            turnOnFlashlight()
        }
    }
}