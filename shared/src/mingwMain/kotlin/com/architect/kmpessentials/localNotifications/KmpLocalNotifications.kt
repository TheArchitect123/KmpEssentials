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

        actual fun cancelAllAlarms() {
        }

        actual fun cancelAlarmWithId(alarmId: String) {

        }

        actual fun isSchedulingAlarmWithId(alarmId: String): Boolean {
            TODO("Not yet implemented")
        }
    }
}