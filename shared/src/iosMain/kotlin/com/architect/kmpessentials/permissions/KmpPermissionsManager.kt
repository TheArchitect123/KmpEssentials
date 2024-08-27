package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.delegates.LocationPermissionsDelegate
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionRecordPermissionGranted
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.CoreLocation.CLLocationManager
import platform.UIKit.UIApplication
import platform.UIKit.currentUserNotificationSettings
import platform.UIKit.isRegisteredForRemoteNotifications
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionProvisional
import platform.UserNotifications.UNUserNotificationCenter

actual class KmpPermissionsManager {
    actual companion object {
        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            KmpMainThread.runViaMainThread {
                if (!isPermissionGranted(permission)) {
                    when (permission) {
                        Permission.Camera -> {
                            AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) {
                                runAction()
                            }
                        }

                        Permission.PushNotifications -> {
                            UNUserNotificationCenter.currentNotificationCenter()
                                .requestAuthorizationWithOptions(
                                    UNAuthorizationOptionAlert and UNAuthorizationOptionBadge and UNAuthorizationOptionProvisional
                                ) { res, error ->
                                    if (error != null && res) {
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
                } else {
                    runAction()
                }
            }
        }

        actual fun isPermissionGranted(permission: Permission): Boolean {
            return when (permission) {
                Permission.Camera -> AVCaptureDevice.authorizationStatusForMediaType(
                    AVMediaTypeVideo
                ) == AVAuthorizationStatusAuthorized

                Permission.Location -> CLLocationManager().authorizationStatus() == 3 || CLLocationManager().authorizationStatus() == 4
                Permission.PushNotifications -> UIApplication.sharedApplication()
                    .currentUserNotificationSettings() != null && UIApplication.sharedApplication()
                    .isRegisteredForRemoteNotifications()

                Permission.Microphone -> AVAudioSession.sharedInstance()
                    .recordPermission() == AVAudioSessionRecordPermissionGranted

                else -> false
            }
        }
    }
}