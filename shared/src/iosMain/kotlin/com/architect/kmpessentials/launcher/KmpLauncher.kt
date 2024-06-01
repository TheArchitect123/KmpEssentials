package com.architect.kmpessentials.launcher

actual class KmpLauncher {
    actual companion object {
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
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
        }

        actual fun launchAppInternalSettings() {
        }

    }


}