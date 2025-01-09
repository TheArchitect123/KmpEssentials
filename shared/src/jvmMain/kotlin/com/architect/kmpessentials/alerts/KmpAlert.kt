package com.architect.kmpessentials.alerts

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.mainThread.KmpMainThread
import javax.swing.JOptionPane

actual class KmpAlert {
    actual companion object {
        actual fun showAlert(message: String, title: String) {
            KmpMainThread.runViaMainThread {
                JOptionPane.showMessageDialog(
                    null,
                    message,
                    title,
                    JOptionPane.PLAIN_MESSAGE,
                )
            }
        }

        actual fun showAlert(
            message: String,
            title: String,
            okText: String,
            okAction: DefaultAction,
        ) {
            KmpMainThread.runViaMainThread {
                val options = arrayOf(okText)
                val result = JOptionPane.showOptionDialog(
                    null,
                    message,
                    title,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, // Message type
                    null,
                    options, // Button options
                    options[0] // Default button
                )

                // Check result: 0 = "Confirm", 1 = "Cancel"
                if (result == 0) {
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
                val options = arrayOf(okText, cancelText)
                val result = JOptionPane.showOptionDialog(
                    null,
                    message,
                    title,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
                )

                // Check result: 0 = "Confirm", 1 = "Cancel"
                if (result == 0) {
                    okAction()
                } else {
                    cancelAction()
                }
            }
        }
    }
}