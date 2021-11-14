# Theory: When expression

> Kotlin provides a special when expression to perform different actions depending on the value of a variable. It is a very convenient approach to choose an option when you have several. This expression can replace if and make your code more readable.

- when 이라는 절을 통해서 if 절을 줄일 수 있다. (다양한 실행 흐름이 있는 경우에.) 이를 통해서 코드의 readability 가 올라가는.

***

## Alternatives

> For example, the program below performs addition, subtraction, and multiplication of two integer numbers. It uses when to decide what operation to perform:
>
> ```kotlin
> fun main(){
>    val (var1, op, var2) = readLine()!!.split(" ")
>
>    val a = var1.toInt()
>    val b = var2.toInt()
>
>    when (op) {
>        "+" -> println(a + b)
>        "-" -> println(a - b)
>        "*" -> println(a * b)
>        else -> println("Unknown operator")
>    }
> }
> ```
> 
> Let's take a closer look at it. Here, when takes an op and matches it against all values, one by one, until it finds a suitable value. There are three regular branches — "+", "-", "*", and also one else branch. The else branch is performed if none of the values matches the operator. You can skip the else branch, it is optional. If you write the same code with if, it would be less readable.
>
> If there are several cases to handle it, you can combine and separate them with a comma. You can combine as many values as you need in one branch. You can add a trailing comma. It can be helpful if you need to add a long list of cases. Here you can see a modified code snippet from the previous program:
>
> ```kotlin
> when (op) {
>     "+", "plus" -> println(a + b)
>     "-", "minus", -> println(a - b) // trailing comma
>     "*", "times" -> println(a * b)
>     else -> println("Unknown operator")
> }
> ```
> 
> This code works for the 5 + 8 input as well as for 5 plus 8.
>
> You can also use complex blocks with multiple statements as branches:
>
> ````kotlin
> when (op) {
>     "+", "plus" -> {
>         val sum = a + b
>         println(sum)
>     }
>     "-", "minus" -> {
>         val diff = a - b
>         println(diff)
>     }
>     "*", "times" -> {
>         val product = a * b
>         println(product)
>     }
>     else -> println("Unknown operator")
> }
> ````
> 
> As you can see, there are different ways to employ a when expression. Try to stick to the most readable one.

- when 절에서 여러 개의 값을 통해서 하나의 실행 흐름을 결정하는 것도 가능하다. (이 경우에 값은 ',' 로 분리해야한다.)
- when 절에서 복잡한 조건문을 실행할려면 '{}' 로 감싸면 된다.

***

## When as an expression

> When can also return a result. In this case, every branch should return something, and an else branch is required. In the code example below, every branch returns a result of the corresponding operation.
>
> ```kotlin
> val result = when (op) {
>     "+" -> a + b
>     "-" -> a - b
>     "*" -> a * b
>     else -> "Unknown operator"
> }
> println(result)
> ```
> 
> You don't need to declare an additional variable and immediately pass the result to a function. Take a look at the example below:
>
> ```kotlin
> println(when(op) {
>     "+" -> a + b
>     // ...
>     else -> "Unknown operator"
> })
> ```
> 
> Use this notation if you do not need to use the result somewhere else or when you keep your code short.
>
> If a branch contains a block with multiple statements enclosed in {...}, the last line must be a single value or a complex expression that will be performed and returned as the result of the when expression. Take a look at the modified branch from our example above:
>
> ````kotlin
> "+" -> {
>     val sum = a + b
>     sum
> }
> ````
> 
> Choose shorter forms without {...} in branches to make your code easier to understand.

- when 절을 통해서 결과를 가져오는 것도 가능하다. (이 경우에는 else 절이 필요.)
- when 절에서 '{}' 를 사용하고 결과를 가져오려면 마지막 문장에 변수를 적으면 된다.

***

## Branch conditions and ranges

> If you work with other programming languages like Java or C#, you may note that when is similar to a switch statement. When provides more complex checking, not only directly matching a value.
>
> The program below reads three integer numbers a, b, and c, and then tries to determine how to calculate c using a and b. If there are many ways to calculate c, it will print only the first one:
>
> ```kotlin
> fun main(){
>     val (var1, var2, var3) = readLine()!!.split(" ")
> 
>     val a = var1.toInt()
>     val b = var2.toInt()
>     val c = var3.toInt()
> 
>     println(when (c) {
>         a + b -> "$c equals $a plus $b"
>         a - b -> "$c equals $a minus $b"
>         a * b -> "$c equals $a times $b"
>         else -> "We do not know how to calculate $c"
>     })
> } 
> ```
> if input values are 5 3 2 the program outputs 2 equals 5 minus 3. If input values are 0 0 0, it outputs 0 equals 0 plus 0.
>
> Another interesting possibility is to check whether a value belongs to a range. Take a look:
>
> ```kotlin
> when (n) {
>     0 -> println("n is zero")
>     in 1..10 -> println("n is between 1 and 10 (inclusive)")
>     in 25..30 -> println("n is between 25 and 30 (inclusive)")
>     else -> println("n is outside a range")
> }
> ```
> 
> If the integer variable n is 0, the program evaluates the first branch. If n belongs to the 1-10 range inclusively, it evaluates the second branch. If n belongs to the range from 25 to 30 (including both borders), it evaluates the third branch. If n is not equal to 0 and does not belong to either range, the else branch is evaluated.
> 
> You can also combine ranges with a comma just like single values. It looks like this:
>
> ```kotlin
> in a..b, in c..d -> println("n belongs to a range")
> ```

- when 절에서 range 연산을 이용하는 것도 가능하다.

***

## When without arguments

> You can use a when expression without arguments. In this case, every branch condition is a simple boolean expression, and a branch is executed when its condition is true. If several conditions are true, only the first one will be executed.
>
> The program below shows how it works:
>
> ```kotlin
> fun main(){
>     val n = readLine()!!.toInt()
>     
>     when {
>         n == 0 -> println("n is zero")
>         n in 100..200 -> println("n is between 100 and 200")
>         n > 300 -> println("n is greater than 300")
>         n < 0 -> println("n is negative")
>         // else-branch is optional here
>     }
> }
> ```

- When 절에서 arguments 없이 사용하는 것도 가능하다.