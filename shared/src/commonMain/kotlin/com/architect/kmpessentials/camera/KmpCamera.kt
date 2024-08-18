package com.architect.kmpessentials.camera

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpCamera {
    companion object {
        fun isSupported(): Boolean
        fun capturePhoto(actionResult: ActionStringParams)
    }
}