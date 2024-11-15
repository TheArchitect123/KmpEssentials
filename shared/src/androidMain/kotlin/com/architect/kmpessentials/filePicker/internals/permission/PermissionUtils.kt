package com.architect.kmpessentials.filePicker.internals.permission

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity

object PermissionUtils {
    @Keep
    fun <I, O> AppCompatActivity.checkPermission(
        contract: ActivityResultContract<I, O>,
        resultCallBack: (result: O) -> Unit,
    ): ActivityResultLauncher<I> {
        return registerForActivityResult(contract) { result ->
            resultCallBack(result)
        }
    }
}
