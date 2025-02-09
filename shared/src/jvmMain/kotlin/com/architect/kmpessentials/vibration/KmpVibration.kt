package com.architect.kmpessentials.vibration

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import java.io.File

actual class KmpVibration {
    actual companion object {
        actual fun startVibrating(durationMs: Long) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    val scriptFile = File.createTempFile("vibrate", ".ps1")
                    scriptFile.writeText(
                        """
        Add-Type -TypeDefinition @"
        using System;
        using System.Runtime.InteropServices;
        public class Vibration {
            [StructLayout(LayoutKind.Sequential)]
            struct XINPUT_VIBRATION {
                public ushort wLeftMotorSpeed;
                public ushort wRightMotorSpeed;
            }

            [DllImport("XInput1_4.dll", EntryPoint = "XInputSetState")]
            private static extern int XInputSetState(int dwUserIndex, ref XINPUT_VIBRATION pVibration);

            public static void SetVibration(int leftMotor, int rightMotor) {
                XINPUT_VIBRATION vibration = new XINPUT_VIBRATION();
                vibration.wLeftMotorSpeed = (ushort)leftMotor;
                vibration.wRightMotorSpeed = (ushort)rightMotor;
                XInputSetState(0, ref vibration);
            }

            public static void StopVibration() {
                XINPUT_VIBRATION vibration = new XINPUT_VIBRATION();
                vibration.wLeftMotorSpeed = 0;
                vibration.wRightMotorSpeed = 0;
                XInputSetState(0, ref vibration);
            }
        }
        "@ -Language CSharp
        [Vibration]::SetVibration(65535, 65535)
        Start-Sleep -Milliseconds $durationMs
        [Vibration]::StopVibration()
    """.trimIndent()
                    )

                    ProcessBuilder(
                        "powershell",
                        "-ExecutionPolicy",
                        "Bypass",
                        "-File",
                        scriptFile.absolutePath
                    ).start()
                    scriptFile.delete()
                }

                DevicePlatform.MacOS -> {
                    val scriptFile = File.createTempFile("vibrate", ".applescript")
                    scriptFile.writeText(
                        """do shell script "osascript -e 'tell application \"System Events\" to key code 123 using {shift down}'"""".trimIndent()
                    )

                    ProcessBuilder("osascript", scriptFile.absolutePath).start()
                    scriptFile.delete()
                }

                else -> {
                    ProcessBuilder(
                        "sh",
                        "-c",
                        "echo 255 > /sys/class/input/eventX/device/ff_effects"
                    ).start()
                    Thread.sleep(durationMs)
                    ProcessBuilder(
                        "sh",
                        "-c",
                        "echo 0 > /sys/class/input/eventX/device/ff_effects"
                    ).start()
                }
            }
        }

        actual fun stopVibrating() {

        }
    }
}