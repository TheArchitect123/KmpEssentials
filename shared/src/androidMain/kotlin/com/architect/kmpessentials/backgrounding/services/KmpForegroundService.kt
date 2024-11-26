package com.architect.kmpessentials.backgrounding.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class KmpForegroundService : Service() {
    companion object {
        const val CHANNEL_ID = "KmpForegroundServiceChannelId"
        const val TITLE_NOTIFICATION = "TITLE_NOTIFICATION"
        const val MESSAGE_NOTIFICATION = "MESSAGE_NOTIFICATION"
        var actionToInvoke: DefaultActionAsync? = null
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = actionToInvoke
        val title = intent?.getStringExtra(TITLE_NOTIFICATION)
        val message = intent?.getStringExtra(MESSAGE_NOTIFICATION)

        val notification = createNotification(title, message)

        startForeground(KmpLocalNotifications.notificationIcon, notification)

        // Perform the task in a coroutine
        serviceScope.launch {
            action?.invoke()
            stopSelf() // Stop the service when the task is done
        }

        // Keep the service running until explicitly stopped
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel() // Cancel ongoing tasks when the service is destroyed
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // This is not a bound service
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(title: String?, message: String?): Notification {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .build()
        } else {
            Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .build()
        }
    }
}