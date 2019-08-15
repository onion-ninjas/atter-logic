package com.attendance.checker.date

import com.squareup.sqldelight.ColumnAdapter

expect class KDate {

    val isoDate: String

    companion object {
        fun now(): KDate
    }
}

expect class KDateAdapter() : ColumnAdapter<KDate, String>
