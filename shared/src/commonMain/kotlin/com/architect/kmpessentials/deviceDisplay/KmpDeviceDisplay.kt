package com.architect.kmpessentials.deviceDisplay

expect class KmpDeviceDisplay {
    companion object{
        fun preventScreenAutoTurnOff()
        fun allowScreenAutoTurnOff()
        fun preventScreenLock()
        fun adjustScreenBrightness(brightness: Double)
    }
}