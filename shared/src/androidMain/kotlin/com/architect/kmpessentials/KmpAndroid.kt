package com.architect.kmpessentials

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.battery.KmpBattery
import com.architect.kmpessentials.camera.KmpCamera
import com.architect.kmpessentials.filePicker.File
import com.architect.kmpessentials.filePicker.KmpFilePicker
import com.architect.kmpessentials.internals.FilePickingMode
import com.architect.kmpessentials.mediaPicker.KmpMediaPicker
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.nareshchocha.filepickerlibrary.utilities.appConst.Const

class KmpAndroid {
    companion object {
        private var hasRegistered: Boolean = false
        internal lateinit var applicationContext: Application
        internal lateinit var clientAppContext: FragmentActivity
        internal val sensorManagerObserver = SensorObserver()
        internal var guserDisabledPermission: DefaultAction? = null

        fun getCurrentActivityContext(): FragmentActivity {
            return clientAppContext
        }

        fun getCurrentApplicationContext(): Application {
            return applicationContext
        }

        fun preRegisterApplicationContext(appContext: Application) {
            if (!hasRegistered) {
                applicationContext = appContext
                if (Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) { // battery services require Lolliop and above to work
                    KmpBattery.initializeBatteryService()
                }

                applicationContext.registerActivityLifecycleCallbacks(ActivityLifecycleObserver())
                hasRegistered = true
            }
        }

        fun initializeApp(
            context: FragmentActivity,
            userDisabledPermission: DefaultAction? = null
        ) {
            clientAppContext = context
            guserDisabledPermission = userDisabledPermission

            // register application
            preRegisterApplicationContext(context.application)

            registerAllContracts()
        }

        private fun registerAllContracts() {
            // camera apis
            KmpCamera.resultLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    loadFileDataViaIntent(it, FilePickingMode.TakeDataFromCamera)
                }

            // image picker
            KmpMediaPicker.galleryLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    loadFileDataViaIntent(it, FilePickingMode.PickMediaFromGallery)
                }

            // permission manager
            KmpPermissionsManager.resultLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                    if (result) {
                        KmpPermissionsManager.successAction()
                    } else {
                        // permission has not been enabled
                        guserDisabledPermission?.invoke()
                    }
                }

            KmpPermissionsManager.resultManyLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
                    if (result.values.any { !it }) { // all permissions must be enabled for this to work
                        guserDisabledPermission?.invoke()
                    } else {
                        KmpPermissionsManager.successAction()
                    }
                }

            // file picker
            KmpFilePicker.resultLauncher =
                clientAppContext.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    loadFileDataViaIntent(it, FilePickingMode.PickFileFromFileSystem)
                }
        }

        private fun loadFileDataViaIntent(
            it: ActivityResult,
            mode: FilePickingMode
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val singlePath = it.data!!.getStringExtra(Const.BundleExtras.FILE_PATH)
                if (singlePath != null) {
                    val singleFile =
                        java.io.File(singlePath)

                    val pickedFile = File(
                        name = singleFile.name,
                        absolutePath = singleFile.absolutePath,
                        createdISO = "",
                        isProtected = singleFile.isHidden,
                        modifiedISO = ""
                    )
                    when (mode) {
                        FilePickingMode.PickFileFromFileSystem -> {
                            KmpFilePicker.actionResultSingleFile(
                                pickedFile
                            )
                        }

                        FilePickingMode.PickMediaFromGallery -> {
                            KmpMediaPicker.imagePickerResult(
                                pickedFile.absolutePath
                            )
                        }

                        FilePickingMode.TakeDataFromCamera -> {
                            KmpCamera.actionResult(
                                pickedFile.absolutePath
                            )
                        }
                    }
                } else {
                    if (mode == FilePickingMode.PickFileFromFileSystem) {
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

                        KmpFilePicker.actionResultManyFiles(
                            filePaths
                        )
                    }
                }
            }
        }
    }
}