package com.architect.kmpessentials.proximity

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.internal.ActionBoolParams
import platform.Foundation.NSNotificationCenter
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceProximityStateDidChangeNotification

actual class KmpProximity {
    actual companion object {
        private var proximityScope: ActionBoolParams? = null

        init {
            NSNotificationCenter.defaultCenter.addObserverForName(
                name = UIDeviceProximityStateDidChangeNotification,
                `object` = KmpiOS.getTopViewController(),
                queue = null
            ) {
                proximityScope?.invoke(UIDevice.currentDevice.proximityState)
            }
        }

        actual fun startListening(
            proximityScopeVal: ActionBoolParams
        ) {
            proximityScope = proximityScopeVal
            UIDevice.currentDevice.proximityMonitoringEnabled = true
        }

        actual fun stopListening() {
            UIDevice.currentDevice.proximityMonitoringEnabled = false
        }
    }
}