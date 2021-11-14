# Theory: Ranges

> Imagine a situation when you need to check whether the integer variable c is greater than or equal to a and less than or equal to b. To do that you may write something like this:
>
> ````kotlin
> val within = a <= c && c <= b
> ````
> 
> This code works well. However, Kotlin provides a more convenient way to do the same thing using ranges:
>
> ````kotlin
> val within = c in a..b
> ````
> 
> Here, a..b is a range of numbers from a to b (including both border values), in is a special keyword that is used to check whether a value is within a range. Later you will see that this keyword can be used with other types as well.
>
> The value of within is true if c belongs to the range inclusively, otherwise, it is false.
>
> Here are some examples:
>
> ````kotlin
> println(5 in 5..15)  // true
> println(12 in 5..15) // true
> println(15 in 5..15) // true
> println(20 in 5..15) // false
> ````
> 
> If you need to exclude the right border, you may subtract 1 from it:
>
> ````kotlin
> val withinExclRight = c in a..b - 1 // a <= c && c < b
> ````
> 
> If you need to check that a value is not within a range, just add ! (not) before in.
>
> ````kotlin
> val notWithin = 100 !in 10..99 // true
> ````
> 
> You may combine ranges using standard logical operators. The code below checks if c is within one of three ranges.
>
> ````kotlin
> val within = c in 5..10 || c in 20..30 || c in 40..50 // true if c is within at least one range
> ````
> 
> You can assign a range to a variable and use it later.
>
> ````kotlin
> val range = 100..200
> println(300 in range) // false
> ````
>
> In addition to integer ranges, you can also use ranges of characters and even strings (according to dictionary order).
>
> ````kotlin
> println('b' in 'a'..'c') // true
> println('k' in 'a'..'e') // false
> 
> println("hello" in "he".."hi") // true
> println("abc" in "aab".."aac") // false
> ````
> 
> This is enough to understand ranges for integer numbers and characters. We won't cover other type ranges here.

- 코틀린에서는 범위 검사를 사용할 때 Range 를 이용해서 좀 더 이해하기 쉬운 코드를 작성할 수 있다.
- Range 는 기본적으로  in a..b 로 표현되고 a <= <= b 조건을 나타낸다.
- Range 조건의 부등호는 !in 을 이용하면 된다.
- Range 조건들 끼리도 논리 연산자 결합이 가능하다.
- Range 조건 자체를 변수에 할당하는 것도 가능하다.
- Range 는 숫자 범위 뿐 아니라 사전 범위에서도 가능하다.

