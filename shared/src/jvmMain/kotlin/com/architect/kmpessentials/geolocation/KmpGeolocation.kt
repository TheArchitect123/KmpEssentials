package com.architect.kmpessentials.geolocation

import com.architect.kmpessentials.geolocation.models.Location
import com.architect.kmpessentials.logging.KmpLogging
import java.net.URL
import org.json.JSONObject

actual class KmpGeolocation {
    actual companion object {
        actual fun getCurrentLocation(locationCoord: (Location) -> Unit) {
            try {
                val response = URL("http://ip-api.com/json/").readText()
                val json = JSONObject(response)

                if (json.getString("status") == "success") {
                    locationCoord(Location(json.getDouble("lat"), json.getDouble("lon")))
                } else {
                    KmpLogging.writeError("JVM_API", "Failed to get device's current coordinates")
                }
            } catch (e: Exception) {
                KmpLogging.writeError("JVM_API", "Error fetching location: ${e.message}")
            }
        }
    }
}