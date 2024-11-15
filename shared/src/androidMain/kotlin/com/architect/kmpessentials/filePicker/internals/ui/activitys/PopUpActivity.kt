package com.architect.kmpessentials.filePicker.internals.ui.activitys

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.kmpessentials.filePicker.internals.models.BaseConfig
import com.architect.kmpessentials.filePicker.internals.models.DocumentFilePickerConfig
import com.architect.kmpessentials.filePicker.internals.models.ImageCaptureConfig
import com.architect.kmpessentials.filePicker.internals.models.PickMediaConfig
import com.architect.kmpessentials.filePicker.internals.models.PickerData
import com.architect.kmpessentials.filePicker.internals.models.VideoCaptureConfig
import com.architect.kmpessentials.filePicker.internals.ui.FilePicker
import com.architect.kmpessentials.filePicker.internals.ui.adapter.PopUpAdapter
import com.architect.kmpessentials.filePicker.internals.utilities.appConst.Const
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.setCanceledResult
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.github.thearchitect123.R
import io.github.thearchitect123.databinding.ActivityPopUpBinding

internal class PopUpActivity : AppCompatActivity() {
    private val binding: ActivityPopUpBinding by lazy {
        ActivityPopUpBinding.inflate(layoutInflater)
    }
    private val mPickerData: PickerData? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                Const.BundleInternalExtras.PICKER_DATA,
                PickerData::class.java,
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Const.BundleInternalExtras.PICKER_DATA) as PickerData?
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        binding.tbToolbar.title = if (!mPickerData?.mPopUpConfig?.chooserTitle.isNullOrEmpty()) {
            mPickerData?.mPopUpConfig?.chooserTitle
        } else {
            "Choose option"
        }
        if (mPickerData?.mPopUpConfig?.mPopUpType?.isDialog() == true) {
            binding.root.radius = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                Const.CARD_RADIUS,
                resources.displayMetrics,
            )
            setContentView(binding.root)
        } else {
            showBottomSheetDialog()
        }
    }

    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(
            this,
            mPickerData?.mPopUpConfig?.mOrientation ?: RecyclerView.VERTICAL,
            false,
        )
        val popUpAdapter = PopUpAdapter(
            mPickerData?.mPopUpConfig?.layoutId ?: R.layout.item_pop_up,
            items = getAdapterItemList(),
            itemClicked = { item, _ ->
                mBottomSheet.dismiss()
                when (item) {
                    is ImageCaptureConfig -> {
                        intentResultLauncher.launch(
                            FilePicker.Builder(this).imageCaptureBuild(item),
                        )
                    }

                    is VideoCaptureConfig -> {
                        intentResultLauncher.launch(
                            FilePicker.Builder(this).videoCaptureBuild(item),

                        )
                    }

                    is PickMediaConfig -> {
                        intentResultLauncher.launch(
                            FilePicker.Builder(this).pickMediaBuild(item),

                        )
                    }

                    is DocumentFilePickerConfig -> {
                        intentResultLauncher.launch(
                            FilePicker.Builder(this).pickDocumentFileBuild(item),
                        )
                    }
                }
            },
        )
        binding.rvItems.layoutManager = linearLayoutManager
        binding.rvItems.adapter = popUpAdapter
    }

    private fun getAdapterItemList(): List<BaseConfig> {
        return mPickerData?.listIntents ?: emptyList()
    }

    private val mBottomSheet: BottomSheetDialog by lazy {
        BottomSheetDialog(this, R.style.Theme_FilePicker_BottomSheetDialog).apply {

            setContentView(binding.root)
            setOnCancelListener {
                setCanceledResult()
            }
        }
    }

    private fun showBottomSheetDialog() {
        mBottomSheet.window?.setBackgroundDrawable(
            AppCompatResources.getDrawable(
                this,
                R.drawable.transparent,
            ),
        )
        mBottomSheet.show()
    }

    private val intentResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            setResult(result.resultCode, result.data)
            finish()
        }

    companion object {
        fun getInstance(mContext: Context, mPickerData: PickerData?): Intent {
            val filePickerIntent = Intent(mContext, PopUpActivity::class.java)
            mPickerData?.let {
                filePickerIntent.putExtra(Const.BundleInternalExtras.PICKER_DATA, it)
            }
            filePickerIntent.flags = Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION
            return filePickerIntent
        }
    }
}
