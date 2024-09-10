package com.architect.kmpessentials.camera

import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpCamera {
    actual companion object {
        actual fun isSupported(): Boolean {
            return true
        }

        actual fun capturePhoto(actionResult: ActionStringParams) {

        }

        actual fun captureVideo(actionResult: ActionStringParams) {

        }
    }
}