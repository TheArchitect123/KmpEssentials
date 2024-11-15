package com.architect.kmpessentials.filePicker.internals.ui.activitys

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.architect.kmpessentials.filePicker.internals.models.ImageCaptureConfig
import com.architect.kmpessentials.filePicker.internals.permission.PermissionUtils.checkPermission
import com.architect.kmpessentials.filePicker.internals.picker.PickerUtils.createFileGetUri
import com.architect.kmpessentials.filePicker.internals.picker.PickerUtils.createMediaFileFolder
import com.architect.kmpessentials.filePicker.internals.picker.PickerUtils.selectFile
import com.architect.kmpessentials.filePicker.internals.utilities.appConst.Const
import com.architect.kmpessentials.filePicker.internals.utilities.appConst.Const.DefaultPaths.defaultFolder
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getImageCaptureIntent
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.getSettingIntent
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setCanceledResult
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setSuccessResult
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.showMyDialog
import java.io.File

internal class ImageCaptureActivity : AppCompatActivity() {
    private var imageFileUri: Uri? = null
    private var imageFile: File? = null

    private val mImageCaptureConfig: ImageCaptureConfig? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                Const.BundleInternalExtras.IMAGE_CAPTURE,
                ImageCaptureConfig::class.java,
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Const.BundleInternalExtras.IMAGE_CAPTURE) as ImageCaptureConfig?
        }
    }
    private val checkPermission =
        checkPermission(
            ActivityResultContracts.RequestMultiplePermissions(),
            resultCallBack = { input ->
                val allGranted = input.all { permission ->
                    ContextCompat.checkSelfPermission(
                        this,
                        permission.key,
                    ) == PackageManager.PERMISSION_GRANTED
                }
                val isShowRationale = input.any { permission ->
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        permission.key,
                    )
                }
                if (allGranted) {
                    launchCamera()
                } else if (isShowRationale) {
                    showAskDialog()
                } else {
                    showGotoSettingDialog()
                }
            },
        )

    private fun getPermission() {
        checkPermission.launch(getPermissionsList(this).toTypedArray())
    }

    private val imageCapture =
        selectFile(ActivityResultContracts.StartActivityForResult(), resultCallBack = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                setSuccessResult(imageFileUri, imageFile?.absolutePath, true)
            } else {
                setCanceledResult("imageCapture capture Error")
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q || getPermissionsList(this).isNotEmpty()) {
                getPermission()
            } else {
                launchCamera()
            }
        } else {
            launchCamera()
        }
    }

    private fun launchCamera() {
        imageFileUri = if (mImageCaptureConfig != null) {
            imageFile = createMediaFileFolder(
                folderFile = mImageCaptureConfig!!.mFolder ?: defaultFolder(),
                fileName = mImageCaptureConfig!!.fileName ?: Const.DefaultPaths.defaultImageFile(),
            )
            createFileGetUri(imageFile!!)
        } else {
            imageFile = createMediaFileFolder(
                folderFile = defaultFolder(),
                fileName = Const.DefaultPaths.defaultImageFile(),
            )
            createFileGetUri(imageFile!!)
        }
        imageFileUri?.let {
            imageCapture.launch(
                getImageCaptureIntent(
                    it,
                    mImageCaptureConfig?.isUseRearCamera ?: true
                )
            )
        }
    }

    private fun showAskDialog() {
        showMyDialog(
            mImageCaptureConfig?.askPermissionTitle ?: "Permission Denied",
            mImageCaptureConfig?.askPermissionMessage ?: "Please allow ${getPermissionsListString()} permission for capture image/video.",
            negativeClick = {
                setCanceledResult("Permission not allowed")
            },
            positiveClick = {
                getPermission()
            },
        )
    }

    private fun getPermissionsListString(): String {
        val listString = getPermissionsList(this).map {
            it.split(".").lastOrNull() ?: ""
        }.toString()
        return listString.substring(1, listString.length - 1).replace(",", " and ")
    }

    private fun showGotoSettingDialog() {
        showMyDialog(
            mImageCaptureConfig?.settingPermissionTitle
                ?: "Permission Denied",
            mImageCaptureConfig?.settingPermissionMessage ?: "${getPermissionsListString()} permission is not granted. Please allow it from setting.",
            positiveButtonText = "Go To Setting",
            negativeClick = {
                setCanceledResult("Permission not allowed")
            },
            positiveClick = {
                settingCameraResultLauncher.launch(getSettingIntent())
            },
        )
    }

    private val settingCameraResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val allGranted = getPermissionsList(this).all { permission ->
                ContextCompat.checkSelfPermission(
                    this,
                    permission,
                ) == PackageManager.PERMISSION_GRANTED
            }
            if (allGranted) {
                launchCamera()
            } else {
                setCanceledResult("Permission not allowed")
            }
        }

    companion object {
        @Keep
        private fun getPermissionsList(context: Context) = ArrayList<String>().also {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                it.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
            val info: PackageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.PackageInfoFlags.of(PackageManager.GET_PERMISSIONS.toLong()),
                )
            } else {
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_PERMISSIONS,
                )
            }
            val permissions = info.requestedPermissions
            if(permissions != null) {
                if (permissions.contains(Manifest.permission.CAMERA)) {
                    it.add(Manifest.permission.CAMERA)
                }
            }
        }

        @Keep
        fun getInstance(mContext: Context, mImageCaptureConfig: ImageCaptureConfig?): Intent {
            val filePickerIntent = Intent(mContext, ImageCaptureActivity::class.java)
            mImageCaptureConfig?.let {
                filePickerIntent.putExtra(Const.BundleInternalExtras.IMAGE_CAPTURE, it)
            }
            return filePickerIntent
        }
    }
}
