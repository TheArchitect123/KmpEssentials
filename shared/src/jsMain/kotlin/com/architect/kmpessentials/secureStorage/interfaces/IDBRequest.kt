package com.architect.kmpessentials.secureStorage.interfaces

import org.w3c.dom.events.Event

external interface IDBRequest {
    var onsuccess: ((Event) -> Unit)?
    var onerror: ((Event) -> Unit)?
    val result: Any?
}