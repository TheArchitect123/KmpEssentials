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
            return window.navigator.appName
        }

        actual fun getPackageVersionCode(): Int {
            return 0
        }

        actual fun getPackageMinOS(): Int {
            return 1
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
                return AppDeviceTheme.Dark
            }

            return AppDeviceTheme.Light
        }
    }
}

