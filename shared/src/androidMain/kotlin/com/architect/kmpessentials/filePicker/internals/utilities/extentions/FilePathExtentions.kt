package com.architect.kmpessentials.filePicker.internals.utilities.extentions

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.OpenableColumns
import androidx.annotation.Keep
import androidx.annotation.RequiresApi
import com.architect.kmpessentials.filePicker.internals.utilities.appConst.Const
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

/**
 * @return Whether the Uri authority is ExternalStorageProvider.
 */
internal fun Uri.isExternalStorageDocument(): Boolean {
    return "com.android.externalstorage.documents" == authority
}

/**
 * @return Whether the Uri authority is DownloadsProvider.
 */
internal fun Uri.isDownloadsDocument(): Boolean {
    return "com.android.providers.downloads.documents" == authority
}

/**
 * @return Whether the Uri authority is MediaProvider.
 */
internal fun Uri.isMediaDocument(): Boolean {
    return "com.android.providers.media.documents" == authority
}

/**
 * @return Whether the Uri authority is Google Photos.
 */
internal fun Uri.isGooglePhotosUri(): Boolean {
    return "com.google.android.apps.photos.content" == authority
}

internal fun Uri.isGoogleDriveUri(): Boolean {
    return "com.google.android.apps.docs.storage" == authority ||
            "com.google.android.apps.docs.storage.legacy" == authority
}

@Keep
internal fun getDataColumn(
    context: Context,
    uri: Uri?,
    selection: String?,
    selectionArgs: Array<String>?,
): String? {
    var cursor: Cursor? = null
    val column = "_data"
    val projection = arrayOf(
        column,
    )
    try {
        cursor = context.contentResolver.query(
            uri!!,
            projection,
            selection,
            selectionArgs,
            null,
        )
        if (cursor != null && cursor.moveToFirst()) {
            val index = cursor.getColumnIndexOrThrow(column)
            return cursor.getString(index)
        }
    } finally {
        cursor?.close()
    }
    return null
}


@RequiresApi(Build.VERSION_CODES.KITKAT)
@Keep
internal fun Context.getMediaDocumentPath(uri: Uri): String? {
    val docId = DocumentsContract.getDocumentId(uri)
    val split =
        docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val type = split[0]
    val contentUri: Uri?
    when (type) {
        "image" -> {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

        "video" -> {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        }

        "audio" -> {
            contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        }

        else -> {
            contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        }
    }
    val selection = "_id=?"
    val selectionArgs = arrayOf(
        split[1],
    )
    return getDataColumn(this, contentUri, selection, selectionArgs)
}

internal fun Context.getDriveFilePath(uri: Uri): String? {
    val returnCursor: Cursor? = contentResolver.query(
        uri,
        null,
        null,
        null,
        null
    )
    val nameIndex = returnCursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME) ?: return null
    returnCursor.moveToFirst()
    val name = returnCursor.getString(nameIndex)
    val file = File(cacheDir, name)
    returnCursor.close()
    return try {
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(file)
        var read: Int?
        val bytesAvailable = inputStream?.available() ?: 0
        val bufferSize = bytesAvailable.coerceAtMost(Const.MAX_BUFFER_SIZE)
        val buffers = ByteArray(bufferSize)
        while (inputStream?.read(buffers).also { read = it } != -1) {
            read?.let { outputStream.write(buffers, 0, it) }
        }
        inputStream?.close()
        outputStream.close()
        file.path
    } catch (e: IOException) {
        null
    }

}


/***
 * Used for Android Q+
 * @param uri
 * @param newDirName if you want to create a directory, you can set this variable
 * @return
 */
internal fun Context.copyFileToInternalStorage(
    uri: Uri,
    newDirName: String = Const.copyFileFolder
): String? {
    val returnCursor: Cursor? = this.contentResolver.query(
        uri, arrayOf(
            OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE
        ), null, null, null
    )
    val nameIndex = returnCursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME) ?: return null
    returnCursor.moveToFirst()
    val name = returnCursor.getString(nameIndex)
    returnCursor.close()
    val output: File = if (newDirName != "") {
        val dir = File(cacheDir, newDirName)
        if (!dir.exists()) {
            dir.mkdir()
        }
        File(cacheDir, "$newDirName/$name")
    } else {
        File(cacheDir, "/$name")
    }
    return try {
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(output)
        var read: Int?
        val buffers = ByteArray(Const.BUFFER_SIZE)
        while (inputStream?.read(buffers).also { read = it } != -1) {
            read?.let { outputStream.write(buffers, 0, it) }
        }
        inputStream?.close()
        outputStream.close()
        output.path
    } catch (e: IOException) {
        output.delete()
        null
    }
}
