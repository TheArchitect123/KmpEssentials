package com.architect.kmpessentials.geolocation

import android.annotation.SuppressLint
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.geolocation.models.Location
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

actual class KmpGeolocation {
    actual companion object {

        @SuppressLint("MissingPermission")
        actual fun getCurrentLocation(locationCoord: (Location) -> Unit) {
            KmpMainThread.runViaMainThread {
                val fusedLocationClient =
                    LocationServices.getFusedLocationProviderClient(KmpAndroid.clientAppContext)

                val locationCallback = object : LocationCallback() {
                    override fun onLocationResult(locationResult: LocationResult) {
                        val location = locationResult.locations.firstOrNull()
                        if (location == null) {
                            locationCoord(Location(0.0, 0.0))
                        } else {
                            locationCoord(Location(location.latitude, location.longitude))
                        }

                        fusedLocationClient.removeLocationUpdates(this)
                    }
                }

                val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 500)
                    .setWaitForAccurateLocation(false).build()
                fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
            }
        }
    }
}