package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionListStringParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.browser.window

actual class KmpFileSystem {

    actual companion object {
        suspend fun getOPFSDirectory(): dynamic {
            return window.navigator.asDynamic().storage.getDirectory().await()
        }

        actual fun getAppDirectory(): String {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getTempCacheDirectory(): String {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getExternalStorageDirectory(): String {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun deleteFileAt(path: String) {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun createFileAt(path: String) {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun listenToChangesToFileAt(path: String, events: ActionStringParams) {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun createDirectNameAtAppStorage(directoryName: String): String {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getAllFilePathsFromDirectoryPath(directoryPath: String): List<String> {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun writeTextToFileAt(filePath: String, content: String): Boolean {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun readTextFromFileAt(filePath: String): String? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun wipeAllFilesFromDirectoryPath(directoryPath: String): Boolean {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getMergedFilePathFromDirectory(
            directoryPath: String,
            fileName: String
        ): String? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual suspend fun getAppDirectoryAsync(action: ActionStringParams) {
            val root = getOPFSDirectory()
            action(root.name) // OPFS has no standard path
        }

        actual suspend fun getTempCacheDirectoryAsync(action: ActionStringParams) {
            getAppDirectoryAsync(action) // No separate temp directory in OPFS
        }

        actual suspend fun getExternalStorageDirectoryAsync(action: ActionStringParams) {
            getAppDirectoryAsync(action) // OPFS doesn't have external storage
        }

        actual suspend fun deleteFileAtAsync(path: String) {
            val root = getOPFSDirectory()
            try {
                root.removeEntry(path).await()
                console.log("File deleted: $path")
            } catch (e: Throwable) {
                console.error("Error deleting file: $path", e)
            }
        }

        actual suspend fun createFileAtAsync(path: String) {
            val root = getOPFSDirectory()
            try {
                root.getFileHandle(path, create = true).await()
                console.log("File created: $path")
            } catch (e: Throwable) {
                console.error("Error creating file: $path", e)
            }
        }

        actual suspend fun wipeAllFilesFromDirectoryPathAsync(directoryPath: String, action: ActionBoolParams) {
            val root = getOPFSDirectory()
            try {
                val dir = root.getDirectoryHandle(directoryPath, create = false).await()
                for (entry in dir.entries().iterator()) {
                    dir.removeEntry(entry.first).await()
                }
                action(true)
            } catch (e: Throwable) {
                console.error("Error wiping directory: $directoryPath", e)
                action(false)
            }
        }

        actual suspend fun listenToChangesToFileAtAsync(path: String, events: ActionStringParams) {
            console.warn("listenToChangesToFileAtAsync is not supported in OPFS")
        }

        actual suspend fun writeTextToFileAtAsync(filePath: String, content: String, action: ActionBoolParams) {
            val root = getOPFSDirectory()
            try {
                val fileHandle = root.getFileHandle(filePath, create = true).await()
                val writable = fileHandle.createWritable().await()
                writable.write(content).await()
                writable.close().await()
                action(true)
            } catch (e: Throwable) {
                console.error("Error writing to file: $filePath", e)
                action(false)
            }
        }

        actual suspend fun readTextFromFileAtAsync(filePath: String, action: ActionStringNullParams) {
            val root = getOPFSDirectory()
            try {
                val fileHandle = root.getFileHandle(filePath, create = false).await()
                val file = fileHandle.getFile().await()
                val reader = file.text().await()
                action(reader)
            } catch (e: Throwable) {
                console.error("Error reading file: $filePath", e)
                action(null)
            }
        }

        actual suspend fun getMergedFilePathFromDirectoryAsync(directoryPath: String, fileName: String, action: ActionStringNullParams) {
            action("$directoryPath/$fileName") // OPFS doesn't use real paths
        }

        actual suspend fun getAllFilePathsFromDirectoryPathAsync(directoryPath: String, action: ActionListStringParams) {
            val root = getOPFSDirectory()
            val dir = root.getDirectoryHandle(directoryPath, create = false).await()
            val files = mutableListOf<String>()

            for (entry in dir.entries().iterator()) {
                files.add(entry.first)
            }

            action(files)
        }

        actual suspend fun createDirectNameAtAppStorageAsync(directoryName: String, action: ActionStringParams) {
            val root = getOPFSDirectory()
            root.getDirectoryHandle(directoryName, create = true).await()
            action(directoryName)
        }
    }
}