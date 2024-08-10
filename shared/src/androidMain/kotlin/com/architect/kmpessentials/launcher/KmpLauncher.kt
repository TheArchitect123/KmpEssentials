package com.architect.kmpessentials.launcher

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.launcher.constants.MapAppPackageIdentifiers
import com.architect.kmpessentials.launcher.constants.UriPrefixes

actual class KmpLauncher {
    actual companion object {
        private fun addIntentFlags(intent: Intent) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        }

        private fun openMapsUrl(addressPath: Uri) {
            val launchMapsApp = Intent(Intent.ACTION_VIEW, addressPath)
            addIntentFlags(launchMapsApp)

            launchMapsApp.setPackage(MapAppPackageIdentifiers.googleMaps)
            if (launchMapsApp.resolveActivity(KmpAndroid.clientAppContext.packageManager) != null) {
                KmpAndroid.clientAppContext.startActivity(launchMapsApp)
            }
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(linkPath)
            }
            addIntentFlags(browserIntent)

            if (browserIntent.resolveActivity(KmpAndroid.clientAppContext.packageManager) != null) {
                KmpAndroid.clientAppContext.startActivity(browserIntent)
            }
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(linkPath)
            }
            addIntentFlags(browserIntent)

            if (browserIntent.resolveActivity(KmpAndroid.clientAppContext.packageManager) != null) {
                KmpAndroid.clientAppContext.startActivity(browserIntent)
            }
        }

        actual fun launchAppInternalSettings() {
            val settingsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts(
                    UriPrefixes.settingsPackage,
                    KmpAndroid.clientAppContext.packageName!!,
                    null
                )
            }
            addIntentFlags(settingsIntent)
            if (settingsIntent.resolveActivity(KmpAndroid.clientAppContext.packageManager) != null) {
                KmpAndroid.clientAppContext.startActivity(settingsIntent)
            }
        }

        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String
        ) {
            val addressPath = Uri.parse(UriPrefixes.addressPrefix.plus(address))
            openMapsUrl(addressPath)
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {
            val addressPath = Uri.parse(UriPrefixes.coordPrefix.plus("$latitude,$longitude"))
            openMapsUrl(addressPath)
        }

        actual fun launchAppStoreViaIdentifier(appStoreLink: String) {
            launchExternalUrlViaAnyApp(appStoreLink)
        }
    }
}