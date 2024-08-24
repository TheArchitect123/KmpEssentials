package com.architect.kmpessentials.filePicker

data class File(
    val name: String,
    val absolutePath: String,
    val isProtected: Boolean = false,
    val modifiedISO: String = "",
    val createdISO: String = ""
)