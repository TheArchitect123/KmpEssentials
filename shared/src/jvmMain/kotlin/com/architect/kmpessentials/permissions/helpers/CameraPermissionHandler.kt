package com.architect.kmpessentials.permissions.helpers

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import java.io.BufferedReader
import java.io.InputStreamReader

fun executeCommand(command: Array<String>) {
    try {
        val process = ProcessBuilder(*command).start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        val output = reader.readText()
        process.waitFor()
        println("Command Output: $output")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

object CameraPermissionHandler {

    fun requestCameraPermission() {
        when (KmpDeviceInfo.getRunningPlatform()) {
            DevicePlatform.Windows -> {
                val command = arrayOf(
                    "powershell", "-Command",
                    """
        Start-Process ms-settings:privacy-webcam
        """
                )
                executeCommand(command)
            }

            else -> {
                val command = arrayOf(
                    "osascript",
                    "-e",
                    "tell application \"System Events\" to display dialog \"Please allow camera access in System Preferences > Security & Privacy.\" buttons {\"OK\"}"
                )
                executeCommand(command)
            }
        }
    }
}

