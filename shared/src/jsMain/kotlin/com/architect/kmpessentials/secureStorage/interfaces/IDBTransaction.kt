package com.architect.kmpessentials.secureStorage.interfaces

external interface IDBTransaction {
    fun objectStore(name: String): IDBObjectStore
}