package com.architect.kmpessentials.filePicker

typealias DefaultFileAction = (File?) -> Unit
typealias DefaultManyFilesAction = (List<File>?) -> Unit

expect class KmpFilePicker {
    companion object {
        /**
         * Pick a single file from the native file picker app
         * */
        fun getFileFromPicker(action: DefaultFileAction)

        /**
         * Pick multiple files and returns Urls for each file
         * */
        fun getMultipleFilesFromPicker(actions: DefaultManyFilesAction)
    }
}

