package com.architect.kmpessentials.secureStorage

import platform.Foundation.NSUserDefaults

actual class KmpPublicStorage{
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

        actual fun getStringFromKey(key: String): String {
            return NSUserDefaults.standardUserDefaults.stringForKey(key) ?: ""
        }

        actual fun getIntFromKey(key: String): Int {
            return NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
        }

        actual fun getFloatFromKey(key: String): Float {
            return NSUserDefaults.standardUserDefaults.floatForKey(key)
        }

        actual fun getBooleanFromKey(key: String): Boolean {
            return NSUserDefaults.standardUserDefaults.boolForKey(key)
        }

    }

}