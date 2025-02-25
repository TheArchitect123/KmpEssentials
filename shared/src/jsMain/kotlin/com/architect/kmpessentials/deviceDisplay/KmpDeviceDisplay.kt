package com.architect.kmpessentials.deviceDisplay

import kotlinx.browser.window


actual class KmpDeviceDisplay {
    actual companion object {
        private var wakeLock: dynamic = null
        actual fun keepScreenOnActive() {
            if (window.navigator.asDynamic().wakeLock != undefined) {
                window.navigator.asDynamic().wakeLock.request("screen").then { lock ->
                    wakeLock = lock
                    console.log("Wake Lock activated: Screen will not turn off.")
                }.catch { error ->
                    console.log("Failed to activate Wake Lock: ${error.message}")
                }
            } else {
                console.log("Wake Lock API is not supported in this browser.")
            }

        }

        actual fun disableScreenOnActive() {
            wakeLock?.release().then{
                // removes the wake lock (screen sleep is now managed by the device
            }
        }

        actual fun adjustScreenBrightness(brightness: Double) {
            val brightnessCommand = js("new Uint8Array([0x10, $brightness])")
            window.navigator.asDynamic().serial.requestPort().then { port ->
                port.open(js("{ baudRate: 9600 }")).then {
                    val writer = port.writable.getWriter()
                    writer.write(brightnessCommand)
                    writer.releaseLock()
                    console.log("Brightness adjusted to $brightness")
                }
            }.catch { error ->
                console.log("Failed to adjust brightness: ${error.message}")
            }
        }
    }
}