package com.architect.kmpessentials.permissions.delegates

import com.architect.kmpessentials.internal.ActionNoParams
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.CLLocationManagerDelegateProtocol
import platform.darwin.NSObject

class LocationPermissionsDelegate(val runAction: ActionNoParams) : NSObject(),
    CLLocationManagerDelegateProtocol {
    override fun locationManagerDidChangeAuthorization(manager: CLLocationManager) {
        when (manager.authorizationStatus()) {
            0 -> {// Not Determined

            }

            2 -> // denied
            {

            }

            3, 4 -> { // granted
                runAction()
            }
        }
    }
}