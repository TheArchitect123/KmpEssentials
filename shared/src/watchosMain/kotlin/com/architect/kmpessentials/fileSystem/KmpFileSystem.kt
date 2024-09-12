package com.architect.kmpessentials.fileSystem

import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSAllDomainsMask
import platform.Foundation.NSApplicationDirectory
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL

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
    }
}