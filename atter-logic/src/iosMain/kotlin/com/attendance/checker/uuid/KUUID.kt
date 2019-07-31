package com.attendance.checker.uuid

import platform.Foundation.NSUUID

actual class KUUID {
    actual val uuidString: String get() = NSUUID().UUIDString

    actual companion object {
        actual fun new(): KUUID = KUUID()
    }
}
