package com.architect.kmpessentials.telecom

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread


actual class KmpTelecom {
    actual companion object {
        actual fun launchPhoneCallWithNumber(mobileNumber: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:$mobileNumber"))
                KmpAndroid.clientAppContext.startActivity(intent)
            }
        }
    }
}