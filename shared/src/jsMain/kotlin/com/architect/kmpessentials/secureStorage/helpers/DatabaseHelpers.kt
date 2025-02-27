package com.architect.kmpessentials.secureStorage.helpers

import com.architect.kmpessentials.secureStorage.interfaces.IDBDatabase
import com.architect.kmpessentials.secureStorage.interfaces.IDBOpenDBRequest
import com.architect.kmpessentials.secureStorage.interfaces.IndexedDBWrapper
import kotlin.js.Promise

internal object DatabaseHelpers {
    const val DATABASE_NAME = "KmpEssentialsStorage"
    const val STORE_NAME = "storage"
    const val DATABASE_VERSION = 1

    private var db: IDBDatabase? = null

    fun initializeIndexedDB(): Promise<IDBDatabase> {
        return Promise { resolve, reject ->
            val indexedDB = IndexedDBWrapper.getIndexedDB()
            val request =
                indexedDB.open(DATABASE_NAME, DATABASE_VERSION).unsafeCast<IDBOpenDBRequest>()

            request.onsuccess = {
                db = request.result as IDBDatabase
                resolve(db!!)
            }

            request.onerror = {
                reject(Throwable("Failed to open IndexedDB"))
            }

            request.onupgradeneeded = { event ->
                val database =
                    (event.target.unsafeCast<IDBOpenDBRequest>()).result.unsafeCast<IDBDatabase>()
                database.createObjectStore(STORE_NAME)
            }
        }
    }

    fun getValueFromKey(key: String, callback: (String?) -> Unit) {
        getDatabase().then { database ->
            val transaction = database.transaction(STORE_NAME, "readonly")
            val store = transaction.objectStore(STORE_NAME)
            val request = store.get(key)

            request.onsuccess = { callback(request.result as? String) }
            request.onerror = { callback(null) }
        }
    }

    // Get IndexedDB instance
    fun getDatabase(): Promise<IDBDatabase> {
        return if (db != null) Promise.resolve(db!!)
        else initializeIndexedDB()
    }
}