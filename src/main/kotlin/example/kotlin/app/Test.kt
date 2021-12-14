package example.kotlin.app

fun main() {
    var count = 0

    val changeAndPrint = { count: Int -> println(count) }

    println(count)    // 0
    changeAndPrint(count)  // 1
    count += 10
    changeAndPrint(count)  // 12
    println(count)    // 12
}

fun sum(a: Int, b: Int): Int = a + b