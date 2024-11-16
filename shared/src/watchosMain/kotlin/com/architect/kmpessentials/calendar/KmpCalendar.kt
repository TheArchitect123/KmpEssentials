package com.architect.kmpessentials.calendar

import com.architect.kmpessentials.calendar.internals.CalendarInfo
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.plus
import platform.EventKit.EKEvent
import platform.EventKit.EKEventStore
import platform.EventKit.EKSpan
import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970

@OptIn(ExperimentalForeignApi::class)
actual class KmpCalendar {
    actual companion object {
        private fun getEKEvent(eventId: String?, eventInfo: CalendarInfo): EKEvent {
            val startDate = Clock.System.now()
            val endDate =
                startDate.plus(eventInfo.msFromNow, DateTimeUnit.MILLISECOND).epochSeconds / 1000
            val startNSDate =
                NSDate.dateWithTimeIntervalSince1970((startDate.epochSeconds / 1000).toDouble())
            val endNSDate = NSDate.dateWithTimeIntervalSince1970(endDate.toDouble())

            val store = EKEventStore()
            val event =
                if (eventId.isNullOrBlank()) EKEvent() else store.eventWithIdentifier(eventId)!!
            event.apply {
                title = eventInfo.eventName
                location = eventInfo.eventLocation
                calendar = store.defaultCalendarForNewEvents()
            }

            event.startDate = startNSDate
            event.endDate = endNSDate

            return event
        }

        actual fun addCalendarEvent(eventInfo: CalendarInfo): String {
            val store = EKEventStore()
            val event = getEKEvent(null, eventInfo)

//            try {
//                store.stor (event, span = EKSpan.EKSpanThisEvent, commit = true, error = null)
//            } catch (e: Throwable) {
//                return "" // failed to save event
//            }

            return event.eventIdentifier() ?: ""
        }

        actual fun removeCalendarEvent(eventId: String): Boolean {
            val store = EKEventStore()
            val idToRemove = store.eventWithIdentifier(eventId)

//            if (idToRemove != null) {
//                return store.(
//                    idToRemove,
//                    span = EKSpan.EKSpanThisEvent,
//                    commit = true,
//                    error = null
//                )
//            }

            return false
        }

        actual fun updateCalendarEvent(eventId: String, eventInfo: CalendarInfo): String {
            val store = EKEventStore()
            val event = getEKEvent(eventId, eventInfo)

//            if (store.saveEvent(
//                    event,
//                    span = EKSpan.EKSpanThisEvent,
//                    commit = true,
//                    error = null
//                )
//            ) {
//                return event.eventIdentifier ?: ""
//            }

            return ""
        }
    }
}