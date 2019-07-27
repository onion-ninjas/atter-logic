package date

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

actual class KDate(val date: LocalDateTime) {

    actual val isoDate = date.format(DateTimeFormatter.ISO_DATE_TIME)

    actual companion object {
        actual fun now(): KDate = KDate(LocalDateTime.now())
    }
}
