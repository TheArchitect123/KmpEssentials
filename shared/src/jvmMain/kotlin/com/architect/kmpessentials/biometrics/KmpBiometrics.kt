package com.architect.kmpessentials.biometrics

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.internal.ActionBoolParams
import com.architect.kmpessentials.internal.ActionStringParams

import com.sun.jna.platform.win32.Win32Exception

//import com.sun.jna.platform.win32.Wincred.*

actual class KmpBiometrics {
    actual companion object {

        actual fun isSupported(): Boolean {
            return when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> try {
                    val process = ProcessBuilder(
                        "wmic",
                        "path",
                        "Win32_PnPEntity",
                        "where",
                        "Description like '%Fingerprint%'",
                        "get",
                        "Description"
                    )
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText().trim()
                    output.contains("Fingerprint", ignoreCase = true)
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }

                DevicePlatform.MacOS -> try {
                    val process = ProcessBuilder("bioutil", "-r")
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText().trim()
                    output.contains("Touch ID enrolled", ignoreCase = true)
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }

                else -> try {
                    val process = ProcessBuilder("lsusb")
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText().trim()
                    output.contains(
                        "Fingerprint",
                        ignoreCase = true
                    ) || output.contains("AuthenTec", ignoreCase = true)
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }
        }

        actual fun setPromptInfo(title: String, message: String) {

        }

        actual fun scanBiometrics(actionResult: ActionBoolParams, actionError: ActionStringParams) {
            when (KmpDeviceInfo.getRunningPlatform()) {
//                DevicePlatform.Windows -> try {
//                    val credUI = CREDENTIAL_UI_INFO()
//                    credUI.cbSize = credUI.size()
//                    val authResult = CredUIPromptForWindowsCredentials(
//                        credUI,
//                        0,
//                        0,
//                        null,
//                        0,
//                        null,
//                        null,
//                        false,
//                        0
//                    )
//                    actionResult(authResult == 0)
//                } catch (e: Win32Exception) {
//                    actionError(e.stackTraceToString())
//                }

                //DevicePlatform.MacOS -> getCurrentStateForMacOS()
                else -> try {
                    val process = ProcessBuilder("fprintd-verify")
                        .redirectErrorStream(true)
                        .start()

                    val output = process.inputStream.bufferedReader().readText()
                    actionResult(output.contains("Verify complete"))
                } catch (e: Exception) {
                    actionError(e.stackTraceToString())
                }
            }
        }
    }
}