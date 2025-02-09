package com.architect.kmpessentials.telecom

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.logging.KmpLogging
import java.awt.Desktop
import java.net.URI

actual class KmpTelecom {
    actual companion object {
        actual fun launchPhoneCallWithNumber(mobileNumber: String) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        val uri = URI("tel:$mobileNumber")
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop()
                                .isSupported(Desktop.Action.BROWSE)
                        ) {
                            Desktop.getDesktop().browse(uri)
                        }
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS",
                            "Error launching phone call: ${e.stackTraceToString()}"
                        )
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        ProcessBuilder("open", "tel://$mobileNumber").start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", "Error launching phone call: ${e.stackTraceToString()}"
                        )
                    }
                }

                else -> {
                    try {
                        ProcessBuilder("xdg-open", "tel:$mobileNumber").start()
                    } catch (e: Exception) {
                        KmpLogging.writeError(
                            "JVM_APIS", "Error launching phone call: ${e.stackTraceToString()}"
                        )
                    }
                }
            }
        }
    }
}