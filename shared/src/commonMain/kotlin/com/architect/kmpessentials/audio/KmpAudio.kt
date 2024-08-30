package com.architect.kmpessentials.audio

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpAudio {
    companion object {
        fun playAudioFileWithPath(filePath: String)
        fun recordVoiceAndReturnFilePath(actionParams: ActionStringParams)
    }
}