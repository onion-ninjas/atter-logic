package com.attendance.checker.events

import com.soywiz.klock.DateTime

data class Event(
    val id: String,
    val name: String,
    val eventDate: DateTime,
    val attendeesCount: Int
)
