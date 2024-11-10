package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSAllDomainsMask
import platform.Foundation.NSApplicationDirectory
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL

actual class KmpFileSystem {

    actual companion object {
        actual fun getAppDirectory(): String {
            val cacheUrl = NSFileManager.defaultManager.URLsForDirectory(
                NSApplicationDirectory,
                NSAllDomainsMask
            ).first() as NSURL
            return cacheUrl.absoluteURL!!.path!!
        }

        actual fun getTempCacheDirectory(): String {
            val cacheUrl =
                NSFileManager.defaultManager.URLsForDirectory(NSCachesDirectory, NSAllDomainsMask)
                    .first() as NSURL
            return cacheUrl.absoluteURL!!.path!!
        }

        actual fun getExternalStorageDirectory(): String {
            // gets any usb devices currently connected

            return ""
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun deleteFileAt(path: String) {
            NSFileManager.defaultManager.removeItemAtPath(path, null)
        }

        actual fun createFileAt(path: String) {
            NSFileManager.defaultManager.createFileAtPath(path, null, null)
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
    }
}