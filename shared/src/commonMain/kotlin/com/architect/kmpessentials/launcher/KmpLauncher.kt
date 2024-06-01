package com.architect.kmpessentials.launcher

expect class KmpLauncher {
    fun launchExternalMapsAppWithAddress(
        address: String,
        markerTitle: String = "",
        externalApp: MapsApplication = MapsApplication.Default
    )

    fun launchExternalMapsAppWithCoordinates(
        latitude: Double,
        longitude: Double,
        markerTitle: String = "",
        externalApp: MapsApplication = MapsApplication.Default
    )

    fun launchExternalUrlViaBrowser(linkPath: String)
    fun launchExternalUrlViaAnyApp(linkPath: String)
    fun launchAppInternalSettings()
}

