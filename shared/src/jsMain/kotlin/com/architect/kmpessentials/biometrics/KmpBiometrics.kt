package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams
import kotlinx.browser.window
import org.khronos.webgl.Uint8Array

actual class KmpBiometrics {
    actual companion object {

        fun generateWebAuthnChallenge(): Uint8Array {
            val randomBytes = ByteArray(16) // 16-byte challenge
            window.asDynamic().crypto.getRandomValues(randomBytes)
            return Uint8Array(randomBytes.toTypedArray())
        }

        actual fun isSupported(): Boolean {
            return window.navigator.asDynamic().credentials?.get != undefined
        }

        actual fun setPromptInfo(title: String, message: String) {

        }

        actual fun scanBiometrics(actionResult: ActionBoolParams, actionError: ActionStringParams) {
            if (!isSupported()) {
                actionError("Biometric Auth is not supported on ${window.navigator.appName}")
                actionResult(false)
                return
            }

            val options = js("{}")

            // Create a publicKey object dynamically
            val publicKey = js("{}")
            publicKey.challenge = generateWebAuthnChallenge()
            publicKey.timeout = 60000
            publicKey.userVerification = "required"

            options.publicKey = publicKey

            window.navigator.asDynamic().credentials.get(options)
                .then { result ->
                    actionResult(true)
                }
                .catch { error ->
                    actionResult(false)
                    actionError("Biometric authentication failed: ${error.message}")
                }
        }
    }
}