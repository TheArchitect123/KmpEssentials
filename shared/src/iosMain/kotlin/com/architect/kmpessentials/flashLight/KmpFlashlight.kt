package com.architect.kmpessentials.flashlight

import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVCaptureTorchModeOff
import platform.AVFoundation.AVCaptureTorchModeOn
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.hasTorch
import platform.AVFoundation.setTorchMode
import platform.AVFoundation.setTorchModeOnWithLevel

actual class KmpFlashlight {
    @OptIn(ExperimentalForeignApi::class)
    actual companion object {

        private fun getFlashLightDevice(): AVCaptureDevice? {
            return AVCaptureDevice.defaultDeviceWithMediaType(AVMediaTypeVideo)!!
        }

        actual fun turnOnFlashlight() {
            KmpMainThread.runViaMainThread {
                val flashLight = getFlashLightDevice()
                if (flashLight!!.hasTorch) {
                    flashLight.lockForConfiguration(null)
                    flashLight.setTorchMode(AVCaptureTorchModeOn)
                    flashLight.unlockForConfiguration()
                }
            }
        }

        actual fun turnOffFlashlight() {
            KmpMainThread.runViaMainThread {
                val flashLight = getFlashLightDevice()
                if (flashLight!!.hasTorch) {
                    flashLight.lockForConfiguration(null)
                    flashLight.setTorchMode(AVCaptureTorchModeOff)
                    flashLight.unlockForConfiguration()
                }
            }
        }

        actual fun turnOnFlashLightWithAdjustableStrength(strengthLevel: FlashLightMode) {
            KmpMainThread.runViaMainThread {
                val flashLight = getFlashLightDevice()
                if (flashLight!!.hasTorch) {
                    val torchLevel =
                        when (strengthLevel) {
                            FlashLightMode.Low -> 0.2f
                            FlashLightMode.Medium -> 0.5f
                            FlashLightMode.High -> 0.8f
                            else -> 1f
                        }

                    flashLight.lockForConfiguration(null)
                    flashLight.setTorchModeOnWithLevel(torchLevel, null)
                    flashLight.unlockForConfiguration()
                }
            }
        }
    }
}