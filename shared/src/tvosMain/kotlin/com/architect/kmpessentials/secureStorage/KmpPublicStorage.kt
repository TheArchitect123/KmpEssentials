package com.architect.kmpessentials.secureStorage

actual class KmpPublicStorage {
    actual companion object {
        actual fun clearEntireStore() {

        }

        actual fun deleteDataForKey(key: String) {

        }

        actual fun <TData> persistData(key: String, item: TData) {

        }

        actual fun getLongFromKey(key: String): Long? {
            TODO()
        }

        actual fun getStringFromKey(key: String): String? {
            TODO()
        }

        actual fun getIntFromKey(key: String): Int? {
            TODO()
        }

        actual fun getFloatFromKey(key: String): Float? {
            TODO()
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            TODO()
        }
        actual fun getDoubleFromKey(key: String): Double? {
            TODO()
        }

        actual fun getStringFromKey(key: String, defValue: String?): String? {
            TODO("Not yet implemented")
        }

        actual fun getIntFromKey(key: String, defValue: Int): Int {
            TODO("Not yet implemented")
        }

        actual fun getLongFromKey(key: String, defValue: Long): Long {
            TODO("Not yet implemented")
        }

        actual fun getFloatFromKey(key: String, defValue: Float): Float {
            TODO("Not yet implemented")
        }

        actual fun getDoubleFromKey(key: String, defValue: Double): Double {
            TODO("Not yet implemented")
        }

        actual fun getBooleanFromKey(key: String, defValue: Boolean): Boolean {
            TODO("Not yet implemented")
        }
    }
}