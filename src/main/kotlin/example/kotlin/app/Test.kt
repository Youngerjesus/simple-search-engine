package example.kotlin.app


fun main() {
    var a = 10
    when(a) {
        11, 12 -> print("Ok")
        in 1..22 -> print("Ok")
        a + a -> print("Ok")

    }
}