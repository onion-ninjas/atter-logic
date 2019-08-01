package com.attendance.checker.events.useCases

import com.attendance.checker.date.KDate
import com.attendance.checker.events.models.Event
import kotlin.random.Random

@Suppress("MagicNumber")
internal var events = (1..100).map {
    Event(
        id = "$it",
        name = "Event $it",
        attendeesCount = Random.nextInt(0, 100),
        eventDate = KDate.now()
    )
}
    .toMutableList()

class GetEvents {
    operator fun invoke(): List<Event> = events
}
