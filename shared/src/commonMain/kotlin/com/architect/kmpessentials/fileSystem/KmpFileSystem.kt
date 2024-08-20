package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpFileSystem {

    companion object {
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
         * File Directory Observer, listens to any changes for a Directory/File specified with the path
         * @param path the Url for the Directory/File to observe for changes
         * */
        fun listenToChangesToFileAt(path: String, events: ActionStringParams)
    }

}