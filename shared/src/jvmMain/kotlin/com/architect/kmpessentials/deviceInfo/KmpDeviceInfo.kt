package com.architect.kmpessentials.deviceInfo

import kotlinx.datetime.TimeZone
import java.util.Locale

actual class KmpDeviceInfo {
    actual companion object {
        actual fun getDeviceTimeZone(): String {
            return TimeZone.currentSystemDefault().id
        }

        actual fun getRunningPlatform(): DevicePlatform {
            val osName = System.getProperty("os.name").lowercase(Locale.getDefault())
            if (osName.contains("win")) {
                return DevicePlatform.Windows
            } else if (osName.contains("mac")) {
                return DevicePlatform.MacOS
            } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
                return DevicePlatform.Linux
            } else {
                return DevicePlatform.Unknown
            }
        }

        actual fun getDeviceSpecs(): DeviceSpecs {
            throw TODO()
        }
    }
}

