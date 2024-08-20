package com.architect.kmpessentials.vibration

expect class KmpVibration {

    companion object{
        /**
         * Starts a vibrator with the specified duration in Milliseconds
         * */
        fun startVibrating(durationMs : Long)

        /**
         * Stops vibrating the device
         * */
        fun stopVibrating()
    }
}