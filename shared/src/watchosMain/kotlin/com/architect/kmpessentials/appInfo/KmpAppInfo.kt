package com.architect.kmpessentials.appInfo

import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn
import com.architect.kmpessentials.internal.ActionBoolParams
import platform.Foundation.NSBundle

actual class KmpAppInfo {
    actual companion object {

        actual fun getPackageName(): String {
            return NSBundle.mainBundle.infoDictionary?.getValue("CFBundleName") as? String ?: ""
        }

        actual fun isRunningInBackground(action: ActionBoolParams){

        }

        actual fun getPackageVersion(): String {
            return NSBundle.mainBundle.infoDictionary?.getValue("CFBundleShortVersionString") as? String
                ?: ""
        }

        actual fun getPackageVersionCode(): Int {
            return (NSBundle.mainBundle.infoDictionary?.getValue("CFBundleVersion") as? String
                ?: "1").toInt()
        }

        actual fun getPackageMinOS(): Int {
            return 13
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            return AppDeviceTheme.Dark
        }
    }
}

