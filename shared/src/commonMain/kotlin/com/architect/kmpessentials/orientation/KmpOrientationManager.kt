package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener

expect class KmpOrientationManager {
    companion object{
        fun getCurrentOrientation(): OrientationState
        fun startListening(orientationChange: OrientationListener)
        fun stopListening()
    }
}

