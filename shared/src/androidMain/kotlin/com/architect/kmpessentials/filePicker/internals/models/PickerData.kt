package com.architect.kmpessentials.filePicker.internals.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.parcelize.Parcelize
import java.io.File

@Keep
@Parcelize
data class PickerData(
    val mPopUpConfig: PopUpConfig? = null,
    val listIntents: List<BaseConfig> = emptyList(),
) : Parcelable

@Keep
@Parcelize
data class PopUpConfig(
    val chooserTitle: String? = null,
    @LayoutRes val layoutId: Int? = null,
    val mPopUpType: PopUpType? = null,
    @RecyclerView.Orientation val mOrientation: Int? = null,
) : Parcelable

@Parcelize
data class ImageCaptureConfig(
    @DrawableRes override val popUpIcon: Int? = null,
    override val popUpText: String? = null,
    val mFolder: File? = null,
    val fileName: String? = null,
    /**
     * It is not working correctly. However, it will Work on the same devices.
     */
    val isUseRearCamera: Boolean? = null,
    override val askPermissionTitle: String? = null,
    override val askPermissionMessage: String? = null,
    override val settingPermissionTitle: String? = null,
    override val settingPermissionMessage: String? = null,
) : Parcelable, BaseConfig(
    popUpIcon,
    popUpText,
    askPermissionTitle,
    askPermissionMessage,
    settingPermissionTitle,
    settingPermissionMessage,
)

@Parcelize
data class VideoCaptureConfig(
    @DrawableRes override val popUpIcon: Int? = null,
    override val popUpText: String? = null,
    val mFolder: File? = null,
    val fileName: String? = null,
    val maxSeconds: Int? = null,
    val maxSizeLimit: Long? = null,
    val isHighQuality: Boolean? = null,
    override val askPermissionTitle: String? = null,
    override val askPermissionMessage: String? = null,
    override val settingPermissionTitle: String? = null,
    override val settingPermissionMessage: String? = null,
) : Parcelable, BaseConfig(
    popUpIcon,
    popUpText,
    askPermissionTitle,
    askPermissionMessage,
    settingPermissionTitle,
    settingPermissionMessage,
)

@Parcelize
data class PickMediaConfig(
    @DrawableRes override val popUpIcon: Int? = null,
    override val popUpText: String? = null,
    val allowMultiple: Boolean? = null,
    /**
     *  MaxFiles work after SDK 33 or above versions
     */
    val maxFiles: Int? = null,
    val mPickMediaType: PickMediaType? = null,
    override val askPermissionTitle: String? = null,
    override val askPermissionMessage: String? = null,
    override val settingPermissionTitle: String? = null,
    override val settingPermissionMessage: String? = null,
) : Parcelable, BaseConfig(
    popUpIcon,
    popUpText,
    askPermissionTitle,
    askPermissionMessage,
    settingPermissionTitle,
    settingPermissionMessage,
) {
    fun getPickMediaType(input: PickMediaType?): String? {
        return when (input) {
            PickMediaType.ImageOnly -> "image/*"
            PickMediaType.VideoOnly -> "video/*"
            PickMediaType.ImageAndVideo -> null
            else -> null
        }
    }
}

@Parcelize
data class DocumentFilePickerConfig(
    @DrawableRes override val popUpIcon: Int? = null,
    override val popUpText: String? = null,
    val allowMultiple: Boolean? = null,
    /**
     *  MaxFiles work after SDK 33 or above versions
     */
    val maxFiles: Int? = null,
    val mMimeTypes: List<String>? = null,
    override val askPermissionTitle: String? = null,
    override val askPermissionMessage: String? = null,
    override val settingPermissionTitle: String? = null,
    override val settingPermissionMessage: String? = null,
) : Parcelable, BaseConfig(
    popUpIcon,
    popUpText,
    askPermissionTitle,
    askPermissionMessage,
    settingPermissionTitle,
    settingPermissionMessage,
)

@Keep
@Parcelize
enum class PopUpType : Parcelable {
    BOTTOM_SHEET, DIALOG;

    fun isDialog() = this == DIALOG
}

@Parcelize
enum class PickMediaType : Parcelable {
    ImageOnly, VideoOnly, ImageAndVideo
}
