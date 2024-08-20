package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener

expect class KmpOrientationManager {
    companion object{
        /**
         * @return the device's current orientation (Portrait/Landscape)
         * */
        fun getCurrentOrientation(): OrientationState

        /**
         * Starts listening to orientation changes
         * */
        fun startListening(orientationChange: OrientationListener)

        /**
         * Stops listening to orientation changes
         * */
        fun stopListening()
    }
}

