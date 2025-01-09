package com.architect.kmpessentials.alerts

import android.text.Spannable
import android.text.SpannableString
import android.text.style.TextAppearanceSpan
import androidx.appcompat.app.AlertDialog
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpAlert {
    actual companion object {
        private var titleStyle: Int = 0
        private var messageStyle: Int = 0
        private var buttonStyle: Int = 0
        private var cancelButtonStyle: Int = 0
        private var alertDialogStyle: Int = 0

        /**
         * Use this to override the default Title Style for Alert Dialogs, and add your own
         * */
        fun setTitleStyleResource(titleStyle: Int) {
            this.titleStyle = titleStyle
        }

        /**
         * Use this to override the default Ok Button Style for Alert Dialogs, and add your own
         * */
        fun setButtonStyleResource(buttonStyle: Int) {
            this.buttonStyle = buttonStyle
        }

        /**
         * Use this to override the Cacnel Button Style for Alert Dialogs, and add your own
         * */
        fun setCancelButtonStyleResource(cancelButtonStyle: Int) {
            this.cancelButtonStyle = cancelButtonStyle
        }

        /**
         * Use this to override the default Message Style for Alert Dialogs, and add your own
         * */
        fun setMessageStyleResource(messageStyle: Int) {
            this.messageStyle = messageStyle
        }

        /**
         * Use this to override the default Style for Alert Dialogs, and add your own
         * */
        fun setAlertDialogStyleResource(alertDialogStyle: Int) {
            this.alertDialogStyle = alertDialogStyle
        }

        actual fun showAlert(message: String, title: String) {
            KmpMainThread.runViaMainThread {
                val titleSpan = SpannableString(title)
                if (titleStyle != 0) {
                    titleSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, titleStyle),
                        0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val messageSpan = SpannableString(message)
                if (messageStyle != 0) {
                    messageSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, messageStyle),
                        0, message.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val buttonString = "Ok"
                val buttonSpan = SpannableString(buttonString)
                if (buttonStyle != 0) {
                    buttonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, buttonStyle),
                        0, buttonString.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val alert = AlertDialog.Builder(KmpAndroid.clientAppContext!!, alertDialogStyle)
                    .setTitle(titleSpan)
                    .setMessage(messageSpan)
                    .setPositiveButton(buttonSpan) { result, dial ->

                    }

                alert.show()
            }
        }

        actual fun showAlert(
            message: String,
            title: String,
            okText: String,
            okAction: DefaultAction,
        ) {
            KmpMainThread.runViaMainThread {
                val titleSpan = SpannableString(title)
                if (titleStyle != 0) {
                    titleSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, titleStyle),
                        0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val messageSpan = SpannableString(message)
                if (messageStyle != 0) {
                    messageSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, messageStyle),
                        0, message.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val buttonString = okText
                val buttonSpan = SpannableString(buttonString)
                if (buttonStyle != 0) {
                    buttonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, buttonStyle),
                        0, buttonString.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val alert = AlertDialog.Builder(KmpAndroid.clientAppContext!!, alertDialogStyle)
                    .setTitle(titleSpan)
                    .setMessage(messageSpan)
                    .setPositiveButton(buttonSpan) { result, dial ->
                        okAction()
                    }

                alert.show()
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
                val titleSpan = SpannableString(title)
                if (titleStyle != 0) {
                    titleSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, titleStyle),
                        0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val messageSpan = SpannableString(message)
                if (messageStyle != 0) {
                    messageSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, messageStyle),
                        0, message.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val buttonSpan = SpannableString(okText)
                if (buttonStyle != 0) {
                    buttonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, buttonStyle),
                        0, okText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val cancelButtonSpan = SpannableString(cancelText)
                if (cancelButtonStyle != 0) {
                    cancelButtonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, cancelButtonStyle),
                        0, cancelText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val alert = AlertDialog.Builder(KmpAndroid.clientAppContext!!, alertDialogStyle)
                    .setTitle(titleSpan)
                    .setMessage(messageSpan)
                    .setPositiveButton(buttonSpan) { result, dial ->
                        okAction()
                    }
                    .setNegativeButton(cancelButtonSpan) { result, dial ->
                        cancelAction()
                    }

                alert.show()
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
            KmpMainThread.runViaMainThread {
                val titleSpan = SpannableString(title)
                if (titleStyle != 0) {
                    titleSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, titleStyle),
                        0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val messageSpan = SpannableString(message)
                if (messageStyle != 0) {
                    messageSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, messageStyle),
                        0, message.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val buttonSpan = SpannableString(okText)
                if (buttonStyle != 0) {
                    buttonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, buttonStyle),
                        0, okText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val secondaryButtonSpan = SpannableString(secondaryText)
                if (cancelButtonStyle != 0) {
                    secondaryButtonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, cancelButtonStyle),
                        0, secondaryText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val cancelButtonSpan = SpannableString(cancelText)
                if (buttonStyle != 0) {
                    cancelButtonSpan.setSpan(
                        TextAppearanceSpan(KmpAndroid.clientAppContext, buttonStyle),
                        0, cancelText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                val alert = AlertDialog.Builder(KmpAndroid.clientAppContext!!, alertDialogStyle)
                    .setTitle(titleSpan)
                    .setMessage(messageSpan)
                    .setPositiveButton(buttonSpan) { result, dial ->
                        okAction()
                    }
                    .setNegativeButton(secondaryButtonSpan) { result, dial ->
                        secondaryAction()
                    }
                    .setNeutralButton(cancelButtonSpan) { result, dial ->

                    }

                alert.show()
            }
        }
    }
}