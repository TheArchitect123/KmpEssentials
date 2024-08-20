package com.architect.kmpessentials.geolocation

import com.architect.kmpessentials.geolocation.models.Location

expect class KmpGeolocation {
    companion object {
        /**
         * fetches the user's current location
         * @param locationCoord returns the user's current location
         * */
        fun getCurrentLocation(locationCoord: (Location) -> Unit)
    }
}