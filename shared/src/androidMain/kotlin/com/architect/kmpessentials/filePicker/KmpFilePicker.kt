package com.architect.kmpessentials.filePicker

import com.architect.kmpessentials.KmpAndroid
import com.nareshchocha.filepickerlibrary.ui.FilePicker

actual class KmpFilePicker {
    actual companion object {
        lateinit var actionResultSingleFile: DefaultFileAction
        lateinit var actionResultManyFiles: DefaultManyFilesAction

        actual fun getFileFromPicker(action: DefaultFileAction) {
            actionResultSingleFile = action
            bootFilePickerActivity()

        }

        actual fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction) {
            actionResultManyFiles = actions
            bootFilePickerActivity()
        }

        private fun bootFilePickerActivity() {
            KmpAndroid.clientAppContext.startActivity(
                FilePicker.Builder(KmpAndroid.clientAppContext)
                    .setPopUpConfig()
                    .addPickDocumentFile()
                    .addImageCapture()
                    .addVideoCapture()
                    .addPickMedia()
                    .build()
            )
        }
    }
}

