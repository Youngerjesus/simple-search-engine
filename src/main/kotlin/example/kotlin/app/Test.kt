package example.kotlin.app



class Size(val width: Int, val height: Int) {
    val area: Int = width * height
}

object PlayingField {
    const val width = 2
}

class Cat(val name: String, val age: Int) {
    val enoughCat = false // Of course, it's a false, there are never enough cats!
    init {
        require(age >= 0) { "Invalid age: $age" }        // IllegalArgumentException
    }
}

fun main() {
    val mutableListOf = mutableListOf(Cat("test", 5), 5, 5, 5.5)
    println(mutableListOf)
}

fun whatever(num: Int) {
    println("method start")
    val cat = Cat("nae", 2)
    println(cat)
}