package com.architect.kmpessentials.deviceInfo

import android.os.Build
import kotlinx.datetime.TimeZone

actual class KmpDeviceInfo {
    actual companion object {
        actual fun getDeviceTimeZone(): String {
            return TimeZone.currentSystemDefault().id
        }

        actual fun getRunningPlatform(): DevicePlatform {
            return DevicePlatform.Android
        }

        actual fun getDeviceSpecs(): DeviceSpecs {
            return DeviceSpecs(Build.MODEL, Build.VERSION.SDK_INT, Build.MANUFACTURER)
        }
    }
}

