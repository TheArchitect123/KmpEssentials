package com.architect.kmpessentials.contacts

import android.content.ContentResolver
import android.content.Intent
import android.provider.ContactsContract
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.logging.KmpLogging
import com.architect.kmpessentials.logging.constants.ErrorCodes
import com.architect.kmpessentials.mainThread.KmpMainThread
import com.architect.kmpessentials.permissions.KmpPermissionsManager
import com.architect.kmpessentials.permissions.Permission

actual class KmpContacts {
    actual companion object {
        actual fun getAllContacts(contactsResponse: ContactsAction) {
            KmpPermissionsManager.isPermissionGranted(Permission.Contacts) {
                if (it) {
                    val contactsData = mutableListOf<Contact>()
                    val contentResolver =
                        KmpAndroid.applicationContext?.contentResolver
                    val cursor =
                        contentResolver?.query(
                            ContactsContract.Contacts.CONTENT_URI,
                            null,
                            null,
                            null,
                            null
                        )
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
                                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                                            ?: 0
                                    ),
                                    cursor.getString(
                                        cursor.getColumnIndex(ContactsContract.Contacts.PHONETIC_NAME)
                                            ?: 0
                                    ),
                                    cursor.getString(
                                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                                            ?: 0
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
                } else {
                    KmpLogging.writeErrorWithCode(ErrorCodes.MISSING_PERMISSION_CONFIGURATION)
                }
            }
        }

        actual fun pickContact(contactsResponse: SingleContactAction) {
            KmpPermissionsManager.isPermissionGranted(Permission.Contacts) {
                if (it) {
                    KmpMainThread.runViaMainThread {
                        val pickContact =
                            Intent(
                                Intent.ACTION_PICK,
                                ContactsContract.Contacts.CONTENT_URI
                            ).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            }
                        KmpAndroid.applicationContext?.startActivity(pickContact)
                    }
                } else {
                    KmpLogging.writeErrorWithCode(ErrorCodes.MISSING_PERMISSION_CONFIGURATION)
                }
            }

        }
    }
}

