package com.attendance.checker.events.useCases

import com.attendance.checker.events.models.Event

class SaveEvent {
    fun save(event: Event): Event? {
        val index = events.indexOf(event)

        if (index != -1) {
            events[index] = event
        } else {
            events.add(0, event)
        }

        return event
    }
}
