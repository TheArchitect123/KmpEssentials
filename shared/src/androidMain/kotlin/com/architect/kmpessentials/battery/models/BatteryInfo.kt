package com.architect.kmpessentials.battery.models

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryHealth
import com.architect.kmpessentials.battery.enums.BatteryPowerSource

data class BatteryInfo(
    val currentBatteryCharge: Long,
    val batteryStatePowerSource: BatteryPowerSource,
    val batteryChargeState: BatteryChargeState,
    val batteryHealth: BatteryHealth,
    val isBatteryAvailable: Boolean,
    val batteryManufacture: String,
    val isBatteryLow: Boolean,
    val currentVoltageLevel: Long,
    val currentTemperature: Long,
    val currentEnergyCounter: Long,
    val isCharging: Boolean,
    val chargeTimeRemainingMs: Long
)