package com.attendance.checker.events.viewModels

import com.attendance.checker.events.Event
import com.attendance.checker.events.GetEvents
import com.attendance.checker.shared.viewModels.Consumable
import com.attendance.checker.shared.viewModels.toConsumable
import com.github.florent37.livedata.KMutableLiveData

class EventListViewModel(
    private val getEventUseCase: GetEvents
) {

    val events = KMutableLiveData<List<Event>>()
    val navigation = KMutableLiveData<Consumable<Navigation>>()

    companion object {
        fun instance() = EventListViewModel(GetEvents())
    }

    init {
        events.value = getEventUseCase()
    }

    fun refresh() {
        events.value = getEventUseCase()
    }

    fun didSelectRowAt(index: Int) {
        val event = events.value?.get(index) ?: return

        navigation.value = Navigation.NavigateTo(event = event).toConsumable()
    }

    sealed class Navigation {
        data class NavigateTo(val event: Event): Navigation()
    }
}
