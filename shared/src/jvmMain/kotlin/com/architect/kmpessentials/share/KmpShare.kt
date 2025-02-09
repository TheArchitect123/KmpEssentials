package com.architect.kmpessentials.share

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.logging.KmpLogging
import java.io.File

actual class KmpShare {
    actual companion object {
        actual fun setFileType(cFileType: String): Companion {
            return this
        }

        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            val tempFile = File.createTempFile("shared_service_file", ".txt")
            tempFile.writeText(text)

            shareFileWithAnyApp(tempFile.absolutePath, optionalTitle)
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        val file = File(filePath)
                        if (!file.exists()) {
                            return
                        }

                        ProcessBuilder(
                            "cmd",
                            "/c",
                            "explorer /select,\"${file.absolutePath}\""
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError("JVM_APIS", "Error sharing file: ${e.message}")
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        val file = File(filePath)
                        if (!file.exists()) {
                            return
                        }

                        ProcessBuilder(
                            "osascript",
                            "-e",
                            "tell application \"Finder\" to reveal POSIX file \"${file.absolutePath}\""
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError("JVM_APIS", "Error sharing file: ${e.message}")
                    }
                }

                else -> {
                    try {
                        val file = File(filePath)
                        if (!file.exists()) {
                            return
                        }

                        ProcessBuilder("xdg-open", file.absolutePath).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError("JVM_APIS", "Error sharing file: ${e.message}")
                    }
                }
            }
        }
    }
}