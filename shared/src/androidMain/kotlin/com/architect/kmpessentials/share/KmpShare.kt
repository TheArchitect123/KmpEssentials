package com.architect.kmpessentials.share

import android.content.Intent
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpShare {
    actual companion object {
        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, text)

                KmpAndroid.clientAppContext.startActivity(
                    Intent.createChooser(
                        intent,
                        optionalTitle
                    )
                )
            }
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, filePath)

                KmpAndroid.clientAppContext.startActivity(
                    Intent.createChooser(
                        intent,
                        optionalTitle
                    )
                )
            }
        }
    }
}