package com.architect.kmpessentials.secureStorage.interfaces

import org.w3c.dom.events.Event

external interface IDBOpenDBRequest : IDBRequest {
    var onupgradeneeded: ((Event) -> Unit)?
}

external interface IndexedDB {
    fun open(name: String, version: Int = definedExternally): IDBOpenDBRequest
}

object IndexedDBWrapper {
    fun getIndexedDB(): dynamic {
        return js("window.indexedDB")
    }
}