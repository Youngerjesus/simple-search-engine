# Theory: Relational operators

Kotlin provides six relational operators to work with numbers:
- `==` — equal to X
- `!=` — not equal to X
- `>` — greater than X
- `>=` — greater than or equal to X
- `<` — less than X
- `<=` — less than or equal to X

***

## Comparing integer numbers

> Relational operators allow you to compare two integer numbers, among other things. Here are some examples:
>
> ````kotlin
> val one = 1
> val two = 2
> val three = 3
> val four = 4
> 
> val oneIsOne = one == one // true
> 
> val res1 = two <= three // true
> val res2 = two != four  // true
> val res3 = two > four   // false
> val res4 = one == three // false
> ````
> 
> You can use relational operators together with arithmetic operators. In these expressions, relational operators have a lower priority than arithmetic operators.
> 
> Let's take a look at the example below. First, Kotlin calculates two sums, and after that, they are compared with the > operator:
>
> ```kotlin
>  val number = 1000
>  val result = number + 10 > number + 9 // 1010 > 1009 is true
> ```
> 
> The result is true.
>
> Note that you cannot check the equality of Int and Long! You can compare Int and Long freely with >, <. >=, <=, but cannot use == and !=. You can check equality only for the same types, so you need to convert Int to Long:
>
> ```kotlin
>  val one: Long = 1
>  val zero: Int = 0
>  
>  println(one >= zero)          // OK, prints true  
>  // println(one == zero)          Error
>  println(one == zero.toLong()) // OK, prints false
> ```

- relational operator 의 결과를 변수에 넣는게 가능하다.
- 같은 타입이 아니라면 == 연산을 하는게 불가능하다. (타입이 다르면 비교 연산자만 사용할 수 있다.) 

***

## Joining relational operations

> Kotlin cannot process expressions like:
> 
> ```kotlin
>  a <= b <= c
> ```
> 
> You should join two Boolean expressions using logical operators like || and && instead.
>
> For example, let's say we need to check the validity of the following expression:
>
> ```kotlin
> 100 < number < 200
> ```
> 
> To do that, we should write something like this:
>
> ```kotlin
> number > 100 && number < 200
> ```
> 
> Also, we can put different parts of the expression in the parentheses:
>
> ````kotlin
> (number > 100) && (number < 200)
> ````
> 
> The parentheses are not necessary, though, as relational operators have a higher priority.
>
> Logical operators allow you to join a sequence of relational operations to a single expression. This is a widely used trick in programming.
>
> As a more complex example, let's write a program that reads an integer number and checks whether a number belongs to the following range — [100; 200] including 100 and 200:
>
> ```kotlin
> fun main() {
>      val left = 100
>      val right = 200
>      val number = readLine()!!.toInt()
>  
>      val inRange = number >= left && number <= right // joining two expressions using AND
>  
>      println(inRange)
>  }
> ```
> 
> You can have something like this:
> 
> 50 is false
>
> 99 is false;
>
> 100 is true;
>
> 200 is true, and so on.

- logical operator 보다 relational operator 가 우선순위가 좀 더 높다 라는 것. 
***


