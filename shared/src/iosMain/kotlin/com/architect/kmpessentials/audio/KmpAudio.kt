package com.architect.kmpessentials.audio

import com.architect.kmpessentials.fileSystem.KmpFileSystem
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryOptions
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.AVAudioSessionModeDefault
import platform.AVFAudio.setActive
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL

actual class KmpAudio {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun playAudioFileWithPath(filePath: String) {
            KmpMainThread.runViaMainThread {
                val audioPlayer = AVAudioPlayer(NSURL.fileURLWithPath(filePath), null)
                audioPlayer.numberOfLoops = 1
                audioPlayer.volume = 1f
                audioPlayer.prepareToPlay()

                AVAudioSession.sharedInstance().setCategory(AVAudioSessionCategoryPlayback, null)
                AVAudioSession.sharedInstance().setActive(true, null)
                audioPlayer.play()
            }
        }

        actual fun recordVoiceAndReturnFilePath(actionParams: ActionStringParams) {
            if (KmpPermissionsManager.isPermissionGranted(Permission.Microphone)) {
                // run AVAudioEngine, and record the user's voice.
                // write session data to a file specified by path, and return the url directory
//                val appPath = NSFileManager.defaultManager.createDirectoryAtPath(
//                    "${KmpFileSystem.getAppDirectory()}/audioFiles",
//
//                )

            }
        }
    }
}