package com.architect.kmpessentials.deviceInfo

import kotlinx.datetime.TimeZone

actual class KmpDeviceInfo {
    actual companion object {

        actual fun getDeviceTimeZone(): String {
            return TimeZone.currentSystemDefault().id
        }

        actual fun getRunningPlatform(): DevicePlatform {
            return DevicePlatform.AppleWatch
        }

        actual fun getDeviceSpecs(): DeviceSpecs {
            return DeviceSpecs(
                "",
                "",
                "Apple Inc"
            )
        }
    }
}

