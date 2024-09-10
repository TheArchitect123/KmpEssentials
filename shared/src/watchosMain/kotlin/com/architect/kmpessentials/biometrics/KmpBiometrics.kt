package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpBiometrics {
    actual companion object {

        actual fun isSupported(): Boolean {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun setPromptInfo(title: String, message: String) {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun scanBiometrics(actionResult: ActionBoolParams, actionError: ActionStringParams) {
            TODO("NOT IMPLEMENTED YET")
        }
    }
}