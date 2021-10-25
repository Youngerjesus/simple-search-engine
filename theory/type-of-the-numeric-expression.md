# Theory: Type of the numeric expression

> You already know how to perform type conversion. There are more advanced aspects of it: for example, you know that we cannot assign a variable of Int type to a Long variable. But what happens if we calculate the sum of Int and Long variables? In this case, the type is inferred from the context.

***

## Type coercion

> In such cases, the compiler automatically sets all components (it's called type coercion) and the result type to the widest type in the expression. The picture below illustrates the direction of this casting:
>
> Since the type of the result is wider than the previous type, there is no loss of information.
> 
> Type coercion is rare in Kotlin. It works only with numbers and strings.

- 코틀린에서는 다른 타입끼리 대입하는건 불가능하지만 연산은 가능하다. 
- 다른 타입들을 연산한다고 하면 연산의 구성요소들을 보고 가장 포괄할 수 있는 넓은 타입으로 해준다. (byte, short -> int -> Long -> float -> double 순으로)

***

## Examples

> The theory looks pretty clear, so let's take a look at some examples of type coercion.
>
> from Int to Long:
> 
> ```kotlin
> val num: Int = 100
> val longNum: Long = 1000
> val result = num + longNum // 1100, Long
> ```
> 
> Although result is just 1100, it is the sum of Long and Int variables, so the type is automatically cast to Long. If you try to declare a result as Int, you get an error because you cannot assign the value of Long type to an Int variable. You can assign only an Int value or an integer number to a variable of Int type.
>
> from Long to Double:
>
> ```kotlin
> val bigNum: Long = 100000
> val doubleNum: Double = 0.0
> val bigFraction = bigNum - doubleNum // 100000.0, Double
> ```

- 위의 Type coercion 의 예제다.
- int 와 Long 을 연산하면 결과는 Long 타입으로 강제 변환된다. 
- Long 과 double 을 연산하면 결과는 Double 타입으로 강제 변환된다.

***

## Short and Byte types

> You can see how the result of an expression with variables of different types is automatically cast to the widest type. However, the Byte and Short types are unusual in this respect. If you need to do some calculations with these types, the result of the calculation is Int:
> 
> Byte and Byte
>
> ```kotlin
> val one: Byte = 1
> val two: Byte = 2
> val three = one + two // 3, Int
> ```
> 
> Short and Short
>
> ```kotlin
> val fourteen: Short = 14
> val ten: Short = 10
> val four = fourteen - ten // 4, Int
> ```
> 
> Short and Byte
>
> ````kotlin
> val hundred: Short = 100
> val five: Byte = 5
> val zero = hundred % five // 0, Int
> ````
> 
> So what should we do if we want to sum two Byte variables and get a Byte result? Well, in this case, you must manually perform type conversion:
>
> `````kotlin
> val one: Byte = 1
> val five: Byte = 5
> val six = (one + five).toByte() // 6, Byte
> `````

- Byte 와 Short 는 이런 타입 강제변환이 약간 특이한데 연산을 하면 무조건 int 로 변화된다.
- Byte + Byte 도 int 로 되고, Short + Short 로 int 로 된다. 둘 이 섞여있어도 int 로 변환된다.
- 수동으로 Byte 나 SHort 타입을 얻고 싶다면 수동 변환을 해줘야한다.

***

## Summary

> To sum up, if you have an expression with different numeric types, use these rules to know the type of the result:
>
> 1. If either operand is of type Double, the result is Double.
> 2. Otherwise, if either operand is of type Float, the result is Float.
> 3. Otherwise, if either operand is of type Long, the result is Long.
> 4. Otherwise, the result is Int.
> 
> Type coercion does not occur when a value is put into the variable. For example, val longValue: Long = 10.toInt() is incorrect, because 10 is Int and longValue requires Long type.

- 즉 정리하자면 첫 번째 우선순위로 피연산자에 Double 이 있으면 타입 변환으로 Double 로 되고, 두 번째 우선순위는 피연산자에 float 이 있으면 결과는 float 이 적용된다.
- 세 번째 우선순위는 피 연산자에 Long 이 있으면 Long 이 돤다는 것이고 나머지로는 int 로 자동 변환된다.
- 근데 연산의 결과를 이미 선언한 변수에 넣는 경우에는 타입 강제 변환이 되지 않는다. 왜냐하면 이미 변수에 타입을 선언했으면 이를 바꿀 수 없기 때문이다.





