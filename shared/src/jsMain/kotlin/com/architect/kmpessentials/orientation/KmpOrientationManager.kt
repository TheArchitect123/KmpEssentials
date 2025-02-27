package com.architect.kmpessentials.orientation

import com.architect.kmpessentials.orientation.internal.OrientationListener
import kotlinx.browser.window

actual class KmpOrientationManager {
    actual companion object {

        actual fun getCurrentOrientation(): OrientationState {
            val screenOrientation = window.asDynamic().screen?.orientation?.angle as? Int
            return when {
                screenOrientation != null -> if (screenOrientation == 0 || screenOrientation == 180) {
                    OrientationState.Portrait
                } else {
                    OrientationState.Landscape
                }
                window.innerWidth > window.innerHeight -> OrientationState.Landscape
                window.innerWidth < window.innerHeight -> OrientationState.Portrait
                else -> OrientationState.Unknown
            }
        }


        actual fun startListening(orientationChange: OrientationListener) {
            val screenOrientation = window.asDynamic().screen?.orientation
            if (screenOrientation != undefined) {
                screenOrientation.addEventListener("change") {
                    orientationChange(getCurrentOrientation())
                }
            } else {
                // Fallback for older browsers
                window.addEventListener("resize", {
                    orientationChange(getCurrentOrientation())
                })
            }
        }

        actual fun stopListening() {
            val screenOrientation = window.asDynamic().screen?.orientation
            if (screenOrientation != undefined) {
                screenOrientation.removeEventListener("change") {

                }
            } else {
                window.removeEventListener("resize", {

                })
            }
        }
    }
}

