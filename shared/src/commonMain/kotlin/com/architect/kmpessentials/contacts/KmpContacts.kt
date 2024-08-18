package com.architect.kmpessentials.contacts

typealias ContactsAction = (List<Contact>?) -> Unit
typealias SingleContactAction = (Contact?) -> Unit
expect class KmpContacts {
    companion object {
        fun getAllContacts(contactsResponse: ContactsAction)
        fun pickContact(contactsResponse: SingleContactAction)
    }
}

