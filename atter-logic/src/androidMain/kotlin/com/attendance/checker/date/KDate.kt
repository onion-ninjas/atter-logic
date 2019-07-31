package com.attendance.checker.date

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

actual class KDate constructor(val date: LocalDateTime) {

    actual val isoDate: String

    init {
        isoDate = date.format(DateTimeFormatter.ISO_DATE_TIME)
    }

    actual companion object {
        actual fun now(): KDate = KDate(LocalDateTime.now())
    }
}
