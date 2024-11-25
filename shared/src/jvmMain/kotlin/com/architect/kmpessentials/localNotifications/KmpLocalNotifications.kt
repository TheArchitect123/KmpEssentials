package com.architect.kmpessentials.localNotifications

import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.mainThread.KmpMainThread
import java.awt.Image
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon

actual class KmpLocalNotifications {
    actual companion object {
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

                        val trayIcon = TrayIcon(image, "App Name")
                        trayIcon.isImageAutoSize = true
                        trayIcon.toolTip = "App Name"
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
            return ""
        }

        actual fun scheduleAlarmNotificationRepeating(
            durationMS: Long,
            intervalMs: Long,
            title: String,
            message: String
        ): String {
            return ""
        }

        actual fun cancelAllAlarms() {

        }

        actual fun cancelAlarmWithId(alarmId: String) {

        }

        actual fun isSchedulingAlarmWithId(alarmId: String): Boolean {
            TODO("Not yet implemented")
        }

    }
}