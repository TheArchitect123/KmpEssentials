package com.architect.kmpessentials.secureStorage

import android.content.Context
import com.architect.kmpessentials.KmpAndroid

actual class KmpSecureStorage {
    actual companion object {
        private var sharedPreferences =
            KmpAndroid.clientAppContext.getPreferences(Context.MODE_PRIVATE)

        actual fun clearEntireStore() {
            sharedPreferences.edit().clear().apply()
        }

        actual fun deleteDataForKey(key: String) {
            sharedPreferences.edit().remove(key).apply()
        }

        actual fun <TData> persistData(key: String, item: TData) {
            when (item) {
                is Float -> sharedPreferences.edit().putFloat(key, item).apply()
                is Boolean -> sharedPreferences.edit().putBoolean(key, item).apply()
                is String -> sharedPreferences.edit().putString(key, item).apply()
                is Int -> sharedPreferences.edit().putInt(key, item).apply()
            }
        }

        actual fun getStringFromKey(key: String): String {
            return sharedPreferences.getString(key, "") ?: ""
        }

        actual fun getIntFromKey(key: String): Int {
            return sharedPreferences.getInt(key, 0)
        }

        actual fun getFloatFromKey(key: String): Float {
            return sharedPreferences.getFloat(key, 0f)
        }

        actual fun getBooleanFromKey(key: String): Boolean {
            return sharedPreferences.getBoolean(key, false)
        }

        actual fun configureSecurity(isPrivate: Boolean) {
            if (!isPrivate) {
                sharedPreferences = KmpAndroid.clientAppContext.getPreferences(Context.MODE_PRIVATE)
            }
        }
    }
}