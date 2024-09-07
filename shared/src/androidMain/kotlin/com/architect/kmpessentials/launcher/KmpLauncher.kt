package com.architect.kmpessentials.launcher

import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn
import com.architect.kmpessentials.launcher.constants.UriPrefixes
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpLauncher {
    actual companion object {
        actual fun startTimer(seconds: Double, action: DefaultActionWithBooleanReturn) {
            KmpMainThread.runViaMainThread {
                val handler = Handler(Looper.getMainLooper());
                handler.postDelayed({
                    if (action())
                        startTimer(seconds, action);
                }, seconds.toLong() * 1000);
            }
        }

        actual fun startTimerRepeating(seconds: Double, action: DefaultActionWithBooleanReturn) {
            KmpMainThread.runViaMainThread {
                val handler = Handler(Looper.getMainLooper());
                handler.postDelayed({
                    if (action())
                        startTimer(seconds, action);
                }, seconds.toLong() * 1000);
            }
        }

        private fun addIntentFlags(intent: Intent) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        }

        private fun openMapsUrl(parameters: String) {
            //check for whitespace between address info, and replace with +
            val newParameters = parameters.replace("\\s+".toRegex(), "+")
            val mapPrefix = UriPrefixes.mapsDirectionsPrefix.plus("&destination=$newParameters&travelmode=driving")

            val launchMapsApp = Intent(Intent.ACTION_VIEW, Uri.parse(mapPrefix))
            addIntentFlags(launchMapsApp)

            if (launchMapsApp.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                KmpAndroid.applicationContext.startActivity(launchMapsApp)
            }
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(linkPath)
            }
            addIntentFlags(browserIntent)

            if (browserIntent.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                KmpAndroid.applicationContext.startActivity(browserIntent)
            }
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(linkPath)
            }
            addIntentFlags(browserIntent)

            if (browserIntent.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                KmpAndroid.applicationContext.startActivity(browserIntent)
            }
        }

        actual fun launchAppInternalSettings() {
            val settingsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts(
                    UriPrefixes.settingsPackage,
                    KmpAndroid.applicationContext.packageName!!,
                    null
                )
            }
            addIntentFlags(settingsIntent)
            if (settingsIntent.resolveActivity(KmpAndroid.applicationContext.packageManager) != null) {
                KmpAndroid.applicationContext.startActivity(settingsIntent)
            }
        }

        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String
        ) {
            openMapsUrl(address)
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {
            openMapsUrl("$latitude,$longitude")
        }

        actual fun launchAppStoreViaIdentifier(appStoreLink: String) {
            launchExternalUrlViaAnyApp(appStoreLink)
        }
    }
}