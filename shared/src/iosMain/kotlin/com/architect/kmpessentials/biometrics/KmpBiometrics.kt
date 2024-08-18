package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.LocalAuthentication.LAContext
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthenticationWithBiometrics

actual class KmpBiometrics {
    actual companion object {
        private var fingerprintTitle = "Scan your fingerprint"
        private var fingerprintMessage = "Log in using your biometric credential"

        actual fun isSupported(): Boolean {
            return true
        }

        actual fun setPromptInfo(title: String, message: String) {
            fingerprintTitle = title
            fingerprintMessage = message
        }

        actual fun scanFingerprint(
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