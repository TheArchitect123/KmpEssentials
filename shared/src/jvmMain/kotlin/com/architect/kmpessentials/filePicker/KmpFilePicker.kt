package com.architect.kmpessentials.filePicker

import javax.swing.JFileChooser

actual class KmpFilePicker {
    actual companion object {

        actual fun getFileFromPicker(action: DefaultFileAction) {
            val fileChooser = JFileChooser()
            val returnValue = fileChooser.showOpenDialog(null)
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                action(
                    File(
                        fileChooser.selectedFile.name,
                        fileChooser.selectedFile.absolutePath,
                        fileChooser.selectedFile.isHidden
                    )
                )
            }
        }

        actual fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction) {
            val fileChooser = JFileChooser()
            fileChooser.isMultiSelectionEnabled = true
            val returnValue = fileChooser.showOpenDialog(null)

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                actions(
                    fileChooser.selectedFiles.map {
                        File(
                            it.name,
                            it.absolutePath,
                            it.isHidden
                        )
                    }
                )
            }
        }
    }
}

