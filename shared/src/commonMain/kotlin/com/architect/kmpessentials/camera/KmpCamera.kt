package com.architect.kmpessentials.camera

expect class KmpCamera {
    companion object{
        fun isSupported(): Boolean
    }
}