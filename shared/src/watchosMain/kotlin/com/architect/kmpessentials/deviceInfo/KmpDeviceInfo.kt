package com.architect.kmpessentials.deviceInfo

import kotlinx.datetime.TimeZone
import platform.WatchKit.WKInterfaceDevice

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
                WKInterfaceDevice.currentDevice().model,
                WKInterfaceDevice.currentDevice().systemVersion,
                "Apple Inc"
            )
        }
    }
}

