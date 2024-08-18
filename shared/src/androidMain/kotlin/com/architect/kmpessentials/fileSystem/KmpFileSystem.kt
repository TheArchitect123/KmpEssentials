package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.appInfo.KmpAppInfo
import com.architect.kmpessentials.internal.ActionStringParams
import java.io.File

actual class KmpFileSystem {
    actual companion object {
        actual fun getAppDirectory(): String {
            return KmpAppInfo.packageInfo.applicationInfo.dataDir
        }

        actual fun getTempCacheDirectory(): String {
            return KmpAndroid.clientAppContext.cacheDir.absolutePath
        }

        actual fun getExternalStorageDirectory(): String {
            return KmpAndroid.clientAppContext.externalCacheDir?.absolutePath ?: ""
        }

        actual fun deleteFileAt(path: String) {
            KmpAndroid.clientAppContext.deleteFile(path)
        }

        actual fun createFileAt(path: String) {
            File(path).createNewFile()
        }

        actual fun listenToChangesToFileAt(path: String, events: ActionStringParams) {

        }
    }

}