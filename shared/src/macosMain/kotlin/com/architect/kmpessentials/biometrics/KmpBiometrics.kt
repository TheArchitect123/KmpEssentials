package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.LocalAuthentication.LAContext
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthenticationWithBiometrics

actual class KmpBiometrics {
    actual companion object {
        private var fingerprintMessage = "Log in using your biometric credential"

        @OptIn(ExperimentalForeignApi::class)
        actual fun isSupported(): Boolean {
            return LAContext().canEvaluatePolicy(
                LAPolicyDeviceOwnerAuthenticationWithBiometrics,
                null
            )
        }

        actual fun setPromptInfo(title: String, message: String) {
            fingerprintMessage = message
        }

        actual fun scanBiometrics(
            actionResult: ActionBoolParams,
            actionError: ActionStringParams
        ) {
            KmpMainThread.runViaMainThread {
                val context = LAContext()
                context.evaluatePolicy(
                    LAPolicyDeviceOwnerAuthenticationWithBiometrics,
                    fingerprintMessage
                ) { result, error ->
                    if (error == null) {
                        actionResult(result)
                    } else {
                        actionError(error.localizedDescription)
                    }
                }
            }
        }
    }
}