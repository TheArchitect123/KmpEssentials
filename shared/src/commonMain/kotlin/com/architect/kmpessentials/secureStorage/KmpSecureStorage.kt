package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionLongParams
import com.architect.kmpessentials.internal.ActionStringNullParams

/**
 * Writes to a secure storage
 * For Android: Writes to Encrypted Text Shared Preferences
 * For iOS: Writes to Keychain Service
 * */
expect class KmpSecureStorage {
    companion object {
        fun clearEntireStore()
        fun deleteDataForKey(key: String)
        fun <TData> persistData(key: String, item: TData)

        fun getLongFromKey(key: String): Long?
        fun getStringFromKey(key: String): String?
        fun getIntFromKey(key: String): Int?
        fun getFloatFromKey(key: String): Float?
        fun getDoubleFromKey(key: String): Double?
        fun getBooleanFromKey(key: String): Boolean?

        // async apis
        suspend fun getLongFromKeyAsync(key: String, action: ActionLongNullParams)
        suspend fun getStringFromKeyAsync(key: String, action: ActionStringNullParams)
        suspend fun getIntFromKeyAsync(key: String, action: ActionIntNullParams)
        suspend fun getFloatFromKeyAsync(key: String, action: ActionFloatNullParams)
        suspend fun getDoubleFromKeyAsync(key: String, action: ActionDoubleNullParams)
        suspend fun getBooleanFromKeyAsync(key: String, action: ActionBoolNullParams)
    }
}

