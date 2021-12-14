# Theory: Functions as objects

> We know how to declare functions, how to invoke them, and what they do. Actually, Kotlin provides a way to work with functions as if they are objects. So, let's learn how to store a function as an object and to use it.

***

## First-class citizen

> First-class citizens in programming are the objects that:
>
> - can be stored as variables,
> - can be returned by a function,
> - can be passed to a function as an argument,
> - don't depend on their name,
> - can be created at the program runtime
> 
> For example, an Int is a first-class citizen in Kotlin. To clarify the fourth requirement, an Int with the ten name doesn't need to be 10. And vice versa: the 10 value doesn't need to be stored under the ten name. You can create as many differently named variables for the same value as you need and the value won't change because of the name changing.
>
> In fact, functions are first-class citizens in the Kotlin language too. Let's prove it! In this topic, we will cover only the first four requirements. We will discuss how to create functions at runtime in the next topic.

- Fist-class citizen 은 일급 객체를 의미한다. (일급 객체는 주로 Functional programming 에서 나오는 개념이라고 한다.) 
- 일급 객체의 조건은 변수에 함수를 저장할 수 있어야 하고, 함수는 함수를 리턴할 수 있어야 하며, 함수의 인자로 함수를 전달하는게 가능해야 한다고한다. (4, 5 번 조건은 정확하게 왜 있는지 모르겠다.) 
- 참조: https://medium.com/@lazysoul/functional-programming-%EC%97%90%EC%84%9C-1%EA%B8%89-%EA%B0%9D%EC%B2%B4%EB%9E%80-ba1aeb048059

***

## Function types

> First of all, Kotlin has built-in support for function types. The syntax of a function type is this
> 
> ```
> (parameters' types) -> return value type
> ```
> 
> In a function type there are arrow symbols (->) in the middle, also, there are parenthesized parameters' types split by commas on the left, and, finally, the return value type is written on the right. Thus the arrow seems to point from what the function takes to what it returns.
>
> Let's recall some functions from previous topics and use them as examples:
>
> ```kotlin
> fun sum(a: Int, b: Int): Int = a + b
> ```
> 
> sum has a type of (Int, Int) -> Int.
>
> ```kotlin
> fun sayHello() {
>     println("Hello")
> }
> ```
>
> sayHello has a type of () -> Unit (this function takes nothing so parentheses with parameters' types are empty, and, also, it returns nothing so the result type is Unit).

- Function Type 이 어떤 것인지 이해해보자. 
- 코틀린에서 함수의 구성은 이렇게 되어있다. (parameters' types) -> return value type
- 즉 Parameter 와 return 타입이 연결되어 있는 구조. (Input 과 Output 으로 구성되어 있다.)
- Unit 은 함수가 아무것도 반환하지 않을 때 사용하는 리턴타입이다.

***

## Function references as objects

> Also, Kotlin allows getting references to functions. To get a reference to a top-level function, we simply need to write double colon (::) before its name and we don't write parentheses and arguments after the name. Take a look at the example: ::sum gives us an object of the (Int, Int) -> Int type.
>
> Now we are ready to assign function references to values! We can create values this way:
>
> ````kotlin
> val sumObject = ::sum
> ````
> 
> Don't confuse this assignment with saving function result to a value like this: val sumResult = sum(1, 2). The sumResult value has the Int type because the result of the invoked sum function is just a number. Meanwhile, the sumObject value is initialized with a reference to the sum function (::sum), so it has the type of the sum function.
>
> We can also specify the type of the sumObject value explicitly:
>
> ````kotlin
> val sumObject: (Int, Int) -> Int = ::sum
> ````
> 
> In both cases, we have an opportunity to invoke the original sum function by invoking the object: sumObject(10, 20) returns 30 as if we invoked the original function with these arguments directly.

- Function Reference 를 통해서 함수를 변수에 대입하는게 가능하다.

***

## Functions returning other functions

> Since a function can be stored as an object, why not create a function that returns such an object? Let's do this. Take a look at the example below:
>
> ```kotlin
> fun getRealGrade(x: Double) = x
> fun getGradeWithPenalty(x: Double) = x - 1
> 
> fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
>   if (isCheater) {
>       return ::getGradeWithPenalty
>   }
> 
>   return ::getRealGrade
> }
> ```
> 
> Here we have a real grade function, which returns its argument, and a grade with penalty function, which returns its argument minus one (in other words, the decrement of its argument). Also, we have another function which provides us one of the previous two functions.
>
> So if we do val wantedFunction = getScoringFunction(false), the wantedFunction value will contain a reference to a grade function for an honest student. Seeing the getScoringFunction function implementation, we can say that in this case the wantedFunction value contains a reference to the getRealGrade function. So the result of the wantedFunction(9.0) will be equal to 9.0.

- 함수가 함수를 리턴하도록 하는 예제 (Function reference 를 통해서 리턴하는.)
***

## Function references as function parameters

> Also, you can create functions that take other functions as arguments. Let's create such function:
>
> ```kotlin
> fun applyAndSum(a: Int, b: Int, transformation: (Int) -> Int): Int {
>     return transformation(a) + transformation(b)
> }
> ```
> 
> It receives two integers, transforms them using the received transformation function, and returns the sum of the transformed integers. We can declare some transformation functions:
>
> ```kotlin
> fun same(x: Int) = x
> fun square(x: Int) = x * x
> fun triple(x: Int) = 3 * x
> ```
> 
> And then pass them to the former function:
>
> ```kotlin
> applyAndSum(1, 2, ::same)    // returns 3 = 1 + 2
> applyAndSum(1, 2, ::square)  // returns 5 = 1 * 1 + 2 * 2
> applyAndSum(1, 2, ::triple)  // returns 9 = 3 * 1 + 3 * 2
> ```

- Function parameter 로 Function 을 넘기는 예제

***

 ## Real-world usage

> The previous example seemstto be a bit synthetic. What about more realistic examples? Well, see for yourself.
>
> The String type has the filter method to filter symbols. How does it know which symbols to remove from the string and which ones to leave in it? The answer is simple: this method takes a predicate as an argument and then uses it for internal computations. A predicate is a function that takes an argument and returns a Boolean result. So in the filter method, the predicate says if the symbol should be left and has the (Char) -> Boolean type.
>
> Let's try to use this method. If we want to remove dots from a string, we declare this predicate:
>
> ```kotlin
> fun isNotDot(c: Char): Boolean = c != '.'
> ```
> 
> Then we can do something like this:
>
> ```kotlin
> val originalText = "I don't know... what to say..."
> val textWithoutDots = originalText.filter(::isNotDot)
> ```
> 
> As a result, the textWithoutDots string is equal to "I don't know what to say".

- 실제 리얼 월드에서 사용하는 예제를 보면 대표적인걸로 Filter 가 있다.
- Filter 는 인자로 Predicate 라는 람다 표현식을 인자로 받는다. 그리고 그걸 내부에서 사용한다.


