package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.internal.ActionBatteryPowerStatusParams
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionChargeStatusParams
import com.architect.kmpessentials.internal.ActionLongParams
import platform.Foundation.NSProcessInfo
import platform.Foundation.isLowPowerModeEnabled
import platform.WatchKit.WKInterfaceDevice
import platform.WatchKit.WKInterfaceDeviceBatteryState
import kotlin.math.roundToLong

actual class KmpBattery {
    actual companion object {
        actual fun getCurrentChargeState(): BatteryChargeState {
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(true)
            val batteryState = when (WKInterfaceDevice.currentDevice().batteryState()) {
                WKInterfaceDeviceBatteryState.WKInterfaceDeviceBatteryStateFull -> BatteryChargeState.Full
                WKInterfaceDeviceBatteryState.WKInterfaceDeviceBatteryStateUnplugged -> BatteryChargeState.NotCharging
                WKInterfaceDeviceBatteryState.WKInterfaceDeviceBatteryStateCharging -> BatteryChargeState.Charging
                else -> BatteryChargeState.Discharging
            }
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(false)
            return batteryState
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(true)
            val result = when (WKInterfaceDevice.currentDevice().batteryState()) {
                WKInterfaceDeviceBatteryState.WKInterfaceDeviceBatteryStateUnplugged -> BatteryPowerSource.Battery
                else -> BatteryPowerSource.Usb
            }
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(false)

            return result
        }

        actual fun getCurrentChargeLevel(): Long {
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(true)

            val roundBatteryState = WKInterfaceDevice.currentDevice().batteryLevel.roundToLong()
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(false)
            return roundBatteryState
        }

        actual fun isEnergySaverOn(): Boolean {
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(true)

            val isPowerMode = NSProcessInfo.processInfo.isLowPowerModeEnabled()
            WKInterfaceDevice.currentDevice().setBatteryMonitoringEnabled(false)
            return isPowerMode
        }

        actual suspend fun getCurrentChargeLevelAsync(action: ActionLongParams) {
            action(getCurrentChargeLevel())
        }

        actual suspend fun getCurrentChargeStateAsync(action: ActionChargeStatusParams) {
            action(getCurrentChargeState())
        }

        actual suspend fun getCurrentPowerSourceAsync(action: ActionBatteryPowerStatusParams) {
            action(getCurrentPowerSource())
        }

        actual suspend fun isEnergySaverOnAsync(action: ActionBoolParams) {
            action(isEnergySaverOn())
        }
    }
}



