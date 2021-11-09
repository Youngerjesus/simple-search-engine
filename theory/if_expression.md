# Theory: If expression

***

## The single if-case

## The if-else-cases

## The if-else-if-cases

## Nested If's

- 이까지 대충 흔히 프로그래밍 언어에서 쓰는 조건문.

***

## Condition is an expression

> Unlike other languages (such as Java, Python, C#), in Kotlin if is an expression, not a statement. As a regular expression, it can return a value (result) of computations. The result must be the last expression in a body.
>
> This code finds the max of two integer numbers a and b. It prints the choice and stores the result to the max variable.
>
> ```kotlin
> val max = if (a > b) {
>     println("Choose a")
>     a
> } else {
>   println("Choose b")
>   b
> }
> ```
> 
> If you are going to use the if as an expression, it must have an else branch.
>
> In an expression-style if, it's better to produce results of the same type in all the branches because in this case, the type of the variable will be strict. However, in general, it's not required. Further, you will learn how to work with variables of an unknown type.
> 
> If all the bodies contain only a single statement, you can skip braces:
>
> ````kotlin
> val max = if (a > b) a else b
> ````
> 
> Sometimes we even do NOT need to declare a new variable for storing a result. In this example, we compare two numbers and print the text information passing it to a function.
>
> ````kotlin
> fun main() {
>    val a = readLine()!!.toInt()
>    val b = readLine()!!.toInt()
>
>    println(if (a == b) {
>        "a equal b"
>    } else if (a > b) {
>        "a is greater than b"
>    } else {
>        "a is less than b"
>    })
> }
> ````

- Kotlin 에서의 if 는 다른 언어에서의 if 와 다르게 expression 으로 사용이 가능하다. (다른 언어는 statement 로만 사용이 가능.)
- 그래서 if else 절을 이용해 변수에 값을 넣는 방법이 가능하다. 
- 이렇게 if 절을 expression 을 사용할 땐 같은 타입을 사용하도록 하는걸 권장한다. (어떤 타입을 사용하고 있는지 모르는 것 보다 그게 더 문제가 생겼을 때 추적하기 좋은듯.)

***

## Idiom

> It's time for the next idiom! Now we draw your attention to the expression-style if. You should prefer to use this form when you need to get some results. Of course, you may work with if as a statement, but using if as an expression is a better way. For example:
>
> ```kotlin
> val max = if (a > b) a else b // one line
> 
> ...
> 
> var max = a // try to avoid var if possible
> if (b > a) max = b
> ```
> 
> The second snippet may cause some trouble, for example, you may accidentally alter the value of the max variable or forget to change it. So we suggest you use expression-style if in those cases.

- if expression 은 one line 으로 사용하는 걸 권장한다.


