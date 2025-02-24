package com.architect.kmpessentials.calendar

import com.architect.kmpessentials.calendar.internals.CalendarInfo

actual class KmpCalendar {
    actual companion object {
        actual fun addCalendarEvent(eventInfo: CalendarInfo): String {
            return ""
        }

        actual fun removeCalendarEvent(eventId: String): Boolean {
            return false
        }

        actual fun updateCalendarEvent(eventId: String, eventInfo: CalendarInfo): String {
            return ""
        }
    }
}