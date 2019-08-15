package com.attendance.checker.date

import com.squareup.sqldelight.ColumnAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

actual class KDate constructor(val date: LocalDateTime) {

    actual val isoDate: String

    init {
        isoDate = date.format(DateTimeFormatter.ISO_DATE_TIME)
    }

    actual companion object {
        actual fun now(): KDate = KDate(LocalDateTime.now())
        fun from(iso: String): KDate = KDate(LocalDateTime.now()) //TODO: this
    }
}

actual class KDateAdapter actual constructor(): ColumnAdapter<KDate, String> {
    override fun encode(value: KDate) = value.isoDate
    override fun decode(databaseValue: String) = KDate.from(databaseValue)
}
