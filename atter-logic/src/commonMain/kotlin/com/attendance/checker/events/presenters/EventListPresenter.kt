package com.attendance.checker.events.presenters

import com.attendance.checker.events.models.Event

interface EventListPresenter {
    fun reloadList()
    fun navigateTo(event: Event)
}
