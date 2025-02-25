package com.architect.kmpessentials.mediaPicker

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLInputElement
import org.w3c.files.get

actual class KmpMediaPicker {
    actual companion object {
        private fun pickMediaFile(actionResult: ActionStringParams, mediaType: String){
            val input = document.createElement("input") as HTMLInputElement
            input.type = "file"
            input.accept = mediaType
            input.onchange = {
                val file = input.files?.get(0) // Get selected file
                if (file != null) {
                    val path = "${window.asDynamic().URL.createObjectURL(file)}"
                    actionResult(path) // Return file URL
                }
            }
            input.click() // Open file picker dialog
        }
        actual fun pickPhotoFromGallery(actionResult: ActionStringParams) {
            pickMediaFile(actionResult, "image/*")
        }

        actual fun pickVideoFromGallery(actionResult: ActionStringParams) {
            pickMediaFile(actionResult, "video/*")
        }
    }
}