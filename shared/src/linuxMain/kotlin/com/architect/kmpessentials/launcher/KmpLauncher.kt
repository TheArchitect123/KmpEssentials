package com.architect.kmpessentials.launcher

import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn

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

        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {

        }

        actual fun launchAppInternalSettings() {

        }

        actual fun launchAppStoreViaIdentifier(appStoreLink: String) {

        }
    }
}