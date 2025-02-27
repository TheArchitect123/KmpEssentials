package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionListStringParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSAllDomainsMask
import platform.Foundation.NSApplicationDirectory
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSDirectoryEnumerationSkipsHiddenFiles
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.NSUserDomainMask
import platform.Foundation.URLByAppendingPathComponent
import platform.Foundation.create
import platform.Foundation.stringWithContentsOfURL
import platform.Foundation.writeToURL

@OptIn(UnsafeNumber::class)
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

        @OptIn(ExperimentalForeignApi::class)
        actual fun createDirectNameAtAppStorage(directoryName: String): String {
            val fileManager = NSFileManager.defaultManager
            val documentsDirectory =
                fileManager.URLsForDirectory(NSDocumentDirectory, NSUserDomainMask).first() as NSURL
            val jsonFilesDir = documentsDirectory.URLByAppendingPathComponent(directoryName)

            // Create the directory if it doesn’t exist
            if (!fileManager.fileExistsAtPath(jsonFilesDir?.path!!)) {
                fileManager.createDirectoryAtURL(
                    jsonFilesDir,
                    withIntermediateDirectories = true,
                    attributes = null,
                    error = null
                )
            }
            return jsonFilesDir.path!!
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun getAllFilePathsFromDirectoryPath(directoryPath: String): List<String> {
            val fileManager = NSFileManager.defaultManager
            val url = NSURL.fileURLWithPath(directoryPath)

            // Get the contents of the directory as an array of NSURLs
            val fileUrls = fileManager.contentsOfDirectoryAtURL(
                url,
                includingPropertiesForKeys = null,
                options = NSDirectoryEnumerationSkipsHiddenFiles,
                error = null
            ) as? List<NSURL> ?: return emptyList()

            return fileUrls.mapNotNull { it.path ?: it.absoluteString } ?: emptyList()
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

        actual fun getMergedFilePathFromDirectory(
            directoryPath: String,
            fileName: String
        ): String? {
            val directoryUrl = NSURL.fileURLWithPath(directoryPath)
            val combinedUrl = directoryUrl.URLByAppendingPathComponent(fileName)
            return combinedUrl?.path
        }


        actual suspend fun getAllFilePathsFromDirectoryPathAsync(
            directoryPath: String,
            action: ActionListStringParams
        ) {
            action(getAllFilePathsFromDirectoryPath(directoryPath))
        }

        actual suspend fun createDirectNameAtAppStorageAsync(
            directoryName: String,
            action: ActionStringParams
        ) {
            action(createDirectNameAtAppStorage(directoryName))
        }

        actual suspend fun getAppDirectoryAsync(action: ActionStringParams) {
            action(getAppDirectory())
        }

        actual suspend fun getTempCacheDirectoryAsync(action: ActionStringParams) {
            action(getTempCacheDirectory())
        }

        actual suspend fun getExternalStorageDirectoryAsync(action: ActionStringParams) {
            action(getExternalStorageDirectory())
        }

        actual suspend fun deleteFileAtAsync(path: String) {
            deleteFileAtAsync(path)
        }

        actual suspend fun createFileAtAsync(path: String) {
            createFileAtAsync(path)
        }

        actual suspend fun wipeAllFilesFromDirectoryPathAsync(
            directoryPath: String,
            action: ActionBoolParams
        ) {
            action(wipeAllFilesFromDirectoryPath(directoryPath))
        }

        actual suspend fun listenToChangesToFileAtAsync(path: String, events: ActionStringParams) {
            listenToChangesToFileAt(path, events)
        }

        actual suspend fun writeTextToFileAtAsync(
            filePath: String,
            content: String,
            action: ActionBoolParams
        ) {
            action(writeTextToFileAt(filePath, content))
        }

        actual suspend fun readTextFromFileAtAsync(
            filePath: String,
            action: ActionStringNullParams
        ) {
            action(readTextFromFileAt(filePath))
        }

        actual suspend fun getMergedFilePathFromDirectoryAsync(
            directoryPath: String,
            fileName: String,
            action: ActionStringNullParams
        ) {
            action(getMergedFilePathFromDirectory(directoryPath, fileName))
        }
    }
}