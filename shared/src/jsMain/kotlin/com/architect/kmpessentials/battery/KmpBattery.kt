package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import kotlinx.browser.window

actual class KmpBattery {
    actual companion object {
        fun isBatteryAPISupported(): Boolean {
            return window.navigator.asDynamic().getBattery != undefined
        }

        actual fun getCurrentChargeState(): BatteryChargeState {
            return BatteryChargeState.Unknown
//            window.navigator.asDynamic().getBattery().await()
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            TODO()
        }

        actual fun getCurrentChargeLevel(): Long {
            TODO()
        }

        actual fun isEnergySaverOn(): Boolean {
            TODO()
        }
    }
}



