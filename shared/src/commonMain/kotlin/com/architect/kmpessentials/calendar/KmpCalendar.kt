package com.architect.kmpessentials.calendar

import com.architect.kmpessentials.calendar.internals.CalendarInfo

expect class KmpCalendar {
    companion object {
        fun addCalendarEvent(eventInfo: CalendarInfo): String
        fun removeCalendarEvent(eventId: String): Boolean
        fun updateCalendarEvent(eventId: String, eventInfo: CalendarInfo): String
    }
}