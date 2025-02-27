package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.internal.ActionBatteryPowerStatusParams
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionChargeStatusParams
import com.architect.kmpessentials.internal.ActionLongParams

/**
 * Use this for fetching Battery State information, Current Charge, and Charge source for your device
 * */
expect class KmpBattery {
    companion object {
        fun getCurrentChargeLevel(): Long
        fun getCurrentChargeState(): BatteryChargeState
        fun getCurrentPowerSource(): BatteryPowerSource
        fun isEnergySaverOn(): Boolean

        suspend fun getCurrentChargeLevelAsync(action: ActionLongParams)
        suspend fun getCurrentChargeStateAsync(action: ActionChargeStatusParams)
        suspend fun getCurrentPowerSourceAsync(action: ActionBatteryPowerStatusParams)
        suspend fun isEnergySaverOnAsync(action: ActionBoolParams)
    }
}



