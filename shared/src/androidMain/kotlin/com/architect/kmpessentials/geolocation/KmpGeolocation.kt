package com.architect.kmpessentials.geolocation

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationListener
import android.location.LocationManager
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.geolocation.models.Location

actual class KmpGeolocation {
    actual companion object {
        @SuppressLint("MissingPermission")
        actual fun getCurrentLocation(locationCoord: (Location) -> Unit) {
            val locationManager =
                KmpAndroid.clientAppContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            val gpsLocationListener = object : LocationListener {
                override fun onLocationChanged(location: android.location.Location) {
                    locationCoord(Location(location.latitude, location.longitude))
                }
            }
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                500,
                0F,
                gpsLocationListener
            )
        }
    }
}