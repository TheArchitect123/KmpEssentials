package com.architect.kmpessentials.appInfo

actual class KmpAppInfo {
    actual companion object {
        actual fun getPackageName(): String {
            return ""
        }

        actual fun getPackageVersion(): String {
            return ""
        }

        actual fun getPackageBuild(): String {
            return ""
        }

        actual fun getPackageMinor(): String {
            return ""
        }

        actual fun getAppTheme(): AppDeviceTheme {
            return AppDeviceTheme.Dark
        }
    }
}

