package com.architect.kmpessentials.localNotifications

import kotlinx.browser.window
import org.w3c.notifications.GRANTED
import org.w3c.notifications.Notification
import org.w3c.notifications.NotificationOptions
import org.w3c.notifications.NotificationPermission

actual class KmpLocalNotifications {
    actual companion object {
        // alarm Ids need to be stored inside the browsers cookies
        val localAlarmIds = mutableListOf<String>()
        actual fun sendNotification(title: String, message: String) {
            if (Notification.permission == NotificationPermission.GRANTED) {
                Notification(
                    title, NotificationOptions(
                        body = message,
                    )
                )
            }
        }

        actual fun scheduleAlarmNotification(
            durationMS: Long,
            title: String,
            message: String
        ): String {
            val notificationId = "alarm_${window.performance.now().toInt()}"
            window.setTimeout({
                if (Notification.permission == NotificationPermission.GRANTED) {
                    Notification(title, NotificationOptions(body = message))
                } else {
                    println("Notification permission not granted.")
                }
            }, durationMS.toInt()) // Delay in milliseconds

            return notificationId
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ): String {
            return ""
        }

        actual fun cancelAllAlarms() {
        }

        actual fun cancelAlarmWithId(alarmId: String) {

        }

        actual fun isSchedulingAlarmWithId(alarmId: String): Boolean {
            TODO("Not yet implemented")
        }
    }
}