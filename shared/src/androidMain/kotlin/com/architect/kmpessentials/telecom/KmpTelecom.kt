package com.architect.kmpessentials.telecom

import android.content.Intent
import android.net.Uri
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpTelecom {
    actual companion object {
        actual fun launchPhoneCallWithNumber(mobileNumber: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                intent.setData(Uri.parse("tel:$mobileNumber"))
                KmpAndroid.applicationContext?.startActivity(intent)
            }
        }
    }
}