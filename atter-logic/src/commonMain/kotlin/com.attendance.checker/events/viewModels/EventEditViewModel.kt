package com.attendance.checker.events.viewModels

import com.attendance.checker.date.KDate
import com.attendance.checker.events.Event
import com.attendance.checker.events.SaveEvent
import com.attendance.checker.shared.viewModels.Consumable
import com.attendance.checker.shared.viewModels.toConsumable
import com.attendance.checker.uuid.KUUID
import com.github.florent37.livedata.KMutableLiveData
import com.github.florent37.livedata.map

class EventEditViewModel constructor(
    private var newEventUseCase: SaveEvent,
    private val event: Event? = null
) {

    private val name = KMutableLiveData<String>()
    private val date = KMutableLiveData<KDate>()
    private val saveButtonEnabled = name.map {
        it.length > 2
    }
    private val navigation = KMutableLiveData<Consumable<Navigation>>()

    companion object {
        fun instance(event: Event?) =
            EventEditViewModel(SaveEvent(), event)
    }

    init {
        name.value = event?.name
        date.value = event?.eventDate ?: KDate.now()
    }

    fun save() {
        val name = this.name.value ?: return
        val date = this.date.value ?: return
        val id = event?.id ?: KUUID().uuidString

        val event = Event(id, name, date, 0)
        val saved = newEventUseCase.save(event) ?: return

        navigation.value = Navigation.Dismiss.toConsumable()
    }

    sealed class Navigation {
        object Dismiss : Navigation()
    }
}
