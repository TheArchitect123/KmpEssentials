package com.architect.kmpessentials.email

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.launcher.KmpLauncher
import kotlinx.browser.window

actual class KmpEmail {
    actual companion object {
        actual fun isEmailSupported(action: ActionBoolParams) {
            action(window.navigator.asDynamic().canShare != undefined)
        }

        actual fun sendEmailToAddress(address: String, emailSubject: String, emailMessage: String) {
            KmpLauncher.launchExternalUrlViaBrowser("mailto:$address&body=$emailMessage&subject=$emailSubject")
        }

        actual fun sendEmailsToCCAddress(
            address: String,
            ccAddresses: Array<String>?,
            emailSubject: String,
            emailMessage: String
        ) {
            val ccs = if (ccAddresses != null) ",${ccAddresses.joinToString()}" else ""
            KmpLauncher.launchExternalUrlViaBrowser("mailto:$address$ccs&body=$emailMessage&subject=$emailSubject")
        }
    }
}