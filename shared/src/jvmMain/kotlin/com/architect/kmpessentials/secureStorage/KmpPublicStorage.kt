package com.architect.kmpessentials.secureStorage

import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import com.architect.kmpessentials.fileSystem.KmpFileSystem
import com.architect.kmpessentials.internal.ActionBoolNullParams
import com.architect.kmpessentials.internal.ActionDoubleNullParams
import com.architect.kmpessentials.internal.ActionFloatNullParams
import com.architect.kmpessentials.internal.ActionIntNullParams
import com.architect.kmpessentials.internal.ActionLongNullParams
import com.architect.kmpessentials.internal.ActionStringNullParams
import jdk.internal.misc.VM.saveProperties
import org.bytedeco.javacpp.Loader.loadProperties
import java.io.File
import java.util.Properties

actual class KmpPublicStorage {
    actual companion object {
        private var storageFile: File? = null

        init {
            reinitializeStoreFile()
        }

        private fun loadProperties(): MutableMap<String, String> {
            val properties = Properties()
            if (storageFile!!.exists()) {
                storageFile!!.inputStream().use { properties.load(it) }
            }
            return properties.entries.associate { it.key.toString() to it.value.toString() }
                .toMutableMap()
        }

        private fun saveProperties(map: MutableMap<String, String>) {
            val properties = Properties()
            properties.putAll(map)
            storageFile!!.outputStream().use { properties.store(it, "KmpPublicStorage") }
        }

        private fun reinitializeStoreFile() {
            val appDirectory = KmpFileSystem.getAppDirectory()
            storageFile = when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> File(appDirectory, "essentials_public_storage.txt")
                DevicePlatform.MacOS -> File(
                    appDirectory,
                    "Library/Application Support/public_storage.txt"
                )

                else -> File(appDirectory, ".config/public_storage.txt")
            }
        }

        actual fun clearEntireStore() {
            if (storageFile!!.exists()) {
                storageFile!!.delete()
            }

            reinitializeStoreFile()
        }

        actual fun deleteDataForKey(key: String) {
            val properties = loadProperties()
            if (properties.containsKey(key)) {
                properties.remove(key)
                saveProperties(properties)
            }
        }


        actual fun getLongFromKey(key: String): Long? {
            return loadProperties()[key]?.toString()?.toLongOrNull()
        }

        actual fun <TData> persistData(key: String, item: TData) {
            val properties = loadProperties()
            properties[key] = item.toString()
            saveProperties(properties)
        }


        actual fun getStringFromKey(key: String): String? {
            return loadProperties()[key]?.toString()
        }

        actual fun getIntFromKey(key: String): Int? {
            return loadProperties()[key]?.toString()?.toIntOrNull()
        }

        actual fun getFloatFromKey(key: String): Float? {
            return loadProperties()[key]?.toString()?.toFloatOrNull()
        }

        actual fun getBooleanFromKey(key: String): Boolean? {
            return loadProperties()[key]?.toString()?.toBooleanStrictOrNull()
        }

        actual fun getDoubleFromKey(key: String): Double? {
            return loadProperties()[key]?.toString()?.toDoubleOrNull()
        }

        actual fun getStringFromKey(key: String, defValue: String?): String? {
            return loadProperties()[key]?.toString()
        }

        actual fun getIntFromKey(key: String, defValue: Int): Int {
            return loadProperties()[key]?.toString()?.toIntOrNull() ?: 0
        }

        actual fun getLongFromKey(key: String, defValue: Long): Long {
            return loadProperties()[key]?.toString()?.toLongOrNull() ?: 0L
        }

        actual fun getFloatFromKey(key: String, defValue: Float): Float {
            return loadProperties()[key]?.toString()?.toFloatOrNull() ?: 0f
        }

        actual fun getDoubleFromKey(key: String, defValue: Double): Double {
            return loadProperties()[key]?.toString()?.toDoubleOrNull() ?: 0.0
        }

        actual fun getBooleanFromKey(key: String, defValue: Boolean): Boolean {
            return loadProperties()[key]?.toString()?.toBooleanStrictOrNull() ?: false
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