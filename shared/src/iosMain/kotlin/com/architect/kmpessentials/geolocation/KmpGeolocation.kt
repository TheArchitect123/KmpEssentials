package com.architect.kmpessentials.geolocation

import com.architect.kmpessentials.geolocation.models.Location
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.kCLLocationAccuracyBest

actual class KmpGeolocation {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun getCurrentLocation(locationCoord: (Location) -> Unit) {
            val locationManager = CLLocationManager().apply {
                desiredAccuracy = kCLLocationAccuracyBest
            }

            locationManager.startUpdatingLocation()
            locationManager.location!!.coordinate.useContents {
                locationCoord(Location(latitude, longitude))
                locationManager.stopUpdatingLocation()
            }
        }
    }
}