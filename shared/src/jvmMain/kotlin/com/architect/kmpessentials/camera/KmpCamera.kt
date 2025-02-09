package com.architect.kmpessentials.camera

import com.architect.kmpessentials.internal.ActionStringParams
import org.bytedeco.javacv.Java2DFrameConverter
import org.bytedeco.javacv.OpenCVFrameGrabber
import java.io.File
import javax.imageio.ImageIO

actual class KmpCamera {
    actual companion object {
        private val videoStreamer by lazy {
            JvmVideoRecorder()
        }

        actual fun isSupported(): Boolean {
            return true
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            val frameGrabber = OpenCVFrameGrabber(0)
            frameGrabber.start()

            val frame = frameGrabber.grab()
            if (frame != null) {
                val converter = Java2DFrameConverter()
                val bufferedImage = converter.convert(frame)

                val uniqueId = "${System.currentTimeMillis()}_kmp_essentials.jpg"
                val outputFile = File(uniqueId)
                ImageIO.write(bufferedImage, "jpg", outputFile)
                actionResult(outputFile.absolutePath)
            }

            frameGrabber.stop()
        }

        actual fun captureVideo(actionResult: ActionStringParams) {
            this.actionResult = actionResult
            videoStreamer.startStreaming()
        }

        private var actionResult: ActionStringParams? = null
        fun stopRecordingVideo() {
            val streamedVideo = videoStreamer.stopStreaming()
            if(streamedVideo != null) {
                actionResult?.invoke(streamedVideo.absolutePath)
            }
        }
    }
}
