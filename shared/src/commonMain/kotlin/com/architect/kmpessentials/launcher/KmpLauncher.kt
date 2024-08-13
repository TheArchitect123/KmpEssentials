package com.architect.kmpessentials.launcher

import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KmpLauncher {
    companion object {
        fun startTimer(seconds: Double, action: DefaultActionWithBooleanReturn)
        fun startTimerRepeating(seconds: Double, action: DefaultActionWithBooleanReturn)

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
        fun launchAppStoreViaIdentifier(appStoreLink: String)
    }
}