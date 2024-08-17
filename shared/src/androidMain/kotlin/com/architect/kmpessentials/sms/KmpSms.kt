package com.architect.kmpessentials.sms

import android.content.Intent
import android.net.Uri
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.launcher.KmpLauncher
import com.architect.kmpessentials.mainThread.KmpMainThread


actual class KmpSms {
    actual companion object {
        actual fun sendSmsToNumber(message: String, mobileNumber: String) {
            KmpMainThread.runViaMainThread {
                val sendIntent = Intent(Intent.ACTION_VIEW)
                sendIntent.setData(Uri.parse("sms:$mobileNumber"))
                sendIntent.putExtra("sms_body", message)

                KmpAndroid.clientAppContext.startActivity(sendIntent)
            }
        }
    }
}