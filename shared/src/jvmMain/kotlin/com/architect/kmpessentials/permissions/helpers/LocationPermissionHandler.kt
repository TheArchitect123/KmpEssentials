package com.architect.kmpessentials.permissions.helpers

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo

object LocationPermissionHandler {

    fun requestLocationPermission() {
        when (KmpDeviceInfo.getRunningPlatform()) {
            DevicePlatform.Windows -> {
                executeCommand(
                    arrayOf(
                        "powershell",
                        "-Command",
                        "Start-Process ms-settings:privacy-location"
                    )
                )
            }

            else -> {
                executeCommand(
                    arrayOf(
                        "osascript",
                        "-e",
                        "tell application \"System Events\" to display dialog \"Enable location services in System Preferences > Security & Privacy.\" buttons {\"OK\"}"
                    )
                )
            }
        }
    }
}