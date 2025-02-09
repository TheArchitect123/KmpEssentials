package com.architect.kmpessentials.appInfo

import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn
import com.architect.kmpessentials.internal.ActionBoolParams
import java.util.Locale

actual class KmpAppInfo {
    actual companion object {

        /// need to figure out how these apis will work if each platform has its own way of managing manifest files
        actual fun getPackageName(): String {
            val stackTrace = Thread.currentThread().stackTrace
            for (element in stackTrace) {
                val className = element.className
                // Skip internal JVM classes and your own library package
                if (!className.startsWith("java.") && !className.startsWith("kotlin.") &&
                    !className.startsWith("com.architect.kmpessentials")) {
                    return className.substringBeforeLast('.')
                }
            }

            return ""
        }

        actual fun isRunningInBackground(action: ActionBoolParams){

        }

        actual fun getPackageVersion(): String {
            return ""
        }

        actual fun getPackageVersionCode(): Int {
            return 0
        }

        actual fun getPackageMinOS(): Int {
            return 0
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            val theme = System.getProperty("sun.desktop.theme", "").lowercase(Locale.getDefault())
            return if (theme.contains("dark")) AppDeviceTheme.Dark else AppDeviceTheme.Light
        }
    }
}

