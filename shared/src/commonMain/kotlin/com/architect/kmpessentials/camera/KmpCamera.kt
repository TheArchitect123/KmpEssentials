package com.architect.kmpessentials.camera

import com.architect.kmpessentials.internal.ActionStringParams

/**
 * Use this for taking photos either from the camera or photo gallery
 * */
expect class KmpCamera {
    companion object {
        fun isSupported(): Boolean
        fun capturePhoto(actionResult: ActionStringParams)
        fun captureVideo(actionResult: ActionStringParams)
    }
}