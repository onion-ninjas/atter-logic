package com.attendance.checker.date

expect class KDate {

    val isoDate: String

    companion object {
        fun now(): KDate
    }
}
