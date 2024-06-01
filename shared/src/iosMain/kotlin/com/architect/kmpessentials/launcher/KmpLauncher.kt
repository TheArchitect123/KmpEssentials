package com.architect.kmpessentials.launcher

actual class KmpLauncher {
    actual fun launchExternalMapsAppWithAddress(
        address: String,
        markerTitle: String,
        externalApp: MapsApplication
    ) {
    }

    actual fun launchExternalMapsAppWithCoordinates(
        latitude: Double,
        longitude: Double,
        markerTitle: String,
        externalApp: MapsApplication
    ) {
    }

    actual fun launchExternalUrlViaBrowser(linkPath: String) {
    }

    actual fun launchExternalUrlViaAnyApp(linkPath: String) {
    }

    actual fun launchAppInternalSettings() {
    }

}