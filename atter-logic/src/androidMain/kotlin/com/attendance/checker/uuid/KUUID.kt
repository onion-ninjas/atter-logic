package com.attendance.checker.uuid

import java.util.*

actual class KUUID {
    actual val uuidString: String get() = UUID.randomUUID().toString()

    actual companion object {
        actual fun new(): KUUID = KUUID()
    }
}
