package com.architect.kmpessentials.geolocation

import com.architect.kmpessentials.geolocation.models.Location
import kotlinx.browser.window

actual class KmpGeolocation {
    actual companion object {
        actual fun getCurrentLocation(locationCoord: (Location) -> Unit) {
            val geolocation = window.navigator.asDynamic().geolocation
            if (geolocation != undefined) {
                geolocation.getCurrentPosition({ position ->
                    val latitude = position.coords.latitude as Double
                    val longitude = position.coords.longitude as Double
                    locationCoord(Location(latitude, longitude))
                }, { error ->
                    console.log("Error getting location: ${error.message}")
                })
            } else {
                console.log("Geolocation API is not supported in this browser : \"${window.navigator.appName}\"")
            }
        }
    }
}