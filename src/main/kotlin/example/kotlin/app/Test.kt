package example.kotlin.app

fun main () {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    val triple = intArrayOf(a,b,c).sortedArrayDescending()

    if (triple[0] < triple[1] + triple[2]) {
        println("YES")
    }
    else {
        println("NO")
    }
}
