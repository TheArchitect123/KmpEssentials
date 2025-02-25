package com.architect.kmpessentials.share

import kotlinx.browser.window
import org.w3c.files.File

actual class KmpShare {
    actual companion object {
        private var fileType = ""

        actual fun setFileType(cFileType: String): Companion {
            fileType = cFileType
            return this
        }

        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            if (window.navigator.asDynamic().share != undefined) {
                window.navigator.asDynamic().share(text).then {

                }.catch {

                }
            } else {

            }
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            window.fetch(filePath).then {
                 it.blob().then { cfile ->
                     val file = File(arrayOf(cfile), "", js("{}")) // Convert Blob to File

                     val shareData = js("{}")
                     shareData.asDynamic().files = arrayOf(file)

                     if (window.navigator.asDynamic().canShare(shareData) == true) {
                         window.navigator.asDynamic().share(shareData).then {

                         }.catch { error ->

                         }
                     } else {

                     }
                 }
            }
        }
    }
}