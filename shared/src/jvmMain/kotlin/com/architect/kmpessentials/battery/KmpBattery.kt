package com.architect.kmpessentials.battery

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo

actual class KmpBattery {
    actual companion object {

        private fun getCurrentStateForDesktop(): BatteryChargeState {
            return try {
                val process =
                    ProcessBuilder("wmic", "path", "Win32_Battery", "get", "BatteryStatus")
                        .redirectErrorStream(true)
                        .start()

                val output = process.inputStream.bufferedReader().readText().trim()
                val statusCode =
                    output.lines().find { it.trim().matches(Regex("\\d+")) }?.trim()?.toIntOrNull()

                when (statusCode) {
                    1 -> BatteryChargeState.Discharging
                    2, 6, 7, 8, 9 -> BatteryChargeState.Charging
                    3 -> BatteryChargeState.Full
                    4, 5, 11 -> BatteryChargeState.NotCharging
                    else -> BatteryChargeState.Unknown
                }
            } catch (e: Exception) {
                e.printStackTrace()
                BatteryChargeState.Unknown
            }
        }

        private fun getCurrentStateForMacOS(): BatteryChargeState {
            return try {
                val process = ProcessBuilder("pmset", "-g", "batt")
                    .redirectErrorStream(true)
                    .start()

                val output = process.inputStream.bufferedReader().readText().trim()
                return when {
                    output.contains("AC attached") -> BatteryChargeState.Charging
                    output.contains("charging") -> BatteryChargeState.Charging
                    output.contains("discharging") -> BatteryChargeState.Discharging
                    output.contains("charged") -> BatteryChargeState.Full
                    else -> BatteryChargeState.Unknown
                }
            } catch (e: Exception) {
                e.printStackTrace()
                BatteryChargeState.Unknown
            }
        }

        private fun getCurrentStateForLinux(): BatteryChargeState {
            return try {
                val process = ProcessBuilder("acpi", "-b")
                    .redirectErrorStream(true)
                    .start()

                val output = process.inputStream.bufferedReader().readText().trim()
                return when {
                    output.contains("Charging") -> BatteryChargeState.Charging
                    output.contains("Discharging") -> BatteryChargeState.Discharging
                    output.contains("Full") -> BatteryChargeState.Full
                    else -> BatteryChargeState.Unknown
                }
            } catch (e: Exception) {
                e.printStackTrace()
                BatteryChargeState.Unknown
            }
        }

        actual fun getCurrentChargeState(): BatteryChargeState {
            return when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> getCurrentStateForDesktop()
                DevicePlatform.MacOS -> getCurrentStateForMacOS()
                else -> getCurrentStateForLinux()
            }
        }

        actual fun getCurrentPowerSource(): BatteryPowerSource {
            val chargeState = when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> getCurrentStateForDesktop()
                DevicePlatform.MacOS -> getCurrentStateForMacOS()
                else -> getCurrentStateForLinux()
            }

            return if (chargeState == BatteryChargeState.Discharging || chargeState == BatteryChargeState.NotCharging) {
                return BatteryPowerSource.Battery
            } else {
                BatteryPowerSource.Usb
            }
        }

        actual fun getCurrentChargeLevel(): Long {
            return when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> try {
                    val process = ProcessBuilder(
                        "wmic",
                        "path",
                        "Win32_Battery",
                        "get",
                        "EstimatedChargeRemaining"
                    )
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText()
                    val percentage = output.lines()
                        .find { it.trim().matches(Regex("\\d+")) }
                        ?.trim()?.toIntOrNull()

                    percentage?.toLong() ?: 0
                } catch (e: Exception) {
                    e.printStackTrace()
                    0
                }

                else -> try {
                    val command = if (System.getProperty("os.name").lowercase().contains("mac")) {
                        arrayOf("pmset", "-g", "batt")
                    } else {
                        arrayOf("acpi", "-b")
                    }

                    val process = ProcessBuilder(*command)
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText()
                    val percentage =
                        Regex("(\\d+)%").find(output)?.groupValues?.get(1)?.toIntOrNull()

                    percentage?.toLong() ?: 0
                } catch (e: Exception) {
                    e.printStackTrace()
                    0
                }
            }
        }

        actual fun isEnergySaverOn(): Boolean {
            return when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> try {
                    val process = ProcessBuilder("powercfg", "/query")
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText().trim()
                    output.contains("Power Saver") && output.contains("0x1")
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
                DevicePlatform.MacOS -> try {
                    val process = ProcessBuilder("pmset", "-g", "batt")
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText().trim()
                    output.contains("lowpowermode 1")
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
                else -> try {
                    val process = ProcessBuilder("upower", "-i", "/org/freedesktop/UPower/devices/battery_BAT0")
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText().trim()
                    output.contains("energy-saving: yes")
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }
        }
    }
}



