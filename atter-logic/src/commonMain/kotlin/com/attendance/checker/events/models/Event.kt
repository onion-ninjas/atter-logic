package com.attendance.checker.events.models

import com.attendance.checker.date.KDate

data class Event(
    val id: String,
    val name: String,
    val eventDate: KDate,
    val attendeesCount: Int
)
