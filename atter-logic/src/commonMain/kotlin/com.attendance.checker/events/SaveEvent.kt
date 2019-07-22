package com.attendance.checker.events

class SaveEvent {
    fun save(event: Event): Event? {
        events.add(0, event)

        return event
    }
}
