package com.architect.kmpessentials.appInfo

actual class KmpAppInfo {
    actual companion object {

        actual fun getPackageName(): String {
            TODO("NOT IMPLEMENTED YET")
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
            return AppDeviceTheme.System
        }
    }
}

