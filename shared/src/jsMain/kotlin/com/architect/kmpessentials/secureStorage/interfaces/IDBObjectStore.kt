package com.architect.kmpessentials.secureStorage.interfaces

external interface IDBObjectStore {
    fun put(value: Any, key: String)
    fun get(key: String): IDBRequest
    fun delete(key: String)
    fun clear()
}