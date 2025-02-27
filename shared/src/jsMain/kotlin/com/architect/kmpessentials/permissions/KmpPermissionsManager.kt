package com.architect.kmpessentials.permissions

import com.architect.kmpessentials.geolocation.KmpGeolocation
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionNoParams
import com.architect.kmpessentials.internal.ActionPermissionStatusParams
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.w3c.dom.clipboard.Clipboard
import org.w3c.notifications.GRANTED
import org.w3c.notifications.Notification
import org.w3c.notifications.NotificationPermission

enum class KmpWebPermission(val value: String) {
    GEOLOCATION("geolocation"),
    MICROPHONE("microphone"),
    CAMERA("camera"),
    NOTIFICATIONS("notifications"),
    CLIPBOARD_READ("clipboard-read"),
    CLIPBOARD_WRITE("clipboard-write"),
    PUSH("push"),
    MAGNETOMETER("magnetometer"),
    ACCELEROMETER("accelerometer"),
    GYROSCOPE("gyroscope");

    companion object {
        fun fromValue(value: String): KmpWebPermission? {
            return values().find { it.value == value }
        }
    }
}

actual class KmpPermissionsManager {
    actual companion object {

        private fun checkPermission(permissionType: String, callback: (PermissionStatus) -> Unit) {
            val permissions = window.navigator.asDynamic().permissions
            if (permissions != undefined) {
                permissions.query(js("{ name: 'permissionType' }")).then { result ->
                    callback(
                        when (result.asDynamic().state as String) {
                            "granted" -> PermissionStatus.Granted
                            "prompt" -> PermissionStatus.NotDetermined
                            else -> PermissionStatus.Denied
                        }
                    )
                }
            } else {
                console.log("Permissions API not supported.")
                callback(PermissionStatus.Denied)
            }
        }

        actual fun requestPermission(
            permission: Permission,
            runAction: ActionNoParams
        ) {
            when (permission) {
                Permission.Camera -> {
                    val constraints = js("{ video: true, audio: true }")
                    window.navigator.asDynamic().mediaDevices.getUserMedia(constraints)
                        .then { stream ->
                            console.log("Camera and Microphone Access Granted")
                            runAction()
                        }
                        .catch { error ->
                            console.log("Error Accessing Camera/Microphone: ${error.message}")
                        }
                }

                Permission.PushNotifications -> {
                    Notification.requestPermission().then {
                        if (it == NotificationPermission.GRANTED) {
                            runAction()
                        }
                    }
                }

                Permission.Microphone, Permission.Speech -> {
                    val constraints = js("{ audio: true }")
                    window.navigator.asDynamic().mediaDevices.getUserMedia(constraints)
                        .then { stream ->
                            console.log("Microphone Access Granted")
                            runAction()
                        }
                        .catch { error ->
                            console.log("Error Accessing Microphone: ${error.message}")
                        }
                }

                Permission.Location -> {
                    KmpGeolocation.getCurrentLocation {
                        runAction()
                    }
                }

                Permission.Clipboard -> {
                    GlobalScope.launch {
                        val permissions = window.navigator.asDynamic().permissions
                        val readPermission =
                            permissions.query(KmpWebPermission.CLIPBOARD_READ.value).await()
                        val writePermission =
                            permissions.query(KmpWebPermission.CLIPBOARD_WRITE.value).await()

                        if (writePermission != null && readPermission != null) {
                            checkPermission(KmpWebPermission.CLIPBOARD_WRITE.value) {
                                if (it == PermissionStatus.Granted) {
                                    checkPermission(KmpWebPermission.CLIPBOARD_READ.value) { read ->
                                        if (read == PermissionStatus.Granted) {
                                            runAction()
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Permission.Magnetometer -> {
                    activateSensorPermission(KmpWebPermission.MAGNETOMETER.value, runAction)
                }

                Permission.Accelerometer -> {
                    activateSensorPermission(KmpWebPermission.ACCELEROMETER.value, runAction)
                }

                Permission.Gyroscope -> {
                    activateSensorPermission(KmpWebPermission.GYROSCOPE.value, runAction)
                }

                else -> {

                }
            }
        }

        private fun activateSensorPermission(permission: String, action: ActionNoParams) {
            val permissions = window.navigator.asDynamic().permissions
            if (permissions != undefined) {
                val cresult = js("{ }")
                cresult.asDynamic().name = permission
                permissions.query(cresult).then { result ->
                    action()
                }
            } else {
                console.log("Permissions API not supported.")
            }
        }

        actual fun getCurrentPermissionState(
            permission: Permission,
            actionResult: ActionPermissionStatusParams
        ) {
            if (permission == Permission.PushNotifications) {
                checkPermission(KmpWebPermission.PUSH.value) {
                    actionResult(it)
                }
            }
            if (permission == Permission.Camera) {
                checkPermission(KmpWebPermission.CAMERA.value) {
                    actionResult(it)
                }
            }

            if (permission == Permission.Contacts) {
                val isAvailable = window.navigator.asDynamic().contacts != undefined
                if (isAvailable) actionResult(PermissionStatus.Granted) else actionResult(
                    PermissionStatus.Denied
                )
            }

            if (permission == Permission.Speech || permission == Permission.Microphone) {
                checkPermission(KmpWebPermission.MICROPHONE.value) {
                    actionResult(it)
                }
            }
            if (permission == Permission.PhotoGallery) {
                actionResult(PermissionStatus.Granted)
            }
            if (permission == Permission.Location) {
                checkPermission(KmpWebPermission.GEOLOCATION.value) {
                    actionResult(it)
                }
            }
        }

        // DEPRECATED API
        actual fun isPermissionGranted(permission: Permission): Boolean {
            return false
        }

        actual fun isPermissionGranted(permission: Permission, actionResult: ActionBoolParams) {
            getCurrentPermissionState(permission) {
                actionResult(it == PermissionStatus.Granted)
            }
        }

        actual fun canShowPromptDialog(permission: Permission, actionResult: ActionBoolParams) {
            actionResult(true)
        }
    }
}