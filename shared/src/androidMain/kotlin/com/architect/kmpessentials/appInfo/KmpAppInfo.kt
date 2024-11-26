package com.architect.kmpessentials.appInfo

import android.content.res.Configuration
import androidx.lifecycle.ProcessLifecycleOwner
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.aliases.DefaultActionWithBooleanReturn
import com.architect.kmpessentials.internal.ActionBoolParams

actual class KmpAppInfo {
    actual companion object {
        val packageInfo by lazy {
            KmpAndroid.applicationContext?.packageManager?.getPackageInfo(
                getPackageName(),
                0
            )
        }

        actual fun getPackageName(): String {
            return KmpAndroid.applicationContext?.packageName ?: ""
        }

        actual fun isRunningInBackground(action: ActionBoolParams) {
            val appLifecycle = ProcessLifecycleOwner.get().lifecycle
            action(
                appLifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)
                    .not()
            )
        }

        actual fun getPackageVersion(): String {
            return packageInfo?.versionName ?: ""
        }

        actual fun getSystemThemeMode(): AppDeviceTheme {
            if (KmpAndroid.applicationContext?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
                return AppDeviceTheme.Dark
            }
            return AppDeviceTheme.Light
        }

        actual fun getPackageVersionCode(): Int {
            return KmpAndroid.applicationContext?.packageManager?.getPackageInfo(
                getPackageName(),
                0
            )?.versionCode ?: 0
        }

        actual fun getPackageMinOS(): Int {
            return packageInfo?.applicationInfo?.targetSdkVersion ?: 21
        }
    }
}

