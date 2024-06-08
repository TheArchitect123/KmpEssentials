package com.architect.kmpessentials.contacts

expect class KmpContacts {
    companion object {
        fun getAllContacts(): List<Contact>?
        fun pickContact(): Contact?
    }
}

