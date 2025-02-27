package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.appInfo.KmpAppInfo
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionListStringParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.internal.ActionStringParams
import java.io.File

actual class KmpFileSystem {
    actual companion object {
        actual fun getAppDirectory(): String {
            return KmpAppInfo.packageInfo?.applicationInfo?.dataDir ?: ""
        }

        actual fun getTempCacheDirectory(): String {
            return KmpAndroid.applicationContext?.cacheDir?.absolutePath ?: ""
        }

        actual fun getExternalStorageDirectory(): String {
            return KmpAndroid.applicationContext?.externalCacheDir?.absolutePath ?: ""
        }

        actual fun deleteFileAt(path: String) {
            val fileToDelete = File(path)
            if (fileToDelete.exists()) {
                fileToDelete.delete()
            }
        }

        actual fun createFileAt(path: String) {
            File(path).createNewFile()
        }

        actual fun listenToChangesToFileAt(path: String, events: ActionStringParams) {

        }

        actual fun createDirectNameAtAppStorage(directoryName: String): String {
            val jsonFilesDir = File(KmpAndroid.applicationContext?.filesDir, directoryName)
            if (!jsonFilesDir.exists()) {
                jsonFilesDir.mkdir() // Create the directory if it doesn’t exist
            }
            return jsonFilesDir.absolutePath
        }

        actual fun getAllFilePathsFromDirectoryPath(directoryPath: String): List<String> {
            val directory = File(directoryPath)
            return if (directory.exists() && directory.isDirectory) {
                directory.listFiles()?.map { it.absolutePath } ?: emptyList()
            } else {
                emptyList() // Return an empty list if the directory doesn't exist or isn't a directory
            }
        }

        actual fun writeTextToFileAt(filePath: String, content: String): Boolean {
            try {
                File(filePath).writeText(content) // Write the text to the file
            } catch (ex: Exception) {
                return false
            }

            return true
        }

        actual fun readTextFromFileAt(filePath: String): String? {
            return try {
                File(filePath).readText()
            } catch (e: Exception) {
                null
            }
        }

        actual fun wipeAllFilesFromDirectoryPath(directoryPath: String): Boolean {
            val directory = File(directoryPath)
            return if (directory.exists() && directory.isDirectory) {
                directory.listFiles()?.forEach { file ->
                    if (file.isFile) file.delete()
                }
                true
            } else {
                false // Return false if the directory doesn't exist or isn't a directory
            }
        }

        actual fun getMergedFilePathFromDirectory(
            directoryPath: String,
            fileName: String
        ): String? {
            return File(directoryPath, fileName).path
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