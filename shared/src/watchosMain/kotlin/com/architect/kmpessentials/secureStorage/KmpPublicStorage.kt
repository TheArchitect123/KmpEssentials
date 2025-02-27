package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSUserDefaults
import platform.darwin.NSInteger

@OptIn(UnsafeNumber::class)
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
                is Long -> sharedPreferences.setInteger(item as NSInteger, key)
            }
        }

        actual fun getStringFromKey(key: String): String? {
            return NSUserDefaults.standardUserDefaults.stringForKey(key)
        }

        actual fun getLongFromKey(key: String): Long? {
            return NSUserDefaults.standardUserDefaults.integerForKey(key).toLong()
        }

        actual fun getIntFromKey(key: String): Int? {
            return NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
        }

        actual fun getFloatFromKey(key: String): Float? {
            return NSUserDefaults.standardUserDefaults.floatForKey(key)
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            return NSUserDefaults.standardUserDefaults.boolForKey(key)
        }

        actual fun getDoubleFromKey(key: String): Double? {
            return NSUserDefaults.standardUserDefaults.doubleForKey(key)
        }

        actual fun getStringFromKey(key: String, defValue: String?): String? {
            return NSUserDefaults.standardUserDefaults.stringForKey(key) ?: defValue
        }

        actual fun getIntFromKey(key: String, defValue: Int): Int {
            return (NSUserDefaults.standardUserDefaults.objectForKey(key) as Long?)?.toInt() ?: defValue
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