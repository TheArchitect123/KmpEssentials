package com.architect.kmpessentials.secureStorage

actual class KmpSecureStorage {
    actual companion object {
        // if privacy is configured, then use the keychain, otherwise user defaults
        actual fun configureSecurity(isPrivate: Boolean) {
        }

        actual fun clearEntireStore() {
        }

        actual fun deleteDataForKey(key: String) {
        }

        actual fun <TData> persistData(key: String, item: TData) {
        }

        actual fun getStringFromKey(key: String): String {
            TODO("Not yet implemented")
        }

        actual fun getIntFromKey(key: String): Int {
            TODO("Not yet implemented")
        }

        actual fun getFloatFromKey(key: String): Float {
            TODO("Not yet implemented")
        }

        actual fun getBooleanFromKey(key: String): Boolean {
            TODO("Not yet implemented")
        }

    }
}