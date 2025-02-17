
import com.architect.kmpessentials.backgrounding.extensions.toNSData
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.setActive

@OptIn(ExperimentalForeignApi::class)
internal class SilentAudioService {
    private var player: AVAudioPlayer? = null

    fun playSilentAudio() {
        val session = AVAudioSession.sharedInstance()
        try {

            AVAudioSession.sharedInstance().setCategory(AVAudioSessionCategoryPlayback, null)
            session.setActive(true, null)

          //  val silentSoundURL = NSBundle.mainBundle.URLForResource("silence", "mp3")


            //player = AVAudioPlayer(contentsOfURL = silentSoundURL, error = null)

            player?.numberOfLoops = -1 // Infinite loop
            player?.play()
        } catch (e: Exception) {
            println("❌ Error playing silent audio: ${e.message}")
        }
    }

    fun playAudioFromByteArray(byteArray: ByteArray) {
        val session = AVAudioSession.sharedInstance()
        try {
            session.setCategory(AVAudioSessionCategoryPlayback, null)
            session.setActive(true, error = null)

            // ✅ Convert ByteArray to NSData
            val nsData = byteArray.toNSData()

            // ✅ Play the NSData using AVAudioPlayer
            player = AVAudioPlayer(data = nsData, error = null)
            player?.numberOfLoops = -1 // Infinite loop
            player?.volume = 0.0f // Keep it silent if needed

            player?.play()
            println("🔊 Audio playback started (from ByteArray).")
        } catch (e: Exception) {
            println("❌ Error playing audio: ${e.message}")
        }
    }

    fun stopSilentAudio() {
        player?.stop()
    }
}

