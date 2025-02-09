package com.architect.kmpessentials.camera

import com.architect.kmpessentials.logging.KmpLogging
import org.bytedeco.ffmpeg.global.avcodec
import org.bytedeco.javacv.FFmpegFrameRecorder
import org.bytedeco.javacv.OpenCVFrameGrabber
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean

class JvmVideoRecorder() {
    private var grabber: OpenCVFrameGrabber? = null
    private var recorder: FFmpegFrameRecorder? = null
    private val recording = AtomicBoolean(false)
    private var recordingThread: Thread? = null

    private var streamedFile: File? = null
    fun startStreaming() {
        if (recording.get()) {
            return
        }

        grabber = OpenCVFrameGrabber(0) // 0 = Default webcam
        grabber!!.start()

        val uniqueId = "${System.currentTimeMillis()}_kmp_essentials.mp4"
        streamedFile = File(uniqueId)
        recorder = FFmpegFrameRecorder(streamedFile, grabber!!.imageWidth, grabber!!.imageHeight)
        recorder!!.frameRate = 30.0
        recorder!!.videoCodec = avcodec.AV_CODEC_ID_H264 // Use H.264 codec for MP4
        recorder!!.format = "mp4"
        recorder!!.start()

        recording.set(true)

        // Start a new thread to handle recording
        recordingThread = Thread {
            KmpLogging.writeInfo("JVM_CAMERA", "Recording started...")
            try {
                while (recording.get()) {
                    val frame = grabber!!.grab()
                    if (frame != null) {
                        recorder!!.record(frame)
                    }
                }
            } catch (e: Exception) {
                KmpLogging.writeError("JVM_CAMERA", "Error during recording: ${e.message}")
            } finally {
                releaseResources()
            }
        }

        recordingThread!!.start()
    }

    fun stopStreaming(): File? {
        if (!recording.get()) {
            return null
        }

        recording.set(false)
        recordingThread?.join() // Wait for the recording thread to finish

        return streamedFile!!
    }

    private fun releaseResources() {
        try {
            grabber?.stop()
            recorder?.stop()
            grabber?.release()
            recorder?.release()
            grabber = null
            recorder = null
        } catch (e: Exception) {
            KmpLogging.writeError("JVM_CAMERA", "Error stopping recorder: ${e.message}")
        }
    }
}