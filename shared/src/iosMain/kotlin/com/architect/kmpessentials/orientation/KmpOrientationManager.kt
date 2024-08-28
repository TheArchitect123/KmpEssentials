package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.orientation.internal.OrientationListener
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceOrientation
import platform.UIKit.UIDeviceOrientationDidChangeNotification
import platform.UIKit.UIInterfaceOrientationLandscapeLeft
import platform.UIKit.UIInterfaceOrientationLandscapeRight
import platform.UIKit.UIInterfaceOrientationPortrait
import platform.UIKit.interfaceOrientation
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
            return when (UIDevice.currentDevice.orientation) {
                UIDeviceOrientation.UIDeviceOrientationPortrait, UIDeviceOrientation.UIDeviceOrientationPortraitUpsideDown -> OrientationState.Portrait
                UIDeviceOrientation.UIDeviceOrientationLandscapeLeft, UIDeviceOrientation.UIDeviceOrientationLandscapeRight -> OrientationState.Landscape
                else -> OrientationState.Unknown
            }
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(orientationChange: OrientationListener) {
            corientationChange = orientationChange
            NSNotificationCenter.defaultCenter.addObserver(
                observer = orientationListener,
                selector = NSSelectorFromString(orientationListener::orientationTriggered.name + ":"),
                name = UIDeviceOrientationDidChangeNotification,
                `object` = null,
            )
        }

        actual fun stopListening() {
            NSNotificationCenter.defaultCenter.removeObserver(
                observer = orientationListener,
                name = UIDeviceOrientationDidChangeNotification,
                `object` = null,
            )
        }
    }
}

