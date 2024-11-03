package com.architect.kmpessentials.share

import android.content.Intent
import androidx.core.app.ShareCompat
import androidx.core.content.FileProvider
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.Mimes
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorTags
import com.architect.kmpessentials.mainThread.KmpMainThread
import java.io.File

actual class KmpShare {
    actual companion object {
        private var fileFlags = mutableListOf<Int>()
        private var fileType = ""

        actual fun setFileType(cFileType: String): Companion {
            fileType = cFileType
            return this
        }

        fun addOptionalFlags(cfileFlags: List<Int>): Companion {
            this.fileFlags.addAll(cfileFlags)

            return this
        }

        fun resetOptionalFlags(): Companion {
            fileFlags.clear()
            return this
        }

        actual fun shareTextWithAnyApp(text: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                try {
                    val titleOfIntent = if (optionalTitle.isNotBlank()) optionalTitle else text
                    val shareIntent =
                        ShareCompat.IntentBuilder(KmpAndroid.applicationContext!!)
                            .setType(Mimes.plainText)
                            .setChooserTitle(titleOfIntent)
                            .setText(text)
                            .createChooserIntent()

                    shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                    KmpAndroid.applicationContext?.startActivity(shareIntent)
                } catch (ex: Exception) {
                    KmpLogging.writeException(ErrorTags.GENERAL_ERROR_TAG, ex)
                }
            }
        }

        actual fun shareFileWithAnyApp(filePath: String, optionalTitle: String) {
            KmpMainThread.runViaMainThread {
                try {
                    val processedFileType = if (fileType.isNotBlank()) fileType else Mimes.plainText
                    // copy the file into a directory that's accessible to all applications
                    val shareIntent = ShareCompat.IntentBuilder(KmpAndroid.applicationContext!!)
                        .addStream(
                            FileProvider.getUriForFile(
                                KmpAndroid.applicationContext!!,
                                KmpAndroid.applicationContext?.packageName + ".fileprovider",
                                File(filePath)
                            )
                        )
                        .setChooserTitle(optionalTitle)
                        .setType(processedFileType)
                        .createChooserIntent()

                    shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

                    // process file flags & add to the intent
                    fileFlags.forEach {
                        shareIntent.addFlags(it)
                    }

                    resetAllConfiguration()
                    KmpAndroid.applicationContext?.startActivity(shareIntent)
                } catch (ex: Exception) {
                    KmpLogging.writeException(ErrorTags.GENERAL_ERROR_TAG, ex)
                }
            }
        }

        private fun resetAllConfiguration() {
            fileFlags.clear()
            fileType = ""
        }
    }
}