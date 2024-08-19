package com.architect.kmpessentials.appInfo

/**
 * Use this for fetching information about your app (Package Name, Version, Configured App Theme, etc)
 * */
expect class KmpAppInfo {
    companion object{

        fun getPackageName(): String
        fun getPackageVersion(): String
        fun getPackageVersionCode(): Int
        fun getPackageMinOS(): Int
        fun getSystemThemeMode(): AppDeviceTheme
    }
}

