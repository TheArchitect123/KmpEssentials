package com.architect.kmpessentials.toast

import com.architect.kmpessentials.appInfo.KmpAppInfo
import com.architect.kmpessentials.localNotifications.KmpLocalNotifications

actual class KmpToast {
    actual companion object {
        actual fun showToastShort(message: String) {
            KmpLocalNotifications.sendNotification(KmpAppInfo.getPackageName(), message)
        }

        actual fun showToastLong(message: String) {
            KmpLocalNotifications.sendNotification(KmpAppInfo.getPackageName(), message)
        }
    }
}