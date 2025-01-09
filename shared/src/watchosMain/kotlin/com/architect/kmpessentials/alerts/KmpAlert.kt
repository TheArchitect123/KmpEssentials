package com.architect.kmpessentials.alerts

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.UnsafeNumber
import platform.WatchKit.WKAlertAction
import platform.WatchKit.WKAlertActionStyleCancel
import platform.WatchKit.WKAlertActionStyleDefault
import platform.WatchKit.WKAlertControllerStyle

@OptIn(UnsafeNumber::class)
actual class KmpAlert {
    actual companion object {
        actual fun showAlert(message: String, title: String) {
            KmpMainThread.runViaMainThread {
                KmpWatchKit.getRootWatchController()?.presentAlertControllerWithTitle(
                    title,
                    message,
                    WKAlertControllerStyle.WKAlertControllerStyleAlert,
                    listOf(
                        WKAlertAction.actionWithTitle(
                            "Ok",
                            WKAlertActionStyleDefault
                        ) {

                        }
                    )
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
                KmpWatchKit.getRootWatchController()?.presentAlertControllerWithTitle(
                    title,
                    message,
                    WKAlertControllerStyle.WKAlertControllerStyleAlert,
                    listOf(
                        WKAlertAction.actionWithTitle(
                            okText,
                            WKAlertActionStyleDefault
                        ) {
                            okAction()
                        }
                    )
                )
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
                KmpWatchKit.getRootWatchController()?.presentAlertControllerWithTitle(
                    title,
                    message,
                    WKAlertControllerStyle.WKAlertControllerStyleAlert,
                    listOf(
                        WKAlertAction.actionWithTitle(
                            okText,
                            WKAlertActionStyleDefault
                        ) {
                            okAction()
                        },
                        WKAlertAction.actionWithTitle(
                            cancelText,
                            WKAlertActionStyleCancel
                        ) {
                            cancelAction()
                        }
                    )
                )
            }
        }
    }
}