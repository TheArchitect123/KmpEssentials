package com.architect.kmpessentials.calendar

import com.architect.kmpessentials.calendar.internals.CalendarInfo
import com.architect.kmpessentials.deviceInfo.DevicePlatform
import com.architect.kmpessentials.deviceInfo.KmpDeviceInfo
import java.io.File
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

actual class KmpCalendar {
    actual companion object {

        // create a local ics calendar event.
        // all platforms natively support these files (and use them for their native calendar apps)
        private fun generateLocalICSFile(eventInfo: CalendarInfo): Pair<File, String> {
            val formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'")
            val start = Instant.now().plusMillis(eventInfo.msFromNow).atZone(ZoneId.of("UTC"))
                .format(formatter)
            val end =
                Instant.now().plusMillis(eventInfo.msFromNow + 3600000).atZone(ZoneId.of("UTC"))
                    .format(formatter)

            val uniqueId = "${System.currentTimeMillis()}_kmp_essentials"
            val icsContent = """
        BEGIN:VCALENDAR
        VERSION:2.0
        PRODID:-//KmpEssentials//NONSGML v1.0//EN
        BEGIN:VEVENT
        UID:$uniqueId
        DTSTAMP:$start
        DTSTART:$start
        DTEND:$end
        SUMMARY:${eventInfo.eventName}
        DESCRIPTION:${eventInfo.eventDescription}
        LOCATION:${eventInfo.eventLocation}
        END:VEVENT
        END:VCALENDAR
    """.trimIndent()

            val file = File("$uniqueId.ics")
            file.writeText(icsContent)
            return Pair(file, uniqueId)
        }

        actual fun addCalendarEvent(eventInfo: CalendarInfo): String {
            val calendar = generateLocalICSFile(eventInfo)
            autoImportICSFile(calendar.first)
            return calendar.second
        }

        actual fun removeCalendarEvent(eventId: String): Boolean {
            return File(eventId).delete()
        }

        actual fun updateCalendarEvent(eventId: String, eventInfo: CalendarInfo): String {
            // clear the original link to the calendar
            val icsEvent = File(eventId)
            if (icsEvent.exists()) {
                icsEvent.delete()
            }

            // replace the old version with a new event
            val calendar = generateLocalICSFile(eventInfo)
            autoImportICSFile(calendar.first)
            return calendar.second
        }

        private fun autoImportICSFile(icsCalendar: File) {
            when (KmpDeviceInfo.getRunningPlatform()) {
                DevicePlatform.Windows -> {
                    val process =
                        ProcessBuilder("cmd", "/c", "start", icsCalendar.absolutePath).start()
                    process.waitFor()
                }

                DevicePlatform.MacOS -> {
                    val process = ProcessBuilder("open", icsCalendar.absolutePath).start()
                    process.waitFor()
                }

                else -> {
                    val process = ProcessBuilder("xdg-open", icsCalendar.absolutePath).start()
                    process.waitFor()
                }
            }
        }
    }
}