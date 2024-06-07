package com.architect.kmpessentials.email

expect class KmpEmail {
    companion object {
        fun sendEmailToAddress(address: String)
        fun sendEmailsToCCAddress(address: String, vararg ccAddresses: String)
    }
}