# Theory: For loop and ranges

> Often you need to do some action repeatedly. For example, if you want to find the sum of numbers from 1 to 100 (without formula), you need to add the numbers sequentially. To do this, you may use the for loop and ranges, which you are already familiar with. Let's take a closer look at this!

***

## For loop

> Kotlin provides the for loop to iterate through ranges, arrays, and other collections of elements. We will meet them later.
>
> This is the syntax the for loop has:
>
> ````kotlin
> for (element in source) {
>     // body of loop
> }
> ````
> 
> The body of this loop consists of one or more statements that are executed for each element from the specified source. The loop stops after having processed the last element.

- kotlin 에서는 for loop 을 지원한다. (이는 ranges, arrays, collection 에서 사용이 가능하다.)

***

## Iterating through a range

> The simplest example of using the for loop is printing each element of an integer range.
>
> ```kotlin
> for (i in 1..4) {
>     println(i)    
> }
> ```
>
> This loop prints each number from 1 to 4.
>
> ```kotlin
> 1
> 2
> 3
> 4
> ```
> 
> It is also possible to iterate through a range of characters:
>
> ```kotlin
> for (ch in 'a'..'c') {
>     println(ch)
> }
> ```
> 
> This loop prints:
> 
> ```kotlin
> a
> b
> c
> ```
> 
> From now on, all the examples will be about numbers because iterating through characters is always the same.

- Kotlin 에서 range 를 이용한 for loop

***

## Iterating through a String

> Also, you may iterate over strings. The following code prints each symbol of a String:
>
> ```kotlin
> val str = "Hello!"
> for (ch in str) {
>     println(ch)    
> }
> ```
> 
> This code prints:
>
> ```kotlin
> H
> e
> l
> l
> o
> !
> ```

- Kotlin 에서 String 을 이용한 for loop

***

## Iterating in the backward order

> You can also iterate a range in the backward order.
> 
> ````kotlin
> for (i in 4 downTo 1) {
>     println(i)
> }
> ````
> 
> This loop prints numbers from 4 to 1.
>
> ```
> 4
> 3
> 2
> 1
> ```

- Kotlin 에서 downTo 를 통해서 역순으로 하는게 가능.

***

## Excluding the upper limit

> If we need to exclude the upper limit from a range, we can subtract one from it or write until instead of ..:
>
> ```kotlin
> for (i in 1 until 4) {
>     println(i)
> }
> ```
> 
> This loop prints numbers from 1 to 3.

- 'until' 을 통해서 범위를 제한시키는것도 가능. (range 에서 until 을 쓰는게 가능.)

***

## Specifying a step

> If we do not specify a step, it is assumed that the step is equal to one (e.g. 1, 2, 3, ...). Although if we want to change the step, we need to specify it explicitly.
>
> In the example below, we print only odd numbers from the range 1..7.
>
> ```kotlin
> for (i in 1..7 step 2) {
>     println(i)
> }
> ```
> 
> This loop prints four numbers:
>
> ```kotlin
> 1
> 3
> 5
> 7
> ```
> 
> You can also use it for backward iteration.
>
> ```kotlin
> for (i in 7 downTo 1 step 2) {
>     println(i)
> }
> ```
> 
> This loop prints:
>
> ````
> 7
> 5
> 3
> 1
> ````

- step 을 통해서 for loop 의 증가폭(?) 을 결정해줄 수 있다.

***

## An example: the factorial of a number

> Let's write a program that calculates the factorial of a given integer number. It's a classic. The factorial of n is a product of integer numbers from 1 to n inclusive. Assumed that factorial of 0 is 1. The factorial of 1 is 1 as well.
>
> ```kotlin
> fun main() {
>     val n = readLine()!!.toInt()
>     var result = 1 // starting value of the factorial
> 
>     for (i in 2..n) { // the product from 2 to n
>         result *= i
>     }
> 
>     println(result)
> }
> ```
> 
> The program above reads an integer number from the standard input. We suppose that the starting value of the factorial is 1 and then sequentially multiply it by numbers from 2 to n. If the input number is 1, the result is 1. If the input number is 5, the result is 120.

***

## An example: the multiplication table of even numbers

> You can nest one for loop in the body of another for loop because loops are just regular statements. Programmers often use nested loops to process multidimensional structures like tables (matrices), data cubes, and so on.
>
> For example, the code below prints the multiplication table of even numbers from 2 to 10.
>
> ```kotlin
> fun main() {
>     for (i in 2..10 step 2) {
>         for (j in 2..10 step 2) {
>             print(i * j)
>             print('\t')  // print the product of i and j followed by one tab
>         }
>         println()
>     }
> }
> ```
> 
> It prints:
>
> ```kotlin
> 4   8   12  16  20  
> 8   16  24  32  40  
> 12  24  36  48  60  
> 16  32  48  64  80  
> 20  40  60  80  100
> ```

***
