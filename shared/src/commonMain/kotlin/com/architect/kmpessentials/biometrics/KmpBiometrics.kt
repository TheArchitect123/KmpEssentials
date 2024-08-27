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
         * @param title title to place on top of the biometric prompt window (will be shown depending on the device if supported)
         * @param message a description for the reason for why users are prompted for biometrics (choose something that explains to users why biometrics is needed)
         * */
        fun setPromptInfo(title: String, message: String)

        /**
         * Prompt the user for a fingerprint/facial auth (depending on what is configured on user's device) and verifies if they are registered on the device
         * @param actionResult returns true if scanning is successful, false if not
         * @param actionError returns a string with the reason for the error if scanning has failed
         * */
        fun scanBiometrics(actionResult: ActionBoolParams, actionError: ActionStringParams)
    }
}