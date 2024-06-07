package com.architect.kmpessentials.filePicker

expect class KmpFilePicker {
    companion object {
        fun getFileFromPicker(): File
        fun getMultipleFilesFromPicker(): List<File>
    }
}

