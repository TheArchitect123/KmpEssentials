package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.cinterop.ExperimentalForeignApi

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

        actual fun createDirectNameAtAppStorage(directoryName: String): String {
            return ""
        }

        actual fun getAllFilePathsFromDirectoryPath(directoryPath: String): List<String> {
            return emptyList()
        }

        actual fun writeTextToFileAt(filePath: String, content: String): Boolean {
            return false
        }

        actual fun readTextFromFileAt(filePath: String): String? {
            return ""
        }

        actual fun wipeAllFilesFromDirectoryPath(directoryPath: String): Boolean {
            return false
        }

        actual fun getMergedFilePathFromDirectory(
            directoryPath: String,
            fileName: String
        ): String? {
            return null
        }
    }
}