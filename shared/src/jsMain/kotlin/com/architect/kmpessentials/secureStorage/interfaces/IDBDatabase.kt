package com.architect.kmpessentials.secureStorage.interfaces

external interface IDBDatabase {
    fun createObjectStore(name: String)
    fun transaction(storeName: String, mode: String = definedExternally): IDBTransaction
    fun close()
}