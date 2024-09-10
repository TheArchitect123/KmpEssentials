package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.WatchKit.WKInterfaceDevice
import platform.WatchKit.WKInterfaceDeviceCrownOrientation
import platform.darwin.NSObject

actual class KmpOrientationManager {
    actual companion object {
        private lateinit var corientationChange: OrientationListener

        @OptIn(BetaInteropApi::class)
        private val orientationListener = object : NSObject() {
            @Suppress("unused")
            @ObjCAction
            fun orientationTriggered(arg: NSNotification) {
                corientationChange.invoke(getCurrentOrientation())
            }
        }

        actual fun getCurrentOrientation(): OrientationState {
            return when (WKInterfaceDevice.currentDevice().crownOrientation) {
                WKInterfaceDeviceCrownOrientation.WKInterfaceDeviceCrownOrientationRight -> OrientationState.RightWrist
                WKInterfaceDeviceCrownOrientation.WKInterfaceDeviceCrownOrientationLeft -> OrientationState.LeftWrist
                else -> OrientationState.Unknown
            }
        }


        actual fun startListening(orientationChange: OrientationListener) {

        }

        actual fun stopListening() {

        }
    }
}

