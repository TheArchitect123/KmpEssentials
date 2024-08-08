package com.architect.kmpessentials.launcher

import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationOpenSettingsURLString

actual class KmpLauncher {
    actual companion object {
        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String
        ) {
            val mapsAddress = NSURL.URLWithString("https://maps.apple.com/?address=$address")!!
            if (UIApplication.sharedApplication.canOpenURL(mapsAddress)) {
                UIApplication.sharedApplication.openURL(mapsAddress)
            }
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {
            val mapsAddress = NSURL.URLWithString("https://maps.apple.com/?ll:$latitude,$longitude")!!
            if (UIApplication.sharedApplication.canOpenURL(mapsAddress)) {
                UIApplication.sharedApplication.openURL(mapsAddress)
            }
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            openExternalLink(linkPath)
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            openExternalLink(linkPath)
        }

        private fun openExternalLink(linkPath: String) {
            val link = NSURL.URLWithString(linkPath)!!
            if (UIApplication.sharedApplication.canOpenURL(link)) {
                UIApplication.sharedApplication.openURL(link)
            }
        }

        actual fun launchAppInternalSettings() {
            UIApplication.sharedApplication.openURL(NSURL.URLWithString(UIApplicationOpenSettingsURLString)!!)
        }
    }
}