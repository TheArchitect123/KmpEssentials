package com.architect.kmpessentials.secureStorage

import android.content.Context
import androidx.preference.PreferenceManager
import com.architect.kmpessentials.KmpAndroid

actual class KmpPublicStorage {
    actual companion object {
        private lateinit var localContext : Context
        private val sharedPreference by lazy {
            PreferenceManager.getDefaultSharedPreferences(KmpAndroid.applicationContext ?: localContext)
        }

        fun setCustomContext(customContext: Context){
            localContext = customContext
        }

        actual fun clearEntireStore() {
            sharedPreference.edit().clear().apply()
        }

        actual fun deleteDataForKey(key: String) {
            sharedPreference.edit().remove(key).apply()
        }

        actual fun <TData> persistData(key: String, item: TData) {
            when (item) {
                is Float -> sharedPreference.edit().putFloat(key, item)
                is Boolean -> sharedPreference.edit().putBoolean(key, item)
                is String -> sharedPreference.edit().putString(key, item)
                is Int -> sharedPreference.edit().putInt(key, item)
                else -> sharedPreference.edit().putLong(key, item as Long)
            }.apply()
        }

        actual fun getStringFromKey(key: String): String? {
            return sharedPreference.getString(key, "")
        }

        actual fun getLongFromKey(key: String): Long? {
            return sharedPreference.getLong(key, 0)
        }

        actual fun getIntFromKey(key: String): Int? {
            return sharedPreference.getInt(key, 0)
        }

        actual fun getFloatFromKey(key: String): Float? {
            return sharedPreference.getFloat(key, 0f)
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            return sharedPreference.getBoolean(key, false)
        }

        actual fun getDoubleFromKey(key: String): Double?{
            return sharedPreference.getFloat(key, 0.0f).toDouble()
        }

        fun getAllKeys() : List<String>{
            return sharedPreference.all.keys.toList()
        }

        actual fun getStringFromKey(key: String, defValue: String?): String? {
            return sharedPreference.getString(key, defValue)
        }

        actual fun getIntFromKey(key: String, defValue: Int): Int {
            return sharedPreference.getInt(key, defValue)
        }

        actual fun getLongFromKey(key: String, defValue: Long): Long {
            return sharedPreference.getLong(key, defValue)
        }

        actual fun getFloatFromKey(key: String, defValue: Float): Float {
            return sharedPreference.getFloat(key, defValue)
        }

        actual fun getDoubleFromKey(key: String, defValue: Double): Double {
            return sharedPreference.getFloat(key, defValue.toFloat()).toDouble()
        }

        actual fun getBooleanFromKey(
            key: String,
            defValue: Boolean
        ): Boolean {
            return sharedPreference.getBoolean(key, defValue)
        }
    }
}