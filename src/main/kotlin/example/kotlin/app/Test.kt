package example.kotlin.app

import kotlin.math.min


fun calcEndDayAmount(startAmount: Int = 0, ticketPrice: Int, soldTickets: Int) = startAmount + ticketPrice * soldTickets

fun calcEndDayAmount2 (startAmount: Int = 0, ticketPrice: Int = 0, soldTickets: Int = 0) =
    startAmount + ticketPrice * soldTickets

fun calcEndDayAmount3 (startAmount: Int = 0, ticketPrice: Int = 0, soldTickets: Int) =
    startAmount + ticketPrice * soldTickets

fun sum1(a: Int, b: Int = a) = a + b

fun sum2(a: Int = 0, b: Int) = a + b

fun main() {
    val calcEndDayAmount = calcEndDayAmount(startAmount = 10, ticketPrice = 20, 500)
    val calcEndDayAmount1 = calcEndDayAmount(10, 20, soldTickets = 50)
    val calcEndDayAmount2 = calcEndDayAmount(10, soldTickets = 30, ticketPrice = 40)

    val calcEndDayAmount21 = calcEndDayAmount2(0, 5)

    calcEndDayAmount3(0, soldTickets = 5)

    val sum1 = sum1(1, 2)
    val sum11 = sum1(5)
}