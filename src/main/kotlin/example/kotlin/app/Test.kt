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
        check(false) {"Invalid"}
        require(age >= 0) { "Invalid age: $age" }        // IllegalArgumentException
    }
}

fun main() {
    whatever()
}

fun whatever() {
    val rangeStart = 'C'
    val rangeEnd = 'Y'
    val findLetter = 'Q'
    for (c in rangeStart..rangeEnd) {
        if (c == findLetter) {
            System.out.printf(
                "Character %s is within range %s-%s",
                findLetter, rangeStart, rangeEnd
            )
            return
        }
    }
    System.out.printf(
        "Character %s is within range %s-%s",
        findLetter, rangeStart, rangeEnd
    )
}