package example.kotlin.app

fun main () {
    //put your code here
    val str = """
    {
        "firstName": "John",
        "lastName": "Smith",
        "age": 35,
        "phoneNumbers": [
            {
                "type": "mobile",
                "number": "123 567-7890"
            }
        ]
    }
    """

    println(str.trimIndent())
}

fun divide(a: Long, b: Long): Double = a.div(b.toDouble())

fun isVowel(alphabet: Char): Boolean {
    val listOf = listOf('A', 'E', 'I', 'O', 'U')
    return listOf.contains(alphabet.uppercaseChar())
}

fun getLastDigit(number: Int): Int = if (number > 0) number.mod(10) else 10 - number.mod(10)

fun isRightEquation(first: Int, second: Int, third: Int): Boolean = first * second == third