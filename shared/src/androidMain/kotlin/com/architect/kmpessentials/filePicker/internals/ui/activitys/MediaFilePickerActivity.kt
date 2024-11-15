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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.architect.kmpessentials.filePicker.internals.models.PickMediaConfig
import com.architect.kmpessentials.filePicker.internals.models.PickMediaType
import com.architect.kmpessentials.filePicker.internals.utilities.appConst.Const
import com.architect.kmpessentials.filePicker.internals.permission.PermissionUtils.checkPermission
import com.architect.kmpessentials.filePicker.internals.picker.PickerUtils.selectFile
import com.architect.kmpessentials.filePicker.internals.utilities.FileUtils
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getMediaIntent
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getSettingIntent
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setCanceledResult
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setSuccessResult
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.showMyDialog

internal class MediaFilePickerActivity : AppCompatActivity() {

    private val mPickMediaConfig: PickMediaConfig? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                Const.BundleInternalExtras.PICK_MEDIA,
                PickMediaConfig::class.java,
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Const.BundleInternalExtras.PICK_MEDIA) as PickMediaConfig?
        }
    }
    private val checkPermission =
        checkPermission(ActivityResultContracts.RequestPermission(), resultCallBack = {
            if (it) {
                launchFilePicker()
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    getPermission(
                        mPickMediaConfig = mPickMediaConfig!!,
                    ),
                )
            ) {
                showAskDialog()
            } else {
                showGotoSettingDialog()
            }
        })
    private val selectFile =
        selectFile(ActivityResultContracts.StartActivityForResult(), resultCallBack = { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                if (mPickMediaConfig?.allowMultiple == true && result.data?.clipData != null) {
                    val uris = result.data?.getClipDataUris()
                    val filePaths = uris?.getFilePathList(this)
                    setSuccessResult(uris, filePath = filePaths)
                } else if (result.data?.data != null) {
                    val data = result.data?.data
                    val filePath = data?.let { FileUtils.getRealPath(this, it) }
                    setSuccessResult(data, filePath)
                }
            } else {
                setCanceledResult("Media Pick Error")
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

    private fun List<Uri>.getFilePathList(context: Context): ArrayList<String> {
        val filePathList = ArrayList<String>()
        forEach { uri ->
            FileUtils.getRealPath(context, uri)?.also { filePath ->
                filePathList.add(filePath)
            }
        }
        return filePathList
    }

    private fun launchFilePicker() {
        if (mPickMediaConfig != null) {
            selectFile.launch(getMediaIntent(mPickMediaConfig!!))
        } else {
            setCanceledResult(
                "data is set",
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
            mPickMediaConfig?.askPermissionTitle ?: "Permission Denied",
            mPickMediaConfig?.askPermissionMessage ?: "Please allow ${
                getPermission(mPickMediaConfig!!).split(".").lastOrNull() ?: ""
            } permission for capture image/video.",
            negativeClick = {
                setCanceledResult("Permission not allowed")
            },
            positiveClick = {
                checkPermission()
            },
        )
    }

    private fun showGotoSettingDialog() {
        if (mPickMediaConfig != null) {
            showMyDialog(
                mPickMediaConfig?.settingPermissionTitle
                    ?: "Permission not allowed",
                mPickMediaConfig?.settingPermissionMessage ?: "${
                    getPermission(mPickMediaConfig!!).split(".").lastOrNull() ?: ""
                } permission is not granted. Please allow it from setting.",
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
                "${this::mPickMediaConfig::class.java.name} data is set"
            )
        }
    }

    private val settingCameraResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (mPickMediaConfig != null) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        getPermission(mPickMediaConfig!!),
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
        if (mPickMediaConfig != null) {
            checkPermission.launch(
                getPermission(
                    mPickMediaConfig = mPickMediaConfig!!,
                ),
            )
        } else {
            setCanceledResult(
                "data is set"
            )
        }
    }

    companion object {

        private fun getPermission(mPickMediaConfig: PickMediaConfig): String {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (mPickMediaConfig.mPickMediaType == PickMediaType.ImageOnly) {
                    Manifest.permission.READ_MEDIA_IMAGES
                } else {
                    Manifest.permission.READ_MEDIA_VIDEO
                }
            } else {
                Manifest.permission.READ_EXTERNAL_STORAGE
            }
        }

        fun getInstance(mContext: Context, mPickMediaConfig: PickMediaConfig?): Intent {
            val filePickerIntent = Intent(mContext, MediaFilePickerActivity::class.java)
            mPickMediaConfig?.let {
                filePickerIntent.putExtra(Const.BundleInternalExtras.PICK_MEDIA, it)
            }
            return filePickerIntent
        }
    }
}
