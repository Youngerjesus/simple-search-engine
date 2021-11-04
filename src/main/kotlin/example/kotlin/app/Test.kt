package example.kotlin.app

class Box(n:Int) {
    var size = n

    fun addBall() = size++

}

fun main () {
    Box
    val blueBox = Box(3)
    val azureBox = blueBox
    val cyanBox = Box(3)
    println(blueBox == azureBox)  // true
    println(blueBox === azureBox) // true, azureBox points to the same object
    println(blueBox == cyanBox)   // true
    println(blueBox === cyanBox)  // false, cyanBox points to another object
}

fun divide(a: Long, b: Long): Double = a.div(b.toDouble())

fun isVowel(alphabet: Char): Boolean {
    val listOf = listOf('A', 'E', 'I', 'O', 'U')
    return listOf.contains(alphabet.uppercaseChar())
}

fun getLastDigit(number: Int): Int = if (number > 0) number.mod(10) else 10 - number.mod(10)

fun isRightEquation(first: Int, second: Int, third: Int): Boolean = first * second == third