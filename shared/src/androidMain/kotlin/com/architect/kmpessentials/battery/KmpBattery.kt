package com.architect.kmpessentials.battery

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.PowerManager
import androidx.annotation.RequiresApi
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.battery.models.BatteryInfo
import com.architect.kmpessentials.battery.receivers.BatteryManagerBroadcastReceiver
import com.architect.kmpessentials.battery.utils.BatteryInfoUtils
import kotlin.math.roundToLong

actual class KmpBattery {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    actual companion object {
        private var batteryState: BatteryInfo? = null
        private val batteryService: BatteryManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        }
        private val powerManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.POWER_SERVICE) as PowerManager
        }

        private val batteryReceiver: BatteryManagerBroadcastReceiver by lazy {
            BatteryManagerBroadcastReceiver {
                var propertyEnergyCounter = 0L
                if (Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
                    propertyEnergyCounter =
                        batteryService.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER)
                }

                var isCharging: Boolean? = null
                var chargeTimeRemaining: Long? = null
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    isCharging = batteryService.isCharging
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    chargeTimeRemaining = batteryService.computeChargeTimeRemaining()
                }

                val batteryPct: Float? = it?.let { intent ->
                    val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    level * 100 / scale.toFloat()
                }

                batteryState = BatteryInfo(
                    batteryHealth = BatteryInfoUtils.getBatteryHealth(
                        it!!.getIntExtra(
                            BatteryManager.EXTRA_HEALTH,
                            -99
                        )
                    ),
                    batteryStatePowerSource = BatteryInfoUtils.getBatteryPlugged(
                        it.getIntExtra(
                            BatteryManager.EXTRA_PLUGGED,
                            -99
                        )
                    ),
                    batteryChargeState = BatteryInfoUtils.getBatteryStatus(
                        it.getIntExtra(
                            BatteryManager.EXTRA_STATUS,
                            -99
                        )
                    ),

                    isBatteryLow = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        it.getBooleanExtra(BatteryManager.EXTRA_BATTERY_LOW, false)
                    } else {
                        false
                    },
                    isCharging = isCharging ?: false,
                    batteryManufacture = it.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY) ?: "",
                    isBatteryAvailable = it.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false),
                    currentVoltageLevel = it.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -99)
                        .toLong(),
                    currentTemperature = it.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -99)
                        .toLong(),
                    chargeTimeRemainingMs = chargeTimeRemaining ?: 0L,
                    currentBatteryCharge = batteryPct?.roundToLong() ?: 0L,
                    currentEnergyCounter = propertyEnergyCounter
                )
            }
        }

        fun initializeBatteryService() {
            val stateFilter = IntentFilter().apply {
                addAction(Intent.ACTION_BATTERY_CHANGED)
            }

            KmpAndroid.applicationContext.registerReceiver(batteryReceiver, stateFilter)
        }

        @RequiresApi(Build.VERSION_CODES.P)
        actual fun getCurrentChargeLevel(): Long {
            return batteryState?.currentBatteryCharge ?: 0L
        }

        actual fun getCurrentChargeState(): BatteryChargeState {
            return batteryState?.batteryChargeState ?: BatteryChargeState.Unknown
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            return batteryState?.batteryStatePowerSource ?: BatteryPowerSource.Unknown
        }

        actual fun isEnergySaverOn(): Boolean {
            return powerManager.isPowerSaveMode
        }
    }
}

