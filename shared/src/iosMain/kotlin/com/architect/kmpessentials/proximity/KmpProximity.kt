package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceProximityStateDidChangeNotification
import platform.darwin.NSObject

actual class KmpProximity {
    actual companion object {
        private var proximityScope: ActionBoolParams? = null

        @OptIn(BetaInteropApi::class)
        private val proximityListener = object : NSObject() {
            @Suppress("unused")
            @ObjCAction
            fun proximityTriggered(arg: NSNotification) {
                proximityScope?.invoke(UIDevice.currentDevice.proximityState)
            }
        }

        @OptIn(ExperimentalForeignApi::class)
        actual fun startListening(
            proximityScopeVal: ActionBoolParams
        ) {
            proximityScope = proximityScopeVal
            UIDevice.currentDevice.proximityMonitoringEnabled = true
            NSNotificationCenter.defaultCenter.addObserver(
                observer = proximityListener,
                selector = NSSelectorFromString(proximityListener::proximityTriggered.name + ":"),
                name = UIDeviceProximityStateDidChangeNotification,
                `object` = null,
            )
        }

        actual fun stopListening() {
            UIDevice.currentDevice.proximityMonitoringEnabled = false
            NSNotificationCenter.defaultCenter.removeObserver(
                observer = proximityListener,
                name = UIDeviceProximityStateDidChangeNotification,
                `object` = null,
            )
        }
    }
}