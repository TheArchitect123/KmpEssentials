package com.architect.kmpessentials.telecom

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual class KmpTelecom {
    actual companion object {
        actual fun launchPhoneCallWithNumber(mobileNumber: String) {
            KmpMainThread.runViaMainThread {
                val telephone = NSURL(string = "tel://$mobileNumber")
                if (UIApplication.sharedApplication.canOpenURL(telephone)) {
                    UIApplication.sharedApplication.openURL(telephone)
                }
            }
        }
    }
}