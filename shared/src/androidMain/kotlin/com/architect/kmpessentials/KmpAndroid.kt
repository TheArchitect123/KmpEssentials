package com.architect.kmpessentials

import android.R.attr.data
import android.app.Activity
import android.app.Application
import android.graphics.Bitmap
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.battery.KmpBattery
import com.architect.kmpessentials.camera.KmpCamera
import com.architect.kmpessentials.filePicker.File
import com.architect.kmpessentials.filePicker.KmpFilePicker
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.nareshchocha.filepickerlibrary.utilities.appConst.Const


class KmpAndroid {
    companion object {
        internal var hasRegistered: Boolean = false
        internal lateinit var applicationContext: Application

        internal lateinit var clientAppContext: AppCompatActivity
        internal val sensorManagerObserver = SensorObserver()

        fun initializeApp(
            context: AppCompatActivity,
            userDisabledPermission: DefaultAction? = null
        ) {
            clientAppContext = context

            context.lifecycle.addObserver(sensorManagerObserver)
            if (!hasRegistered) {
                applicationContext = clientAppContext.application
                if (Build.VERSION.SDK_INT == VERSION_CODES.LOLLIPOP) { // battery services require Lolliop and above to work
                    KmpBattery.initializeBatteryService()
                }

                hasRegistered = true
            }

            // permission manager
            KmpPermissionsManager.resultLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                    if (result) {
                        KmpPermissionsManager.successAction()
                    } else {
                        // permission has not been enabled
                        userDisabledPermission?.invoke()
                    }
                }

            KmpPermissionsManager.resultManyLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
                    if (result.values.any { !it }) { // all permissions must be enabled for this to work
                        userDisabledPermission?.invoke()
                    } else {
                        KmpPermissionsManager.successAction()
                    }
                }

            // file picker
            clientAppContext.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    // check if intent is a photo
                    if (it.data?.action == MediaStore.ACTION_IMAGE_CAPTURE) {
                        // Handle the image taken from the camera
                        val extras = it.data?.extras
                        if (extras != null) {
                            val imageBitmap = extras["data"] as? Bitmap?
                            val mediaStore = MediaStore.Images.Media.insertImage( // adds the image from the camera to the store, then returns result
                                KmpAndroid.clientAppContext.contentResolver,
                                imageBitmap,
                                "",
                                ""
                            )

                            KmpCamera.actionResult(mediaStore)
                        }
                    } else {
                        // Use the uri to load the image
                        val singlePath = it.data!!.getStringExtra(Const.BundleExtras.FILE_PATH)
                        if (singlePath != null) {
                            val singleFile =
                                java.io.File(singlePath)
                            KmpFilePicker.actionResultSingleFile(
                                File(
                                    name = singleFile.name,
                                    absolutePath = singleFile.absolutePath,
                                    createdISO = "",
                                    isProtected = singleFile.isHidden,
                                    modifiedISO = ""
                                )
                            )
                        } else {
                            val filePaths =
                                it.data?.getStringArrayListExtra(Const.BundleExtras.FILE_PATH_LIST)
                                    ?.map { file ->
                                        val singleFile =
                                            java.io.File(file)
                                        File(
                                            name = singleFile.name,
                                            absolutePath = singleFile.absolutePath,
                                            createdISO = "",
                                            isProtected = singleFile.isHidden,
                                            modifiedISO = ""
                                        )
                                    }

                            KmpFilePicker.actionResultManyFiles(filePaths)
                        }
                    }
                }
            }
        }
    }
}



