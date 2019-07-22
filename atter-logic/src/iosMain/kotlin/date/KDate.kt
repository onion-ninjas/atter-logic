package date

import platform.Foundation.NSDate
import platform.Foundation.NSISO8601DateFormatter

actual class KDate constructor(date: NSDate) {

    actual val isoDate: String

    val date: NSDate = date

    init {
        val isoFormatter = NSISO8601DateFormatter()
        val isoDate = isoFormatter.stringFromDate(date)

        this.isoDate = isoDate
    }

    actual companion object {
        actual fun now(): KDate = KDate(NSDate())
    }
}
