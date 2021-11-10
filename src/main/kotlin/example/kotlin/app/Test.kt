package example.kotlin.app

import java.time.LocalDateTime

class Calendar(var day: String = "-", var month: String = "-", var year: String = "-") {
    fun selectCurrentDay() {
        val now = LocalDateTime.now()
        day = now.dayOfMonth.toString()
        month = now.monthValue.toString()
        year = now.year.toString()
    }
}
fun createCalendar() =
    Calendar("-", "-", "-")

fun main() {
    val calendar = createCalendar()
    // write your code here
    calendar.selectCurrentDay()
    println("${calendar.day} ${calendar.month} ${calendar.year}")
}