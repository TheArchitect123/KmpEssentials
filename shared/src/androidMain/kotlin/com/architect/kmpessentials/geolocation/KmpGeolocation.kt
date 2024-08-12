package com.architect.kmpessentials.geolocation

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import com.architect.kmpessentials.KmpAndroid

actual class KmpGeolocation {
    actual companion object {
        @SuppressLint("MissingPermission")
        actual fun getCurrentLocation(locationCoord: (com.architect.kmpessentials.geolocation.models.Location) -> Unit) {
            val locationManager =
                KmpAndroid.clientAppContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            val gpsLocationListener: LocationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    locationCoord(
                        com.architect.kmpessentials.geolocation.models.Location(
                            location.latitude,
                            location.longitude
                        )
                    )
                }
            }

            val networkLocationListener: LocationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    locationCoord(
                        com.architect.kmpessentials.geolocation.models.Location(
                            location.latitude,
                            location.longitude
                        )
                    )
                }
            }

            if (hasGps) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000,
                    0F,
                    gpsLocationListener
                )
            } else if (hasNetwork) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    5000,
                    0F,
                    networkLocationListener
                )
            }
        }
    }
}