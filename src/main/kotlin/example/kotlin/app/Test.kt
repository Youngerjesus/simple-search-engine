package example.kotlin.app

fun main() {
    var southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
    southernCross += "Ginan" // will not compile
}

fun sum(a: Int, b: Int): Int = a + b