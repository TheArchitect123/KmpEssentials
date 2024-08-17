package com.architect.kmpessentials.battery

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
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
            return UIDevice.currentDevice.batteryLevel.roundToLong()
        }

        actual fun isEnergySaverOn(): Boolean {
            return NSProcessInfo.processInfo.isLowPowerModeEnabled()
        }
    }
}

