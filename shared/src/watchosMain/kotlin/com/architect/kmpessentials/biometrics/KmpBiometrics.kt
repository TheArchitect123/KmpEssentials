package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams

actual class KmpBiometrics {
    actual companion object {

        actual fun isSupported(): Boolean {
            return false
        }

        actual fun setPromptInfo(title: String, message: String) {

        }

        actual fun scanBiometrics(actionResult: ActionBoolParams, actionError: ActionStringParams) {

        }
    }
}