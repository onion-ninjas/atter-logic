package com.attendance.checker.events.presenters

import com.attendance.checker.date.KDate

interface EventEditPresenter {
    fun setSaveButton(enabled: Boolean)
    fun displayName(name: String?)
    fun displayDate(kdate: KDate)
    fun dismiss()
}