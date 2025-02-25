package com.architect.kmpessentials.filePicker

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLInputElement
import org.w3c.files.get

actual class KmpFilePicker {
    actual companion object {

        actual fun getFileFromPicker(action: DefaultFileAction) {
            val fileInput = document.createElement("input") as HTMLInputElement
            fileInput.type = "file"
            fileInput.style.display = "none"

            fileInput.onchange = {
                val file = fileInput.files?.get(0)
                if (file != null) {
                    val path = "${window.asDynamic().URL.createObjectURL(file)}"
                    action(
                        File(
                            file.name,
                            path
                        )
                    )
                }
            }

            document.body?.appendChild(fileInput) // Add to DOM temporarily
            fileInput.click() // Open the file picker dialog
            document.body?.removeChild(fileInput)
        }

        actual fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction) {
            val fileInput = document.createElement("input") as HTMLInputElement
            fileInput.type = "file"
            fileInput.multiple = true // Allow multiple file selection

            fileInput.onchange = {
                val pickedFiles = fileInput.files
                if (pickedFiles != null) {
                    if (pickedFiles.length > 0) {
                        val files = (0 until pickedFiles.length)
                            .map { pickedFiles[it]!! } // Convert FileList to List<File>
                            .map {
                                val path = "${window.asDynamic().URL.createObjectURL(it)}"
                                File(
                                    it.name,
                                    path
                                )
                            }

                        actions(
                            files
                        )
                    }
                }
            }

            fileInput.click() // Open file picker dialog
        }
    }
}

