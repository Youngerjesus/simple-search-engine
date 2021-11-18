package example.kotlin.app



class Size(val width: Int, val height: Int) {
    val area: Int = width * height
}

fun main() {
    val size = Size(5, 3)
    println("${size.height}, ${size.width}")
}