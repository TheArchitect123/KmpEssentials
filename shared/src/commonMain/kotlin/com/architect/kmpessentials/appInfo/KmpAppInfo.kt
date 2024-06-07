package com.architect.kmpessentials.appInfo

expect class KmpAppInfo {

    companion object{
        fun getPackageName(): String
        fun getPackageVersion(): String
        fun getPackageBuild(): String
        fun getPackageMinor(): String
        fun getAppTheme(): AppDeviceTheme
    }

}

