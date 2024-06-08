package com.architect.kmpessentials.mediaPicker

actual class KmpMediaPicker { // saves both media components into temp cache directory, which users can read the file path from
    actual companion object {
        actual fun getPhotoFromCamera(): String {
            return ""
        }

        actual fun getVideoFromCamera(): String {
            return ""
        }
    }
}
