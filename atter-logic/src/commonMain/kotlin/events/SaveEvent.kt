package events

class SaveEvent {
    fun save(event: Event) {
        events.add(event)
    }
}