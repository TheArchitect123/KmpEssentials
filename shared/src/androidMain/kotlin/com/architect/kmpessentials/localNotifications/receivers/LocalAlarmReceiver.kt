package com.architect.kmpessentials.localNotifications.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications

class LocalAlarmReceiver : BroadcastReceiver() {
    companion object{
        const val alarmReceiverFilter = "com.kmpessentials.action.filter"
    }
    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("title") ?: ""
        val message = intent.getStringExtra("message") ?: ""

        // Create the notification
        KmpLocalNotifications.sendNotification(title, message)
    }
}