package com.architect.kmpessentials.appInfo

import android.content.res.Configuration
import com.architect.kmpessentials.KmpAndroid

actual class KmpAppInfo {
    actual companion object {
        val packageInfo = KmpAndroid.applicationContext.packageManager.getPackageInfo(
            getPackageName(),
            0
        )
        actual fun getPackageName(): String {
            return KmpAndroid.applicationContext.packageName
        }

        actual fun getPackageVersion(): String {
            return packageInfo.versionName
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            if (KmpAndroid.applicationContext.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
                return AppDeviceTheme.Dark
            }
            return AppDeviceTheme.Light
        }

        actual fun getPackageVersionCode(): Int {
            return KmpAndroid.applicationContext.packageManager.getPackageInfo(getPackageName(), 0).versionCode
        }

        actual fun getPackageMinOS(): Int {
            return packageInfo.applicationInfo.targetSdkVersion
        }
    }
}

