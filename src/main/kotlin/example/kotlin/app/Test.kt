package example.kotlin.app

import java.util.Scanner
import kotlin.math.min

fun main () {
    val totalSeconds = System.currentTimeMillis() / 1000

    val oneYear = 60 * 60 * 24 * 365
    val remainYear = totalSeconds - oneYear * (totalSeconds / oneYear)

    val oneDay = 60 * 60 * 24
    val remainDay = remainYear - oneDay * (remainYear / oneDay)

    val minutes = 60
    val seconds = 60
    val currentHour = remainDay / (minutes * seconds)
    val currentMinutes = (remainDay - currentHour * minutes * seconds) / (seconds)
    val currentSeconds = (remainDay - currentHour * minutes * seconds - currentMinutes * seconds) % seconds

    print("$currentHour:$currentMinutes:$currentSeconds")
}
