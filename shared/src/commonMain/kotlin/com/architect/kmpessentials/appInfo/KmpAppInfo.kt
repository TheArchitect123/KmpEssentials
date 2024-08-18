package com.architect.kmpessentials.appInfo

expect class KmpAppInfo {
    companion object{
        fun getPackageName(): String
        fun getPackageVersion(): String
        fun getPackageVersionCode(): Int
        fun getPackageMinOS(): Int
        fun getSystemThemeMode(): AppDeviceTheme
    }
}

