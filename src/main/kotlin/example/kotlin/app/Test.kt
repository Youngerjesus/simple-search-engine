package example.kotlin.app

fun main() {
    val sumObject = ::sum
    println(sumObject(1,2))
}

fun sum(a: Int, b: Int): Int = a + b