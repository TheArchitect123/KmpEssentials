package com.architect.kmpessentials.localNotifications

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.localNotifications.receivers.LocalAlarmReceiver
import kotlin.random.Random

actual class KmpLocalNotifications {
    actual companion object {
        private var repeatingAlarms = mutableListOf<PendingIntent>()
        private var notificationIcon: Int = 0
        private val standardChannel = "default"
        private val notificationChannelName = "Default"
        private val notifManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }

        fun setNotificationIcon(icon: Int) {
            notificationIcon = icon
        }

        internal fun getPendingIntentForAlarmBroadcasts(
            title: String,
            message: String
        ): PendingIntent {
            // Create an intent to trigger LocalAlarmReceiver
            val intent =
                Intent(KmpAndroid.applicationContext, LocalAlarmReceiver::class.java).apply {
                    putExtra("title", title)
                    putExtra("message", message)
                }

            return PendingIntent.getBroadcast(
                KmpAndroid.applicationContext,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }

        internal fun notificationBuilder(title: String, message: String): Notification {
            val notification = NotificationCompat.Builder(
                KmpAndroid.applicationContext,
                standardChannel
            )
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText(message)
                .setSmallIcon(notificationIcon)

            return notification.build()
        }

        actual fun sendNotification(title: String, message: String) {
            if (notificationIcon == 0) {
                throw Exception("Notification Icon must be set. Please set via your Activities OnCreate method")
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    standardChannel,
                    notificationChannelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                notifManager.createNotificationChannel(channel)
            }

            notifManager.notify(Random.nextInt(), notificationBuilder(title, message))
        }


        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @SuppressLint("MissingPermission")
        actual fun scheduleAlarmNotification(durationMS: Long, title: String, message: String) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // allows notification to run regardless of Doze mode
                (KmpAndroid.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                    durationMS,
                    getPendingIntentForAlarmBroadcasts(title, message)
                )
            } else {
                (KmpAndroid.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setExact(
                    AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                    durationMS,
                    getPendingIntentForAlarmBroadcasts(title, message)
                )
            }
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ) {
            val repeatingAlarm = getPendingIntentForAlarmBroadcasts(title, message)
            repeatingAlarms.add(repeatingAlarm)

            (KmpAndroid.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setRepeating(
                AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                durationMS,
                intervalMs,
                repeatingAlarm
            )
        }

        actual fun cancelAllRepeatingAlarms() {
            repeatingAlarms.forEach {
                it.cancel()
            }

            repeatingAlarms.clear()
        }
    }
}