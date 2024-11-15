package com.architect.kmpessentials.filePicker.internals.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep()
@Parcelize
open class BaseConfig(
    open val popUpIcon: Int?,
    open val popUpText: String?,
    open val askPermissionTitle: String?,
    open val askPermissionMessage: String?,
    open val settingPermissionTitle: String?,
    open val settingPermissionMessage: String?,
) : Parcelable
