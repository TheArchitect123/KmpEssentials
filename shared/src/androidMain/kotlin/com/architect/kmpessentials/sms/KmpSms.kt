package com.architect.kmpessentials.sms

import android.content.Intent
import android.net.Uri
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpSms {
    actual companion object {
        actual fun sendSmsToNumber(message: String, mobileNumber: String) {
            KmpMainThread.runViaMainThread {
                val sendIntent = Intent(Intent.ACTION_VIEW).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                sendIntent.setData(Uri.parse("sms:$mobileNumber"))
                sendIntent.putExtra("sms_body", message)

                KmpAndroid.applicationContext?.startActivity(sendIntent)
            }
        }
    }
}