package com.architect.kmpessentials.secureStorage

actual class KmpPublicStorage {
    actual companion object {
        actual fun clearEntireStore() {

        }

        actual fun deleteDataForKey(key: String) {

        }


        actual fun <TData> persistData(key: String, item: TData) {

        }

        actual fun getStringFromKey(key: String): String {
            TODO()
        }

        actual fun getLongFromKey(key: String): Long {
            TODO()
        }

        actual fun getIntFromKey(key: String): Int {
            TODO()
        }

        actual fun getFloatFromKey(key: String): Float {
            TODO()
        }

        actual fun getBooleanFromKey(key: String): Boolean {
            TODO()
        }
    }
}