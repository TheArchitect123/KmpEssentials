package com.architect.kmpessentials.secureStorage

/**
 * Writes to a public storage
 * For Android: Writes to Clear Text Shared Preferences
 * For iOS: Writes to NSUserDefaults
 * */
expect class KmpPublicStorage {
    companion object {
        fun clearEntireStore()
        fun deleteDataForKey(key: String)
        fun <TData> persistData(key: String, item: TData)

        fun getStringFromKey(key: String): String
        fun getIntFromKey(key: String): Int
        fun getFloatFromKey(key: String): Float
        fun getBooleanFromKey(key: String): Boolean
    }
}