# Theory: Repeating blocks

***

## Repeat loop

> To use the simplest loop, write repeat(n) and a sequence of statements in curly braces {...}. N is an integer that determines how many times these statements are going to be repeated.
>
> ```kotlin
> repeat(n) {
>     // statements
> }
> ```
> 
> For example, the program below prints Hello three times:
>
> ```kotlin
> fun main() {
>     repeat(3) {
>         println("Hello")
>     }
> }
> ```
> 
> Output:
>
> ```
> Hello
> Hello
> Hello
> ```

- 간단한 반복문이 필요하다면 repeat() {} 로 구현이 가능하다 라는 점.

***

## Reading and processing data in a loop

> You can read data from the standard input, declare variables and even perform calculations inside the repeat statement.
> 
> Take a look at this example. The program below reads numbers from the standard input and calculates their sum. The first number is not a part of the sum, it determines the length of the input sequence.
>
> ```kotlin
> fun main() {    
>     val n = readLine()!!.toInt()
>     var sum = 0
>     
>     repeat(n) {
>         val next = readLine()!!.toInt()
>         sum += next
>     }
>     
>     println(sum)
> }
> ```
> 
> This code reads a length of a number sequence and assigns it to the n variable. After that, it creates a variable to store the total sum. The code reads the next number and adds it to the sum exactly n times. Then, the loop stops, and the program prints the total sum.
>
> Here is an example of input numbers:
>
> ```kotlin
> 5
> 40
> 15
> 30
> 25
> 50
> ```
> 
> Output
> 
> ``` 
> 160
> ```