package com.architect.kmpessentials.contacts

data class Contact(
    val id: String,
    val namePrefix: String,
    val givenName: String,
    val middleName: String,
    val familyName: String,
    val nameSuffix: String,
    val phoneNumbers: List<String>,
    val emails : List<String>,
    val displayName: String
)