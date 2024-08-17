package com.architect.kmpessentials.sms

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.MessageUI.MFMessageComposeViewController

actual class KmpSms {
    actual companion object {
        actual fun sendSmsToNumber(message: String, mobileNumber: String) {
            KmpMainThread.runViaMainThread {
                if (MFMessageComposeViewController.canSendText()) {
                    val messageController = MFMessageComposeViewController()
                    messageController.body = message
                    messageController.recipients = listOf(mobileNumber)

                    KmpiOS.getTopViewController()
                        ?.presentViewController(messageController, true, null)
                }
            }
        }
    }
}