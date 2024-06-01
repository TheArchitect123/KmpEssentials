package com.architect.kmpessentials.launcher

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.architect.kmpessentials.ClientAppContext
import com.architect.kmpessentials.launcher.constants.MapAppPackageIdentifiers
import com.architect.kmpessentials.launcher.constants.UriPrefixes

actual class KmpLauncher {
    actual companion object {
        private fun openMapsUrl(addressPath: Uri, externalApp: MapsApplication) {
            val launchMapsApp = Intent(Intent.ACTION_VIEW, addressPath)
            launchMapsApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            launchMapsApp.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            launchMapsApp.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            launchMapsApp.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)

            // by default the users choose which map they want to open the app with
            if (externalApp == MapsApplication.GoogleMaps) {
                launchMapsApp.setPackage(MapAppPackageIdentifiers.googleMaps)
            }

            if (launchMapsApp.resolveActivity(ClientAppContext.clientAppContext.packageManager) != null) {
                ClientAppContext.clientAppContext.startActivity(launchMapsApp)
            }
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkPath))
            if (browserIntent.resolveActivity(ClientAppContext.clientAppContext.packageManager) != null) {
                ClientAppContext.clientAppContext.startActivity(browserIntent)
            }
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkPath))
            if (browserIntent.resolveActivity(ClientAppContext.clientAppContext.packageManager) != null) {
                ClientAppContext.clientAppContext.startActivity(browserIntent)
            }
        }

        actual fun launchAppInternalSettings() {
            val settingsIntent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
            settingsIntent.setData(Uri.parse(UriPrefixes.settingsPackage.plus(ClientAppContext.clientAppContext.packageName)))

            if (settingsIntent.resolveActivity(ClientAppContext.clientAppContext.packageManager) != null) {
                ClientAppContext.clientAppContext.startActivity(settingsIntent)
            }
        }

        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String,
            externalApp: MapsApplication
        ) {
            val addressPath = Uri.parse(UriPrefixes.googleMapsPrefix.plus(address))
            openMapsUrl(addressPath, externalApp)
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String,
            externalApp: MapsApplication
        ) {
            val addressPath = Uri.parse(UriPrefixes.googleMapsPrefix.plus("$latitude,$longitude"))
            openMapsUrl(addressPath, externalApp)
        }
    }
}