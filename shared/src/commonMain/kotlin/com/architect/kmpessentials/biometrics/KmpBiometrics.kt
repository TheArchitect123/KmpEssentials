package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams

/**
 * Used for Biometric Authentication (Fingerprint Scanning & Facial Detection)
 * */
expect class KmpBiometrics {
    companion object {

        /**
         * Checks if the device has a fingerprint scanner available
         * */
        fun isSupported(): Boolean

        /**
         * Use this method to configure the title and message for the fingerprint prompt
         * */
        fun setPromptInfo(title: String, message: String)

        /**
         * Prompt the user for a fingerprint and verify if they are registered on the device
         * */
        fun scanFingerprint(actionResult: ActionBoolParams, actionError: ActionStringParams)
    }
}