package com.architect.kmpessentials.camera

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLInputElement
import org.w3c.files.get

actual class KmpCamera {
    actual companion object {
        actual fun isSupported(): Boolean {
            return window.navigator.asDynamic().mediaDevices?.getUserMedia != undefined
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {
            val input = document.createElement("input") as HTMLInputElement
            input.type = "file"
            input.accept = "image/*"
            input.setAttribute("capture", "environment")

            input.onchange = {
                val file = input.files?.get(0)
                val path = "${window.asDynamic().URL.createObjectURL(file)}"
                actionResult(path)
            }

            input.click() // Opens the device's camera app, opens file picker on browser

            // to show camera stream, users will have to modify the DOM
        }

        actual fun captureVideo(actionResult: ActionStringParams) {
            val input = document.createElement("input") as HTMLInputElement
            input.type = "file"
            input.accept = "video/*"
            input.setAttribute("capture", "environment")

            input.onchange = {
                val file = input.files?.get(0)
                val path = "${window.asDynamic().URL.createObjectURL(file)}"
                actionResult(path)
            }

            input.click() // Opens the device's camera app
        }
    }
}