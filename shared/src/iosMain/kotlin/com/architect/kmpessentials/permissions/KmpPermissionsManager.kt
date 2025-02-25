package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionPermissionStatusParams
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.delegates.LocationPermissionsDelegate
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionRecordPermissionDenied
import platform.AVFAudio.AVAudioSessionRecordPermissionGranted
import platform.AVFAudio.AVAudioSessionRecordPermissionUndetermined
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusDenied
import platform.AVFoundation.AVAuthorizationStatusNotDetermined
import platform.AVFoundation.AVAuthorizationStatusRestricted
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.Contacts.CNAuthorizationStatusAuthorized
import platform.Contacts.CNAuthorizationStatusDenied
import platform.Contacts.CNAuthorizationStatusNotDetermined
import platform.Contacts.CNAuthorizationStatusRestricted
import platform.Contacts.CNContactStore
import platform.Contacts.CNEntityType
import platform.CoreLocation.CLAuthorizationStatus
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.kCLAuthorizationStatusAuthorizedAlways
import platform.CoreLocation.kCLAuthorizationStatusAuthorizedWhenInUse
import platform.CoreLocation.kCLAuthorizationStatusDenied
import platform.CoreLocation.kCLAuthorizationStatusNotDetermined
import platform.CoreLocation.kCLAuthorizationStatusRestricted
import platform.Photos.PHAuthorizationStatusAuthorized
import platform.Photos.PHAuthorizationStatusDenied
import platform.Photos.PHAuthorizationStatusNotDetermined
import platform.Photos.PHAuthorizationStatusRestricted
import platform.Photos.PHPhotoLibrary
import platform.Speech.SFSpeechRecognizer
import platform.Speech.SFSpeechRecognizerAuthorizationStatus
import platform.UIKit.UIApplication
import platform.UIKit.currentUserNotificationSettings
import platform.UIKit.isRegisteredForRemoteNotifications
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionSound
import platform.UserNotifications.UNAuthorizationStatusAuthorized
import platform.UserNotifications.UNAuthorizationStatusDenied
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

        actual fun getCurrentPermissionState(
            permission: Permission,
            actionResult: ActionPermissionStatusParams
        ) {
            KmpMainThread.runViaMainThread {
                if (permission == Permission.PushNotifications) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .getNotificationSettingsWithCompletionHandler {
                            val response = when (it?.alertSetting()) {
                                UNAuthorizationStatusAuthorized -> PermissionStatus.Granted
                                UNAuthorizationStatusDenied -> PermissionStatus.Denied
                                else -> PermissionStatus.NotDetermined
                            }

                            actionResult(response)
                        }
                } else {
                    if (permission == Permission.Camera) {
                        actionResult(
                            when (AVCaptureDevice.authorizationStatusForMediaType(
                                AVMediaTypeVideo
                            )) {
                                AVAuthorizationStatusAuthorized -> PermissionStatus.Granted
                                AVAuthorizationStatusDenied -> PermissionStatus.Denied
                                AVAuthorizationStatusRestricted -> PermissionStatus.DeniedAlways
                                else -> PermissionStatus.NotDetermined
                            }
                        )
                    }

                    if (permission == Permission.Contacts) {
                        actionResult(
                            when (CNContactStore.authorizationStatusForEntityType(
                                CNEntityType.CNEntityTypeContacts
                            )) {
                                CNAuthorizationStatusAuthorized -> PermissionStatus.Granted
                                CNAuthorizationStatusDenied -> PermissionStatus.Denied
                                CNAuthorizationStatusRestricted -> PermissionStatus.DeniedAlways
                                else -> PermissionStatus.NotDetermined
                            }
                        )
                    }
                    if (permission == Permission.Speech) {
                        actionResult(
                            when (SFSpeechRecognizer.authorizationStatus()) {
                                SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusAuthorized -> PermissionStatus.Granted
                                SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusDenied -> PermissionStatus.Denied
                                SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusRestricted -> PermissionStatus.DeniedAlways
                                else -> PermissionStatus.NotDetermined
                            }
                        )
                    }
                    if (permission == Permission.PhotoGallery) {
                        actionResult(
                            when (PHPhotoLibrary.authorizationStatus()) {
                                PHAuthorizationStatusAuthorized -> PermissionStatus.Granted
                                PHAuthorizationStatusDenied -> PermissionStatus.Denied
                                PHAuthorizationStatusRestricted -> PermissionStatus.DeniedAlways
                                else -> PermissionStatus.NotDetermined
                            }
                        )
                    }
                    if (permission == Permission.Location) {

                        actionResult(
                            when (CLLocationManager.authorizationStatus()) {
                                kCLAuthorizationStatusRestricted -> PermissionStatus.DeniedAlways
                                kCLAuthorizationStatusDenied -> PermissionStatus.Denied
                                kCLAuthorizationStatusAuthorizedAlways, kCLAuthorizationStatusAuthorizedWhenInUse -> PermissionStatus.Granted
                                else -> PermissionStatus.NotDetermined
                            }
                        )
                    }

                    if (permission == Permission.Microphone) {
                        actionResult(
                            when (AVAudioSession.sharedInstance()
                                .recordPermission()) {
                                AVAudioSessionRecordPermissionGranted -> PermissionStatus.Granted
                                AVAudioSessionRecordPermissionDenied -> PermissionStatus.Denied
                                else -> PermissionStatus.NotDetermined
                            }
                        )
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
                Permission.Location -> CLLocationManager().authorizationStatus() == kCLAuthorizationStatusAuthorizedWhenInUse || CLLocationManager().authorizationStatus() == kCLAuthorizationStatusAuthorizedAlways
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
                            Permission.Location -> CLLocationManager().authorizationStatus() == kCLAuthorizationStatusAuthorizedWhenInUse || CLLocationManager().authorizationStatus() == kCLAuthorizationStatusAuthorizedAlways

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
                            Permission.Location -> CLLocationManager().authorizationStatus() == kCLAuthorizationStatusNotDetermined
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