package com.architect.kmpessentials.biometrics

import android.media.FaceDetector
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission
import com.architect.kmpessentials.permissions.services.KmpPermissions
import java.util.concurrent.Executor

actual class KmpBiometrics {
    actual companion object {
        private lateinit var executor: Executor
        private lateinit var biometricPrompt: BiometricPrompt
        private lateinit var promptInfo: BiometricPrompt.PromptInfo
        private var fingerprintTitle = "Scan your fingerprint"
        private var fingerprintMessage = "Log in using your biometric credential"

        private val biometric = BiometricManager.from(KmpAndroid.clientAppContext)

        actual fun isSupported(): Boolean {
            return biometric.canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_STRONG
                        or BiometricManager.Authenticators.DEVICE_CREDENTIAL
            ) == BiometricManager.BIOMETRIC_SUCCESS
        }

        actual fun setPromptInfo(title: String, message: String) {
            fingerprintTitle = title
            fingerprintMessage = message
        }

        actual fun scanBiometrics(
            actionResult: ActionBoolParams,
            actionError: ActionStringParams
        ) {
            KmpPermissionsManager.isPermissionGranted(Permission.Biometrics) {
                if (it) {
                    KmpMainThread.runViaMainThread {
                        executor = ContextCompat.getMainExecutor(KmpAndroid.clientAppContext)
                        biometricPrompt = BiometricPrompt(KmpAndroid.clientAppContext, executor,
                            object : BiometricPrompt.AuthenticationCallback() {
                                override fun onAuthenticationError(
                                    errorCode: Int,
                                    errString: CharSequence
                                ) {
                                    super.onAuthenticationError(errorCode, errString)
                                    actionError(errString.toString())
                                }

                                override fun onAuthenticationSucceeded(
                                    result: BiometricPrompt.AuthenticationResult
                                ) {
                                    super.onAuthenticationSucceeded(result)
                                    actionResult(true)
                                }

                                override fun onAuthenticationFailed() {
                                    super.onAuthenticationFailed()
                                    actionError("Failed to authenticate")
                                }
                            })

                        promptInfo = BiometricPrompt.PromptInfo.Builder()
                            .setTitle(fingerprintTitle)
                            .setSubtitle(fingerprintMessage)
                            .setNegativeButtonText("Use password")
                            .build()

                        biometricPrompt.authenticate(promptInfo)
                    }
                } else {
                    KmpLogging.writeErrorWithCode(ErrorCodes.MISSING_PERMISSION_CONFIGURATION)
                }
            }
        }
    }
}