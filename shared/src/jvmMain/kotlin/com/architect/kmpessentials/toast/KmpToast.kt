package com.architect.kmpessentials.toast

import com.architect.kmpessentials.localNotifications.KmpLocalNotifications

actual class KmpToast {
    actual companion object {
        actual fun setStyleOfToast(mode: ToastMode) {

        }

        actual fun showToastShort(message: String) {
            KmpLocalNotifications.sendNotification("", message)
        }

        actual fun showToastLong(message: String) {
            KmpLocalNotifications.sendNotification("", message)
        }
    }
}