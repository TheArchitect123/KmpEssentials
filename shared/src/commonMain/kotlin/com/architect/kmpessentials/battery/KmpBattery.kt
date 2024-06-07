package com.architect.kmpessentials.battery

expect class KmpBattery {
    companion object{
        fun getCurrentChargeLevel(): Double
        fun getCurrentChargeState():BatteryChargeState
        fun getCurrentPowerSource(): BatteryPowerSource
        fun getCurrentEnergySaverStatus(): EnergySaverStatus
    }
}

