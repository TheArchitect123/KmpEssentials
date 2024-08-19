package com.architect.kmpessentials.contacts

typealias ContactsAction = (List<Contact>?) -> Unit
typealias SingleContactAction = (Contact?) -> Unit


expect class KmpContacts {
    companion object {
        /**
         * Get a list of all contacts on your device's store
         * @param contactsResponse returns the contact list from your store
         * */
        fun getAllContacts(contactsResponse: ContactsAction)

        /**
         * Allows you to pick a single contact from your device
         * @param contactsResponse returns the contact item from your store
         * */
        fun pickContact(contactsResponse: SingleContactAction)
    }
}

