package com.architect.kmpessentials.vibration

expect class KmpVibration {

    companion object{
        fun startVibrating(durationMs : Long)
        fun stopVibrating()
    }
}