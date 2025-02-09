package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.internal.ActionTripleFloatParams
import java.io.File

actual class KmpMagnometer {
    actual companion object {
        actual fun startListening(
            magScopeVal: ActionTripleFloatParams
        ) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        val scriptFile = File.createTempFile("magnetometer_read", ".ps1")
                        scriptFile.writeText(
                            """
            Add-Type -TypeDefinition @"
            using System;
            using Windows.Devices.Sensors;

            public class SensorReader {
                public static string GetMagnetometerData() {
                    var sensor = Magnetometer.GetDefault();
                    if (sensor == null) return "No Magnetometer found";

                    var reading = sensor.GetCurrentReading();
                    return $"{reading.MagneticFieldX},{reading.MagneticFieldY},{reading.MagneticFieldZ}";
                }
            }
            "@ -Language CSharp
            [SensorReader]::GetMagnetometerData()
        """.trimIndent()
                        )

                        val process = ProcessBuilder(
                            "powershell",
                            "-ExecutionPolicy",
                            "Bypass",
                            "-File",
                            scriptFile.absolutePath
                        ).start()
                        val output = process.inputStream.bufferedReader().readText().trim()

                        val values = output.split(",").mapNotNull { it.toFloatOrNull() }
                        if (values.size == 3) {
                            magScopeVal(Triple(values[0], values[1], values[2]))
                        }

                        scriptFile.delete()
                    } catch (e: Exception) {

                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        val process = ProcessBuilder(
                            "sh",
                            "-c",
                            "ioreg -r -c AppleSMC | grep -i magnetometer"
                        ).start()
                        val output = process.inputStream.bufferedReader().readText().trim()

                        val values = output.split(",").mapNotNull { it.toFloatOrNull() }
                        if (values.size == 3) {
                            magScopeVal(Triple(values[0], values[1], values[2]))
                        }
                    } catch (e: Exception) {

                    }
                }

                else -> {
                    try {
                        val xProcess = ProcessBuilder(
                            "cat",
                            "/sys/bus/iio/devices/iio:device0/in_magn_x_raw"
                        ).start()
                        val yProcess = ProcessBuilder(
                            "cat",
                            "/sys/bus/iio/devices/iio:device0/in_magn_y_raw"
                        ).start()
                        val zProcess = ProcessBuilder(
                            "cat",
                            "/sys/bus/iio/devices/iio:device0/in_magn_z_raw"
                        ).start()

                        val x =
                            xProcess.inputStream.bufferedReader().readText().trim().toFloatOrNull()
                                ?: 0f
                        val y =
                            yProcess.inputStream.bufferedReader().readText().trim().toFloatOrNull()
                                ?: 0f
                        val z =
                            zProcess.inputStream.bufferedReader().readText().trim().toFloatOrNull()
                                ?: 0f

                        magScopeVal(Triple(x, y, z))
                    } catch (e: Exception) {

                    }
                }
            }
        }

        actual fun stopListening() {

        }
    }
}