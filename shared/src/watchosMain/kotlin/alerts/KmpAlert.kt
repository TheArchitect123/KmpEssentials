package com.architect.kmpessentials.alerts

import com.architect.kmpessentials.aliases.DefaultAction

actual class KmpAlert {
    actual companion object {

        actual fun showAlert(message: String, title: String) {

        }

        actual fun showAlert(
            message: String,
            title: String,
            okText: String,
            okAction: DefaultAction
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

        }
    }
}