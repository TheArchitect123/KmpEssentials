package com.architect.kmpessentials.contacts

import kotlinx.browser.window

actual class KmpContacts {
    actual companion object {
        private fun isContactsAPISupported(): Boolean {
            return window.navigator.asDynamic().contacts != undefined
        }

        actual fun getAllContacts(contactsResponse: ContactsAction) {
            val properties = arrayOf("name", "email", "tel")

            if (isContactsAPISupported()) {
                window.navigator.asDynamic().contacts.select(properties, true).then { contacts ->
                    val contactList = (contacts as Array<dynamic>).map { contact ->
                        val name = contact.name?.toString() ?: "Unknown"
                        val email = contact.email?.toString() ?: "Unknown"
                        val phone = contact.tel?.toString() ?: "No Number"

                        Contact(
                            "",
                            "",
                            name,
                            "",
                            "",
                            "",
                            emails = listOf(email),
                            phoneNumbers = listOf(phone),
                            displayName = ""
                        )
                    }

                    contactsResponse(contactList)
                }.catch { error ->
                    console.log("Error fetching contacts: ${error.message}")
                    contactsResponse(emptyList())
                }
            } else {
                console.log("Contacts API is not supported in this browser.")
                contactsResponse(emptyList())
            }
        }

        actual fun pickContact(contactsResponse: SingleContactAction) {
            val properties = arrayOf("name", "email", "tel")

            if (isContactsAPISupported()) {
                window.navigator.asDynamic().contacts.select(properties, false).then { contacts ->
                    val firstContact = contacts.unsafeCast<Array<dynamic>>().firstOrNull()
                    val name = firstContact?.name?.toString() ?: "Unknown"
                    val email = firstContact.email?.toString() ?: "Unknown"
                    val phone = firstContact?.tel?.toString() ?: "No Number"
                    Contact(
                        "",
                        "",
                        name,
                        "",
                        "",
                        "",
                        emails = listOf(email),
                        phoneNumbers = listOf(phone),
                        displayName = ""
                    )
                }.catch { error ->
                    console.log("Error picking contact: ${error.message}")
                    contactsResponse(null)
                }
            } else {
                console.log("Contacts API is not supported in this browser.")
                contactsResponse(null)
            }
        }
    }
}

