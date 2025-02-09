package com.architect.kmpessentials.launcher

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.logging.KmpLogging
import java.awt.Desktop
import java.net.URI
import java.util.Timer
import java.util.TimerTask

actual class KmpLauncher {
    actual companion object {
        actual fun startTimer(seconds: Double, action: () -> Boolean) {
            val milliseconds = (seconds * 1000).toLong()
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    if (!action()) this.cancel()
                }
            }, milliseconds)
        }

        actual fun startTimerRepeating(seconds: Double, action: () -> Boolean) {
            val milliseconds = (seconds * 1000).toLong()
            Timer().scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    if (!action()) this.cancel()
                }
            }, 0, milliseconds)
        }

        actual fun launchExternalMapsAppWithAddress(address: String, markerTitle: String) {
            val encodedAddress = URI.create(
                "https://www.google.com/maps/search/?api=1&query=${
                    address.replace(
                        " ",
                        "+"
                    )
                }"
            )
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(encodedAddress)
            }
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {
            val mapUrl =
                URI.create("https://www.google.com/maps/search/?api=1&query=$latitude,$longitude")
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(mapUrl)
            }
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            // Check if the Desktop API is supported on the current platform
            if (Desktop.isDesktopSupported()) {
                val desktop = Desktop.getDesktop()

                // Check if the BROWSE action is supported
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(URI(linkPath))
                } else {
                    KmpLogging.writeError(
                        "KmpEssentials", "BROWSE action not supported."
                    )
                }
            } else {
                KmpLogging.writeError(
                    "KmpEssentials",
                    "Desktop API is not supported on this platform."
                )
            }
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            val url = URI.create(linkPath)
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(url)
            }
        }

        actual fun launchAppInternalSettings() {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        ProcessBuilder("cmd", "/c", "start ms-settings:").start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", "Failed to open Windows settings: ${e.message}"
                        )
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        ProcessBuilder("open", "-a", "System Preferences").start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Failed to open macOS settings: ${e.message}"
                        )
                    }
                }

                else -> {
                    try {
                        val commands = listOf(
                            "gnome-control-center",  // GNOME (Ubuntu, Fedora)
                            "systemsettings",       // KDE Plasma
                            "xfce4-settings-manager" // XFCE
                        )

                        for (cmd in commands) {
                            if (ProcessBuilder("which", cmd).start().waitFor() == 0) {
                                ProcessBuilder(cmd).start()
                                return
                            }
                        }

                        KmpLogging.writeError(
                            "JVM_APIS", "No supported system settings application found."
                        )
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", "Failed to open Linux settings: ${e.message}"
                        )
                    }
                }
            }
        }

        actual fun launchAppStoreViaIdentifier(appStoreLink: String) {
            launchExternalUrlViaBrowser(appStoreLink)
        }
    }
}