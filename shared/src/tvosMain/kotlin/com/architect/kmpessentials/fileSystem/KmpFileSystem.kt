package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDirectoryEnumerationSkipsHiddenFiles
import platform.Foundation.NSFileManager
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.stringWithContentsOfURL
import platform.Foundation.writeToURL

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

        @OptIn(ExperimentalForeignApi::class)
        actual fun writeTextToFileAt(filePath: String, content: String): Boolean {
            val fileUrl = NSURL.fileURLWithPath(filePath)
            val nsString = NSString.create(string = content)

            // Write the string to the specified file path
            return nsString.writeToURL(
                fileUrl,
                atomically = true,
                encoding = NSUTF8StringEncoding,
                error = null
            )
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun readTextFromFileAt(filePath: String): String? {
            val fileUrl = NSURL.fileURLWithPath(filePath)
            return NSString.stringWithContentsOfURL(fileUrl, NSUTF8StringEncoding, null)
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun wipeAllFilesFromDirectoryPath(directoryPath: String): Boolean {
            val fileManager = NSFileManager.defaultManager
            val directoryUrl = NSURL.fileURLWithPath(directoryPath)

            // Get the contents of the directory
            val fileUrls = fileManager.contentsOfDirectoryAtURL(
                directoryUrl,
                includingPropertiesForKeys = null,
                options = NSDirectoryEnumerationSkipsHiddenFiles,
                error = null
            ) as? List<NSURL> ?: return false

            // Delete each file
            fileUrls.forEach { fileUrl ->
                fileManager.removeItemAtURL(fileUrl, null)
            }

            return true
        }
    }
}