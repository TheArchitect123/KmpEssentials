package com.architect.kmpessentials.geolocation

import com.architect.kmpessentials.geolocation.models.Location

expect class KmpGeolocation {
    companion object {
        fun getCurrentLocation(locationCoord: (Location) -> Unit)
    }
}