package com.architect.kmpessentials.telecom

expect class KmpTelecom {
    companion object{
        fun launchPhoneCallWithNumber(mobileNumber: String)
    }
}