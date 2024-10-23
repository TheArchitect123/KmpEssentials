package com.architect.kmpessentials.email

import com.architect.kmpessentials.email.delegates.EmailReceipientDelegate
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.MessageUI.MFMailComposeViewController
import platform.UIKit.UIApplication

actual class KmpEmail {
    actual companion object {
        actual fun isEmailSupported(action: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                action(MFMailComposeViewController.canSendMail())
            }
        }

        actual fun sendEmailToAddress(address: String, emailSubject : String, emailMessage: String) {
            KmpMainThread.runViaMainThread {
                val mailController = MFMailComposeViewController()
                mailController.setToRecipients(arrayListOf(address))
                mailController.setMailComposeDelegate(EmailReceipientDelegate())
                mailController.setSubject(emailSubject)
                mailController.setMessageBody(emailMessage, false)

                UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
                    mailController,
                    true
                ) {

                }
            }
        }

        actual fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>?, emailSubject : String, emailMessage: String) {
            KmpMainThread.runViaMainThread {
                val mailController = MFMailComposeViewController()
                mailController.setToRecipients(arrayListOf(address, ccAddresses))
                mailController.setMailComposeDelegate(EmailReceipientDelegate())
                mailController.setSubject(emailSubject)
                mailController.setMessageBody(emailMessage, false)

                UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
                    mailController,
                    true
                ) {

                }
            }
        }
    }
}