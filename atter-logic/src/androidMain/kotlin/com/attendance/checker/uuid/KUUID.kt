package com.attendance.checker.uuid

import java.util.*

actual class KUUID {
    actual val uuidString: String get() = UUID.randomUUID().toString()
}