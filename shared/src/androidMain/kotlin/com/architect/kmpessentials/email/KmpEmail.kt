package com.architect.kmpessentials.email

import android.content.Intent
import android.net.Uri
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.toast.KmpToast

actual class KmpEmail {
    actual companion object {
        private val emailPrefix = "mailto:"
        actual fun isEmailSupported(action: ActionBoolParams) {
            KmpMainThread.runViaMainThread {
                val emailAddress = "sample@gmail.com"

                val emailIntent = Intent(Intent.ACTION_VIEW)
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                emailIntent.setData(Uri.parse(emailAddress))

                action(
                    KmpAndroid.applicationContext.packageManager.resolveActivity(
                        emailIntent,
                        0
                    ) != null
                )
            }
        }

        actual fun sendEmailToAddress(address: String) {
            KmpMainThread.runViaMainThread {
                try {
                    var emailAddress = address
                    if (!address.startsWith(emailPrefix)) {
                        emailAddress = "$emailPrefix$address"
                    }

                    val emailIntent = Intent(Intent.ACTION_VIEW)
                    emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    emailIntent.setData(Uri.parse(emailAddress))

                    KmpAndroid.applicationContext.startActivity(emailIntent)
                } catch (_: Exception) {
                    KmpToast.showToastShort("Email is not supported on this device")
                }
            }
        }

        actual fun sendEmailsToCCAddress(address: String, ccAddresses: Array<String>?) {
            KmpMainThread.runViaMainThread {
                try {
                    var emailAddress = address
                    if (!address.startsWith(emailPrefix)) {
                        emailAddress = "$emailPrefix$address"
                    }

                    val emailIntent = Intent(Intent.ACTION_VIEW)
                    emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    emailIntent.setData(Uri.parse(emailAddress))
                    emailIntent.putExtra(Intent.EXTRA_CC, arrayOf(ccAddresses))

                    KmpAndroid.applicationContext.startActivity(emailIntent)
                } catch (_: Exception) {
                    KmpToast.showToastShort("Email is not supported on this device")
                }
            }
        }
    }
}