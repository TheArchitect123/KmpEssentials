package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.internal.ActionBatteryPowerStatusParams
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionChargeStatusParams
import com.architect.kmpessentials.internal.ActionLongParams
import platform.Foundation.NSProcessInfo
import platform.Foundation.isLowPowerModeEnabled
import kotlin.math.roundToLong

actual class KmpBattery {
    actual companion object {
        actual fun getCurrentChargeState(): BatteryChargeState {

            TODO()
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            TODO()
        }

        actual fun getCurrentChargeLevel(): Long {
            TODO()
        }

        actual fun isEnergySaverOn(): Boolean {
            TODO()
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



