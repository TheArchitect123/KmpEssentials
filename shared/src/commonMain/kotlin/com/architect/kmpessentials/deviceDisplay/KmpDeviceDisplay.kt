package com.architect.kmpessentials.deviceDisplay

expect class KmpDeviceDisplay {
    companion object {
        fun keepScreenOnActive()
        fun disableScreenOnActive()
        fun adjustScreenBrightness(brightness: Double)
    }
}