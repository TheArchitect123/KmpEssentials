package com.architect.kmpessentials.accelerometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.browser.window

actual class KmpAccelerometer {
    actual companion object {
        private fun isAccelerometerSupported(): Boolean {
            return window.asDynamic().Accelerometer != undefined
        }

        private var sensor: dynamic = null

        actual fun startListening(accScopeVal: ActionTripleFloatParams) {
            if (!isAccelerometerSupported()) {
                console.log("Accelerometer API not supported in this browser.")
                return
            }

            try {
                sensor = js("new Accelerometer({ frequency: 60 })") // 60Hz update rate

                sensor.onreading = {
                    val x = sensor.x as Float
                    val y = sensor.y as Float
                    val z = sensor.z as Float
                    accScopeVal(Triple(x, y, z))
                }

                sensor.onerror = { event: dynamic ->
                    console.log("Accelerometer error: ${event.asDynamic().message}")
                }

                sensor.start()
                console.log("Accelerometer started.")
            } catch (e: dynamic) {
                console.log("Accelerometer initialization failed: ${e.message}")
            }
        }

        actual fun stopListening() {
            try {
                sensor?.stop()
                console.log("Accelerometer stopped.")
                sensor = null
            } catch (e: dynamic) {
                console.log("Error stopping Accelerometer: ${e.message}")
            }
        }
    }
}