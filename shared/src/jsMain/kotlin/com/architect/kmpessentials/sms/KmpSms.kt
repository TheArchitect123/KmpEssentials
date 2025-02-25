package com.architect.kmpessentials.sms

import com.architect.kmpessentials.launcher.KmpLauncher

actual class KmpSms {
    actual companion object {

        actual fun sendSmsToNumber(message: String, mobileNumber: String) {
            KmpLauncher.launchExternalUrlViaBrowser("sms:$mobileNumber&body=$message")
        }
    }
}