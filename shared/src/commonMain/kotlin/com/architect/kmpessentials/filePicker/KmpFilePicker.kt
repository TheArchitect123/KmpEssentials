package com.architect.kmpessentials.filePicker

typealias DefaultFileAction = (File?) -> Unit
typealias DefaultManyFilesAction = (List<File>?) -> Unit
expect class KmpFilePicker {
    companion object {
        fun getFileFromPicker(action: DefaultFileAction)
        fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction)
    }
}

