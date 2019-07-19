package com.attendance.checker.events

import kotlin.random.Random

internal var events = (1..100).map {
    Event(
        id = "$it",
        name = "Event $it",
        attendeesCount = Random.nextInt(),
        eventDate = "DateTime.now"
    )
}
    .toMutableList()

class GetEvents {

    operator fun invoke(): List<Event> =
        events
}
