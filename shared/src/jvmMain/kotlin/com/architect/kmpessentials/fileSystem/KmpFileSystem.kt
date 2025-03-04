package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionListStringParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.internal.ActionStringParams
import java.io.File
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardWatchEventKinds.ENTRY_CREATE
import java.nio.file.StandardWatchEventKinds.ENTRY_DELETE
import java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY
import kotlin.io.path.isDirectory
import kotlin.io.path.listDirectoryEntries

actual class KmpFileSystem {

    actual companion object {

        actual fun getAppDirectory(): String {
            return System.getProperty("user.dir")
        }

        actual fun getTempCacheDirectory(): String {
            return System.getProperty("java.io.tmpdir")
        }

        actual fun getExternalStorageDirectory(): String {
            return System.getProperty("user.home")
        }

        actual fun deleteFileAt(path: String) {
            val removeFile = File(path)
            if(removeFile.exists()){
                removeFile.delete()
            }
        }

        actual fun createFileAt(path: String) {
            val file = File(path)
            if(!file.exists()){
                file.createNewFile()
            }
        }

        actual fun listenToChangesToFileAt(path: String, events: ActionStringParams) {
            val filePath = Paths.get(path)
            val watchService = FileSystems.getDefault().newWatchService()

            filePath.parent?.register(
                watchService,
                ENTRY_CREATE,
                ENTRY_DELETE,
                ENTRY_MODIFY
            )

            while (true) {
                val key = watchService.take()
                for (event in key.pollEvents()) {
                    val eventPath = event.context() as Path
                    if (eventPath.toString() == filePath.fileName.toString()) {
                        events(event.kind().name()) // Notify callback
                    }
                }
                key.reset()
            }
        }

        actual fun createDirectNameAtAppStorage(directoryName: String): String {
            val dir = File(getAppDirectory(), directoryName)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            return dir.absolutePath
        }

        actual fun getAllFilePathsFromDirectoryPath(directoryPath: String): List<String> {
            val dir = kotlin.io.path.Path(directoryPath)
            return if (dir.isDirectory()) {
                dir.listDirectoryEntries().map { it.toString() }
            } else {
                emptyList()
            }
        }

        actual fun writeTextToFileAt(filePath: String, content: String): Boolean {
            return try {
                File(filePath).writeText(content)
                true
            } catch (e: IOException) {
                false
            }
        }

        actual fun readTextFromFileAt(filePath: String): String? {
            return try {
                File(filePath).readText()
            } catch (e: IOException) {
                null
            }
        }

        actual fun wipeAllFilesFromDirectoryPath(directoryPath: String): Boolean {
            val dir = File(directoryPath)
            return if (dir.exists() && dir.isDirectory) {
                dir.listFiles()?.forEach { it.delete() }
                true
            } else {
                false
            }
        }

        actual fun getMergedFilePathFromDirectory(
            directoryPath: String,
            fileName: String
        ): String? {
            val file = File(directoryPath, fileName)
            return if (file.exists()) file.absolutePath else null
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