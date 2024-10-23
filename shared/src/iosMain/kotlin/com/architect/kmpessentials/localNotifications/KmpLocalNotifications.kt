package com.architect.kmpessentials.localNotifications

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNNotificationSound
import platform.UserNotifications.UNUserNotificationCenter

actual class KmpLocalNotifications {
    actual companion object {
        actual fun sendNotification(title: String, message: String) {
            KmpMainThread.runViaMainThread {
                val localNotifications = UNMutableNotificationContent()
                localNotifications.setTitle(title)
                localNotifications.setBody(message)
                localNotifications.setSound(UNNotificationSound.defaultSound)

                val request =
                    UNNotificationRequest.requestWithIdentifier(
                        "defaultNotification",
                        localNotifications,
                        null
                    )

                UNUserNotificationCenter.currentNotificationCenter()
                    .addNotificationRequest(request) {

                    }
            }
        }

        actual fun scheduleAlarmNotification(durationMS: Long, title: String, message: String){

        }
    }
}