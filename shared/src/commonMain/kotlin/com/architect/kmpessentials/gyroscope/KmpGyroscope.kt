package com.architect.kmpessentials.gyroscope

import com.architect.kmpessentials.internal.ActionTripleFloatParams

/**
 * Used for fetching Gyroscope Data from your device (X,Y,Z Axes)
 * */
expect class KmpGyroscope {
    companion object {
        /**
         * Turns on the gyroscope listener.
         * @param gyroScopeVal your action to invoke when gyro data is received from your device. Results are available as a Triple(X,Y,Z)
         * */
        fun startListening(
            gyroScopeVal: ActionTripleFloatParams
        )

        /**
         * Turns off the gyroscope listener. Stops receiving gyro data from the device
         * */
        fun stopListening()
    }
}