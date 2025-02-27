package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.internal.ActionBatteryPowerStatusParams
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionChargeStatusParams
import com.architect.kmpessentials.internal.ActionLongParams
import kotlinx.browser.window

actual class KmpBattery {
    actual companion object {
        private suspend fun getBattery(): dynamic {
            return window.navigator.asDynamic().getBattery().await()
        }

        fun isBatteryAPISupported(): Boolean {
            return window.navigator.asDynamic().getBattery != undefined
        }

        actual fun getCurrentChargeState(): BatteryChargeState {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getCurrentChargeLevel(): Long {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun isEnergySaverOn(): Boolean {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        // Get current battery charge level asynchronously
        actual suspend fun getCurrentChargeLevelAsync(action: ActionLongParams) {
            getBattery().then { batteryManager ->
                action.invoke((batteryManager.level.unsafeCast<Double>() * 100).toLong())
            }
        }

        // Get current battery charge state asynchronously
        actual suspend fun getCurrentChargeStateAsync(action: ActionChargeStatusParams) {
            getBattery().then { batteryManager ->
                val chargeState = when {
                    batteryManager.charging == true -> BatteryChargeState.Charging
                    batteryManager.charging == false -> BatteryChargeState.Discharging
                    batteryManager.level == 1.0 -> BatteryChargeState.Full
                    else -> BatteryChargeState.Unknown
                }
                action.invoke(chargeState)
            }
        }

        // Get current power source (Battery or AC Power) asynchronously
        actual suspend fun getCurrentPowerSourceAsync(action: ActionBatteryPowerStatusParams) {
            getBattery().then { batteryManager ->
                val powerSource = when {
                    batteryManager.charging == true -> BatteryPowerSource.AC
                    batteryManager.charging == false -> BatteryPowerSource.Battery
                    else -> BatteryPowerSource.Unknown
                }
                action.invoke(powerSource)
            }
        }

        // Check if Energy Saver Mode is on (battery level < 20%) asynchronously
        actual suspend fun isEnergySaverOnAsync(action: ActionBoolParams) {
            getBattery().then { batteryManager ->
                action.invoke(batteryManager.level.unsafeCast<Double>() < 0.2)
            }
        }
    }
}



