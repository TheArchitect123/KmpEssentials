package com.architect.kmpessentials.filePicker

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.filePicker.internals.models.DocumentFilePickerConfig
import com.architect.kmpessentials.filePicker.internals.ui.FilePicker
import com.architect.kmpessentials.mainThread.KmpMainThread

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
            if(KmpAndroid.clientAppContext != null) {
                resultLauncher.launch(
                    FilePicker.Builder(KmpAndroid.clientAppContext!!)
                        .pickDocumentFileBuild(DocumentFilePickerConfig(allowMultiple = callowMultiple))
                )
            }
        }
    }
}

