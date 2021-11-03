# Theory: Declaring functions

***

## Program decomposition

> Kotlin supports functions, a very useful feature, to say the least. A function is a sequence of instructions put together to operate. In a way, it is a kind of subprogram. A function has a name, so you can invoke it when you need it. Kotlin standard library has lots of functions, for example println. If they are not enough, you can declare a new function and then invoke it the same way as a standard function.
>
> Functions can divide a program into small reusable pieces. It is called decomposition. You can call these pieces as many times as you need, instead of repeating them. A decomposed program has a modular structure; it is easier to modify and maintain than a program with one main function that contains a thousand lines. This idea comes from procedural programming.

- 코틀린은 function 을 지원한다. 
- function 은 sub program 과도 같다. 이름으 가지고 재사용할 수 있다. 
- 코틀린에서는 편리한 기능을 제공해주기 위해서 Standard Library 들을 제공해주는데 println 과 같은 것들이다.

***

## Basic syntax

> To declare a new function, you need to indicate the fun keyword and a function name, a list of parameters in parentheses, and the type of the result value. So, it looks like this:
> 
> ````kotlin
> fun functionName(p1: Type1, p2: Type2, ...): ReturnType {
>      // body
>      return result
>  }
> ````
> 
> A function has the following components:
>
> - a name that follows the same rules and recommendations as a variable name;
> - a list of parameters in parentheses. Each parameter has a name and a type separated by a colon :. All the parameters are separated by commas ,;
> - the type of the return value (optional);
> - a body that contains statements and expressions;
> - the keyword return followed by the result (also optional).
>
> The types of parameters and the result can be of any type including Int, Double, Boolean, String, and so on.
  
- 함수 선언을 어떻게 하는지, 문법에 대한 이야기를 주로 다룬다.
- fun 키워드를 써야 함수 선언을 나타낼 수 있고 매개변수는 타입을 써야한다.
- 리턴은 선택적이다. (내 생각엔 리턴값 없는 경우는 안써도 되자않나. ㅇㅇ 맞다. 컨벤션에 그렇게 적혀있네.)  

***

## Defining a simple function

> Let's declare a function that calculates the sum of integer numbers and then invokes it.
>
> ````kotlin
>  fun sum(a: Int, b: Int): Int {
>      val result = a + b
>      return result
>  }
>  
>  fun main() {
>      val result1 = sum(2, 5)
>      println(result1) // 7
>      
>      val result2 = sum(result1, 4)
>      println(result2) // 11
>  }
> ````
> 
> When we invoke our function for the first time, we pass two values 2 and 5 to it. We assign them to a and b parameters respectively. The function returns the value of the result. The result type is the same as the type of the return value declared in the function (Int). When we invoke the function the second time, we pass the value of the result1, 7 and 4 as its arguments. The function returns 11.
  
- 실제 예제를 보여주는 케이스

***

## Function parameters

> As you may know, parameters represent the input data of a function. You can declare a function that takes one or more parameters of the same or different types. Also, you can declare a function that does not have parameters at all, but the parentheses are still required.
>
> Here are some examples:
>
> ```kotlin
> /**
>   * The function returns its argument
>   */
>  fun identity(a: Int): Int {
>      return a
>  }
>  
>  /**
>   * The function returns the sum of two Ints
>   */
>  fun sum(a: Int, b: Int): Int {
>      return a + b
>  }
>  
>  /**
>   * The function just returns 3
>   */
>  fun get3(): Int {
>      return 3
>  }
>  
>  fun main() {
>      println(identity(1000)) // 1000
>      println(sum(200, 300)) // 500    
>      println(get3()) // 3
>  }
> ```
>
> As you can see, we can invoke a function from the main function, but it is also possible to invoke a function from another regular function.
>
> Since Kotlin 1.4, you can put a comma at the end of the parameters list. It can be very useful if you have a lot of arguments or use multi-line syntax, because you may easily copy-paste variables:
>
> ```kotlin
>  fun sum(a: Int, b: Int, ): Int { // you can easily add some arguments
>      // 
>  }
>  
>  fun max(
>      a: Int,
>      b: Int,
>  ): Int { // you can swap arguments without worrying about commas
>      // 
>  }
> ```

- 함수에 파라미터를 써도 되고 안써도 된다 뭐 이런 얘기 
- 코틀린에서 파라미터를 구분시키기 위 ',' 을 써도 된다라는 것. 그래서 파라미터를 추가하기 쉽다라는 것

***

## Return type

> A function can return a single value or nothing. If a function returns something, its body must have the return keyword followed by the result. Sometimes, you need a function that returns nothing. There are two ways to declare a function that returns nothing:
> 
> omit the return type part:
> 
> ````kotlin
>  /**
>   * The function prints the values of a and b
>   */
>  fun printAB(a: Int, b: Int) {
>      println(a)
>      println(b)
>  }
> ````
> 
> specify the special Unit type as the return type:
>
> ````kotlin
>  /**
>   * The function prints the sum of a and b
>   */
>  fun printSum(a: Int, b: Int): Unit {
>      println(a + b)
>  }
> ````

- 함수에서 리턴은 하나의 값이거나 아무것도 리턴하지 않거나 둘 중 하나다.
- 아무것도 리턴하지 않으면 Unit 을 리턴한늑 것.

***

## Function body

> You can write any statements in a function body, for example, inside the main function. In addition to the parameters, you can declare new variables that are visible in the function only.
>
> For example, this function extracts the last digit of a number and then returns it.
>
> ```kotlin
> fun extractLastDigit(number: Int): Int {
>      val lastDigit = number % 10
>      return lastDigit
>  }
> ```
> 
> You can simplify this code by excluding the extra variable:
>
> ```kotlin
>  fun extractLastDigit(number: Int): Int {
>      return number % 10
>  }
> ```
> 
> You can perform any operations in the function body. For example, this function uses a relational operation. It checks whether the number is positive or not:
>
> ```kotlin
>  fun isPositive(number: Int): Boolean {
>      return number > 0
>  }
> ```
> 
> The function isPositive takes an integer number and returns a Boolean value because the result of the expression number > 0 is either true or false.
>
> Take a look at one more example. The line after the return statement will not be executed (the so-called unreachable code). These lines clutter up your program:
>
> ````kotlin
>  /**
>   * It returns "Hello"
>   */
>  fun getGreeting(): String {
>      return "hello"   // Ends the function
>      println("hello") // Will not be executed
>  }
> ````

- 함수안에서는 main() 함수처럼 그냥 기능, 동작별로 작성하면 된다.
- return 뒤의 문장은 실행하지는 않는다.

***

## Single-expression functions

> If a function returns a single expression, you can write it without curly braces:
>
> ```kotlin
>  fun sum(a: Int, b: Int): Int = a + b
>  
>  fun sayHello(): Unit = println("Hello")
>  
>  fun isPositive(number: Int): Boolean = number > 0
>
> ```
> 
> Specifying the return type is optional, as it can be inferred automatically:
> 
> ```kotlin
>  fun sum(a: Int, b: Int) = a + b // Int
>  
>  fun sayHello() = println("Hello") // Unit
>  
>  fun isPositive(number: Int) = number > 0 // Boolean
> ```

- 함수가 한 줄이라면 {} 를 줄여서 한 줄 표현식으로 사용이 가능하다. 
- 타입추론이 가능한 경우에 Return Type 은 작성하지 않을 수 있는데 Coding Convention 에서는 명확하게 쓰는걸 원하는 듯 (특히 라이브러리를 작성할 때)

***

## Idiom

> A single-expression function is idiomatic. They are useful when you need a small function to do something like checking a simple condition. If your function returns only a single expression, try to stick to this form. You also may omit the return type, as the compiler can often infer it from the context. Look at the example. The single-expression function is shorter and easier to understand. This syntax may be awkward at first, but if you use it often, you will find it very convenient
> 
> ```kotlin
>  fun theAnswer() = 42   // short and clear
>  ...
>  fun theAnswer(): Int { // equivalent common function
>      return 42
>  }
> ```

- 코틀린에서 함수를 한 줄로 표현하는게 처음에는 어색할 수 있겠지만 코드를 이해하는데 도움을 준다. 