package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams

/**
 * Used for checking if an object is close to your device's proximity sensor
 * */
expect class KmpProximity {
    companion object {
        /**
         * Turns on the proximity listener.
         * @param proximityScopeVal your action to invoke when proximity sensor is triggered. Results are available as a Boolean
         * If true, something is close to your sensor.
         * false otherwise
         * */
        fun startListening(
            proximityScopeVal: ActionBoolParams
        )

        /**
         * Turns off the proximity listener. Stops receiving proximity data from the device
         * */
        fun stopListening()
    }
}