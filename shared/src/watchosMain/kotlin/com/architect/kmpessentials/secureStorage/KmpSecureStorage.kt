package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.secureStorage.internals.KeychainManager

actual class KmpSecureStorage {
    actual companion object {
        private lateinit var keyVault: KeychainManager
        actual fun clearEntireStore() {
            keyVault.clear()
        }

        actual fun deleteDataForKey(key: String) {
            keyVault.deleteObject(key)
        }

        actual suspend fun getLongFromKeyAsync(key: String, action: ActionLongNullParams) {
            action(getLongFromKey(key))
        }

        actual suspend fun getStringFromKeyAsync(key: String, action: ActionStringNullParams) {
            action(getStringFromKey(key))
        }

        actual suspend fun getIntFromKeyAsync(key: String, action: ActionIntNullParams) {
            action(getIntFromKey(key))
        }

        actual suspend fun getFloatFromKeyAsync(key: String, action: ActionFloatNullParams) {
            action(getFloatFromKey(key))
        }

        actual suspend fun getDoubleFromKeyAsync(key: String, action: ActionDoubleNullParams) {
            action(getDoubleFromKey(key))
        }

        actual suspend fun getBooleanFromKeyAsync(key: String, action: ActionBoolNullParams) {
            action(getBooleanFromKey(key))
        }

        actual fun <TData> persistData(key: String, item: TData) {
            when (item) {
                is Float -> keyVault.set(key, item)
                is Double -> keyVault.set(key, item)
                is Boolean -> keyVault.set(key, item)
                is String -> keyVault.set(key, item)
                is Int -> keyVault.set(key, item)
            }
        }

        actual fun getStringFromKey(key: String): String? {
            return keyVault.string(key)
        }

        actual fun getIntFromKey(key: String): Int? {
            return keyVault.int(key)
        }

        actual fun getFloatFromKey(key: String): Float? {
            return keyVault.float(key)
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            return keyVault.bool(key)
        }

        actual fun getLongFromKey(key: String): Long? {
            return keyVault.long(key)
        }

        actual fun getDoubleFromKey(key: String): Double? {
            return keyVault.double(key)
        }

        fun configureSecurityForWatchOS(serviceName: String, accessGroup: String) {
            keyVault = KeychainManager(serviceName, accessGroup)
        }
    }
}

