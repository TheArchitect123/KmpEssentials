package com.architect.kmpessentials.secureStorage

actual class KmpPublicStorage{
    actual companion object {
        actual fun clearEntireStore() {
        }

        actual fun deleteDataForKey(key: String) {
        }

        actual fun <TData> persistData(key: String, item: TData) {
        }

        actual fun getStringFromKey(key: String): String {
            TODO("")
        }

        actual fun getIntFromKey(key: String): Int {
            return 0
        }

        actual fun getFloatFromKey(key: String): Float {
            return 0f
        }

        actual fun getBooleanFromKey(key: String): Boolean {
            return false
        }

    }

}