package com.architect.kmpessentials.email

import android.content.Intent
import android.net.Uri
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpEmail {
    actual companion object {
        actual fun sendEmailToAddress(address: String) {
            KmpMainThread.runViaMainThread {
                val emailIntent = Intent(Intent.ACTION_VIEW)
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                emailIntent.setData(Uri.parse(address))
                KmpAndroid.applicationContext.startActivity(emailIntent)
            }
        }

        actual fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>?) {
            KmpMainThread.runViaMainThread {
                val emailIntent = Intent(Intent.ACTION_VIEW)
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                emailIntent.setData(Uri.parse(address))
                emailIntent.putExtra(Intent.EXTRA_CC, arrayOf(ccAddresses))
                KmpAndroid.applicationContext.startActivity(emailIntent)
            }
        }
    }
}