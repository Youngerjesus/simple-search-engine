package example.kotlin.app



class Size(val width: Int, val height: Int) {
    val area: Int = width * height
}

object PlayingField {
    const val width = 2
}

fun main() {
    val size = Size(5, 3)
    println("${size.height}, ${size.width}")

    val width = PlayingField.width
}