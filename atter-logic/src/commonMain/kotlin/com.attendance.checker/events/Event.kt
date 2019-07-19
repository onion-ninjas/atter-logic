package com.attendance.checker.events

data class Event(
    val id: String,
    val name: String,
    val eventDate: String,
    val attendeesCount: Int
)
