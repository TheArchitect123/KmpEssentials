package com.architect.kmpessentials.share

import android.content.Intent
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.Mimes
import com.architect.kmpessentials.mainThread.KmpMainThread
import java.io.File

actual class KmpShare {
    actual companion object {
        private var fileType: String = ""
        private var fileName: String = ""
        private var fileFlags = mutableListOf<Int>()

        fun setFileType(cfileType: String) {
            this.fileType = cfileType
        }

        fun setFileName(cfileName: String) {
            this.fileName = cfileName
        }

        fun addOptionalFlags(cfileFlags: List<Int>) {
            this.fileFlags.addAll(cfileFlags)
        }

        fun resetOptionalFlags() {
            fileFlags.clear()
        }

        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                intent.setType(Mimes.plainText)
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
                val fileNameToUse = if (fileName.isNotBlank()) fileName else File(filePath).name
                val fileTypeToUse = if (fileType.isNotBlank()) fileType else Mimes.plainText
                val intent = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_STREAM, filePath)
                    putExtra(Intent.EXTRA_TITLE, fileNameToUse)
                    type = fileTypeToUse
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }

                // process file flags & add to the intent
                fileFlags.forEach {
                    intent.addFlags(it)
                }

                resetAllConfiguration()
                KmpAndroid.applicationContext.startActivity(
                    Intent.createChooser(
                        intent,
                        optionalTitle
                    )
                )
            }
        }

        private fun resetAllConfiguration() {
            fileFlags.clear()
            fileType = ""
            fileName = ""
        }
    }
}