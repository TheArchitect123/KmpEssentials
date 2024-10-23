package com.architect.kmpessentials.localNotifications

expect class KmpLocalNotifications {
    companion object{
        /**
         * Broadcasts a local notification with the specified Title & Message
         * */
        fun sendNotification(title: String, message: String)

        /**
         * Schedules an alarm, and broadcasts a local notification with the specified Title & Message, after duration in milliseconds has passed
         * @param durationMS milliseconds until the local notification is triggered
         * */
        fun scheduleAlarmNotification(durationMS: Long, title: String, message: String)
    }
}