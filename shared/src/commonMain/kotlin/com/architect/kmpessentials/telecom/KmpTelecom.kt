package com.architect.kmpessentials.telecom

expect class KmpTelecom {
    companion object{
        /**
         * Opens up the device's Phone Dialer with the specified mobile number
         * */
        fun launchPhoneCallWithNumber(mobileNumber: String)
    }
}