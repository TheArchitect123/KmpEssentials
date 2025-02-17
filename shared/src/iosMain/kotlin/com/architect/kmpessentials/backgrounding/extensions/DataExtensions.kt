package com.architect.kmpessentials.backgrounding.extensions

import com.architect.kmpessentials.logging.KmpLogging
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.NSFileManager
import platform.Foundation.dataWithBytes
import platform.Foundation.dataWithContentsOfFile
import platform.posix.memcpy

@OptIn(ExperimentalForeignApi::class)
fun ByteArray.toNSData(): NSData {
    return this.usePinned { pinned ->
        NSData.dataWithBytes(pinned.addressOf(0), this.size.toULong())
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun NSData.toByteArray(): ByteArray {
    val length = this.length.toInt()
    val byteArray = ByteArray(length)

    byteArray.usePinned {
        memcpy(it.addressOf(0), this.bytes, length.toULong())
    }
    return byteArray
}

fun loadSilentBackgroundAudioFileAsByteArray(): ByteArray? {
    val fileManager = NSFileManager.defaultManager
    val currentPath = NSFileManager.defaultManager.currentDirectoryPath
    val filePath =
        "$currentPath/src/iosMain/kotlin/com/architect/kmpessentials/backgrounding/resources/silencer_audio_backgrounding.mp3"

    if (!fileManager.fileExistsAtPath(filePath)) {
        KmpLogging.writeError("KMP_BACKGROUNDING", "❌ Error: File not found at $filePath")
        return null
    }

    // ✅ Read file as NSData
    val fileData = NSData.dataWithContentsOfFile(filePath)
    if (fileData == null) {
        KmpLogging.writeError("KMP_BACKGROUNDING", "❌ Error reading file at $filePath")
        return null
    }

    // ✅ Convert NSData to ByteArray
    return fileData.toByteArray()
}

fun intArrayToByteArray(intArray: IntArray): ByteArray {
    val byteArray = ByteArray(intArray.size * 4)  // Each Int is 4 bytes
    for (i in intArray.indices) {
        // Convert each Int into its 4-byte representation
        val byteStart = i * 4
        byteArray[byteStart] = (intArray[i] shr 24).toByte()  // Highest byte
        byteArray[byteStart + 1] = (intArray[i] shr 16).toByte()
        byteArray[byteStart + 2] = (intArray[i] shr 8).toByte()
        byteArray[byteStart + 3] = intArray[i].toByte()  // Lowest byte
    }
    return byteArray
}