package com.architect.kmpessentials.audio

import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.launcher.KmpLauncher

actual class KmpAudio {
    actual companion object {
        actual fun playAudioFileWithPath(filePath: String) {
            KmpLauncher.launchExternalUrlViaBrowser(filePath)
        }

        actual fun recordVoiceAndReturnFilePath(actionParams: ActionStringParams) {

            // needs permission via
        }
    }
}