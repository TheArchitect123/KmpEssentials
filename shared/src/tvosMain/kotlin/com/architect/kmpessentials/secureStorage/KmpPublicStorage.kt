package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionStringNullParams

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