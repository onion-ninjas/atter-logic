package com.attendance.checker.events.viewModels

import com.attendance.checker.events.models.Event
import com.attendance.checker.events.useCases.GetEvents
import com.attendance.checker.events.presenters.EventListPresenter
import com.attendance.checker.shared.viewModels.ViewModel

class EventListViewModel constructor(private val presenter: EventListPresenter,
                                     private val getEventUseCase: GetEvents): ViewModel {

    var events: List<Event> = listOf()
        private set

    companion object {
        fun instance(presenter: EventListPresenter) = EventListViewModel(presenter, GetEvents())
    }

    fun refresh() {
        events = getEventUseCase()
        presenter.reloadList()
    }

    fun didSelectRowAt(index: Int) {
        val event = events[index]
        presenter.navigateTo(event)
    }
}
