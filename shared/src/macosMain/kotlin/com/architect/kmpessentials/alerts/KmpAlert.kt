package com.architect.kmpessentials.alerts

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.AppKit.NSAlert
import platform.AppKit.NSModalResponseCancel
import platform.AppKit.NSModalResponseOK
import platform.AppKit.alertWithMessageText

actual class KmpAlert {
    actual companion object {
        actual fun showAlert(message: String, title: String) {
            KmpMainThread.runViaMainThread {
                NSAlert.alertWithMessageText(
                    message,
                    "Ok",
                    null,
                    null,
                    informativeTextWithFormat = title
                ).runModal()
            }
        }

        actual fun showAlert(
            message: String,
            title: String,
            okText: String,
            okAction: DefaultAction,
        ) {
            KmpMainThread.runViaMainThread {
                val alert = NSAlert.alertWithMessageText(
                    message,
                    okText,
                    null,
                    null,
                    informativeTextWithFormat = title
                )

                val response = alert.runModal()
                if (response == NSModalResponseOK) {
                    okAction()
                }
            }
        }

        actual fun showAlertWithTertiaryButtonsConfirmation(
            message: String,
            title: String,
            okText: String,
            secondaryText: String,
            cancelText: String,
            okAction: DefaultAction,
            secondaryAction: DefaultAction
        ) {
        }

        actual fun showAlertWithConfirmation(
            message: String,
            title: String,
            okText: String,
            cancelText: String,
            okAction: DefaultAction,
            cancelAction: DefaultAction
        ) {
            KmpMainThread.runViaMainThread {
                val alert = NSAlert.alertWithMessageText(
                    message,
                    okText,
                    null,
                    cancelText,
                    informativeTextWithFormat = title
                )

                val response = alert.runModal()
                if (response == NSModalResponseOK) {
                    okAction()
                } else if (response == NSModalResponseCancel) {
                    cancelAction()
                }
            }
        }
    }
}