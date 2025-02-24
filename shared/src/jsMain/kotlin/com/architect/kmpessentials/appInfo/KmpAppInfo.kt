package com.architect.kmpessentials.appInfo

import com.architect.kmpessentials.internal.ActionBoolParams
import kotlinx.browser.window

actual class KmpAppInfo {
    actual companion object {

        actual fun getPackageName(): String {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun isRunningInBackground(action: ActionBoolParams) {

        }

        actual fun getPackageVersion(): String {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun getPackageVersionCode(): Int {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun getPackageMinOS(): Int {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
                return AppDeviceTheme.Dark
            }

            return AppDeviceTheme.Light
        }
    }
}

