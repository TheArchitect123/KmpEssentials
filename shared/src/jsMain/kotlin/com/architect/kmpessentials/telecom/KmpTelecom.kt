package com.architect.kmpessentials.telecom

import com.architect.kmpessentials.launcher.KmpLauncher

actual class KmpTelecom {
    actual companion object {
        actual fun launchPhoneCallWithNumber(mobileNumber: String) {
            KmpLauncher.launchExternalUrlViaBrowser("tel:$mobileNumber")
        }
    }
}