package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionListStringParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpFileSystem {

    companion object {
        /**
         * @return a list of all file paths specified by the absolute directory path
         * */
        fun getAllFilePathsFromDirectoryPath(directoryPath: String): List<String>

        /**
         * @return the Url of the App Directory with the specified directory name. Creates the directory folder if it doesn't exist
         * */
        fun createDirectNameAtAppStorage(directoryName: String): String

        /**
         * @return the Url of the App Directory, where app generated data is stored
         * */
        fun getAppDirectory(): String

        /**
         * @return directory for storing any temporary files. Please DO NOT Store files that are critical in this directory
         * */
        fun getTempCacheDirectory(): String

        /**
         * @return storage directory for the external storage device connected to this phone
         * */
        fun getExternalStorageDirectory(): String

        /**
         * Deletes the file with the specified Url
         * */
        fun deleteFileAt(path: String)

        /**
         * Create the file with the specified Url
         * */
        fun createFileAt(path: String)

        /**
         * Removes all files from the specified directoryPath
         * @return true if successful, false if not
         * */
        fun wipeAllFilesFromDirectoryPath(directoryPath: String): Boolean

        /**
         * File Directory Observer, listens to any changes for a Directory/File specified with the path
         * @param path the Url for the Directory/File to observe for changes
         * */
        fun listenToChangesToFileAt(path: String, events: ActionStringParams)

        /**
         * Create the file if it doesn't exist, and writes the text content into it
         * @return true if successful, false if not
         * */
        fun writeTextToFileAt(filePath: String, content: String): Boolean

        /**
         * @return text file content from the file, if no content exists returns null
         * */
        fun readTextFromFileAt(filePath: String): String?

        /**
         * @return generates a merged file path from the filename + directory path
         * */
        fun getMergedFilePathFromDirectory(directoryPath: String, fileName: String): String?


        // NON BLOCKING APIs (Async)

        /**
         * @return a list of all file paths specified by the absolute directory path
         * */
        suspend fun getAllFilePathsFromDirectoryPathAsync(
            directoryPath: String,
            action: ActionListStringParams
        )

        /**
         * @return the Url of the App Directory with the specified directory name. Creates the directory folder if it doesn't exist
         * */
        suspend fun createDirectNameAtAppStorageAsync(
            directoryName: String,
            action: ActionStringParams
        )

        /**
         * @return the Url of the App Directory, where app generated data is stored
         * */
        suspend fun getAppDirectoryAsync(action: ActionStringParams)

        /**
         * @return directory for storing any temporary files. Please DO NOT Store files that are critical in this directory
         * */
        suspend fun getTempCacheDirectoryAsync(action: ActionStringParams)

        /**
         * @return storage directory for the external storage device connected to this phone
         * */
        suspend fun getExternalStorageDirectoryAsync(action: ActionStringParams)

        /**
         * Deletes the file with the specified Url
         * */
        suspend fun deleteFileAtAsync(path: String)

        /**
         * Create the file with the specified Url
         * */
        suspend fun createFileAtAsync(path: String)

        /**
         * Removes all files from the specified directoryPath
         * @return true if successful, false if not
         * */
        suspend fun wipeAllFilesFromDirectoryPathAsync(
            directoryPath: String,
            action: ActionBoolParams
        )

        /**
         * File Directory Observer, listens to any changes for a Directory/File specified with the path
         * @param path the Url for the Directory/File to observe for changes
         * */
        suspend fun listenToChangesToFileAtAsync(path: String, events: ActionStringParams)

        /**
         * Create the file if it doesn't exist, and writes the text content into it
         * @return true if successful, false if not
         * */
        suspend fun writeTextToFileAtAsync(
            filePath: String,
            content: String,
            action: ActionBoolParams
        )

        /**
         * @return text file content from the file, if no content exists returns null
         * */
        suspend fun readTextFromFileAtAsync(filePath: String, action: ActionStringNullParams)

        /**
         * @return generates a merged file path from the filename + directory path
         * */
        suspend fun getMergedFilePathFromDirectoryAsync(
            directoryPath: String,
            fileName: String,
            action: ActionStringNullParams
        )
    }

}