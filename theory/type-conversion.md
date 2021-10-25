# Theory: Type conversion

***

## Conversion between numeric types

> There are three most common numeric types: Int, Long, and Double. Sometimes, you may need to assign a value of one numeric type to a variable of another numeric type. In this case, you need to carry out type conversion by invoking a special function, for example, toInt(), toLong(), toDouble(), and so on.
> 
> Imagine, you have a variable called num, which is of the Int type. You want to pass this variable to a function called sqrt that finds the square root of a number. This function requires a Double value rather than Int, so you need to convert it using toDouble() to prevent a type mismatch error.
> 
> ````kotlin
> val num: Int = 100
> 
> val res: Double = Math.sqrt(num.toDouble())
> println(res) // 10.0
>
> println(num) // 100, it is not modified
> ````
> 
> In the example above, the variable types are specified to simplify the explanation.
>
> `toDouble() does not modify the type of the variable. This function produces a new value of the Double type.`
> 
> It's possible to perform these operations even when the target type is larger than the source type. So it means that we can convert Int to Long. It distinguishes Kotlin from other programming languages like Java and C#. They allow assigning numbers of a smaller type to variables of a larger type without extra actions.
> 
> ````kotlin
> val num: Int = 100
> val bigNum: Long = num.toLong() // 100
> ````
> 
> Char is not a numeric type, but you can convert a number to a character and vice versa according to the character code. You can take a look at the code in the Unicode table. This code is basically an integer number.
>
> ````kotlin
> val n1: Int = 125
> val ch: Char = n1.toChar() // '}'
> val n2: Int = ch.toInt()   // 125
> ````
> 
> If you have a value of a floating type, a Double value, for example, you may convert it to a value of an integer type, such as Int or Long.
>
> ````kotlin
> val d: Double = 12.5
> val n: Long = d.toLong() // 12
> ````
> 
> As you can see, the fractional part is simply dropped.
>
> Also, you can convert a number from a larger type to a smaller type ( Long or Double to Int) using the functions mentioned above.
>
> ````kotlin
> val d: Double = 10.2
> val n: Long = 15
>
> val res1: Int = d.toInt() // 10
> val res2: Int = n.toInt() // 15
> ````
> 
> However, this conversion may truncate the value, as Long and Double can store numbers larger than the truncated Int number.
> 
> ````kotlin
> val bigNum: Long = 100_000_000_000_000
>
> val n: Int = bigNum.toInt() // 276447232; oops
> ````
> 
> As a result, we receive a truncated value. This problem is known as type overflow. The same problem may occur if you try to convert Int to Short or Byte. So, if you want to convert a larger type value into a smaller one, make sure that the truncation is not going to mess up your program.

- 코틀린에서 numeric 타입의 경우 type conversion 을 메소드 형태로 사용하기 쉽게 제공해준다.
  - 예로 int 를 double 로 변환하고 싶다면 toDouble() 메소드를 호출하기만 하면 된다.
  - 이때 메소드를 호출한 변수 값이 바뀌는게 아니라 새로운 값이 반환된다.
- Type Conversion 에서 Source 타입이 Target 타입보다 더 작은 경우에도 확실하게 타입 변환을 할 수 있다는 점이 C# 과 자바와의 차이다.
- 그리고 Char 타입의 경우 numeric 타입이 아닌데도 불구하고 int 로 타입 변환을 할 수 있고 int 도 char 로 타입변환을 하는게 가능하다. 이 경우에는 Unicode Table 을 따라간다.
- Source 타입이 Target 타입보다 더 큰 경우라면 Truncate 를 할 때 주의하자. (값이 잘릴수도 있으니까. 여기서는 Type Overflow 라고도 한다.)

***

## Conversion to Short and Byte types

> As you know, the Short and Byte types are really small. These types are rarely used, and if you need to store an integer number, you should use Int. Here is an example of why you need to do it.
>
> Normally, you can use functions toShort() and toByte() to convert something to these types. Since Kotlin 1.4, you should avoid these functions when you try to convert Double or Float type. This feature will be removed in future releases. The main problem here is that the conversion can lead to unexpected results due to the variable's smaller size. Now, you need to convert Double or Float to Int and then convert the result to Short or Byte:
>
> ```kotlin
> val floatNumber = 10f
> val doubleNumber = 1
>
> val shortNumber = floatNumber.toShort() // avoid this
> val byteNumber = doubleNumber.toByte()  // avoid this
>
> val shortNumber = floatNumber.toInt().toShort() // correct way
> val byteNumber = doubleNumber.toInt().toByte()  // correct way
> ```

- Kotlin 에서 Double 과 Float 타입을 Type Conversion 할 때 Short 와 Bytes 로 변환하지 않도록 주의해라. (왜냐하면 너무나 사이즈가 작으니까 제대로 부동 소수점 계산을 하기가 어렵겠지.)
- 그래서 코릍린 1.4 에서는 바로 short 나 byte 타입으로 변환을 못한다. 

***

## String conversion

> Sometimes you need to get a string representation of a value of another type. Kotlin provides the toString() function for that. It can convert a value of any type to a string.
>
> ```kotlin
> val n = 8     // Int
> val d = 10.09 // Double
> val c = '@'   // Char
> val b = true  // Boolean
> 
> val s1 = n.toString() // "8"
> val s2 = d.toString() // "10.09"
> val s3 = c.toString() // "@"
> val s4 = b.toString() // "true"
> ```
> 
> A string can be converted to a number or even to a boolean value but not to a single character.
>
> ````kotlin
> val n = "8".toInt() // Int
> val d = "10.09".toDouble() // Double
> val b = "true".toBoolean() // Boolean
> ````
> 
> If a string representation has an invalid format, it will produce an error. After that, the program will stop unless you take special actions. We will discuss them later.
> 
> However, if you convert a string to a boolean value, no errors will occur. If the string is "true" (case insensitive), it will produce a true boolean value, otherwise a false one.
> 
> ````kotlin
> val b1 = "false".toBoolean() // false
> val b2 = "tru".toBoolean()   // false
> val b3 = "true".toBoolean()  // true
> val b4 = "TRUE".toBoolean()  // true
> ````

- 일반적인 primitive 을 String 으로 변환하기 쉽다. toString() 메소드만 호출하면 되므로.
- 그리고 String 도 primitive 타입으로 변환할 수 있다. 이때 변환하는 쪽으로 올바른 값이 아니라면 에러를 낸다 Boolean 타입을 제외하고
- Boolean 타입은 올바른 값이 아니라면 그냥 false 로 변환된다.

***

## Demonstration

> The program below demonstrates the functions discussed above. It reads a string representation of a number, converts it to several other types, and then prints the results of all conversions.
>
> ````kotlin
> fun main() {
>    val something = readLine()!!
>
>   val d = something.toDouble()
>   val f = d.toFloat()
>   val i = f.toInt()
>   val b = i.toByte()
>
>   println(d)
>   println(f)
>   println(i)
>   println(b)
>   println(something.toBoolean())
> }
> ````
>
> Imagine, we have the following input:
>
> `1000.0123456789`
> 
> ```
> 1000.0123456789
> 1000.0123
> 1000
> -24
> false
> ```
> 
> Let's take a closer look at the output. The number represented by a string is successfully converted to Double, as it has a suitable format. This number can be saved as a Double type safely. Then the number is converted to Float. We see a loss here, as this type can store fewer decimal numbers. The Int conversion cuts the fractional part. The number 1000 is larger than the Byte type can store (from -128 to 127), so we have a type overflow (-24). The result of converting the input string to Boolean is false, because the value is not "true".

- 위에 String Conversion 에 대한 예시다.


