# Theory: Lambda expressions

> We already know how to declare functions with fixed names. Now let's find out the last factor of being a first-class citizen: the opportunity to create a function at runtime and without a predefined name.

***

## Functions without names

> To create a function that isn't bound to its name in Kotlin you can create an anonymous one or a lambda expression:
>
> - `fun(arguments): ReturnType { body }` – this one is commonly called an "anonymous function"
> - `{ arguments -> body }` – this one is commonly called a "lambda expression".
> 
> To make it clearer, take a look at the example below. Here two functions are declared; they are declared in different ways but they do the same thing:
> 
> ````kotlin
> fun(a: Int, b: Int): Int {
>     return a * b
> }
> 
> { a: Int, b: Int -> a * b }
> ````
> 
> As you see, they compute the multiplication of two numbers.
>
> Both these functions have a reasonable type: (Int, Int) -> Int. So types work just like they do for top-level functions discussed in previous topics.
>
> We need to add that if you want to declare a lambda without arguments, you do not need to write the "arrow symbols". So, a lambda without argument definition looks like this: { body }.
>
> You may ask: how to use a function without a known name? The answer is: there are several options.
>
> For example, you can assign the function to a variable and then invoke it by invoking the variable:
>
> ````kotlin
> val mul1 = fun(a: Int, b: Int): Int {
>     return a * b
> }
> 
> val mul2 = { a: Int, b: Int -> a * b }
> 
> println(mul1(2, 3))  // prints "6"
> println(mul2(2, 3))  // prints "6" too
> ````
> 
> Also, you can pass such a function as an argument or return such a function from another function.
>
> Finally, you can place parentheses with desired arguments right after the function definition to invoke it in place. However, that doesn't make much sense. So, mostly the three first described options are used.
> 
> The process of creating these two functions is quite similar, but lambdas have a more concise and convenient syntax. Therefore, almost always lambdas are used to create a function at runtime in real life. Moreover, there are programmers that don't listen to Kotlin official naming rules, so they can say "an anonymous function" instead of "a lambda". Despite the fact that everybody understands them, we suggest you call a spade a spade.
>
> For the same reason of convenience, now we will talk only about lambdas.

- 함수를 선언할 때 anonymous function 또는 lambda expression 으로 선언할 수 있다. 이렇게 선언하면 함수는 이름을 가지지 않는다.
- 이름이 없는데 어떻게 사용하냐? 라고 물을 수 있는데 함수 자체를 변수에 넣어서 사용이 가능하고 함수를 인자로 받는 곳에서 직접 함수를 람다식으로 만들어서 사용이 가능하다.
- 일반적으로 lambda 식이 더 간단해서 익명 함수는 잘 사용하지 않는다.

***

## Lambdas and syntactic sugar

> There are ways to make the code more readable for human beings without changing the code logic. If there is such a way in a programming language and it relates to syntax, its name is syntactic sugar. Kotlin promotes Functional Programming so there is syntactic sugar for it.
>
> Let's recall this example of passing the function as an argument:
>
> ````kotlin
> fun isNotDot(c: Char): Boolean = c != '.'
> val originalText = "I don't know... what to say..."
> val textWithoutDots = originalText.filter(::isNotDot)
> ````
> 
> Rewrite it to pass a lambda:
>
> ````kotlin
> val originalText = "I don't know... what to say..."
> val textWithoutDots = originalText.filter({ c: Char -> c != '.' })
> ````
> 
> It works! First of all, Kotlin infers types of many objects, and here specifying the c type isn't necessary:
>
> ````kotlin
> originalText.filter({ c -> c != '.' })
> ````
> 
> Second, there are situations when the lambda is passed as the last argument. This is the case. Kotlin provides a way to eliminate these bracket sequences ({ }), allowing to write the lambda outside the parentheses:
>
> ````kotlin
> originalText.filter() { c -> c != '.' }
> ````
> 
> If the parentheses are left empty after this operation, you can remove them:
>
> ````kotlin
> originalText.filter { c -> c != '.' }
> ````
> 
> Finally, when there is a single parameter in a lambda, there is an opportunity to skip it. The parameter is available under the it name. The final version of the code that removes dots is this:
>
> ````kotlin
> val originalText = "I don't know... what to say..."
> val textWithoutDots = originalText.filter { it != '.' }
> ````
> 
> Pretty impressive, huh?

- 람다 표현식에서 syntactic sugar 를 사용하면 좀 더 읽기 쉬운 코드를 작성할 수 있다.
- 기존 코드에서 syntactic sugar 를 사용했을 때  어떻게 코드가 개선될 수 있는지 살펴보자.

### Before 

```kotlin
fun isNotDot(c: Char): Boolean = c != '.'
val originalText = "I don't know... what to say..."
val textWithoutDots = originalText.filter(::isNotDot)
```

### After 

````kotlin
val originalText = "I don't know... what to say..."
val textWithoutDots = originalText.filter { it != '.' }
````

- filter 에 함수를 전달할 때 isNotDot() 이라는 함수를 선언한 후 그 함수의 레퍼런스를 넘기는 게 아니라 인자에서 함수를 직접 만들어줄 수 있다.
- 인수에서 람다 표현식을 만들 때 함수 타입을 명시적으로 선언하지 않아도 된다. 코틀린은 타입 추론이 가능하므로. 
- 이렇게 함수가 인자로 넘어간 경우에 호출자 입장에서 마지막 인수가 함수라면 {} 중괄호를 밖으로 빼낼 수 있다. 
- 그리고 이 이외에 함수 인자가 없다면 () 소괄호는 삭제할 수 있다.
- 람다에서 싱글 파라미터의 경우에는 이를 삭제할 수 있다. 이거에 접근하고 싶다면 it 라는 이름의 변수를 사용하면 된다.

***

## Complex lambdas

> Sometimes the code in a lambda isn't short enough to be fit in one line, so you need to split the code into lines. In this case, the last line inside the lambda is treated as the lambda return value:
>
> ```kotlin
> val textWithoutSmallDigits = originalText.filter {
>     val isNotDigit = !it.isDigit()
>     val stringRepresentation = it.toString()
> 
>     isNotDigit || stringRepresentation.toInt() >= 5
> }
> ```
>
> Also, a lambda can contain earlier returns. They must be written using the qualified return syntax. This means that after the return keyword the @ symbol and the label name are written. The label name is usually the function name where the lambda was passed. Let's rewrite the previous lambda without changing its result:
>
> ```kotlin
> val textWithoutSmallDigits = originalText.filter {
>     if (!it.isDigit()) {
>         return@filter true
>     }
>         
>     it.toString().toInt() >= 5
> }
> ```

- lambda 에서 한 라인을 넘어가는 경우 마지막 라인이 리턴으로 인식되서 넘어간다. 
- 이런 리턴을 다른곳에서 하고 싶다면 return 뒤에 @ 와 전달할 함수 이름을 명시적으로 입력하면 된다.

***

## Capturing variables

> Now let's discuss the advantage of function creation at runtime. The point is that all the variables and values which are visible where the lambda is created are visible inside the lambda too. If a lambda uses a variable that is declared outside the lambda, then it's said that the lambda captures the variable.
>
> This works intuitively. In case of a captured value, the lambda can just read it. If a variable is captured, the lambda and the outside code can change it, and these changes will be visible in the lambda and in the outside code.
>
> Take a look at the example below:
>
> ```kotlin
> var count = 0
> 
> val changeAndPrint = {
>   ++count
>   println(count)
> }
> 
> println(count)    // 0
> changeAndPrint()  // 1
> count += 10
> changeAndPrint()  // 12
> println(count)    // 12
> ```
> 
> Here we declare a lambda and assign it to the changeAndPrint value. The lambda takes the count variable, increments it (increases it by 1), and prints the new value. Take a look at the printed numbers: they may seem okay but it's vital to understand that the count variable is available for changes from inside and outside the lambda and it changes everywhere.
>
> ````kotlin
> fun placeArgument(value: Int, f: (Int, Int) -> Int): (Int) -> Int {
>     return { i -> f(value, i) }
> }
> ````
> 
> The placeArgument transforms the f function that takes two arguments to a function that takes a single argument. We achieve it by creating a lambda that takes only one argument and calls the given function with this argument and the given value. Here the lambda captures the value and the f.
>
> Recall the sum function from previous lessons and the mul2 lambda expression from this lesson:
>
> ````kotlin
> fun sum(a: Int, b: Int): Int = a + b
> val mul2 = { a: Int, b: Int -> a * b }
> ````
> 
> We can create other functions using them. Please note that the sum name refers to a function, so we need to receive the object by writing a doubled colon before the name:
>
> ````kotlin
> val increment = placeArgument(1, ::sum)
> val triple = placeArgument(3, mul2)
> 
> println(increment(4))   // 5
> println(increment(40))  // 41
> println(triple(4))      // 12
> println(triple(40))     // 120
> ````

- 람다식은 람다식 내부에서 외부에 선언된 변수에 직접적으로 접근할 수 있다. 
- 이 경우 인자로 이 변수를 받아서 처리하는게 아니라 내부에서 직접적으로 엑세스하면 원본을 변경할 수 있다.
- 이런 문제를 방지할려면 람다에 인수로 외부 변수를 넘기면 변수가 캡쳐되서 복사본을 이용하므로 원본에 영향을 안가도록 할 수 있다.

