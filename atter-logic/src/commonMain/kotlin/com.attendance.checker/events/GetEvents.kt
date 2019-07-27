package com.attendance.checker.events

import com.soywiz.klock.DateTime
import kotlin.random.Random

internal var events = (1..100).map {
    Event(
        id = "$it",
        name = "Event $it",
        attendeesCount = Random.nextInt(0, 100),
        eventDate = DateTime.now()
    )
}
    .toMutableList()

class GetEvents {

    operator fun invoke(): List<Event> =
        events
}
