package com.architect.kmpessentials.battery.utils

import android.os.BatteryManager
import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryHealth
import com.architect.kmpessentials.battery.enums.BatteryPowerSource

object BatteryInfoUtils {
    fun getBatteryHealth(batteryHealth: Int): BatteryHealth {
        return when (batteryHealth) {
            BatteryManager.BATTERY_HEALTH_COLD -> BatteryHealth.Cold
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> BatteryHealth.Failure
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> BatteryHealth.OverCharge
            BatteryManager.BATTERY_HEALTH_DEAD -> BatteryHealth.Dead
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> BatteryHealth.Overheat
            BatteryManager.BATTERY_HEALTH_GOOD -> BatteryHealth.Good
            else -> BatteryHealth.Unknown
        }
    }

    fun getBatteryStatus(batteryStatus: Int): BatteryChargeState {
        return when (batteryStatus) {
            BatteryManager.BATTERY_STATUS_FULL -> BatteryChargeState.Full
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> BatteryChargeState.NotCharging
            BatteryManager.BATTERY_STATUS_DISCHARGING -> BatteryChargeState.Discharging
            BatteryManager.BATTERY_STATUS_CHARGING -> BatteryChargeState.Charging
            else -> BatteryChargeState.Unknown
        }
    }

    fun getBatteryPlugged(batteryPlugged: Int): BatteryPowerSource {
        return when (batteryPlugged) {
            BatteryManager.BATTERY_PLUGGED_AC -> BatteryPowerSource.AC
            BatteryManager.BATTERY_PLUGGED_USB -> BatteryPowerSource.Usb
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> BatteryPowerSource.Wireless
            else -> BatteryPowerSource.Unknown
        }
    }
}