package com.architect.kmpessentials.battery

actual class KmpBattery {
    actual companion object {
        actual fun getCurrentChargeLevel(): Double {
            return 0.0
        }

        actual fun getCurrentChargeState(): BatteryChargeState {
            return BatteryChargeState.Charging
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            return BatteryPowerSource.Battery
        }

        actual fun getCurrentEnergySaverStatus(): EnergySaverStatus {
            return EnergySaverStatus.Off
        }
    }
}

