package com.architect.kmpessentials.localNotifications


actual class KmpLocalNotifications {
    actual companion object {
        actual fun sendNotification(title: String, message: String) {

        }

        actual fun scheduleAlarmNotification(
            durationMS: Long,
            title: String,
            message: String
        ): String {
            return ""
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ): String {
            return ""
        }

        actual fun cancelAllRepeatingAlarms() {
        }

        actual fun cancelAlarmWithId(alarmId: String) {

        }
    }
}