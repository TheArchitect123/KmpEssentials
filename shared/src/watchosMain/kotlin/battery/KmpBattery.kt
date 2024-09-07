package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource

/**
 * Use this for fetching Battery State information, Current Charge, and Charge source for your device
 * */
actual class KmpBattery {
    actual companion object {
        actual fun getCurrentChargeLevel(): Long {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun getCurrentChargeState(): BatteryChargeState {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun isEnergySaverOn(): Boolean {
            TODO("NOT IMPLEMENTED YET")
        }
    }
}



