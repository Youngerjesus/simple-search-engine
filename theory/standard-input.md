# Theory: Standard input

***

## ReadLine function

> Kotlin has a useful function to read data from the standard input. It is readLine. It reads the whole line as a string:
>
> ```kotlin
> val line = readLine()!!
> ```
> 
> The line variable is of the String type because the readLine()!! expression returns a value of this type.
>
> `Why exclamation marks? We will discuss this later. For now, just memorize it as a special type of construction. You may read about it in JetBrains Academy's Null Safety topic.`
> 
> Here is a program that reads a line from the standard input and sends it to the standard output:
>
> ````kotlin
>  fun main() {
>    val line = readLine()!!
>    println(line)
> }
> ````
> 
> Here is an example of valid input data:
> `Hello, Kotlin`
> 
> The output is:
> `Hello, Kotlin`
> 
> This function has several shortcomings. If you'd like to read several values from the same line one by one, you need to perform additional actions.
> 
> If you need to get a number from the input, you can use this construction: val number = readLine()!!.toInt(). We will discuss it in more detail later.

- Kotlin 에서는 readLine()!! 이라는 함수로 스트림 입력을 받을 수 있다. 여기에서 반환되는 타입은 String 이다.
- 만약에 input 을 Boolean 타입이나 Int 타입으로 변환하고 싶다면 readLine().toBoolean() 함수나 toInt() 함수를 쓰면된다.

## Java Scanner

> Another way to obtain data from the standard input is to use the Java Scanner. You can access it directly from Kotlin because it is interoperable with other Java libraries. Scanner allows a program to read values of different types (strings, numbers, etc) from the standard input.
>
> To use this type, you need to add this import statement to the top of your file with the source code:
> ```java
> import java.util.Scanner
> ```
> 
> or 
> 
> ````java
> import java.util.*
> ````
> 
> You can use any method to add Scanner to your program. We will discuss importing in a more detailed way later.
>
> Let's create a variable initialized by Scanner:
>
> ````kotlin
> val scanner = Scanner(System.`in`)
> ````
> In this line, System.`in` is an object that represents the standard input stream. The scanner wraps it as an internal data source and provides a set of convenient methods to work with it.
> 
> Now we can read data from the standard input:
>
> ````kotlin
> val line = scanner.nextLine() // read a whole line, i.e. "Hello, Kotlin"
> val num = scanner.nextInt()   // read a number, i.e. 123
> val string = scanner.next()   // read a string, i.e. "Hello"
> ````
> 
> Scanner.next() reads only one word, not a line. A word is separated from other words by one or more delimiters, such as spaces or a new line character. If the user enters Hello, Kotlin, it will read Hello,.
>
> After you call scanner.nextLine() or scanner.nextInt() or something else, the program will anticipate input data. Here is an example of correct input data:
>
> ```
> Hello, Kotlin
> 123 Hello
> ```
> 
> The input example below is also valid:
>
> ```
> Hello, Kotlin
> 123
> Hello
> ```
> 
> It's possible to read a number as a string using scanner.next() or scanner.nextLine() if the number is on a new line.
>
> Also, the Scanner type provides several methods (functions) for reading values of other types. Refer to the Class Scanner documentation for more details.
>
> The program below reads two numbers and outputs them in reverse order on two different lines:
> 
> ```kotlin
> import java.util.Scanner // a class (type) from the Java standard library
> fun main() {
>   val scanner = Scanner(System.`in`) // reads data
>
>   val num1 = scanner.nextInt() // reads the first number
>   val num2 = scanner.nextInt() // reads the second number
> 
>   println(num2) // prints the second number
>   println(num1) // prints the first number
> 
> ```

- readLine() 뿐 아니라 Java 에서 사용되는 Scanner 를 통해서도 입력받는게 가능하다. 코틀린은 자바와 호환되기 때문에 그냥 자바에 있는 라이브러리를 import 해서 가지고오면 된다.
- Scanner 를 사용할 땐 사용할 Input Stream 을 생성자에 넣어주면 사용할 수 있다.
- Scanner.next() 함수는 한 라인이 아니라 한 단어 위주로 값을 읽어오는 함수로 단어를 구별할 땐 space 나 줄바꿈 키를 기준으로 구별한다.