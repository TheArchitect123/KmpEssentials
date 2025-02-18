import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.backgrounding.extensions.intArrayToByteArray
import com.architect.kmpessentials.logging.KmpLogging
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.*
import platform.UserNotifications.*
import platform.MediaPlayer.MPNowPlayingInfoCenter

class KmpForegroundService {
    companion object {
        private var currentTask: DefaultActionAsync? = null
        private val isTaskRunning = atomic(false)
        private val silentAudioService = SilentAudioService() // 🔊 Silent Audio Player

        fun startNotificationService(title: String, message: String, action: DefaultActionAsync) {
            if (!isTaskRunning.compareAndSet(expect = false, update = true)) {
                KmpLogging.writeError(
                    "KMP_MEDIA_SERVICE",
                    "⚠️ Notification service is already running."
                )
                return
            }

            currentTask = action

            // ✅ Start silent audio to prevent iOS from suspending the app
            silentAudioService.playAudioFromByteArray(intArrayToByteArray(SilentAudioData.mp3ByteArray()))

            // ✅ Start persistent notification loop
            CoroutineScope(Dispatchers.Default).launch {
                while (isTaskRunning.value) {
                    updateNotification(title, message)
                    delay(20_000) // ⏳ Retrigger notification every 30 seconds
                }
            }

            // ✅ Execute the foreground task
            CoroutineScope(Dispatchers.Default).launch {
                try {
                    KmpLogging.writeError(
                        "KMP_MEDIA_SERVICE",
                        "✅ Executing task inside notification service..."
                    )
                    action.invoke() // Run the action
                } catch (e: Exception) {
                    KmpLogging.writeError("KMP_MEDIA_SERVICE", "❌ Task failed: ${e.message}")
                } finally {
                    isTaskRunning.value = false
                    stopNotificationService() // Auto-close when done
                }
            }
        }

        fun stopNotificationService() {
            isTaskRunning.value = false
            MPNowPlayingInfoCenter.defaultCenter().nowPlayingInfo = null // Remove UI
            KmpLogging.writeError("KMP_MEDIA_SERVICE", "🛑 Notification service stopped.")

            // ✅ Stop silent audio when service is stopped
            silentAudioService.stopSilentAudio()

            // ✅ Remove Notification
            UNUserNotificationCenter.currentNotificationCenter().removePendingNotificationRequestsWithIdentifiers(
                listOf("KmpForegroundService")
            )
        }

        private fun updateNotification(title: String, subtitle: String) {
            val center = UNUserNotificationCenter.currentNotificationCenter()
            val content = UNMutableNotificationContent().apply {
                setTitle(title)
                setSubtitle(subtitle)
                setBody(subtitle)
                setSound(null) // 🔇 Silent Notification
            }

            val trigger = UNTimeIntervalNotificationTrigger.triggerWithTimeInterval(1.0, false)
            val request = UNNotificationRequest.requestWithIdentifier(
                "KmpForegroundService",
                content,
                trigger
            )

            center.addNotificationRequest(request) { error ->
                if (error != null) {
                    KmpLogging.writeError(
                        "KMP_IOS_FOREGROUNDSERVICES",
                        "❌ Failed to send notification: ${error.localizedDescription}"
                    )
                } else {
                    KmpLogging.writeError(
                        "KMP_IOS_FOREGROUNDSERVICES",
                        "✅ Foreground service notification sent"
                    )
                }
            }
        }
    }
}