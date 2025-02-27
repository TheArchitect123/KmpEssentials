package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import platform.Foundation.NSUserDefaults

actual class KmpPublicStorage {
    actual companion object {
        actual fun clearEntireStore() {
        }

        actual fun deleteDataForKey(key: String) {
            NSUserDefaults.standardUserDefaults.removeObjectForKey(key)
        }

        actual fun <TData> persistData(key: String, item: TData) {
            val sharedPreferences = NSUserDefaults.standardUserDefaults
            when (item) {
                is Float -> sharedPreferences.setFloat(item, key)
                is Double -> sharedPreferences.setDouble(item, key)
                is Boolean -> sharedPreferences.setBool(item, key)
                is String -> sharedPreferences.setObject(item, key)
                is Long -> sharedPreferences.setInteger(item, key)
            }
        }

        actual fun getStringFromKey(key: String): String? {
            return NSUserDefaults.standardUserDefaults.stringForKey(key)
        }

        actual fun getLongFromKey(key: String): Long? {
            val longKey = NSUserDefaults.standardUserDefaults.objectForKey(key)
            if (longKey != null) {
                return NSUserDefaults.standardUserDefaults.integerForKey(key)
            } else {
                return null
            }
        }

        actual fun getIntFromKey(key: String): Int? {
            val intKey = NSUserDefaults.standardUserDefaults.objectForKey(key)
            if (intKey != null) {
                return NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
            } else {
                return null
            }
        }

        actual fun getFloatFromKey(key: String): Float? {
            val checkKey = NSUserDefaults.standardUserDefaults.objectForKey(key)
            if (checkKey != null) {
                return NSUserDefaults.standardUserDefaults.floatForKey(key)
            }

            return null
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            val checkKey = NSUserDefaults.standardUserDefaults.objectForKey(key)
            if (checkKey != null) {
                return NSUserDefaults.standardUserDefaults.boolForKey(key)
            }

            return null
        }

        actual fun getDoubleFromKey(key: String): Double? {
            val checkKey = NSUserDefaults.standardUserDefaults.objectForKey(key)
            if (checkKey != null) {
                return NSUserDefaults.standardUserDefaults.doubleForKey(key)
            }

            return null
        }

        actual fun getStringFromKey(key: String, defValue: String?): String? {
            val checkKey = NSUserDefaults.standardUserDefaults.objectForKey(key)
            if (checkKey != null) {
                return NSUserDefaults.standardUserDefaults.stringForKey(key) ?: defValue
            }

            return null
        }

        actual fun getIntFromKey(key: String, defValue: Int): Int {
            return (NSUserDefaults.standardUserDefaults.objectForKey(key) as Long?)?.toInt()
                ?: defValue
        }

        actual fun getLongFromKey(key: String, defValue: Long): Long {
            return (NSUserDefaults.standardUserDefaults.objectForKey(key) as Long?) ?: defValue
        }

        actual fun getFloatFromKey(key: String, defValue: Float): Float {
            return (NSUserDefaults.standardUserDefaults.objectForKey(key) as Float?) ?: defValue
        }

        actual fun getDoubleFromKey(key: String, defValue: Double): Double {
            return (NSUserDefaults.standardUserDefaults.objectForKey(key) as Double?) ?: defValue
        }

        actual fun getBooleanFromKey(
            key: String,
            defValue: Boolean
        ): Boolean {
            return (NSUserDefaults.standardUserDefaults.objectForKey(key) as Boolean?) ?: defValue
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
    }
}