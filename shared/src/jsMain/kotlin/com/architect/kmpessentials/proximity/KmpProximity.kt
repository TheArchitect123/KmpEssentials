package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.browser.window

actual class KmpProximity {
    actual companion object {
        private fun isProximitySensorSupported(): Boolean {
            return window.asDynamic().ProximitySensor != undefined
        }

        private var sensor: dynamic = null

        actual fun startListening(proximityScopeVal: ActionBoolParams) {
            if (!isProximitySensorSupported()) {
                console.log("Proximity Sensor API not supported in this browser.")
                return
            }

            try {
                sensor = js("new ProximitySensor({ frequency: 10 })") // 10Hz update rate

                sensor.onreading = {
                    val distance = sensor.distance as Float
                    console.log("Proximity: $distance cm")
                    proximityScopeVal(distance != 0f)
                }

                sensor.onerror = { event: dynamic ->
                    console.log("Proximity Sensor error: ${event.asDynamic().message}")
                }

                sensor.start()
                console.log("Proximity Sensor started.")
            } catch (e: dynamic) {
                console.log("Proximity Sensor initialization failed: ${e.message}")
            }
        }

        actual fun stopListening() {
            try {
                sensor?.stop()
                console.log("Proximity Sensor stopped.")
                sensor = null
            } catch (e: dynamic) {
                console.log("Error stopping Proximity Sensor: ${e.message}")
            }
        }
    }
}