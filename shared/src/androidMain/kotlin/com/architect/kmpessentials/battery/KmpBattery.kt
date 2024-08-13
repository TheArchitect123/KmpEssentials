package com.architect.kmpessentials.battery

import android.content.Context
import android.os.BatteryManager
import com.architect.kmpessentials.KmpAndroid

actual class KmpBattery {
    actual companion object {
        val batteryService =
            KmpAndroid.clientAppContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

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

