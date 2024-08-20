package com.architect.kmpessentials.sms

expect class KmpSms {
    companion object{
        /**
         * Opens the device's messaging app, and starts a new text message
         * */
        fun sendSmsToNumber(message: String, mobileNumber: String)
    }
}