package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.internal.ActionTripleFloatParams
import java.io.File


actual class KmpGyroscope {
    actual companion object {
        actual fun startListening(
            gyroScopeVal: ActionTripleFloatParams
        ) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    try {
                        val scriptFile = File.createTempFile("sensor_read", ".ps1")
                        scriptFile.writeText(
                            """
            Add-Type -TypeDefinition @"
            using System;
            using Windows.Devices.Sensors;

            public class SensorReader {
                public static string GetGyroscopeData() {
                    var sensor = Gyrometer.GetDefault();
                    if (sensor == null) return "No Gyroscope found";

                    var reading = sensor.GetCurrentReading();
                    return $"{reading.AngularVelocityX},{reading.AngularVelocityY},{reading.AngularVelocityZ}";
                }
            }
            "@ -Language CSharp
            [SensorReader]::GetGyroscopeData()
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
                            gyroScopeVal(Triple(values[0], values[1], values[2]))
                        }

                        scriptFile.delete()
                    } catch (e: Exception) {
                        println("Error reading gyroscope data: ${e.message}")
                    }
                }

                DevicePlatform.MacOS -> {
                    try {
                        val process = ProcessBuilder(
                            "sh",
                            "-c",
                            "ioreg -r -c AppleSMC | grep -i gyroscope"
                        ).start()
                        val output = process.inputStream.bufferedReader().readText().trim()

                        val values = output.split(",").mapNotNull { it.toFloatOrNull() }
                        if (values.size == 3) {
                            gyroScopeVal(Triple(values[0], values[1], values[2]))
                        }
                    } catch (e: Exception) {

                    }
                }

                else -> {
                    try {
                        val xProcess = ProcessBuilder(
                            "cat",
                            "/sys/bus/iio/devices/iio:device0/in_anglvel_x_raw"
                        ).start()
                        val yProcess = ProcessBuilder(
                            "cat",
                            "/sys/bus/iio/devices/iio:device0/in_anglvel_y_raw"
                        ).start()
                        val zProcess = ProcessBuilder(
                            "cat",
                            "/sys/bus/iio/devices/iio:device0/in_anglvel_z_raw"
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

                        gyroScopeVal(Triple(x, y, z))
                    } catch (e: Exception) {
                        println("Error reading gyroscope data: ${e.message}")
                    }
                }
            }
        }

        actual fun stopListening() {

        }
    }
}