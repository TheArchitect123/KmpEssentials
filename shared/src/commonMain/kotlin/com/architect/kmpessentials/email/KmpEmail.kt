package com.architect.kmpessentials.email

import com.architect.kmpessentials.internal.ActionBoolParams


expect class KmpEmail {
    companion object {
        /**
         * Sends an email to a single recipient
         * */
        fun sendEmailToAddress(address: String)

        /**
         * Sends an email to multiple recipients
         * */
        fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>? = null)

        /**
         * Checks if email is currently supported on the device.
         * for iOS (Checks if the default email app is available)
         * for Android (checks if ANY app can handle the intent)
         * */
        fun isEmailSupported(action: ActionBoolParams)
    }
}