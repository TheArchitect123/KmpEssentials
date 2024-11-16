package com.architect.kmpessentials.calendar

import android.content.ContentValues
import android.os.Build
import android.provider.CalendarContract
import androidx.annotation.RequiresApi
import com.architect.kmpessentials.KmpAndroid
import com.architect.kmpessentials.calendar.internals.CalendarInfo
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.plus

actual class KmpCalendar {
    actual companion object {
        @RequiresApi(Build.VERSION_CODES.N)
        actual fun addCalendarEvent(eventInfo: CalendarInfo): String {
            val onboardSystemCalendars = getAvailableCalendars()
            if (onboardSystemCalendars.isNotEmpty()) {
                val startDate = Clock.System.now()
                val endDate = startDate.plus(eventInfo.msFromNow, DateTimeUnit.MILLISECOND)

                val values = ContentValues().apply {
                    put(
                        CalendarContract.Events.CALENDAR_ID,
                        onboardSystemCalendars.first().first
                    ) // Replace with a valid calendar ID
                    put(CalendarContract.Events.TITLE, eventInfo.eventName)
                    put(CalendarContract.Events.DESCRIPTION, eventInfo.eventDescription)
                    put(CalendarContract.Events.EVENT_LOCATION, eventInfo.eventLocation)
                    put(CalendarContract.Events.DTSTART, startDate.epochSeconds)
                    put(CalendarContract.Events.DTEND, endDate.epochSeconds)
                    put(CalendarContract.Events.EVENT_TIMEZONE, KmpDeviceInfo.getDeviceTimeZone())
                    put(
                        CalendarContract.Events.EVENT_END_TIMEZONE,
                        KmpDeviceInfo.getDeviceTimeZone()
                    )
                }

                val uri =
                    KmpAndroid.applicationContext?.contentResolver?.insert(
                        CalendarContract.Events.CONTENT_URI,
                        values
                    )
                return uri?.lastPathSegment.toString()
            }

            return ""
        }

        actual fun removeCalendarEvent(eventId: String): Boolean {
            val uri = CalendarContract.Events.CONTENT_URI.buildUpon().appendPath(eventId)
                .build()

            return (KmpAndroid.applicationContext?.contentResolver?.delete(uri, null, null)
                ?: 0) > 0
        }

        actual fun updateCalendarEvent(eventId: String, eventInfo: CalendarInfo): String {
            val startDate = Clock.System.now()

            val values = ContentValues().apply {
                eventInfo.eventName.let { put(CalendarContract.Events.TITLE, it) }
                eventInfo.eventDescription.let { put(CalendarContract.Events.DESCRIPTION, it) }
                startDate.epochSeconds.let { put(CalendarContract.Events.DTSTART, it) }
                eventInfo.msFromNow.let { put(CalendarContract.Events.DTEND, it) }
            }

            val uri = CalendarContract.Events.CONTENT_URI.buildUpon().appendPath(eventId)
                .build()
            return KmpAndroid.applicationContext?.contentResolver?.update(uri, values, null, null)
                .toString()
        }

        private fun getAvailableCalendars(): List<Pair<Long, String>> {
            val uri = CalendarContract.Calendars.CONTENT_URI
            val projection = arrayOf(
                CalendarContract.Calendars._ID,
                CalendarContract.Calendars.CALENDAR_DISPLAY_NAME
            )
            val calendars = mutableListOf<Pair<Long, String>>()

            val cursor = KmpAndroid.applicationContext?.contentResolver?.query(
                uri,
                projection,
                null,
                null,
                null
            )
            cursor?.use {
                while (it.moveToNext()) {
                    val id = it.getLong(it.getColumnIndexOrThrow(CalendarContract.Calendars._ID))
                    val name =
                        it.getString(it.getColumnIndexOrThrow(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME))
                    calendars.add(id to name)
                }
            }

            return calendars
        }
    }
}