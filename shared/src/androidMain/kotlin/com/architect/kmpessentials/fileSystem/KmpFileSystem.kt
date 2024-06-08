package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpFileSystem {

    actual companion object {
        actual fun getAppDirectory(): String {
            return ""
        }

        actual fun getTempCacheDirectory(): String {
            return ""
        }

        actual fun getExternalStorageDirectory(): String {
            return ""
        }

        actual fun deleteFileAt(path: String) {

        }

        actual fun createFileAt(path: String) {

        }

        actual fun listenToChangesToFileAt(path: String, events: ActionStringParams) {

        }
    }

}