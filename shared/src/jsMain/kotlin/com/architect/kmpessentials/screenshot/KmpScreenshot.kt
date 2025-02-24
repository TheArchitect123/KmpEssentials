package com.architect.kmpessentials.screenshot

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventListener
import org.w3c.dom.mediacapture.MediaStream

actual class KmpScreenshot {
    actual companion object {
        actual fun getScreenshot(
            action: ActionStringParams,
            shareDialogTitle: String,
            shareImage: Boolean
        )
        {
            val constraints = js("{}") // Create an empty JS object dynamically
            constraints.video = js("{}") // Video capture settings
            constraints.video.displaySurface = "browser" // Capture the browser window

            val mediaDevices = window.navigator.asDynamic().mediaDevices
            if (mediaDevices != undefined && mediaDevices.getDisplayMedia != undefined) {
                mediaDevices.getDisplayMedia(constraints).then { stream: MediaStream ->
                    val video = document.createElement("video") as HTMLVideoElement
                    video.srcObject = stream
                    video.autoplay = true

                    // ✅ FIX: Use `EventListener` explicitly instead of lambda
                    val metadataListener = object : EventListener {
                        override fun handleEvent(event: Event) {
                            val canvas = document.createElement("canvas") as HTMLCanvasElement
                            canvas.width = video.videoWidth
                            canvas.height = video.videoHeight
                            val context = canvas.getContext("2d") as CanvasRenderingContext2D
                            context.drawImage(video, 0.0, 0.0)

                            val imageUrl = canvas.toDataURL("image/png") // Convert to image
                            window.open(imageUrl) // Open screenshot in new tab

                            // Stop video stream after capture
                            stream.getTracks().forEach { it.stop() }
                        }
                    }

                    video.addEventListener("loadedmetadata", metadataListener)
                }.catch { error ->
                    console.log("Error capturing screenshot: ${error.message}")
                }
            } else {
                console.log("Screen capture not supported in this browser.")
            }
        }

        actual fun isSupported(): Boolean {
            return window.navigator.asDynamic().mediaDevices !== undefined
        }
    }
}