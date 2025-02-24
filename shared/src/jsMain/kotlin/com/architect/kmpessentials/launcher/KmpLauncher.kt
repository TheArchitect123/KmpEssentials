package com.architect.kmpessentials.launcher

import kotlinx.browser.window

actual class KmpLauncher {
    actual companion object {
        private fun encodeURIComponent(value: String): String {
            return js("encodeURIComponent(value)") as String
        }

        actual fun startTimer(seconds: Double, action: () -> Boolean) {
            val milliseconds = (seconds * 1000).toInt()

            var timerId = 0
            timerId = window.setTimeout({
                if (!action()) {
                    window.clearTimeout(timerId)
                }
            }, milliseconds)
        }

        actual fun startTimerRepeating(seconds: Double, action: () -> Boolean) {
            val milliseconds = (seconds * 1000).toInt()
            var timerId = 0
            timerId = window.setInterval({
                if (!action()) {
                    window.clearInterval(timerId)
                }
            }, milliseconds)
        }

        actual fun launchExternalMapsAppWithAddress(
            address: String,
            markerTitle: String
        ) {
            val encodedAddress = encodeURIComponent(address)
            window.open("https://www.google.com/maps/search/?api=1&query=$encodedAddress")
        }

        actual fun launchExternalMapsAppWithCoordinates(
            latitude: Double,
            longitude: Double,
            markerTitle: String
        ) {
            val encodedTitle = encodeURIComponent(markerTitle)
            val mapsUrl =
                "https://www.google.com/maps/search/?api=1&query=$latitude,$longitude&query_place_id=$encodedTitle"
            window.open(mapsUrl)
        }

        actual fun launchExternalUrlViaBrowser(linkPath: String) {
            window.open(linkPath)
        }

        actual fun launchExternalUrlViaAnyApp(linkPath: String) {
            window.open(linkPath)
        }

        actual fun launchAppInternalSettings() {
            when {
                window.navigator.userAgent.contains(
                    "Chrome",
                    ignoreCase = true
                ) -> window.open("chrome://settings/")

                window.navigator.userAgent.contains(
                    "Firefox",
                    ignoreCase = true
                ) -> window.open("about:preferences")

                window.navigator.userAgent.contains(
                    "Edg",
                    ignoreCase = true
                ) -> window.open("edge://settings/")

                else -> println("Browser settings URL not supported for this browser.")
            }
        }

        actual fun launchAppStoreViaIdentifier(appStoreLink: String) {
            window.open(appStoreLink)
        }
    }
}