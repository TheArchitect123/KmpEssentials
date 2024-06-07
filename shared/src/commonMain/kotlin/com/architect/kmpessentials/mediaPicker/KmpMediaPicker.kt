package com.architect.kmpessentials.mediaPicker

expect class KmpMediaPicker { // saves both media components into temp cache directory, which users can read the file path from
    companion object {
        fun getPhotoFromCamera(): String
        fun getVideoFromCamera(): String
    }
}
