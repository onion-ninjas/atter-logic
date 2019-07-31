package com.attendance.checker.uuid

expect class KUUID {
    val uuidString: String

    companion object {
        fun new(): KUUID
    }
}
