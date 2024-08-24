package com.architect.kmpessentials.share

import android.content.Intent
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpShare {
    actual companion object {
        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, text)

                KmpAndroid.applicationContext.startActivity(
                    Intent.createChooser(
                        intent,
                        optionalTitle
                    )
                )
            }
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, filePath)

                KmpAndroid.applicationContext.startActivity(
                    Intent.createChooser(
                        intent,
                        optionalTitle
                    )
                )
            }
        }
    }
}