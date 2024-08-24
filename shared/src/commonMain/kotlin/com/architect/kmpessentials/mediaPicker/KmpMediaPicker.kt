package com.architect.kmpessentials.mediaPicker

import com.architect.kmpessentials.internal.ActionStringParams

expect class KmpMediaPicker {
    companion object{
        fun pickPhotoFromGallery(actionResult: ActionStringParams)
        fun pickVideoFromGallery(actionResult: ActionStringParams)
    }
}