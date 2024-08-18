package com.architect.kmpessentials.accelerometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams

/**
 * Used for fetching Accelerometer Data from your device (X,Y,Z Axes)
 * */
expect class KmpAccelerometer {
    companion object {
        /**
         * Turns on the accelerometer listener.
         * @param accScopeVal your action to invoke when Acc data is received from your device. Results are available as a Triple(X,Y,Z)
         * */
        fun startListening(
            accScopeVal: ActionTripleFloatParams
        )
        /**
         * Turns off the accelerometer listener. Stops receiving acc data from the device
         * */
        fun stopListening()
    }
}