package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpFileSystem {

    companion object {
        fun getAppDirectory(): String
        fun getTempCacheDirectory(): String
        fun getExternalStorageDirectory(): String
        fun deleteFileAt(path: String)
        fun createFileAt(path: String)
        fun listenToChangesToFileAt(path: String, events: ActionStringParams)
    }

}