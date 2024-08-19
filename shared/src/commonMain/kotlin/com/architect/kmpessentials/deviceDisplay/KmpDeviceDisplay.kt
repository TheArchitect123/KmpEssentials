package com.architect.kmpessentials.deviceDisplay

/**
 * Use this to manage your device's screen and display behavior
 * */
expect class KmpDeviceDisplay {
    companion object {
        /**
         * Keeps the screen active and on
         * NOTE: This will drain your battery, you should make sure to deactivate this feature by running "disableScreenOnActive" as soon as you can
         * */
        fun keepScreenOnActive()

        /**
         * Allows the device to manage screen locking on its own
         * */
        fun disableScreenOnActive()

        /**
         * Adjust the device's screen brightness
         * */
        fun adjustScreenBrightness(brightness: Double)
    }
}