package com.architect.kmpessentials.launcher

import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn
import com.architect.kmpessentials.logging.KmpLogging
import java.awt.Desktop
import java.net.URI

actual class KmpLauncher {
    actual companion object {
        actual fun startTimer(seconds: Double, action: DefaultActionWithBooleanReturn) {

        }

        actual fun startTimerRepeating(seconds: Double, action: DefaultActionWithBooleanReturn) {

        }

        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String
        ) {

        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {

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

        }

        actual fun launchAppInternalSettings() {

        }

        actual fun launchAppStoreViaIdentifier(appStoreLink: String) {

        }
    }
}