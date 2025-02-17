import com.architect.kmpessentials.aliases.DefaultActionAsync
import com.architect.kmpessentials.backgrounding.extensions.intArrayToByteArray
import com.architect.kmpessentials.backgrounding.extensions.loadSilentBackgroundAudioFileAsByteArray
import com.architect.kmpessentials.logging.KmpLogging
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import platform.Foundation.NSDictionary
import platform.Foundation.NSNumber
import platform.Foundation.NSString
import platform.Foundation.dictionaryWithObjects
import platform.MediaPlayer.MPMediaItemPropertyArtist
import platform.MediaPlayer.MPMediaItemPropertyTitle
import platform.MediaPlayer.MPNowPlayingInfoCenter
import platform.MediaPlayer.MPNowPlayingInfoPropertyPlaybackRate

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
            updateNotification(title, message, 0.0)

            // ✅ Start silent audio to prevent iOS from suspending the app
            silentAudioService.playAudioFromByteArray(intArrayToByteArray(SilentAudioData.mp3ByteArray))

            CoroutineScope(Dispatchers.Default).launch {
                try {
                    KmpLogging.writeError(
                        "KMP_MEDIA_SERVICE",
                        "✅ Executing task inside notification service..."
                    )
                    action.invoke() // Run the action

                    updateNotification("Task Completed", "Finished", 100.0)
                } catch (e: Exception) {
                    KmpLogging.writeError("KMP_MEDIA_SERVICE", "❌ Task failed: ${e.message}")
                    updateNotification("Task Failed", "Error", 0.0)
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
        }

        private fun updateNotification(title: String, subtitle: String, progress: Double) {
            val nowPlayingInfoMap: Map<Any?, *> = mapOf(
                MPMediaItemPropertyTitle to title as NSString,
                MPMediaItemPropertyArtist to subtitle as NSString,
                MPNowPlayingInfoPropertyPlaybackRate to 1.0 as NSNumber
            )

            val nowPlayingInfoNSDictionary = NSDictionary.dictionaryWithObjects(
                nowPlayingInfoMap.values.toList(),
                nowPlayingInfoMap.keys.toList()
            )

            MPNowPlayingInfoCenter.defaultCenter().nowPlayingInfo = nowPlayingInfoNSDictionary
        }
    }
}

