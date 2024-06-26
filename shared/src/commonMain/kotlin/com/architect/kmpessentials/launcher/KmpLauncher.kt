package com.architect.kmpessentials.launcher

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KmpLauncher {
    companion object {
        fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String = ""
        )

        fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String = ""
        )

        fun launchExternalUrlViaBrowser(linkPath: String)
        fun launchExternalUrlViaAnyApp(linkPath: String)
        fun launchAppInternalSettings()
    }
}