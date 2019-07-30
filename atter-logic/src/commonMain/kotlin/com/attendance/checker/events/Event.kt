package com.attendance.checker.events

import date.KDate

data class Event(
    val id: String,
    val name: String,
    val eventDate: KDate,
    val attendeesCount: Int
)
