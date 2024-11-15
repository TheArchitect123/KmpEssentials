package com.architect.kmpessentials.filePicker.internals.utilities

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import androidx.annotation.Keep
import androidx.annotation.RequiresApi
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.copyFileToInternalStorage
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getDataColumn
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getDriveFilePath
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getMediaDocumentPath
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.isDownloadsDocument
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.isExternalStorageDocument
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.isGoogleDriveUri
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.isGooglePhotosUri
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.isMediaDocument
import java.io.File

@Keep
internal object FileUtils {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Keep
    fun getRealPath(context: Context, fileUri: Uri): String? {
        return pathFromURI(context, fileUri)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Keep
    private fun pathFromURI(context: Context, uri: Uri): String? {
        return when {
            DocumentsContract.isDocumentUri(context, uri) -> {
                getDocumentUri(context, uri)
            }

            uri.isGoogleDriveUri() -> {
                context.getDriveFilePath(uri)
            }

            "content".equals(uri.scheme, ignoreCase = true) -> {
                // Return the remote address
                if (uri.isGooglePhotosUri()) {
                    uri.lastPathSegment
                } else if (uri.isGoogleDriveUri()) {
                    return context.getDriveFilePath(uri)
                } else {
                    getDataColumn(
                        context,
                        uri,
                        null,
                        null,
                    ) ?: context.copyFileToInternalStorage(uri)
                }
            }

            "file".equals(uri.scheme, ignoreCase = true) -> {
                uri.path
            }

            else -> {
                context.copyFileToInternalStorage(uri)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun getDocumentUri(context: Context, uri: Uri) = when {
        uri.isExternalStorageDocument() -> {
            getExternalDocumentPath(uri)
        }

        uri.isDownloadsDocument() -> {
            getFileName(context, uri)?.let {
                Environment.getExternalStorageDirectory()
                    .toString() + "/Download/" + it
            } ?: context.getDownloadsDocumentPath(uri) ?: context.copyFileToInternalStorage(
                uri
            )
        }

        uri.isMediaDocument() -> {
            context.getMediaDocumentPath(uri) ?: context.copyFileToInternalStorage(uri)
        }

        else -> {
            context.copyFileToInternalStorage(uri)
        }
    }


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Keep
    private fun Context.getDownloadsDocumentPath(uri: Uri): String? {
        /*val fileName = getFileName(this, uri)
        if (fileName != null) {
            return Environment.getExternalStorageDirectory()
                .toString() + "/Download/" + fileName
        }*/

        var id = DocumentsContract.getDocumentId(uri)
        if (id.startsWith("raw:")) {
            id = id.replaceFirst("raw:".toRegex(), "")
            val file = File(id)
            if (file.exists()) return id
        }
        val contentUriPrefixesToTry = arrayOf(
            "content://downloads/public_downloads",
            "content://downloads/my_downloads"
        )
        var filePath: String? = null
        for (contentUriPrefix in contentUriPrefixesToTry) {
            try {
                val contentUri = ContentUris.withAppendedId(
                    Uri.parse(contentUriPrefix),
                    java.lang.Long.valueOf(id)
                )
                filePath = getDataColumn(this, contentUri, null, null)
                if (filePath != null) {
                    break
                }
            } catch (e: NumberFormatException) {
                filePath = null
            }
        }
        return filePath ?: uri.path?.replaceFirst("^/document/raw:", "")?.replaceFirst("^raw:", "")
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Keep
    private fun getExternalDocumentPath(uri: Uri): String {
        val docId = DocumentsContract.getDocumentId(uri)
        val split =
            docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val type = split[0]

        // This is for checking Main Memory
        return if ("primary".equals(type, ignoreCase = true)) {
            if (split.size > 1) {
                Environment.getExternalStorageDirectory()
                    .toString() + "/" + split[1]
            } else {
                Environment.getExternalStorageDirectory().toString() + "/"
            }
            // This is for checking SD Card
        } else {
            "storage" + "/" + docId.replace(":", "/")
        }
    }


    @Keep
    private fun getFileName(context: Context, uri: Uri?): String? {
        var cursor: Cursor? = null
        val projection = arrayOf(
            MediaStore.MediaColumns.DISPLAY_NAME,
        )
        try {
            cursor = context.contentResolver.query(
                uri!!,
                projection,
                null,
                null,
                null,
            )
            if (cursor != null && cursor.moveToFirst()) {
                val index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME)
                return cursor.getString(index)
            }
        } finally {
            cursor?.close()
        }
        return null
    }
}
