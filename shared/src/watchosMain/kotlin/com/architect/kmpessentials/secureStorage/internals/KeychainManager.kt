package com.architect.kmpessentials.secureStorage.internals

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.value
import platform.CoreFoundation.CFAutorelease
import platform.CoreFoundation.CFDictionaryAddValue
import platform.CoreFoundation.CFDictionaryCreateMutable
import platform.CoreFoundation.CFDictionaryRef
import platform.CoreFoundation.CFStringRef
import platform.CoreFoundation.CFTypeRef
import platform.CoreFoundation.CFTypeRefVar
import platform.CoreFoundation.kCFBooleanFalse
import platform.CoreFoundation.kCFBooleanTrue
import platform.Foundation.CFBridgingRelease
import platform.Foundation.CFBridgingRetain
import platform.Foundation.NSData
import platform.Foundation.NSKeyedArchiver
import platform.Foundation.NSKeyedUnarchiver
import platform.Foundation.NSNumber
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding
import platform.Security.SecItemAdd
import platform.Security.SecItemCopyMatching
import platform.Security.SecItemDelete
import platform.Security.SecItemUpdate
import platform.Security.kSecAttrAccessGroup
import platform.Security.kSecAttrAccessible
import platform.Security.kSecAttrAccessibleAfterFirstUnlock
import platform.Security.kSecAttrAccessibleAfterFirstUnlockThisDeviceOnly
import platform.Security.kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly
import platform.Security.kSecAttrAccessibleWhenUnlocked
import platform.Security.kSecAttrAccessibleWhenUnlockedThisDeviceOnly
import platform.Security.kSecAttrAccount
import platform.Security.kSecAttrService
import platform.Security.kSecClass
import platform.Security.kSecClassGenericPassword
import platform.Security.kSecMatchLimit
import platform.Security.kSecMatchLimitAll
import platform.Security.kSecMatchLimitOne
import platform.Security.kSecReturnAttributes
import platform.Security.kSecReturnData
import platform.Security.kSecValueData
import platform.darwin.OSStatus
import platform.darwin.noErr
import platform.posix.memcpy

@OptIn(ExperimentalForeignApi::class)
internal class KeychainManager(
    private val serviceName: String? = null,
    private val accessGroup: String? = null,
    private val accessibility: Accessible = Accessible.WhenUnlocked
) {
    enum class Accessible(val value: CFStringRef?) {
        WhenPasscodeSetThisDeviceOnly(kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly),
        WhenUnlockedThisDeviceOnly(kSecAttrAccessibleWhenUnlockedThisDeviceOnly),
        WhenUnlocked(kSecAttrAccessibleWhenUnlocked),
        AfterFirstUnlock(kSecAttrAccessibleAfterFirstUnlock),
        AfterFirstUnlockThisDeviceOnly(kSecAttrAccessibleAfterFirstUnlockThisDeviceOnly)
    }

    fun set(key: String, stringValue: String): Boolean {
        return addOrUpdate(key, stringValue.toNSData())
    }

    fun set(key: String, intValue: Int): Boolean {
        return addOrUpdate(key, NSNumber(int = intValue).toNSData())
    }

    fun set(key: String, longValue: Long): Boolean {
        return addOrUpdate(key, NSNumber(longValue).toNSData())
    }

    fun set(key: String, floatValue: Float): Boolean {
        return addOrUpdate(key, NSNumber(float = floatValue).toNSData())
    }

    fun set(key: String, doubleValue: Double): Boolean {
        return addOrUpdate(key, NSNumber(double = doubleValue).toNSData())
    }

    fun set(key: String, boolValue: Boolean): Boolean {
        return addOrUpdate(key, NSNumber(bool = boolValue).toNSData())
    }

    fun set(key: String, dataValue: ByteArray): Boolean {
        return addOrUpdate(key, dataValue.toNSData())
    }

    fun string(forKey: String): String? {
        return value(forKey)?.stringValue
    }

    fun int(forKey: String): Int? {
        return value(forKey)?.toNSNumber()?.intValue
    }

    fun long(forKey: String): Long? {
        return value(forKey)?.toNSNumber()?.longLongValue()
    }

    fun float(forKey: String): Float? {
        return value(forKey)?.toNSNumber()?.floatValue
    }

    fun double(forKey: String): Double? {
        return value(forKey)?.toNSNumber()?.doubleValue
    }

    fun bool(forKey: String): Boolean? {
        return value(forKey)?.toNSNumber()?.boolValue
    }

    fun data(forKey: String): ByteArray? {
        return value(forKey)?.toByteArray()
    }

    @Suppress("UNCHECKED_CAST")
    fun allKeys(): List<String> = context {
        val query = query(
            kSecClass to kSecClassGenericPassword,
            kSecReturnAttributes to kCFBooleanTrue,
            kSecMatchLimit to kSecMatchLimitAll
        )

        memScoped {
            val result = alloc<CFTypeRefVar>()
            val isValid = SecItemCopyMatching(query, result.ptr).validate()
            if (isValid) {
                val items = CFBridgingRelease(result.value) as? List<Map<String, Any>>
                items?.mapNotNull { it["acct"] as? String } ?: listOf()
            } else {
                listOf()
            }
        }
    }

    fun existsObject(forKey: String): Boolean = context(forKey) { (account) ->
        val query = query(
            kSecClass to kSecClassGenericPassword,
            kSecAttrAccount to account,
            kSecReturnData to kCFBooleanFalse,
        )

        SecItemCopyMatching(query, null)
            .validate()
    }

    fun deleteObject(forKey: String): Boolean = context(forKey) { (account) ->
        val query = query(
            kSecClass to kSecClassGenericPassword,
            kSecAttrAccount to account
        )

        SecItemDelete(query)
            .validate()
    }

    fun clear(): Boolean = context {
        val query = query(
            kSecClass to kSecClassGenericPassword
        )

        SecItemDelete(query)
            .validate()
    }

    private fun addOrUpdate(key: String, value: NSData?): Boolean {
        return if (existsObject(key)) {
            update(key, value)
        } else {
            add(key, value)
        }
    }

    private fun add(key: String, value: NSData?): Boolean = context(key, value) { (account, data) ->
        val query = query(
            kSecClass to kSecClassGenericPassword,
            kSecAttrAccount to account,
            kSecValueData to data,
            kSecAttrAccessible to accessibility.value
        )
        SecItemAdd(query, null)
            .validate()

    }

    private fun update(key: String, value: Any?): Boolean = context(key, value) { (account, data) ->
        val query = query(
            kSecClass to kSecClassGenericPassword,
            kSecAttrAccount to account,
            kSecReturnData to kCFBooleanFalse,
        )

        val updateQuery = query(
            kSecValueData to data
        )

        SecItemUpdate(query, updateQuery)
            .validate()
    }

    private fun value(forKey: String): NSData? = context(forKey) { (account) ->
        val query = query(
            kSecClass to kSecClassGenericPassword,
            kSecAttrAccount to account,
            kSecReturnData to kCFBooleanTrue,
            kSecMatchLimit to kSecMatchLimitOne,
        )

        memScoped {
            val result = alloc<CFTypeRefVar>()
            SecItemCopyMatching(query, result.ptr)
            CFBridgingRelease(result.value) as? NSData
        }
    }

    // ========
    // HELPERS
    // ========

    private class Context(val refs: Map<CFStringRef?, CFTypeRef?>) {
        @OptIn(UnsafeNumber::class)
        fun query(vararg pairs: Pair<CFStringRef?, CFTypeRef?>): CFDictionaryRef? {
            val map = mapOf(*pairs).plus(refs.filter { it.value != null })
            return CFDictionaryCreateMutable(
                null, map.size.convert(), null, null
            ).apply {
                map.entries.forEach { CFDictionaryAddValue(this, it.key, it.value) }
            }.apply {
                CFAutorelease(this)
            }
        }
    }

    private fun <T> context(vararg values: Any?, block: Context.(List<CFTypeRef?>) -> T): T {
        val standard = mapOf(
            kSecAttrService to CFBridgingRetain(serviceName),
            kSecAttrAccessGroup to CFBridgingRetain(accessGroup)
        )
        val custom = arrayOf(*values).map { CFBridgingRetain(it) }
        return block.invoke(Context(standard), custom).apply {
            standard.values.plus(custom).forEach { CFBridgingRelease(it) }
        }
    }

    @OptIn(UnsafeNumber::class)
    private fun String.toNSData(): NSData? =
        NSString.create(string = this).dataUsingEncoding(NSUTF8StringEncoding)

    private fun NSNumber.toNSData() = NSKeyedArchiver.archivedDataWithRootObject(this)
    private fun NSData.toNSNumber() = NSKeyedUnarchiver.unarchiveObjectWithData(this) as? NSNumber

    @OptIn(UnsafeNumber::class)
    private val NSData.stringValue: String?
        get() = NSString.create(this, NSUTF8StringEncoding) as String?


    @OptIn(UnsafeNumber::class)
    private fun NSData.toByteArray(): ByteArray =
        ByteArray(length.toInt()).apply {
            if (isNotEmpty()) {
                usePinned {
                    memcpy(it.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
                }
            }
        }

    @OptIn(UnsafeNumber::class)
    private fun ByteArray.toNSData(): NSData =
        memScoped {
            NSData.create(
                bytes = allocArrayOf(this@toNSData),
                length = this@toNSData.size.convert()
            )
        }

    private fun OSStatus.validate(): Boolean = toUInt() == noErr
}