package example.kotlin.app

import kotlin.math.min


fun main() {
    val n = readLine()!!.toInt()
    var before = Int.MIN_VALUE
    var isAscending = true

    for (i in 1..n) {
        val number = readLine()!!.toInt()
        if (before > number) {
            isAscending = false
            break
        }
        before = number
    }

    if (isAscending) println("YES") else println("NO")
}