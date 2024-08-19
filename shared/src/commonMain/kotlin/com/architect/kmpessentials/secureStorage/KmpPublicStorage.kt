package com.architect.kmpessentials.secureStorage

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