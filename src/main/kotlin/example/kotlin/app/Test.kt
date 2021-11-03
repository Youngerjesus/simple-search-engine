package example.kotlin.app

fun main () {
    val butterCups = readLine()!!.toInt()
    val isWeekend = readLine()!!.toBoolean()

    val result = if (isWeekend) butterCups in 15..25 else butterCups in 10..20
    println(result)
}

