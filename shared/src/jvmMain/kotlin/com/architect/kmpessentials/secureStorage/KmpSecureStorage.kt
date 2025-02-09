package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.logging.KmpLogging
import java.io.File

actual class KmpSecureStorage {
    actual companion object {
        actual fun clearEntireStore() {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> ProcessBuilder(
                    "cmd",
                    "/c",
                    "cmdkey /delete:KmpSecureStorage"
                ).start()

                DevicePlatform.MacOS -> ProcessBuilder(
                    "sh",
                    "-c",
                    "security delete-generic-password -s KmpSecureStorage"
                ).start()

                else -> ProcessBuilder("sh", "-c", "secret-tool clear key KmpSecureStorage").start()
            }
        }

        actual fun deleteDataForKey(key: String) {

            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        ProcessBuilder("cmd", "/c", "cmdkey /delete:KmpSecureStorage").start()
                    } catch (e: Exception) {
                        println("Error deleting secure data: ${e.message}")
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        ProcessBuilder(
                            "sh",
                            "-c",
                            "security delete-generic-password -s KmpSecureStorage -a $key"
                        ).start()
                    } catch (e: Exception) {
                        println("Error deleting data from Keychain: ${e.message}")
                    }
                }

                else -> {
                    try {
                        ProcessBuilder("sh", "-c", "secret-tool clear key $key").start()
                    } catch (e: Exception) {
                        println("Error deleting data from GNOME Keyring: ${e.message}")
                    }
                }
            }
        }

        actual fun getLongFromKey(key: String): Long? {
            return getStringFromKey(key)?.toLongOrNull()
        }

        actual fun <TData> persistData(key: String, item: TData) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        val scriptFile = File.createTempFile("secure_store", ".ps1")
                        scriptFile.writeText("cmdkey /generic:KmpSecureStorage /user:$key /pass:$item")
                        ProcessBuilder(
                            "powershell",
                            "-ExecutionPolicy",
                            "Bypass",
                            "-File",
                            scriptFile.absolutePath
                        ).start()
                        scriptFile.delete()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error storing data securely: ${e.stackTraceToString()}"
                        )
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        ProcessBuilder(
                            "sh",
                            "-c",
                            "security add-generic-password -s KmpSecureStorage -a $key -w \"$item\""
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error storing data securely: ${e.stackTraceToString()}"
                        )
                    }
                }

                else -> {
                    try {
                        ProcessBuilder(
                            "sh",
                            "-c",
                            "echo \"$item\" | secret-tool store --label='KmpSecureStorage' key $key"
                        ).start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error storing data securely: ${e.stackTraceToString()}"
                        )
                    }
                }
            }
        }

        actual fun getStringFromKey(key: String): String? {
            return when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows ->
                    return try {
                        val script = """cmdkey /list:"KmpSecureStorage-$key""""
                        val process = ProcessBuilder("cmd", "/c", script).start()
                        val output = process.inputStream.bufferedReader().readText().trim()
                        output.ifEmpty { null }
                    } catch (e: Exception) {
                        println("Error retrieving secure data: ${e.message}")
                        null
                    }

                DevicePlatform.MacOS -> try {
                    val process = ProcessBuilder(
                        "sh",
                        "-c",
                        "security find-generic-password -s KmpSecureStorage -a $key -w"
                    ).start()
                    val result = process.inputStream.bufferedReader().readText().trim()
                    result.ifEmpty { null }
                } catch (e: Exception) {
                    println("Error retrieving data from Keychain: ${e.message}")
                    null
                }

                else -> try {
                    val process = ProcessBuilder("sh", "-c", "secret-tool lookup key $key").start()
                    val result = process.inputStream.bufferedReader().readText().trim()
                    result.ifEmpty { null }
                } catch (e: Exception) {
                    println("Error retrieving data from GNOME Keyring: ${e.message}")
                    null
                }
            }
        }

        actual fun getIntFromKey(key: String): Int? {
            return getStringFromKey(key)?.toIntOrNull()
        }

        actual fun getFloatFromKey(key: String): Float? {
            return getStringFromKey(key)?.toFloatOrNull()
        }

        actual fun getDoubleFromKey(key: String): Double? {
            return getStringFromKey(key)?.toDoubleOrNull()
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            return getStringFromKey(key)?.toBooleanStrictOrNull()
        }
    }
}

