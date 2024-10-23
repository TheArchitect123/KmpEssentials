package com.architect.kmpessentials.localNotifications

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNUserNotificationCenter

actual class KmpLocalNotifications {
    actual companion object {
        actual fun sendNotification(title: String, message: String) {

        }

        actual fun scheduleAlarmNotification(durationMS: Long, title: String, message: String) {

        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ) {

        }

        actual fun cancelAllRepeatingAlarms() {
        }
    }
}