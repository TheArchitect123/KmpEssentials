package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.internal.ActionBatteryPowerStatusParams
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionChargeStatusParams
import com.architect.kmpessentials.internal.ActionLongParams
import platform.Foundation.NSProcessInfo
import platform.Foundation.isLowPowerModeEnabled
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceBatteryState
import kotlin.math.roundToLong

actual class KmpBattery {
    actual companion object {
        actual fun getCurrentChargeState(): BatteryChargeState {
            UIDevice.currentDevice.setBatteryMonitoringEnabled(true)
            val batteryState = when (UIDevice.currentDevice.batteryState()) {
                UIDeviceBatteryState.UIDeviceBatteryStateFull -> BatteryChargeState.Full
                UIDeviceBatteryState.UIDeviceBatteryStateUnplugged -> BatteryChargeState.NotCharging
                UIDeviceBatteryState.UIDeviceBatteryStateCharging -> BatteryChargeState.Charging
                else -> BatteryChargeState.Discharging
            }
            UIDevice.currentDevice.setBatteryMonitoringEnabled(false)
            return batteryState
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            UIDevice.currentDevice.setBatteryMonitoringEnabled(true)
            val result = when (UIDevice.currentDevice.batteryState()) {
                UIDeviceBatteryState.UIDeviceBatteryStateUnplugged -> BatteryPowerSource.Battery
                else -> BatteryPowerSource.Usb
            }
            UIDevice.currentDevice.setBatteryMonitoringEnabled(false)

            return result
        }

        actual fun getCurrentChargeLevel(): Long {
            UIDevice.currentDevice.setBatteryMonitoringEnabled(true)

            val roundBatteryState = UIDevice.currentDevice.batteryLevel.roundToLong()
            UIDevice.currentDevice.setBatteryMonitoringEnabled(false)
            return roundBatteryState
        }

        actual fun isEnergySaverOn(): Boolean {
            UIDevice.currentDevice.setBatteryMonitoringEnabled(true)

            val isPowerMode = NSProcessInfo.processInfo.isLowPowerModeEnabled()
            UIDevice.currentDevice.setBatteryMonitoringEnabled(false)
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

