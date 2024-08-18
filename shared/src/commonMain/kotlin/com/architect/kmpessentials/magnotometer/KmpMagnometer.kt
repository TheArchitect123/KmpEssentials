package com.architect.kmpessentials.magnotometer

import com.architect.kmpessentials.internal.ActionTripleFloatParams

/**
 * Used for fetching magnetometer Data from your device (X,Y,Z Axes)
 * */
expect class KmpMagnometer {
    companion object {
        /**
         * Turns on the magnetometer listener.
         * @param magScopeVal your action to invoke when mag data is received from your device. Results are available as a Triple(X,Y,Z)
         * */
        fun startListening(
            magScopeVal: ActionTripleFloatParams
        )

        /**
         * Turns off the magnetometer listener. Stops receiving acc data from the device
         * */
        fun stopListening()
    }
}