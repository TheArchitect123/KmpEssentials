package com.architect.kmpessentials.clipBoard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.architect.kmpessentials.KmpAndroid

actual class KmpClipboard {
    actual companion object {
        private val clipBoardManager by lazy {
            KmpAndroid.applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        }

        actual fun getTextFromClipboard(): String {
            if (clipBoardManager.hasPrimaryClip()) {
                if (clipBoardManager.primaryClip!!.itemCount > 0) {
                    return clipBoardManager.primaryClip!!.getItemAt(0).text.toString()
                }
            }

            return ""
        }

        actual fun copyTextIntoClipboard(textToCopy: String) {
            clipBoardManager.setPrimaryClip(ClipData.newPlainText("KmpEssentialsText", textToCopy))
        }

        actual fun isSupported(): Boolean {
            return clipBoardManager.hasPrimaryClip()
        }
    }
}