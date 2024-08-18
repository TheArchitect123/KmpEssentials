package com.architect.kmpessentials.contacts

import android.content.ContentResolver
import android.content.Intent
import android.provider.ContactsContract
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.mainThread.KmpMainThread

actual class KmpContacts {
    actual companion object {
        actual fun getAllContacts(contactsResponse: ContactsAction) {
            val contactsData = mutableListOf<Contact>()
            val contentResolver: ContentResolver = KmpAndroid.clientAppContext.contentResolver
            val cursor =
                contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
            if (cursor!!.moveToFirst()) {
                do {
                    cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)

                    contactsData.add(
                        Contact(
                            cursor.getString(
                                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)
                                    ?: 0
                            ),
                            cursor.getString(
                                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)
                                    ?: 0
                            ),
                            cursor.getString(
                                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) ?: 0
                            ),
                            cursor.getString(
                                cursor.getColumnIndex(ContactsContract.Contacts.PHONETIC_NAME) ?: 0
                            ),
                            cursor.getString(
                                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) ?: 0
                            ),
                            "",
                            listOf(),
                            listOf(),
                            "",


                            )
                    )

                } while (cursor.moveToNext())
            }

            contactsResponse(contactsData)
        }

        actual fun pickContact(contactsResponse: SingleContactAction) {
            KmpMainThread.runViaMainThread {
                val pickContact = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
                KmpAndroid.clientAppContext.startActivity(pickContact)
            }
        }
    }
}

