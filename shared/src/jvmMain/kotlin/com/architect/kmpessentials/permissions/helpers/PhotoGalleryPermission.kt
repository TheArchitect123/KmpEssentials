package com.architect.kmpessentials.permissions.helpers

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo

object PhotoGalleryPermission {
    fun requestPhotoGalleryPermission() {
        when (KmpDeviceInfo.getRunningPlatform()) {
            DevicePlatform.Windows -> {
                executeCommand(
                    arrayOf(
                        "powershell", "-Command",
                        "Start-Process ms-settings:privacy-pictures"
                    )
                )
            }

            else -> {
                executeCommand(
                    arrayOf(
                        "osascript", "-e", """
        tell application "System Events"
            display dialog "Go to System Preferences > Security & Privacy > Photos and enable access."
        end tell
    """
                    )
                )
            }
        }
    }

}