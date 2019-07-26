package com.attendance.checker.events.viewModels

import com.attendance.checker.date.KDate
import com.attendance.checker.events.Event
import com.attendance.checker.events.SaveEvent
import com.attendance.checker.events.presenters.EventEditPresenter
import com.attendance.checker.shared.viewModels.ViewModel
import com.attendance.checker.uuid.KUUID

class EventEditViewModel constructor(val presenter: EventEditPresenter, var newEventUseCase: SaveEvent, val event: Event? = null): ViewModel {

    private var name: String?
    private var date: KDate

    companion object {
        fun instance(presenter: EventEditPresenter, event: Event?) = EventEditViewModel(presenter, SaveEvent(), event)
    }

    init {
        name = event?.name
        date = event?.eventDate ?: KDate.now()
    }

    override fun onStart() {
        refreshSaveButtonStatus()
        presenter.displayName(name)
        presenter.displayDate(date.isoDate)
    }

    fun didChangeName(name: String) {
        this.name = name

        refreshSaveButtonStatus()
    }

    fun didChangeDate(date: KDate) {
        this.date = date

        presenter.displayDate(date.isoDate)
        refreshSaveButtonStatus()
    }

    fun save() {
        val name = this.name ?: return
        val id = event?.id ?: KUUID().uuidString

        val event = Event(id, name, date, 0)
        val saved = newEventUseCase.save(event)

        if (saved != null) {
            presenter.dismiss()
        }
    }

    private fun refreshSaveButtonStatus() {
        val nameValidated = (name?.length ?: 0) > 2
        //TODO: other validations

        val enabled = nameValidated
        presenter.setSaveButton(enabled)
    }
}