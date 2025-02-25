package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.browser.window

actual class KmpMagnometer {
    actual companion object {
        private var sensor: dynamic = null

        private fun isMagnetometerSupported(): Boolean {
            return window.asDynamic().Magnetometer != undefined
        }

        actual fun startListening(magScopeVal: ActionTripleFloatParams) {
            if (!isMagnetometerSupported()) {
                console.log("Magnetometer API not supported.")
                return
            }

            try {
                sensor = js("new Magnetometer({ frequency: 10 })") // 10Hz update rate

                sensor.onreading = {
                    val x = sensor.x as Float
                    val y = sensor.y as Float
                    val z = sensor.z as Float
                    magScopeVal(Triple(x, y, z))
                }

                sensor.onerror = { event: dynamic ->
                    console.log("Magnetometer error: ${event.asDynamic().message}")
                }

                sensor.start()
                console.log("Magnetometer started.")
            } catch (e: dynamic) {
                console.log("Magnetometer initialization failed: ${e.message}")
            }
        }

        actual fun stopListening() {
            try {
                sensor?.stop()
                console.log("Magnetometer stopped.")
                sensor = null
            } catch (e: dynamic) {
                console.log("Error stopping Magnetometer: ${e.message}")
            }
        }
    }
}