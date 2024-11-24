package com.architect.kmpessentials.localNotifications

import com.architect.kmpessentials.fileSystem.KmpFileSystem
import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNNotificationSound
import platform.UserNotifications.UNUserNotificationCenter
import platform.UserNotifications.*
import platform.Foundation.*
import kotlin.random.Random

actual class KmpLocalNotifications {
    actual companion object {
        private const val scheduledIds = "LocalNotifs"
        actual fun sendNotification(title: String, message: String) {
            KmpMainThread.runViaMainThread {
                val localNotifications = UNMutableNotificationContent()
                localNotifications.setTitle(title)
                localNotifications.setBody(message)
                localNotifications.setSound(UNNotificationSound.defaultSound)

                val request =
                    UNNotificationRequest.requestWithIdentifier(
                        "defaultNotification",
                        localNotifications,
                        null
                    )

                UNUserNotificationCenter.currentNotificationCenter()
                    .addNotificationRequest(request) {

                    }
            }
        }

        private fun broadcastScheduleNotification(
            durationMS: Long,
            title: String,
            message: String,
            repeats: Boolean = false
        ): String {
            // Create notification content
            val content = UNMutableNotificationContent().apply {
                setTitle(title)
                setBody(message)
                setSound(UNNotificationSound.defaultSound)
            }

            // Set up a time-based trigger for the notification
            val trigger =
                UNTimeIntervalNotificationTrigger.triggerWithTimeInterval(
                    timeInterval = (durationMS / 1000).toDouble(),
                    repeats = repeats
                )


            val uniqueId = "random_notification_id_${Random.nextInt()}_${
                Clock.System.now().toEpochMilliseconds()
            }" // store in prefernces in case users need to cancel it

            GlobalScope.launch {
                try {
                    val uniqueLocalNotifs = NSURL.fileURLWithPath(
                        KmpFileSystem.createDirectNameAtAppStorage(scheduledIds)
                    ).URLByAppendingPathComponent("$uniqueId.txt")?.absoluteURL
                    KmpFileSystem.writeTextToFileAt(
                        uniqueLocalNotifs?.absoluteString ?: "", uniqueId
                    )
                } catch (ex: Exception) {

                }
            }

            // Create a request with a unique identifier
            val request = UNNotificationRequest.requestWithIdentifier(
                uniqueId, // unique identifier
                content = content,
                trigger = trigger
            )

            // Schedule the notification
            UNUserNotificationCenter.currentNotificationCenter()
                .addNotificationRequest(request) { error ->
                    if (error != null) {
                        println("Error scheduling notification: $error")
                    } else {
                        println("Notification scheduled successfully!")
                    }
                }

            return uniqueId
        }

        actual fun scheduleAlarmNotification(
            durationMS: Long,
            title: String,
            message: String
        ): String {
            return broadcastScheduleNotification(durationMS, title, message)
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ): String {
            return broadcastScheduleNotification(durationMS, title, message, true)
        }

        actual fun cancelAlarmWithId(alarmId: String) {
            GlobalScope.launch {
                val allLocalIds = KmpFileSystem.getAllFilePathsFromDirectoryPath(scheduledIds)
                val ids =
                    allLocalIds.singleOrNull { alarmId == KmpFileSystem.readTextFromFileAt(it) }
                if (ids != null) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .removePendingNotificationRequestsWithIdentifiers(listOf(ids))

                    KmpFileSystem.deleteFileAt(ids)
                }
            }
        }

        actual fun cancelAllRepeatingAlarms() {
            GlobalScope.launch {
                val allLocalIds = KmpFileSystem.getAllFilePathsFromDirectoryPath(scheduledIds)
                val ids = allLocalIds.mapNotNull { KmpFileSystem.readTextFromFileAt(it) }
                if (ids.isNotEmpty()) {
                    UNUserNotificationCenter.currentNotificationCenter()
                        .removePendingNotificationRequestsWithIdentifiers(ids)
                }

                // wipe all the files after canceling the notifications
                allLocalIds.forEach {
                    KmpFileSystem.deleteFileAt(it)
                }
            }
        }

        actual fun isSchedulingAlarmWithId(alarmId: String) : Boolean{
            val allLocalIds = KmpFileSystem.getAllFilePathsFromDirectoryPath(scheduledIds)
            val ids = allLocalIds.mapNotNull { KmpFileSystem.readTextFromFileAt(it) }
            return ids.any { it == alarmId }
        }
    }
}