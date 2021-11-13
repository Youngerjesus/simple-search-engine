package example.kotlin.app


fun main() {
    val char1 = readLine()!!.first().uppercaseChar()
    val char2 = readLine()!!.first().uppercaseChar()

    println(char1 == char2)
}