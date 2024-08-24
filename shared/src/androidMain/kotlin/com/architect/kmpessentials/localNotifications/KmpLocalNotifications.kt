package com.architect.kmpessentials.localNotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.architect.kmpessentials.KmpAndroid

actual class KmpLocalNotifications {
    actual companion object {
        private var notificationIcon: Int = 0
        private val standardChannel = "default"
        private val notificationChannelName = "Default"

        fun setNotificationIcon(icon: Int) {
            notificationIcon = icon
        }

        actual fun sendNotification(title: String, message: String) {
            if (notificationIcon == 0) {
                throw Exception("Notification Icon must be set. Please set via your Activities OnCreate method")
            }

            val notifManager =
                KmpAndroid.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    standardChannel,
                    notificationChannelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                notifManager.createNotificationChannel(channel)
            }

            val notification = NotificationCompat.Builder(
                KmpAndroid.applicationContext,
                standardChannel
            )
                .setContentTitle(title).setContentText(message)
                .setSmallIcon(notificationIcon)

            notifManager.notify(1, notification.build())
        }
    }
}