package events

import com.soywiz.klock.DateTime

import kotlin.random.Random

class GetEvents {

    operator fun invoke() = (1..100).map {
        Event(
            id = "$it",
            name = "Event $it",
            attendeesCount = Random.nextInt(),
            eventDate = DateTime.now()
        )
    }
}
