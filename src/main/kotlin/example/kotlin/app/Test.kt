package example.kotlin.app


fun main() {
    val age = readLine()!!.toInt()
    println(age in 18..59)
}