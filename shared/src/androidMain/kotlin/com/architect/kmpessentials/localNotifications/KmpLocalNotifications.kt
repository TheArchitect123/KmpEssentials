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
import com.architect.kmpessentials.backgrounding.KmpBackgrounding
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.localNotifications.models.AlarmSchedulers
import com.architect.kmpessentials.localNotifications.receivers.LocalAlarmReceiver
import com.architect.kmpessentials.secureStorage.KmpPublicStorage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlin.random.Random

actual class KmpLocalNotifications {
    actual companion object {
        private const val prefixNotif = "kmp_essentials_local_notifs_"
        private var repeatingAlarms =
            mutableListOf<Triple<String, PendingIntent, AlarmSchedulers>>()
        internal var notificationIcon: Int = 0
        private val standardChannel = "default"
        private val notificationChannelName = "Default"

        private val notifManager by lazy {
            KmpAndroid.applicationContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }

        // cleans up the local storage from any notifications keys no longer in use
        internal fun bootLoopTimerCheckForActiveNotifications() {
            KmpLauncher.startTimerRepeating(30.0) {
                KmpBackgrounding.createAndStartWorker {
                    val alarms = repeatingAlarms.toList()
                    alarms.forEach {
                        val notificationTriggered =
                            it.third.epochScheduled < System.currentTimeMillis()
                        if (notificationTriggered) {
                            cancelAlarmWithId(it.first)
                        }
                    }
                }

                true
            }
        }


        fun prepareStorageNotifications() {
            GlobalScope.launch {
                val customKeys = KmpPublicStorage.getAllKeys()
                val notificationKeys = customKeys.filter { it == prefixNotif }
                notificationKeys.forEach {
                    val notif = KmpPublicStorage.getStringFromKey(it)
                    if (!notif.isNullOrEmpty()) {
                        val intent = Json.decodeFromString(
                            AlarmSchedulers.serializer(),
                            notif
                        )

                        val alarmIntent = PendingIntent.getBroadcast(
                            KmpAndroid.applicationContext,
                            intent.resultCode,
                            Intent(
                                KmpAndroid.applicationContext,
                                LocalAlarmReceiver::class.java
                            ).apply {
                                putExtra("title", intent.title)
                                putExtra("message", intent.message)
                                putExtra("icon", intent.icon)
                                action = LocalAlarmReceiver.alarmReceiverFilter
                            },
                            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                        )

                        repeatingAlarms.add(
                            Triple(
                                intent.resultCode.toString(),
                                alarmIntent,
                                intent
                            )
                        )
                    }
                }
            }
        }

        fun setNotificationIcon(icon: Int) {
            notificationIcon = icon


            // icon id needs to be written into public storage
        }

        private var allowExact = true
        fun allowSetExact(allowExact: Boolean) {
            this.allowExact = allowExact
        }

        private var allowDozeMode = true
        fun allowDozeMode(allowDozeMode: Boolean) {
            this.allowDozeMode = allowDozeMode
        }

        internal fun getPendingIntentForAlarmBroadcasts(
            title: String,
            message: String,
            epochScheduled: Long
        ): Triple<String, PendingIntent, AlarmSchedulers> {
            // Create an intent to trigger LocalAlarmReceiver
            val intent =
                Intent(KmpAndroid.applicationContext, LocalAlarmReceiver::class.java).apply {
                    putExtra("title", title)
                    putExtra("message", message)
                    putExtra("icon", notificationIcon)
                    action = LocalAlarmReceiver.alarmReceiverFilter
                }


            val uniqueId = Random.nextInt()
            val storageIntent = AlarmSchedulers(
                uniqueId,
                title,
                message,
                notificationIcon,
                epochScheduled
            )
            val alarmIntent = PendingIntent.getBroadcast(
                KmpAndroid.applicationContext,
                uniqueId,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            KmpPublicStorage.persistData(
                "$prefixNotif$uniqueId", Json.encodeToJsonElement(
                    AlarmSchedulers.serializer(),
                    storageIntent
                ).toString()
            )

            val data = Triple(uniqueId.toString(), alarmIntent, storageIntent)
            repeatingAlarms.add(data)

            return data
        }

        internal fun notificationBuilder(title: String, message: String): Notification {
            val notification = NotificationCompat.Builder(
                KmpAndroid.applicationContext!!,
                standardChannel
            )
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText(message)
                .setSmallIcon(notificationIcon)

            return notification.build()
        }

        internal fun notificationBuilderWithContext(
            title: String,
            message: String,
            context: Context
        ): Notification {
            val notification = NotificationCompat.Builder(
                context,
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

        fun sendNotificationWithContext(title: String, message: String, context: Context) {
            if (notificationIcon == 0) {
                throw Exception("Notification Icon must be set. Please set via your Activities OnCreate method")
            }

            val notif =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    standardChannel,
                    notificationChannelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                notif.createNotificationChannel(channel)
            }

            notif.notify(Random.nextInt(), notificationBuilderWithContext(title, message, context))
        }


        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @SuppressLint("MissingPermission")
        actual fun scheduleAlarmNotification(
            durationMS: Long,
            title: String,
            message: String
        ): String {
            val relativeTimeMs = System.currentTimeMillis() + durationMS
            val intent = getPendingIntentForAlarmBroadcasts(title, message, relativeTimeMs)
            val alarmManager =
                (KmpAndroid.applicationContext?.getSystemService(Context.ALARM_SERVICE) as AlarmManager)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // allows notification to run regardless of Doze mode
                if (allowExact) {
                    if (allowDozeMode) {
                        alarmManager.setExactAndAllowWhileIdle(
                            AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                            relativeTimeMs,
                            intent.second
                        )
                    } else {
                        alarmManager.setExact(
                            AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                            relativeTimeMs,
                            intent.second
                        )
                    }
                } else alarmManager.set(
                    AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                    relativeTimeMs,
                    intent.second
                )
            } else {
                if (allowExact)
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                        relativeTimeMs,
                        intent.second
                    )
                else alarmManager.set(
                    AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                    relativeTimeMs,
                    intent.second
                )
            }

            return intent.first
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ): String {
            val relativeTimeMs = System.currentTimeMillis() + durationMS

            val repeatingAlarm = getPendingIntentForAlarmBroadcasts(title, message, relativeTimeMs)
            (KmpAndroid.applicationContext?.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setRepeating(
                AlarmManager.RTC_WAKEUP,  // Use RTC_WAKEUP to wake the device when the alarm triggers
                relativeTimeMs,
                intervalMs,
                repeatingAlarm.second
            )

            return repeatingAlarm.first
        }

        actual fun cancelAllAlarms() {
            repeatingAlarms.forEach {
                it.second.cancel()
                KmpPublicStorage.deleteDataForKey(it.first)
            }

            repeatingAlarms.clear()
        }

        actual fun cancelAlarmWithId(alarmId: String) {
            val alarm =
                repeatingAlarms.singleOrNull { it.first.replace(prefixNotif, "") == alarmId }
            if (alarm != null) {
                alarm.second.cancel()
                KmpPublicStorage.deleteDataForKey(alarmId)
                repeatingAlarms.remove(alarm)
            }
        }

        actual fun isSchedulingAlarmWithId(alarmId: String): Boolean {
            return repeatingAlarms.singleOrNull {
                it.first.replace(
                    prefixNotif,
                    ""
                ) == alarmId
            } != null
        }
    }
}