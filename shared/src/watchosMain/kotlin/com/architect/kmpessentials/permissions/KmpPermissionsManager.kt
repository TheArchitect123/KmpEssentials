package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.delegates.LocationPermissionsDelegate
import kotlinx.cinterop.UnsafeNumber
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionRecordPermissionGranted
import platform.CoreLocation.CLLocationManager
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNUserNotificationCenter

@OptIn(UnsafeNumber::class)
actual class KmpPermissionsManager {
    actual companion object {
        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            KmpMainThread.runViaMainThread {
                when (permission) {
                    Permission.PushNotifications -> {
                        UNUserNotificationCenter.currentNotificationCenter()
                            .requestAuthorizationWithOptions(
                                UNAuthorizationOptionAlert
                            ) { res, error ->
                                if (res) {
                                    runAction()
                                }
                            }
                    }

                    Permission.Microphone -> {
                        AVAudioSession.sharedInstance().requestRecordPermission {
                            if (it) {
                                runAction()
                            }
                        }
                    }

                    Permission.Location -> {
                        val location = CLLocationManager()
                        location.delegate = LocationPermissionsDelegate(runAction)
                        location.requestWhenInUseAuthorization()
                    }

                    else -> {

                    }
                }
            }
        }

        // DEPRECATED API
        actual fun isPermissionGranted(permission: Permission): Boolean {
            return false
        }

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                if (permission == Permission.PushNotifications) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .getNotificationSettingsWithCompletionHandler {
                            actionResult(it?.alertSetting() == 2)
                        }
                } else {
                    actionResult(
                        when (permission) {
                            Permission.Location -> CLLocationManager().authorizationStatus() == 3 || CLLocationManager().authorizationStatus() == 4
                            Permission.Microphone -> AVAudioSession.sharedInstance()
                                .recordPermission() == AVAudioSessionRecordPermissionGranted

                            else -> false
                        }
                    )
                }
            }
        }
    }
}