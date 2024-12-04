package com.architect.kmpessentials.email

import android.content.Intent
import android.content.pm.PackageManager
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
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse(emailPrefix) // Use mailto: scheme
                }
                val resolvedActivities =
                    KmpAndroid.applicationContext?.packageManager?.queryIntentActivities(
                        intent,
                        PackageManager.MATCH_DEFAULT_ONLY
                    )

                action(
                    !resolvedActivities.isNullOrEmpty()
                )
            }
        }

        actual fun sendEmailToAddress(address: String, emailSubject: String, emailMessage: String) {
            KmpMainThread.runViaMainThread {
                try {
                    var emailAddress = address
                    if (!address.startsWith(emailPrefix)) {
                        emailAddress = "$emailPrefix$address"
                    }

                    val emailIntent = Intent(Intent.ACTION_VIEW).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        data =
                            Uri.parse(emailAddress.plus("?subject=$emailSubject&body=$emailMessage"))
                        putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                        putExtra(Intent.EXTRA_TEXT, emailMessage);
                    }

                    KmpAndroid.applicationContext?.startActivity(emailIntent)
                } catch (_: Exception) {
                    KmpToast.showToastShort("Email is not supported on this device")
                }
            }
        }

        actual fun sendEmailsToCCAddress(
            address: String,
            ccAddresses: Array<String>?,
            emailSubject: String,
            emailMessage: String
        ) {
            KmpMainThread.runViaMainThread {
                try {
                    var emailAddress = address
                    if (!address.startsWith(emailPrefix)) {
                        emailAddress = "$emailPrefix$address"
                    }

                    val emailIntent = Intent(Intent.ACTION_VIEW).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        data =
                            Uri.parse(emailAddress.plus("?subject=$emailSubject&body=$emailMessage"))
                        putExtra(Intent.EXTRA_CC, arrayOf(ccAddresses))
                        putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                        putExtra(Intent.EXTRA_TEXT, emailMessage);
                    }

                    KmpAndroid.applicationContext?.startActivity(emailIntent)
                } catch (_: Exception) {
                    KmpToast.showToastShort("Email is not supported on this device")
                }
            }
        }
    }
}