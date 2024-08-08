package com.architect.kmpessentials.email

expect class KmpEmail {
    companion object {
        fun sendEmailToAddress(address: String)
        fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>? = null)
    }
}