package com.architect.kmpessentials.email.delegates

import kotlinx.cinterop.ExportObjCClass
import platform.Foundation.NSError
import platform.MessageUI.MFMailComposeResult
import platform.MessageUI.MFMailComposeViewController
import platform.MessageUI.MFMailComposeViewControllerDelegateProtocol
import platform.darwin.NSObject

@ExportObjCClass
class EmailReceipientDelegate : NSObject(), MFMailComposeViewControllerDelegateProtocol {
    override fun mailComposeController(controller: MFMailComposeViewController, didFinishWithResult: MFMailComposeResult, error: NSError?) {
        // Dismiss the mail composer
        controller.dismissViewControllerAnimated(true, completion = null)
    }
}