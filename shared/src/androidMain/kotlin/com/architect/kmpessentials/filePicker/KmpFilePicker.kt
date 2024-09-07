package com.architect.kmpessentials.filePicker

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.nareshchocha.filepickerlibrary.models.DocumentFilePickerConfig
import com.nareshchocha.filepickerlibrary.ui.FilePicker

actual class KmpFilePicker {
    actual companion object {
        internal lateinit var actionResultSingleFile: DefaultFileAction
        internal lateinit var actionResultManyFiles: DefaultManyFilesAction
        internal lateinit var resultLauncher: ActivityResultLauncher<Intent>

        actual fun getFileFromPicker(action: DefaultFileAction) {
            KmpMainThread.runViaMainThread {
                actionResultSingleFile = action
                bootFilePickerActivity()
            }
        }

        actual fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction) {
            KmpMainThread.runViaMainThread {
                actionResultManyFiles = actions
                bootFilePickerActivity(true)
            }
        }

        private fun bootFilePickerActivity(callowMultiple: Boolean = false) {
            resultLauncher.launch(
                FilePicker.Builder(KmpAndroid.clientAppContext)
                    .pickDocumentFileBuild(DocumentFilePickerConfig(allowMultiple = callowMultiple))
            )
        }
    }
}

