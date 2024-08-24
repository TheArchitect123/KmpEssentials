package com.architect.kmpessentials.contacts

import com.architect.kmpessentials.KmpiOS
import com.architect.kmpessentials.mainThread.KmpMainThread
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Contacts.CNContactFetchRequest
import platform.Contacts.CNContactFormatter
import platform.Contacts.CNContactStore
import platform.ContactsUI.CNContactPickerViewController

actual class KmpContacts {
    actual companion object {
        @OptIn(ExperimentalForeignApi::class)
        actual fun getAllContacts(contactsResponse: ContactsAction) {
            val contacts = mutableListOf<Contact>()
            val keys = listOf(CNContactFormatter.descriptorForRequiredKeysForDelimiter())
            val request = CNContactFetchRequest(keys)
            val response =
                CNContactStore().enumerateContactsWithFetchRequest(request, null) { result, error ->
                    if (result != null) {
                        contacts.add(
                            Contact(
                                result.identifier,
                                result.namePrefix,
                                result.givenName,
                                result.middleName,
                                result.familyName,
                                result.nameSuffix,
                                result.phoneNumbers.map { "$it" },
                                result.emailAddresses.map { "$it" },
                                "${result.givenName} ${result.familyName}",
                            )
                        )
                    }
                }

            if (response) {
                contactsResponse(contacts)
            }
        }

        actual fun pickContact(contactsResponse: SingleContactAction) {
            KmpMainThread.runViaMainThread {
                val contacts = CNContactPickerViewController()

                KmpiOS.getTopViewController()?.presentViewController(contacts, true, null)
            }
        }
//
//        override fun contactPickerDidCancel(picker: CNContactPickerViewController) {
//            super.contactPickerDidCancel(picker)
//        }
    }
}

