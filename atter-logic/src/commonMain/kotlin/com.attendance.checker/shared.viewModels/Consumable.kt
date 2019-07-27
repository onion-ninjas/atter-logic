package com.attendance.checker.shared.viewModels

data class Consumable<T : Any>(
    val value: T
) {

    private var hasBeenConsumed = false

    fun consume(consumer: (T) -> Unit) {
        if (!hasBeenConsumed) {
            consumer(value)
            hasBeenConsumed = true
        }
    }
}

fun <T : Any> T.toConsumable() = Consumable(this)
