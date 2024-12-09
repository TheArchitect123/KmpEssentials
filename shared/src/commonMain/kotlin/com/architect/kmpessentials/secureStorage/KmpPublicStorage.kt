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

        @Deprecated("Deprecated", replaceWith = ReplaceWith("getStingFromKey(key: String, defValue: String?)"))
        fun getStringFromKey(key: String): String?
        @Deprecated("Deprecated", replaceWith = ReplaceWith("getIntFromKey(key: String, defValue: Int)"))
        fun getIntFromKey(key: String): Int?
        @Deprecated("Deprecated", replaceWith = ReplaceWith("getLongFromKey(key: String, defValue: Long)"))
        fun getLongFromKey(key: String): Long?
        @Deprecated("Deprecated", replaceWith = ReplaceWith("getFloatFromKey(key: String, defValue: Float)"))
        fun getFloatFromKey(key: String): Float?
        @Deprecated("Deprecated", replaceWith = ReplaceWith("getDoubleFromKey(key: String, defValue: Double)"))
        fun getDoubleFromKey(key: String): Double?
        @Deprecated("Deprecated", replaceWith = ReplaceWith("getBooleanFromKey(key: String, defValue: Boolean)"))
        fun getBooleanFromKey(key: String): Boolean?

        fun getStringFromKey(key: String, defValue: String?): String?
        fun getIntFromKey(key: String, defValue: Int): Int
        fun getLongFromKey(key: String, defValue: Long): Long
        fun getFloatFromKey(key: String, defValue: Float): Float
        fun getDoubleFromKey(key: String, defValue: Double): Double
        fun getBooleanFromKey(key: String, defValue: Boolean): Boolean
    }
}