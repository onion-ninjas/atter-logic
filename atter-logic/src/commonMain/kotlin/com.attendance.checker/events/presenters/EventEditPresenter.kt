package com.attendance.checker.events.presenters

interface EventEditPresenter {
    fun setSaveButton(enabled: Boolean)
    fun displayName(name: String?)
    fun displayDate(date: String?)
    fun dismiss()
}