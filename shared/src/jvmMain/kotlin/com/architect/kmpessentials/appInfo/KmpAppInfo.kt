package com.architect.kmpessentials.appInfo

import java.util.Locale

actual class KmpAppInfo {
    actual companion object {

        /// need to figure out how these apis will work if each platform has its own way of managing manifest files
        actual fun getPackageName(): String {
            return ""
        }

        actual fun getPackageVersion(): String {
            return ""
        }

        actual fun getPackageVersionCode(): Int {
            return 0
        }

        actual fun getPackageMinOS(): Int {
            TODO("NOT IMPLEMENTED YET")
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            val theme = System.getProperty("sun.desktop.theme", "").lowercase(Locale.getDefault())
            return if (theme.contains("dark")) AppDeviceTheme.Dark else AppDeviceTheme.Light
        }
    }
}

