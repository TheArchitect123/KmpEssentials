package com.architect.kmpessentials.secureStorage

import android.app.Application
import com.architect.kmpessentials.KmpAndroid
import com.liftric.kvault.KVault

actual class KmpSecureStorage {
    actual companion object {
        private var droidPreferenceName: String? = null
        private val keyVault by lazy {
            KVault(KmpAndroid.applicationContext!!, droidPreferenceName)
        }

        actual fun clearEntireStore() {
            keyVault.clear()
        }

        actual fun deleteDataForKey(key: String) {
            keyVault.deleteObject(key)
        }

        actual fun <TData> persistData(key: String, item: TData) {
            when (item) {
                is Float -> keyVault.set(key, item)
                is Double -> keyVault.set(key, item)
                is Boolean -> keyVault.set(key, item)
                is String -> keyVault.set(key, item)
                is Long -> keyVault.set(key, item)
                is Int -> keyVault.set(key, item)
            }
        }

        actual fun getStringFromKey(key: String): String? {
            return keyVault.string(key)
        }

        actual fun getIntFromKey(key: String): Int? {
            return keyVault.int(key)
        }

        actual fun getLongFromKey(key: String): Long? {
            return keyVault.long(key)
        }

        actual fun getFloatFromKey(key: String): Float? {
            return keyVault.float(key)
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            return keyVault.bool(key)
        }

        actual fun getDoubleFromKey(key: String): Double? {
            return keyVault.double(key)
        }

        fun configureDroidPreferenceFileName(preferenceFileName: String) {
            droidPreferenceName = preferenceFileName
        }
    }
}

