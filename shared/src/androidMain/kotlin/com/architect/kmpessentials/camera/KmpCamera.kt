package com.architect.kmpessentials.camera

actual class KmpCamera {
    actual companion object {
        actual fun isSupported(): Boolean {
            return true
        }
    }
}