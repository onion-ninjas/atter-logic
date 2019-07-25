package com.attendance.checker.events.viewModels

import com.attendance.checker.events.Event
import com.attendance.checker.events.GetEvents
import com.attendance.checker.events.presenters.EventListPresenter
import com.attendance.checker.shared.viewModels.ViewModel

class EventListViewModel constructor(val presenter: EventListPresenter, val getEventUseCase: GetEvents): ViewModel {

    var events: List<Event> = listOf()

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