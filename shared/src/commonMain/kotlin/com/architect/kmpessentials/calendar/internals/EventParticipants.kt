package com.architect.kmpessentials.calendar.internals

data class EventParticipants(val emailAddress: String = "",
                             val firstName: String, val lastName: String,
                             val mobileNumber: String = "")