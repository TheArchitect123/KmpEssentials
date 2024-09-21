package com.architect.kmpessentials.flashlight.components

import android.annotation.TargetApi
import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.flashlight.FlashLightMode

@TargetApi(Build.VERSION_CODES.M)
internal class FlashlightHardware {
    private val cameraHardware by lazy {
        KmpAndroid.applicationContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    private var flashlightCameraId: String? = null
    // id of the first device found capable of flashlight hardware

    init {
        flashlightCameraId = getFlashlightCameraId()
    }

    private fun getFlashlightCameraId(): String {
        val flashLightId = cameraHardware.cameraIdList.firstOrNull {
            cameraHardware.getCameraCharacteristics(it).keys.any { cameraChar ->
                cameraChar == CameraCharacteristics.FLASH_INFO_AVAILABLE
            }
        } ?: throw Exception("Failed to find any flashlight capable hardware on device")

        flashlightCameraId = flashLightId
        return flashLightId
    }

    fun turnOnFlashLight() {
        cameraHardware.setTorchMode(flashlightCameraId!!, true)
    }

    fun turnOffFlashLight() {
        cameraHardware.setTorchMode(flashlightCameraId!!, false)
    }

    @TargetApi(Build.VERSION_CODES.TIRAMISU)
    fun turnOnFlashLightWithStrengthLevel(strength: FlashLightMode) {
        val flashLevelMax =
            cameraHardware.getCameraCharacteristics(flashlightCameraId!!)[CameraCharacteristics.FLASH_INFO_STRENGTH_MAXIMUM_LEVEL]
        if (flashLevelMax != null) {
            when (strength) {
                FlashLightMode.Low -> {
                    cameraHardware.turnOnTorchWithStrengthLevel(
                        flashlightCameraId!!,
                        Math.round(flashLevelMax * 0.25f)
                    )
                }

                FlashLightMode.Medium -> {
                    cameraHardware.turnOnTorchWithStrengthLevel(
                        flashlightCameraId!!,
                        Math.round(flashLevelMax * 0.5f)
                    )
                }

                FlashLightMode.High -> {
                    cameraHardware.turnOnTorchWithStrengthLevel(
                        flashlightCameraId!!,
                        Math.round(flashLevelMax * 0.8f)
                    )
                }

                FlashLightMode.Max -> { // max strength level (users need to be warned not to use this unless they have to
                    cameraHardware.turnOnTorchWithStrengthLevel(
                        flashlightCameraId!!,
                        flashLevelMax
                    )
                }

                else -> { // Default Flash (without Strength Control)
                    turnOnFlashLight()
                }
            }
        } else {
            turnOnFlashLight()
        }
    }
}