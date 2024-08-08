package com.architect.kmpessentials.email

import platform.MessageUI.MFMailComposeViewController
import platform.UIKit.UIApplication
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

actual class KmpEmail {
    actual companion object {
        actual fun sendEmailToAddress(address: String) {
            dispatch_async(dispatch_get_main_queue()) {
                val mailController = MFMailComposeViewController()
                mailController.setToRecipients(arrayListOf(address))

                UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
                    mailController,
                    true
                ) {

                }
            }
        }

        actual fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>?) {
            dispatch_async(dispatch_get_main_queue()) {
                val mailController = MFMailComposeViewController()
                mailController.setToRecipients(arrayListOf(address, ccAddresses))
                UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
                    mailController,
                    true
                ) {

                }
            }
        }
    }
}