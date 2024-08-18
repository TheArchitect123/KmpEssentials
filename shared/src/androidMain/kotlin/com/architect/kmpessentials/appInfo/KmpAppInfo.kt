package com.architect.kmpessentials.appInfo

import android.content.res.Configuration
import com.architect.kmpessentials.KmpAndroid

actual class KmpAppInfo {
    actual companion object {
        val packageInfo = KmpAndroid.clientAppContext.packageManager.getPackageInfo(
            getPackageName(),
            0
        )
        actual fun getPackageName(): String {
            return KmpAndroid.clientAppContext.packageName
        }

        actual fun getPackageVersion(): String {
            return packageInfo.versionName
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            if (KmpAndroid.clientAppContext.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
                return AppDeviceTheme.Dark
            }
            return AppDeviceTheme.Light
        }

        actual fun getPackageVersionCode(): Int {
            return KmpAndroid.clientAppContext.packageManager.getPackageInfo(getPackageName(), 0).versionCode
        }

        actual fun getPackageMinOS(): Int {
            return packageInfo.applicationInfo.targetSdkVersion
        }
    }
}

