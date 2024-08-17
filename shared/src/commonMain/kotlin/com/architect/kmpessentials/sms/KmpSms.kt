package com.architect.kmpessentials.sms

expect class KmpSms {
    companion object{
        fun sendSmsToNumber(message: String, mobileNumber: String)
    }
}