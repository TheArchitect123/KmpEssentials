package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.internal.ActionTripleFloatParams
import kotlinx.browser.window

actual class KmpGyroscope {
    actual companion object {
        private var sensor: dynamic = null
        private fun isGyroscopeSupported(): Boolean {
            return window.asDynamic().Gyroscope != undefined
        }

        actual fun startListening(gyroScopeVal: ActionTripleFloatParams) {
            if (!isGyroscopeSupported()) {
                console.log("Gyroscope API not supported in this browser.")
                return
            }

            try {
                sensor = js("new Gyroscope({ frequency: 60 })") // 60Hz update rate

                sensor.onreading = {
                    val x = sensor.x as Float
                    val y = sensor.y as Float
                    val z = sensor.z as Float
                    gyroScopeVal(Triple(x, y, z))
                }

                sensor.onerror = { event: dynamic ->
                    console.log("Gyroscope error: ${event.asDynamic().message}")
                }

                sensor.start()
                console.log("Gyroscope started.")
            } catch (e: dynamic) {
                console.log("Gyroscope initialization failed: ${e.message}")
            }
        }

        actual fun stopListening() {
            try {
                sensor?.stop()
                console.log("Gyroscope stopped.")
                sensor = null
            } catch (e: dynamic) {
                console.log("Error stopping Gyroscope: ${e.message}")
            }
        }
    }
}