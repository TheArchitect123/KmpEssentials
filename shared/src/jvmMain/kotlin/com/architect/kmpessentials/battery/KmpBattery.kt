package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource

actual class KmpBattery {
    actual companion object {
        actual fun getCurrentChargeState(): BatteryChargeState {
            TODO()
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



