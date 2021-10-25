# Theory: Reading data with a readLine

> In this topic, you will learn how we can read information from the user input and interact with it. Quite often, programs prompt the user for some specific information. We will also see how to manage variables with the function readLine() and work with different types.

***

## Standard input

> Standard input is a stream of data that goes into the program. It is supported by the operating system. By default, standard input obtains data from the keyboard, but it is also possible to get it from a file.
> 
> Not all programs need to use standard input, but still, you're likely to use it quite often. A typical way of solving programming problems goes as follows:
> - Read data from the standard input;
> - Process data to obtain a result;
> - Output the result to the standard output.
> 
> Before you start writing programs that do something useful, you need to understand how to read data from the standard input.

- 그냥 뭐 Operating System 의 도움을 통해서 keyboard 나 file 로 부터 데이터를 읽어오는게 가능하다. 그게 Standard Input 이고.

***

## Using readLine

> In Kotlin, to read data from the standard input you can use the function readLine(). It reads the whole line as a string:
>
> ```kotlin
> val line = readLine()!!
> ```
>
> The variable line has the type String because the expression readLine()!! returns a value of this type.
>
> You are probably a little confused about the exclamation marks. This construction guarantees non-empty input to the compiler. We will talk about it in more detail later.
>
> Here is a simple program that reads a line from the standard input and sends it to the standard output:
>
> ````kotlin
> fun main() {
>   val line = readLine()!!
>   println(line)
> }
> ````
> 
> Here is an example of valid input data:
>
> ```
> Hello, Kotlin
> ```
> 
> The output would be the following:
>
> ```
> Hello, Kotlin
> ```
> 
> By default, to see the information about the entered data you need to press Enter.
>
> Now, let's see how you can read different types of data using readLine().

- readLine() 이라는 메소드로부터 데이터를 읽어오는게 가능하고 이때는 String 타입이라고 한다.
- readLine() 에 !! 를 붙이면 컨파일러에게 값이 비어있지 않다는 의미를 전달해준다.
- println() 을 통하면 출력하는게 가능하다. (Standard Output)

***

## toInt() and toLong()

> Sometimes we need to get numeric data from the user. For example, suppose we need to get information about the user's age or graduation year. To work with numeric values, use the function toInt(). To convert the input to an integer, use the toInt()function and dot syntax:
> 
> ````kotlin
> println("Print any number: ") 
> val number = readLine()!!.toInt()
> print("You printed the number: ")
> print(number)
> ````
>
> Here is an example of valid input data:
>
> ```
> 56
> ```
> 
> The output is:
>
> ```
> Print any number: 
> 56
> You printed the number: 56
> ```
> 
> In case we need to process a larger number, for example, the cost of a large and luxurious yacht, use the function toLong():
>
> ```
> println("How much is your yacht worth?")
> val cost = readLine()!!.toLong()
> print("You printed: ")
> print(cost)
> ```
> 
> The output is:
>
> ```
> How much is your yacht worth?
> 10000000000
> You printed: 10000000000
> ```

- readLine()!! 메소드로 String 말고 int 와 Long 같은 타입으로 받을수도 있다. 그냥 변환하는 메소드 호출하면 된다.

***

## toDouble() and toBoolean()

> What if we need to get more accurate values? For example, suppose we need to know the exact price of a liter of gasoline. In this case, we cannot use toInt() or toLong() since likely we won't have a whole number. For this purpose, use the function toDouble():
>
> ```kotlin
> println("Print any double type number:")
> val number = readLine()!!.toDouble()
> println("You printed the number: ")
> print(number)
> ```
> 
> The output is:
> ```
> Print any double type number:
> 0.5673421
> You printed the number: 0.5673421
> ```
> 
> The same logic works for Boolean: use the function toBoolean():
>
> ```kotlin
> println("The earth is flat. Print true or false:")
> val answer = readLine()!!.toBoolean()
> print("The earth is flat: ")
> print(answer)
> ```
> 
> The output is:
>
> ```
> The earth is flat. Print true or false:
> false
> The earth is flat: false
> ```

- 정수형이 아니라 double 이나 boolean 타입으로 받고 싶어도 readLine() 후에 관련 메소드를 호출하면 된다.

***

## Multiple inputs

> Is it possible to receive and process multiple inputs? The answer is yes: all we need to do is declare a few different variables, all with the value of the function readLine()!!. If you want to enter several values and their data types are different, then you need to press Enter in order to separate the different types.
>
> Consider an example that illustrates the input and output of multiple values:
>
> ```kotlin
> val a = readLine()!!
> val b = readLine()!!.toInt()
> val c = readLine()!!
> print(a)
> print(" ")
> print(b)
> print(" ")
> print(c)
> ```
> 
> Here is an example of valid String and Int input values:
>
> ```
> You earned
> 100
> points!
> ```
> 
> The output is:
>
> ```
> You earned 100 points!
> ```

- readLine() 을 통해서 여러개의 변수를 입력받는 것도 가능하다.

````kotlin
fun main () {
    val s1 = readLine()!!
    val s2= readLine()!!
    val s3 = readLine()!!
    val s4 = readLine()!!
    val s5 = readLine()!!

    print("$s1 $s2 $s3 $s4 $s5")
}
````

이렇게 출력하는 것도 가능함. 

***

## Reading multiple values in one line

> If you need to read two values in one line, you can use this construction:
>
> ```kotlin
> val (a, b) = readLine()!!.split(" ")
> println(a)
> println(b)
> ```
> 
> Here is an example of input data:
>
> ```text
> Hello, Kotlin
> ```
> 
> The output would be the following:
> 
> ```text
> Hello,
> Kotlin
> ```
> 
> This construction splits the input string at spaces and stores the words in the variables a and b. We will discuss this in more detail later.
>
> In the same way, you can read up to five values per line:
>
> ```kotlin
> val (a, b, c, d) = readLine()!!.split(" ")
> println(a)
> println(b)
> println(c)
> println(d)
> ```
> 
> Here is an example of input data:
>
> ```text
> Have a nice Kotlin
> ```
> 
> The output would be the following:
>
> ```text
> Have
> a
> nice
> Kotlin
> ```

- readLine() 에서 하나의 라인으로 여러개의 변수를 입력받을 수도 있다. 변수 선언부에서 () 으로 감싸면 되고 readLine() 으로 받은 String 타입을 split() 으로 쪼개면 가능하다.





