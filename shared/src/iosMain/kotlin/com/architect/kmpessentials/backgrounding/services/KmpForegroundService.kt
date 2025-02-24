import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.logging.KmpLogging
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.*
import platform.MediaPlayer.MPNowPlayingInfoCenter

class KmpForegroundService {
    companion object {
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

            // ✅ Start silent audio to prevent iOS from suspending the app
            SilentAudioService.enableRemoteControls({}, {}, {})
            SilentAudioService.updateNowPlayingInfo(title, message)
            silentAudioService.playAudioFromByteArray()

            // ✅ Execute the foreground task
            GlobalScope.launch {
                try {
                    KmpLogging.writeError(
                        "KMP_MEDIA_SERVICE",
                        "✅ Executing task inside notification service..."
                    )

                    runBlocking {
                        action.invoke() // Run the action
                    }
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
            KmpLogging.writeError("KMP_FOREGROUND_SERVICE", "🛑 Notification service stopped.")

            // ✅ Stop silent audio when service is stopped
            silentAudioService.stopSilentAudio()
        }
    }
}