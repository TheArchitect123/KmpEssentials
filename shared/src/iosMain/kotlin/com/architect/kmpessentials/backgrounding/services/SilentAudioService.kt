import com.architect.kmpessentials.backgrounding.KmpBackgrounding
import com.architect.kmpessentials.logging.KmpLogging
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.memScoped
import platform.AVFAudio.AVAudioPlayer
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.setActive
import platform.Foundation.*
import platform.MediaPlayer.*
import kotlinx.cinterop.*

@OptIn(ExperimentalForeignApi::class)
internal class SilentAudioService {
    private var player: AVAudioPlayer? = null

    private fun getMp3FilePath(): NSURL? {
        val filePath = NSBundle.mainBundle.URLForResource("silencer_audio_backgrounding", "mp3")
        if (filePath == null) {
            KmpLogging.writeError("KMP_MP3", "❌ MP3 file not found in Bundle!")
            return null
        }

        KmpLogging.writeError("KMP_MP3", "✅ Found MP3 file: $filePath")
        return filePath
    }

    @OptIn(BetaInteropApi::class)
    fun playAudioFromByteArray() {
        try {
            val session = AVAudioSession.sharedInstance()
            session.setCategory(AVAudioSessionCategoryPlayback, null)
            session.setActive(true, error = null)

            val audioFile = getMp3FilePath()!!
            memScoped {
                val errorRef = alloc<ObjCObjectVar<NSError?>>()

                player = AVAudioPlayer(audioFile, error = errorRef.ptr)
                player?.numberOfLoops = -1 // Infinite loop
                player?.volume = 0.0f // Keep it silent if needed

                if (errorRef.value != null) {
                    KmpLogging.writeError(
                        "KMP_MP3",
                        "❌ AVAudioPlayer failed: ${errorRef.value?.localizedDescription}"
                    )
                }

                if (player == null) {
                    KmpLogging.writeError("KMP_MP3", "❌ AVAudioPlayer is null despite no error!")
                }

                player?.play()

                if (player?.playing == true) {
                    KmpLogging.writeError("KMP_MP3","🔊 AVAudioPlayer is playing!")
                } else {
                    KmpLogging.writeError("KMP_MP3","❌ AVAudioPlayer failed to play")
                }

                KmpLogging.writeError("KMP_MP3","🎵 MP3 Playback started successfully.")
            }
            println("🔊 Audio playback started (from ByteArray).")
        } catch (e: Exception) {
            println("❌ Error playing audio: ${e.stackTraceToString()}")
        }
    }

    companion object {
        fun enableRemoteControls(
            onPlay: () -> Unit,
            onPause: () -> Unit,
            onSeek: (Double) -> Unit
        ) {
            val commandCenter = MPRemoteCommandCenter.sharedCommandCenter()
            commandCenter.playCommand.enabled = false
            commandCenter.pauseCommand.enabled = false
            commandCenter.changePlaybackPositionCommand.enabled = false
            commandCenter.stopCommand.enabled = false
            commandCenter.skipForwardCommand.enabled = false
            commandCenter.skipBackwardCommand.enabled = false

            commandCenter.playCommand.addTargetWithHandler { _ ->
                println("▶️ Play pressed")
                onPlay()
                MPRemoteCommandHandlerStatusSuccess
            }

            commandCenter.pauseCommand.addTargetWithHandler { _ ->
                println("⏸️ Pause pressed")
                onPause()
                MPRemoteCommandHandlerStatusSuccess
            }

            commandCenter.changePlaybackPositionCommand.addTargetWithHandler { event ->
                if (event is MPChangePlaybackPositionCommandEvent) {
                    println("⏩ Seek to ${event.positionTime}")
                    onSeek(event.positionTime)
                    MPRemoteCommandHandlerStatusSuccess
                } else {
                    MPRemoteCommandHandlerStatusCommandFailed
                }
            }
        }

        fun updateNowPlayingInfo(
            title: String,
            artist: String
        ) {
            val nowPlayingInfo = mutableMapOf<Any?, Any?>()
            nowPlayingInfo[MPMediaItemPropertyTitle] = title
            nowPlayingInfo[MPMediaItemPropertyArtist] = artist

            nowPlayingInfo[MPNowPlayingInfoPropertyPlaybackRate] = 0.0
            nowPlayingInfo[MPNowPlayingInfoPropertyIsLiveStream] = false
            nowPlayingInfo[MPMediaItemPropertyPlaybackDuration] = 0.0
            nowPlayingInfo[MPNowPlayingInfoPropertyElapsedPlaybackTime] = 0.0

            // ✅ Set the artwork (icon) for the media notification
            KmpBackgrounding.foregroundIcon?.let {
                val artwork = MPMediaItemArtwork(it)
                nowPlayingInfo[MPMediaItemPropertyArtwork] = artwork
            }

            // ✅ Convert Map to NSDictionary
            MPNowPlayingInfoCenter.defaultCenter().nowPlayingInfo =
                NSDictionary.dictionaryWithObjects(
                    nowPlayingInfo.values.toList(),
                    nowPlayingInfo.keys.toList()
                )
        }
    }

    fun stopSilentAudio() {
        player?.stop()
    }
}

