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
        fun scheduleAlarmNotification(durationMS: Long, title: String, message: String) : String

        /**
         * Schedules a repeating alarm, and broadcasts a local notification with the specified Title & Message, after duration in milliseconds has passed
         * @param durationMS milliseconds until the local notification is triggered, and will repeat after every intervalMs set
         * @param intervalMs the interval in milliseconds between repeats
         * */
        fun scheduleAlarmNotificationRepeating(durationMS: Long, intervalMs: Long, title: String, message: String) : String

        /**
         * Discards all repeating alarms (if any)
         * */
        fun cancelAllRepeatingAlarms()

        /**
         * Discards an alarm with a specific Id
         * */
        fun cancelAlarmWithId(alarmId: String)

        /**
         * Checks to see if a notification with the alarmId is currently scheduled for running on the device (locally)
         * */
        fun isSchedulingAlarmWithId(alarmId: String) : Boolean
    }
}