package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.KmpAndroid
import com.liftric.kvault.KVault

actual class KmpSecureStorage {
    actual companion object {
        private val keyVault: KVault = KVault(KmpAndroid.applicationContext)
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
            }
        }

        actual fun getStringFromKey(key: String): String {
            return keyVault.string(key) ?: ""
        }

        actual fun getIntFromKey(key: String): Int {
            return keyVault.int(key) ?: 0
        }

        actual fun getFloatFromKey(key: String): Float {
            return keyVault.float(key) ?: 0f
        }

        actual fun getBooleanFromKey(key: String): Boolean {
            return keyVault.bool(key) ?: false
        }

        actual fun configureSecurityForiOS(serviceName: String, accessGroup: String) {
            TODO("This method is only used for iOS. DO NOT USE FOR ANDROID")
        }

    }
}

