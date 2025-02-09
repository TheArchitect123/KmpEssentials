package com.architect.kmpessentials.permissions.helpers

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo

object MicrophonePermissionHandler {
    fun requestMicrophonePermission() {
        when (KmpDeviceInfo.getRunningPlatform()) {
            DevicePlatform.Windows -> {
                executeCommand(
                    arrayOf(
                        "powershell",
                        "-Command",
                        "Start-Process ms-settings:privacy-microphone"
                    )
                )
            }

            else -> {
                executeCommand(
                    arrayOf(
                        "osascript",
                        "-e",
                        "tell application \"System Events\" to display dialog \"Enable microphone access in System Preferences > Security & Privacy.\" buttons {\"OK\"}"
                    )
                )
            }
        }
    }
}

