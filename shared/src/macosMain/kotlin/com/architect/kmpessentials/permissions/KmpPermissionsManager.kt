package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionPermissionStatusParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.delegates.LocationPermissionsDelegate
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.AppKit.NSApplication
import platform.AppKit.isRegisteredForRemoteNotifications
import platform.CoreLocation.CLLocationManager
import platform.Photos.PHAuthorizationStatusAuthorized
import platform.Photos.PHPhotoLibrary
import platform.Speech.SFSpeechRecognizer
import platform.Speech.SFSpeechRecognizerAuthorizationStatus
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionProvisional
import platform.UserNotifications.UNNotificationSettingDisabled
import platform.UserNotifications.UNNotificationSettingEnabled
import platform.UserNotifications.UNNotificationSettingNotSupported
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
                            }
                        }
                    }

                    Permission.Camera -> {
                        AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) {
                            runAction()
                        }
                    }

                    Permission.PushNotifications -> {
                        UNUserNotificationCenter.currentNotificationCenter()
                            .requestAuthorizationWithOptions(
                                UNAuthorizationOptionAlert or
                                        UNAuthorizationOptionBadge or
                                        UNAuthorizationOptionProvisional,
                            ) { res, error ->
                                if (res) {
                                    runAction()
                                }
                            }
                    }

                    Permission.Microphone -> {
//                        AVAudioSession.sharedInstance().requestRecordPermission {
//                            if (it) {
//                                runAction()
//                            }
//                        }
                    }

                    Permission.PhotoGallery -> {
                        PHPhotoLibrary.requestAuthorization {
                            when (it) {
                                PHAuthorizationStatusAuthorized -> runAction()
                                else -> print("Permission has not been enabled")
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

        actual fun getCurrentPermissionState(permission: Permission, actionResult: ActionPermissionStatusParams){
            KmpMainThread.runViaMainThread {
                if (permission == Permission.PushNotifications) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .getNotificationSettingsWithCompletionHandler {
                            actionResult(when(it?.alertSetting()){
                                UNNotificationSettingEnabled -> PermissionStatus.Granted
                                UNNotificationSettingDisabled -> PermissionStatus.Denied
                                else -> PermissionStatus.NotDetermined
                            })
                        }
                } else {

                        when (permission) {
                            Permission.Camera -> AVCaptureDevice.authorizationStatusForMediaType(
                                AVMediaTypeVideo
                            ) == AVAuthorizationStatusAuthorized

                            Permission.Speech -> SFSpeechRecognizer.authorizationStatus() == SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusAuthorized
                            Permission.PhotoGallery -> PHPhotoLibrary.authorizationStatus() == PHAuthorizationStatusAuthorized
                            Permission.Location -> CLLocationManager().authorizationStatus() == 3 || CLLocationManager().authorizationStatus() == 4

//                            Permission.Microphone -> AVAudioSession.sharedInstance()
//                                .recordPermission() == AVAudioSessionRecordPermissionGranted

                            else -> false
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
                Permission.PushNotifications -> NSApplication.sharedApplication()
                    .isRegisteredForRemoteNotifications()

//                Permission.Microphone -> AVAudioSession.sharedInstance()
//                    .recordPermission() == AVAudioSessionRecordPermissionGranted

                else -> false
            }
        }

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                if (permission == Permission.PushNotifications) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .getNotificationSettingsWithCompletionHandler {
                            actionResult(it?.alertSetting() == UNNotificationSettingEnabled)
                        }
                } else {
                    actionResult(
                        when (permission) {
                            Permission.Camera -> AVCaptureDevice.authorizationStatusForMediaType(
                                AVMediaTypeVideo
                            ) == AVAuthorizationStatusAuthorized

                            Permission.Speech -> SFSpeechRecognizer.authorizationStatus() == SFSpeechRecognizerAuthorizationStatus.SFSpeechRecognizerAuthorizationStatusAuthorized
                            Permission.PhotoGallery -> PHPhotoLibrary.authorizationStatus() == PHAuthorizationStatusAuthorized
                            Permission.Location -> CLLocationManager().authorizationStatus() == 3 || CLLocationManager().authorizationStatus() == 4

//                            Permission.Microphone -> AVAudioSession.sharedInstance()
//                                .recordPermission() == AVAudioSessionRecordPermissionGranted

                            else -> false
                        }
                    )
                }
            }
        }

        actual fun canShowPromptDialog(permission: Permission, actionResult: ActionBoolParams) {

        }
    }
}