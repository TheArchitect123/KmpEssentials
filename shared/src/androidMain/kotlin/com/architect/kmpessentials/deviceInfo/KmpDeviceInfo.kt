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
            return DevicePlatform.Android
        }

        actual fun getDeviceSpecs(): DeviceSpecs {
            return DeviceSpecs("", "", "")
        }
    }
}

