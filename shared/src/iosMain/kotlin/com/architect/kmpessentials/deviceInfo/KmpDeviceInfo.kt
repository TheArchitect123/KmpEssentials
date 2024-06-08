package com.architect.kmpessentials.deviceInfo

actual class KmpDeviceInfo {
    actual companion object {
        actual fun getDeviceTimeZone(): String {
            return ""
        }

        actual fun getDeviceCurrentTimeUtc(): String {
            return ""
        }

        actual fun getRunningPlatform(): DevicePlatform {
            return DevicePlatform.iOS
        }

        actual fun getDeviceSpecs(): DeviceSpecs {
            return DeviceSpecs("", "", "")
        }
    }
}

