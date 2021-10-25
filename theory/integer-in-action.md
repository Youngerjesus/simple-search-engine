# Theory: Integers in action

***

## Int and long integer types

> Programmers often use integer numbers with their programs. As you may recall, Kotlin has several integer types. The most popular are Int (32 bits) and Long (64 bits). You can perform all types of arithmetic operations (+, -, *, /, %) with variables of these types. Let's take a look at several examples.
>
> ````kotlin
> val two = 2  // Int
> val ten = 10 // Int
>
> val twelve = two + ten // 12
> val eight = ten - two  // 8
> val twenty = two * ten // 20
> val five = ten / two   // 5
> val zero = ten % two   // 0, no remainder
> ````
> 
> You know what these operations do. Long type integers support all these operations as well. To declare a variable of the Long type, you may choose one of these ways:
>
> ```kotlin
> val longNumber1 = 1_000_000_000_000_000
> val longNumber2: Long = 1_000_000
> val longNumber3 = 1000L
>
> val result = longNumber1 + longNumber2 - longNumber3
> println(result) // 1000000000999000
> ```
> 
> The longNumber1 value is of the Long type because it is greater than the possible value of the Int type. The longNumber2 value is also Long because we have specified the type. The longNumber3 value is Long because we have tagged the value with the suffix L (Long). The result is Long, as it is the sum of three Long integers.

- Int 와 Long 의 차이는 비트 수가 가장 대표적이다.
- Long 타입 선언은 여러가지 방법이 있다. Long 으로 명시적으로 선언하는 것 외에 int 를 넘는 수를 선언하면 자동으로 Long 타입이 되기도하고 숫자 끝에 L 을 붙이면 Long 타입으로 읽힌다.

***

## Reading numbers from the standard input

> To solve a problem, you generally need to read data from the input, process it, and output the result. For example, this program reads two numbers from the standard input, performs addition, and outputs the sum.
> 
> ```kotlin
> fun main() {
>   val a = readLine()!!.toInt()
>   val b = readLine()!!.toInt()
>
>   val sum = a + b
>
>   println(sum)
> }
> ```
> 
> The readLine() part is responsible for reading data. It works for positive, negative, and zero numbers because the Int type supports all of them.
>
> If we know that input numbers can be large, we can read Longs instead of Ints:
> 
> ```kotlin
> val a = readLine()!!.toLong()
> val b = readLine()!!.toLong()
> ```
> 
> After that, we don't need to change anything.

- readLine 함수로 int 와 long 타입 모두 읽을 수 있다. positive number, negative number, zero 모두 다. 