package com.architect.kmpessentials.localNotifications.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications
import com.architect.kmpessentials.secureStorage.KmpPublicStorage

class LocalAlarmReceiver : BroadcastReceiver() {
    companion object {
       internal const val alarmReceiverFilter = "com.kmpessentials.action.filter"
    }

    private fun getAppLaunchIcon(context: Context): Int {
        return try {
            val packageManager = context.packageManager
            packageManager.getApplicationInfo(context.packageName, 0).icon
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            0
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == alarmReceiverFilter) {
            val title = intent.getStringExtra("title") ?: ""
            val message = intent.getStringExtra("message") ?: ""
            val icon = intent.getIntExtra("icon", getAppLaunchIcon(context))

            KmpPublicStorage.setCustomContext(context) // add backup context in case app context does not exist, or if the app is not running
            KmpLocalNotifications.setNotificationIcon(icon)
            KmpLocalNotifications.sendNotificationWithContext(title, message, context)
        }
    }
}