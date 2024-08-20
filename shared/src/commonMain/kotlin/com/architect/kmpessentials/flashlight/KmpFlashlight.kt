package com.architect.kmpessentials.flashlight

expect class KmpFlashlight {
    companion object {
        /**
         * Turns on the Device's Flashlight
         * */
        fun turnOnFlashlight()

        /**
         * Turns off the Device's Flashlight
         * */
        fun turnOffFlashlight()

        /**
         * Turns on the Device's flashlight with adjustable
         * */
        fun turnOnFlashLightWithAdjustableStrength(strengthLevel: FlashLightMode)
    }
}