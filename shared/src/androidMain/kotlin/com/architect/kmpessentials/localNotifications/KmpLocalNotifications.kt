package com.architect.kmpessentials.localNotifications

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.localNotifications.receivers.LocalAlarmReceiver
import kotlin.random.Random

actual class KmpLocalNotifications {
    actual companion object {
        private var notificationIcon: Int = 0
        private val standardChannel = "default"
        private val notificationChannelName = "Default"
        private val notifManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }

        fun setNotificationIcon(icon: Int) {
            notificationIcon = icon
        }

        fun notificationBuilder(title: String, message: String): Notification {
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

        @SuppressLint("MissingPermission")
        @RequiresApi(Build.VERSION_CODES.KITKAT)
        actual fun scheduleAlarmNotification(durationMS: Long, title: String, message: String) {
            // Create an intent to trigger LocalAlarmReceiver
            val intent =
                Intent(KmpAndroid.applicationContext, LocalAlarmReceiver::class.java).apply {
                    putExtra("title", title)
                    putExtra("message", message)
                }


            val pendingIntent = PendingIntent.getBroadcast(
                KmpAndroid.applicationContext,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // Schedule the alarm
            (KmpAndroid.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setExact(
                AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                durationMS,
                pendingIntent
            )
        }
    }
}