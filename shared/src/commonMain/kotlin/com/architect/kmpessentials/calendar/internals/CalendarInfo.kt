package com.architect.kmpessentials.calendar.internals

data class CalendarInfo(
    val eventName: String,
    val eventDescription: String,
    val eventLocation: String,
    val participants: List<EventParticipants>? = null,
    val msFromNow: Long
)

