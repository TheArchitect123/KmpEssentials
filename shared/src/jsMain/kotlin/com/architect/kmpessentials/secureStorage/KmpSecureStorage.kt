package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import com.architect.kmpessentials.secureStorage.helpers.DatabaseHelpers
import com.architect.kmpessentials.secureStorage.helpers.SecurityHelpers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// uses the built in web crypto api for secure storage
actual class KmpSecureStorage {
    actual companion object {
        fun setEncryptionKey(encryptionKey: String) {
            SecurityHelpers.encryptionKey = SecurityHelpers.generateKeyFromString(encryptionKey)
        }

        actual fun clearEntireStore() {
            DatabaseHelpers.getDatabase().then { database ->
                val transaction = database.transaction(DatabaseHelpers.STORE_NAME, "readwrite")
                val store = transaction.objectStore(DatabaseHelpers.STORE_NAME)
                store.clear()
            }
        }

        actual fun deleteDataForKey(key: String) {
            DatabaseHelpers.getDatabase().then { database ->
                val transaction = database.transaction(DatabaseHelpers.STORE_NAME, "readwrite")
                val store = transaction.objectStore(DatabaseHelpers.STORE_NAME)
                store.delete(key)
            }
        }

        actual fun <TData> persistData(key: String, item: TData) {
            DatabaseHelpers.getDatabase().then { database ->
                GlobalScope.launch {
                    val transaction = database.transaction(DatabaseHelpers.STORE_NAME, "readwrite")
                    val store = transaction.objectStore(DatabaseHelpers.STORE_NAME)
                    store.put(SecurityHelpers.encryptData("$item"), key)
                }
            }
        }

        actual fun getStringFromKey(key: String): String? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getIntFromKey(key: String): Int? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getLongFromKey(key: String): Long? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getFloatFromKey(key: String): Float? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getDoubleFromKey(key: String): Double? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            TODO("Not supported on JS Platform, please use the asynchronous api")
        }

        // async apis
        actual suspend fun getStringFromKeyAsync(key: String, action: ActionStringNullParams) {
            DatabaseHelpers.getValueFromKey(key) { value ->
                GlobalScope.launch {
                    action(
                        SecurityHelpers.decryptData(key)
                    )
                }
            }
        }

        actual suspend fun getIntFromKeyAsync(key: String, action: ActionIntNullParams) {
            DatabaseHelpers.getValueFromKey(key) { value ->
                GlobalScope.launch {
                    action(
                        SecurityHelpers.decryptData(key).toIntOrNull()
                    )
                }
            }
        }

        actual suspend fun getLongFromKeyAsync(key: String, action: ActionLongNullParams) {
            DatabaseHelpers.getValueFromKey(key) { value ->
                GlobalScope.launch {
                    action(
                        SecurityHelpers.decryptData(key).toLongOrNull()
                    )
                }
            }
        }

        actual suspend fun getFloatFromKeyAsync(key: String, action: ActionFloatNullParams) {
            DatabaseHelpers.getValueFromKey(key) { value ->
                GlobalScope.launch {
                    action(
                        SecurityHelpers.decryptData(key).toFloatOrNull()
                    )
                }
            }
        }

        actual suspend fun getDoubleFromKeyAsync(key: String, action: ActionDoubleNullParams) {
            DatabaseHelpers.getValueFromKey(key) { value ->
                GlobalScope.launch {
                    action(
                        SecurityHelpers.decryptData(key).toDoubleOrNull()
                    )
                }
            }
        }

        actual suspend fun getBooleanFromKeyAsync(key: String, action: ActionBoolNullParams) {
            DatabaseHelpers.getValueFromKey(key) { value ->
                GlobalScope.launch {
                    action(
                        SecurityHelpers.decryptData(key).toBooleanStrictOrNull()
                    )
                }
            }
        }
    }
}

