package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.battery.enums.EnergySaverStatus

/**
 * Use this for fetching Battery State information, Current Charge, and Charge source for your device
 * */
expect class KmpBattery {
    companion object {
        fun getCurrentChargeLevel(): Long
        fun getCurrentChargeState(): BatteryChargeState
        fun getCurrentPowerSource(): BatteryPowerSource
        fun isEnergySaverOn(): Boolean
    }
}



