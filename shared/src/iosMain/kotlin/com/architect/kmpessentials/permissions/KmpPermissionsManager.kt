package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.delegates.LocationPermissionsDelegate
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionRecordPermissionGranted
import platform.AVFAudio.AVAudioSessionRecordPermissionUndetermined
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusNotDetermined
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.Contacts.CNAuthorizationStatusAuthorized
import platform.Contacts.CNAuthorizationStatusNotDetermined
import platform.Contacts.CNContactStore
import platform.Contacts.CNEntityType
import platform.CoreLocation.CLLocationManager
import platform.Photos.PHAuthorizationStatusAuthorized
import platform.Photos.PHAuthorizationStatusNotDetermined
import platform.Photos.PHPhotoLibrary
import platform.Speech.SFSpeechRecognizer
import platform.Speech.SFSpeechRecognizerAuthorizationStatus
import platform.UIKit.UIApplication
import platform.UIKit.currentUserNotificationSettings
import platform.UIKit.isRegisteredForRemoteNotifications
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionProvisional
import platform.UserNotifications.UNAuthorizationOptionSound
import platform.UserNotifications.UNAuthorizationStatusAuthorized
import platform.UserNotifications.UNAuthorizationStatusNotDetermined
import platform.UserNotifications.UNUserNotificationCenter

actual class KmpPermissionsManager {
    actual companion object {
        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            KmpMainThread.runViaMainThread {
                when (permission) {
                    Permission.Speech -> {
                        SFSpeechRecognizer.requestAuthorization {
                            if (it == SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusAuthorized) {
                                runAction()
                            } else {
                                KmpLogging.writeErrorWithCode(ErrorCodes.RUNTIME_PERMISSION_NOT_GRANTED_REFUSED_BY_USER)
                            }
                        }
                    }

                    Permission.Camera -> {
                        AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) {
                            if (it) {
                                runAction()
                            } else {
                                KmpLogging.writeErrorWithCode(ErrorCodes.RUNTIME_PERMISSION_NOT_GRANTED_REFUSED_BY_USER)
                            }
                        }
                    }

                    Permission.PushNotifications -> {
                        val options =
                            UNAuthorizationOptionAlert or UNAuthorizationOptionSound or UNAuthorizationOptionBadge
                        UNUserNotificationCenter.currentNotificationCenter()
                            .requestAuthorizationWithOptions(
                                options.toULong()
                            ) { res, error ->
                                if (res) {
                                    runAction()
                                } else {
                                    KmpLogging.writeErrorWithCode(ErrorCodes.RUNTIME_PERMISSION_NOT_GRANTED_REFUSED_BY_USER)
                                }
                            }
                    }

                    Permission.Contacts -> {
                        CNContactStore().requestAccessForEntityType(CNEntityType.CNEntityTypeContacts) { result, error ->
                            if (result) {
                                runAction()
                            } else {
                                KmpLogging.writeErrorWithCode(ErrorCodes.RUNTIME_PERMISSION_NOT_GRANTED_REFUSED_BY_USER)
                            }
                        }
                    }

                    Permission.Microphone -> {
                        AVAudioSession.sharedInstance().requestRecordPermission {
                            if (it) {
                                runAction()
                            } else {
                                KmpLogging.writeErrorWithCode(ErrorCodes.RUNTIME_PERMISSION_NOT_GRANTED_REFUSED_BY_USER)
                            }
                        }
                    }

                    Permission.PhotoGallery -> {
                        PHPhotoLibrary.requestAuthorization {
                            when (it) {
                                PHAuthorizationStatusAuthorized -> runAction()
                                else -> KmpLogging.writeErrorWithCode(ErrorCodes.RUNTIME_PERMISSION_NOT_GRANTED_REFUSED_BY_USER)
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
            return when (permission) {
                Permission.Camera -> AVCaptureDevice.authorizationStatusForMediaType(
                    AVMediaTypeVideo
                ) == AVAuthorizationStatusAuthorized

                Permission.Speech -> SFSpeechRecognizer.authorizationStatus() == SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusAuthorized
                Permission.PhotoGallery -> PHPhotoLibrary.authorizationStatus() == PHAuthorizationStatusAuthorized
                Permission.Location -> CLLocationManager().authorizationStatus() == 3 || CLLocationManager().authorizationStatus() == 4
                Permission.PushNotifications -> UIApplication.sharedApplication()
                    .currentUserNotificationSettings() != null && UIApplication.sharedApplication()
                    .isRegisteredForRemoteNotifications()

                Permission.Microphone -> AVAudioSession.sharedInstance()
                    .recordPermission() == AVAudioSessionRecordPermissionGranted

                else -> false
            }
        }

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                if (permission == Permission.PushNotifications) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .getNotificationSettingsWithCompletionHandler {
                            actionResult(it?.alertSetting() == UNAuthorizationStatusAuthorized)
                        }
                } else {
                    actionResult(
                        when (permission) {
                            Permission.Camera -> AVCaptureDevice.authorizationStatusForMediaType(
                                AVMediaTypeVideo
                            ) == AVAuthorizationStatusAuthorized

                            Permission.Contacts -> CNContactStore.authorizationStatusForEntityType(
                                CNEntityType.CNEntityTypeContacts
                            ) == CNAuthorizationStatusAuthorized

                            Permission.Speech -> SFSpeechRecognizer.authorizationStatus() == SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusAuthorized
                            Permission.PhotoGallery -> PHPhotoLibrary.authorizationStatus() == PHAuthorizationStatusAuthorized
                            Permission.Location -> CLLocationManager().authorizationStatus() == 3 || CLLocationManager().authorizationStatus() == 4

                            Permission.Microphone -> AVAudioSession.sharedInstance()
                                .recordPermission() == AVAudioSessionRecordPermissionGranted

                            else -> false
                        }
                    )
                }
            }
        }

        actual fun canShowPromptDialog(permission: Permission, actionResult: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                if (permission == Permission.PushNotifications) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .getNotificationSettingsWithCompletionHandler {
                            actionResult(it?.alertSetting() == UNAuthorizationStatusNotDetermined)
                        }
                } else {
                    actionResult(
                        when (permission) {
                            Permission.Camera -> AVCaptureDevice.authorizationStatusForMediaType(
                                AVMediaTypeVideo
                            ) == AVAuthorizationStatusNotDetermined

                            Permission.Contacts -> CNContactStore.authorizationStatusForEntityType(
                                CNEntityType.CNEntityTypeContacts
                            ) == CNAuthorizationStatusNotDetermined

                            Permission.Speech -> SFSpeechRecognizer.authorizationStatus() == SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusNotDetermined
                            Permission.PhotoGallery -> PHPhotoLibrary.authorizationStatus() == PHAuthorizationStatusNotDetermined
                            Permission.Location -> CLLocationManager().authorizationStatus() == 0

                            Permission.Microphone -> AVAudioSession.sharedInstance()
                                .recordPermission() == AVAudioSessionRecordPermissionUndetermined

                            else -> false
                        }
                    )
                }
            }
        }
    }
}