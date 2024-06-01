package com.architect.kmpessentials.flashlight

expect class KmpFlashlight {
    companion object {
        fun turnOnFlashlight()

        fun turnOffFlashlight()

        fun turnOnFlashLightWithAdjustableStrength(strengthLevel: FlashLightMode)

    }
}