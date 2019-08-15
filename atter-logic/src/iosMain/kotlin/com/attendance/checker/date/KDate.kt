package com.attendance.checker.date

import com.squareup.sqldelight.ColumnAdapter
import platform.Foundation.NSDate
import platform.Foundation.NSISO8601DateFormatter

actual class KDate constructor(val date: NSDate) {

    actual val isoDate: String

    init {
        val isoFormatter = NSISO8601DateFormatter()
        val isoDate = isoFormatter.stringFromDate(date)

        this.isoDate = isoDate
    }

    actual companion object {
        actual fun now(): KDate = KDate(NSDate())
        fun from(iso: String): KDate {
            val isoFormatter = NSISO8601DateFormatter()
            return KDate(isoFormatter.dateFromString(iso)!!)
        }
    }
}

actual class KDateAdapter actual constructor() : ColumnAdapter<KDate, String> {
    override fun decode(databaseValue: String): KDate = KDate.from(databaseValue)

    override fun encode(value: KDate): String = value.isoDate
}
