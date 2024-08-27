package com.architect.kmpessentials.alerts

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleCancel
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert

actual class KmpAlert {
    actual companion object {
        actual fun showAlert(message: String, title: String) {
            KmpMainThread.runViaMainThread {
                val alertController = UIAlertController.alertControllerWithTitle(
                    title,
                    message,
                    UIAlertControllerStyleAlert
                )

                alertController.addAction(
                    UIAlertAction.actionWithTitle(
                        "Ok",
                        UIAlertActionStyleDefault
                    ) {

                    })

                KmpiOS.getTopViewController()?.presentViewController(alertController, true, null)
            }
        }

        actual fun showAlert(
            message: String,
            title: String,
            okText: String,
            okAction: DefaultAction,
        ) {
            KmpMainThread.runViaMainThread {
                val alertController = UIAlertController.alertControllerWithTitle(
                    title,
                    message,
                    UIAlertControllerStyleAlert
                )

                alertController.addAction(
                    UIAlertAction.actionWithTitle(
                        okText,
                        UIAlertActionStyleDefault
                    ) {
                        okAction()
                    })

                KmpiOS.getTopViewController()?.presentViewController(alertController, true, null)
            }
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
                val alertController = UIAlertController.alertControllerWithTitle(
                    title,
                    message,
                    UIAlertControllerStyleAlert
                )

                alertController.addAction( // okAction
                    UIAlertAction.actionWithTitle(
                        okText,
                        UIAlertActionStyleDefault
                    ) {
                        okAction()
                    })

                alertController.addAction(// Cancel Action
                    UIAlertAction.actionWithTitle(
                        cancelText,
                        UIAlertActionStyleCancel
                    ) {
                        cancelAction()
                    })

                KmpiOS.getTopViewController()?.presentViewController(alertController, true, null)
            }
        }
    }
}