package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.orientation.internal.OrientationListener
import platform.UIKit.UIInterfaceOrientationLandscapeLeft
import platform.UIKit.UIInterfaceOrientationLandscapeRight
import platform.UIKit.UIInterfaceOrientationPortrait
import platform.UIKit.interfaceOrientation

actual class KmpOrientationManager {
    actual companion object {
        actual fun getCurrentOrientation(): OrientationState {
            return when (KmpiOS.getTopViewController()?.interfaceOrientation) {
                UIInterfaceOrientationPortrait -> OrientationState.Portrait
                UIInterfaceOrientationLandscapeRight, UIInterfaceOrientationLandscapeLeft -> OrientationState.Landscape
                else -> OrientationState.Unknown
            }
        }

        actual fun startListening(orientationChange: OrientationListener) {

        }

        actual fun stopListening() {

        }
    }
}

