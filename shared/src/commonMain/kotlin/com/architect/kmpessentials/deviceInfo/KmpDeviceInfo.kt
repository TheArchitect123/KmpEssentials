package com.architect.kmpessentials.deviceInfo

expect class KmpDeviceInfo {
    companion object {
        fun getDeviceTimeZone(): String
        fun getRunningPlatform(): DevicePlatform
        fun getDeviceSpecs(): DeviceSpecs
    }
}

