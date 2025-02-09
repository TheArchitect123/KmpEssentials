package com.architect.kmpessentials.localNotifications

import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.mainThread.KmpMainThread
import java.awt.Image
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

actual class KmpLocalNotifications {
    actual companion object {
        private val scheduler = Executors.newScheduledThreadPool(1)
        private val scheduledAlarms = mutableMapOf<String, ScheduledFuture<*>>()

        actual fun sendNotification(title: String, message: String) {
            KmpMainThread.runViaMainThread {
                if (!SystemTray.isSupported()) {
                    KmpLogging.writeError(
                        "KMP_ESSENTIALS_LOCAL_NOTIFICATIONS",
                        "SystemTray is not supported on this platform."
                    )
                } else {
                    try {
                        // Create a system tray icon
                        val tray = SystemTray.getSystemTray()
                        val image: Image = Toolkit.getDefaultToolkit()
                            .createImage("icon.png")  // need a custom icon that users can specify

                        val trayIcon = TrayIcon(image, title)
                        trayIcon.isImageAutoSize = true
                        trayIcon.toolTip = title
                        tray.add(trayIcon)

                        // Display notification
                        trayIcon.displayMessage(
                            title,
                            message,
                            TrayIcon.MessageType.INFO
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }

        actual fun scheduleAlarmNotification(
            durationMS: Long,
            title: String,
            message: String
        ): String {
            val alarmId = System.currentTimeMillis().toString() // Generate a unique ID
            val task = scheduler.schedule(
                { sendNotification(title, message) },
                durationMS, TimeUnit.MILLISECONDS
            )

            scheduledAlarms[alarmId] = task
            return alarmId
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ): String {
            val alarmId = System.currentTimeMillis().toString() // Unique ID
            val task = scheduler.scheduleAtFixedRate(
                { sendNotification(title, message) },
                durationMS, intervalMs, TimeUnit.MILLISECONDS
            )

            scheduledAlarms[alarmId] = task
            return alarmId
        }

        actual fun cancelAllAlarms() {
            scheduledAlarms.values.forEach { it.cancel(true) }
            scheduledAlarms.clear()
        }

        actual fun cancelAlarmWithId(alarmId: String) {
            scheduledAlarms[alarmId]?.cancel(true)
            scheduledAlarms.remove(alarmId)
        }

        actual fun isSchedulingAlarmWithId(alarmId: String): Boolean {
            return scheduledAlarms[alarmId]?.isCancelled == false
        }

    }
}