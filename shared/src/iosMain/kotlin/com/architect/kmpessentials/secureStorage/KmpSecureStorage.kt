package com.architect.kmpessentials.secureStorage

import com.liftric.kvault.KVault

actual class KmpSecureStorage {
    actual companion object {
        private lateinit var keyVault: KVault
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

        actual fun getLongFromKey(key: String): Long {
            return keyVault.long(key) ?: 0
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

        fun configureSecurityForiOS(serviceName: String, accessGroup: String) {
            keyVault = KVault(serviceName, accessGroup)
        }

    }
}

