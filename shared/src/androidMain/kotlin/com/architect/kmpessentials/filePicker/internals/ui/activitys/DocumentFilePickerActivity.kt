package com.architect.kmpessentials.filePicker.internals.ui.activitys

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Keep
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.architect.kmpessentials.filePicker.internals.models.DocumentFilePickerConfig
import com.architect.kmpessentials.filePicker.internals.utilities.FileUtils
import com.architect.kmpessentials.filePicker.internals.utilities.appConst.Const
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getDocumentFilePick
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getSettingIntent
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setCanceledResult
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.showMyDialog
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.filePicker.internals.picker.PickerUtils.selectFile
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setSuccessResult
import com.architect.kmpessentials.filePicker.internals.permission.PermissionUtils.checkPermission

@RequiresApi(Build.VERSION_CODES.KITKAT)
internal class DocumentFilePickerActivity : AppCompatActivity() {

    private val mDocumentFilePickerConfig: DocumentFilePickerConfig? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                Const.BundleInternalExtras.PICK_DOCUMENT,
                DocumentFilePickerConfig::class.java,
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Const.BundleInternalExtras.PICK_DOCUMENT) as DocumentFilePickerConfig?
        }
    }
    private val checkPermission =
        checkPermission(ActivityResultContracts.RequestPermission(), resultCallBack = {
            if (it) {
                launchFilePicker()
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    getPermission(),
                )
            ) {
                showAskDialog()
            } else {
                showGotoSettingDialog()
            }
        })
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private val selectFile =
        selectFile(ActivityResultContracts.StartActivityForResult(), resultCallBack = { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                if (mDocumentFilePickerConfig?.allowMultiple == true && result.data?.clipData != null) {
                    val uris = result.data?.getClipDataUris()
                    val filePaths = uris?.getFilePathList(this)
                    KmpLogging.writeError(Const.LogTag.FILE_RESULT, "File Uri ::: $uris")
                    KmpLogging.writeError(Const.LogTag.FILE_RESULT, "filePath ::: $filePaths")
                    setSuccessResult(uris, filePath = filePaths)
                } else if (result.data?.data != null) {
                    val data = result.data?.data
                    val filePath = data?.let { FileUtils.getRealPath(this, it) }
                    KmpLogging.writeError(Const.LogTag.FILE_RESULT, "File Uri ::: ${data?.toString()}")
                    KmpLogging.writeError(Const.LogTag.FILE_RESULT, "filePath ::: $filePath")
                    setSuccessResult(data, filePath)
                }
            } else {
                setCanceledResult("Failed to pick document")
            }
        })

    private fun Intent.getClipDataUris(): ArrayList<Uri> {
        val resultSet = LinkedHashSet<Uri>()
        data?.let { data ->
            resultSet.add(data)
        }
        val clipData = clipData
        if (clipData == null && resultSet.isEmpty()) {
            return ArrayList()
        } else if (clipData != null) {
            for (i in 0 until clipData.itemCount) {
                val uri = clipData.getItemAt(i).uri
                if (uri != null) {
                    resultSet.add(uri)
                }
            }
        }
        return ArrayList(resultSet)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun List<Uri>.getFilePathList(context: Context): ArrayList<String> {
        val filePathList = ArrayList<String>()
        forEach { uri ->
            FileUtils.getRealPath(context, uri)?.also { filePath ->
                filePathList.add(filePath)
            }
        }
        return filePathList
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun launchFilePicker() {
        if (mDocumentFilePickerConfig != null) {
            selectFile.launch(getDocumentFilePick(mDocumentFilePickerConfig!!))
        } else {
            setCanceledResult(
                "Failed to pick document"
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        title = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission()
        } else {
            launchFilePicker()
        }
    }

    private fun showAskDialog() {
        showMyDialog(
            mDocumentFilePickerConfig?.askPermissionTitle
                ?: "Permission Denied",
            mDocumentFilePickerConfig?.askPermissionMessage ?: "Please allow ${getPermission().split(".").lastOrNull() ?: ""} permission for capture image/video.",
            negativeClick = {
                setCanceledResult("Permission not allowed")
            },
            positiveClick = {
                checkPermission()
            },
        )
    }

    private fun showGotoSettingDialog() {
        if (mDocumentFilePickerConfig != null) {
            showMyDialog(
                mDocumentFilePickerConfig?.settingPermissionTitle
                    ?: "Permission Denied",
                mDocumentFilePickerConfig?.settingPermissionMessage ?: "${getPermission().split(".").lastOrNull() ?: ""} permission is not granted. Please allow it from setting",
                positiveButtonText = "Go To Setting",
                negativeClick = {
                    setCanceledResult("Permission not allowed")
                },
                positiveClick = {
                    settingCameraResultLauncher.launch(getSettingIntent())
                },
            )
        } else {
            setCanceledResult(
                ""
            )
        }
    }

    private val settingCameraResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (mDocumentFilePickerConfig != null) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        getPermission(),
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    launchFilePicker()
                } else {
                    setCanceledResult("Permission not allowed")
                }
            } else {
                setCanceledResult(
                    "data is set"
                )
            }
        }

    private fun checkPermission() {
        if (mDocumentFilePickerConfig != null) {
            checkPermission.launch(
                getPermission(),
            )
        } else {
            setCanceledResult(
                "data is set",
            )
        }
    }

    companion object {

        private fun getPermission(): String {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Manifest.permission.READ_MEDIA_VIDEO
            } else {
                Manifest.permission.READ_EXTERNAL_STORAGE
            }
        }

        @Keep
        fun getInstance(
            mContext: Context,
            mDocumentFilePickerConfig: DocumentFilePickerConfig?,
        ): Intent {
            val filePickerIntent = Intent(mContext, DocumentFilePickerActivity::class.java)
            mDocumentFilePickerConfig?.let {
                filePickerIntent.putExtra(Const.BundleInternalExtras.PICK_DOCUMENT, it)
            }
            return filePickerIntent
        }
    }
}
