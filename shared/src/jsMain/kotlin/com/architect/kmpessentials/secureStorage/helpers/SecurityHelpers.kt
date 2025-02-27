package com.architect.kmpessentials.secureStorage.helpers

import diglol.crypto.AesCbc
import org.kotlincrypto.hash.sha2.SHA256

internal object SecurityHelpers {
    var encryptionKey = generateKeyFromString("KmpEssentialsDefaultKey")
    fun generateKeyFromString(userInput: String): ByteArray {
        val sha256 = SHA256()
        sha256.update(userInput.encodeToByteArray())
        return sha256.digest()
    }

    @OptIn(ExperimentalStdlibApi::class)
    suspend fun encryptData(message: String): String {
        val aesCbc = AesCbc(encryptionKey)
        val plaintext = message.encodeToByteArray()

        return aesCbc.encrypt(plaintext).toHexString()
    }

    suspend fun decryptData(message: String): String {
        val aesCbc = AesCbc(encryptionKey)

        val decryptedBytes: ByteArray = aesCbc.decrypt(message.encodeToByteArray())
        return decryptedBytes.decodeToString()
    }
}

