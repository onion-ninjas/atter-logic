package com.attendance.checker.events.presenters

import com.attendance.checker.events.Event

interface EventListPresenter {
    fun reloadList()
    fun navigateTo(event: Event)
}