package com.architect.kmpessentials.email

import com.architect.kmpessentials.internal.ActionBoolParams

actual class KmpEmail {
    actual companion object {
        actual fun isEmailSupported(action: ActionBoolParams) {

        }

        actual fun sendEmailToAddress(address: String) {

        }

        actual fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>?) {

        }
    }
}