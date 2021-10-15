# Theory: Data types

*** 

## What is a data type?

> All of us know that a number and a piece of text are pretty different. How do we know this? Well, you can perform arithmetic operations (such as multiplication) on numbers but not on texts. Kotlin also knows it. That's why every variable has a type that determines what possible operations you can perform on this variable and which values you can store in it.
  
- 모든 변수는 타입이라는 걸 가지고 있다. 이 타입에 맞춰서 할 수 있는 연산이 있다. 

***

## Variable types

> A variable's type is set when the variable is declared:
> 
> ```kotlin
> val text = "Hello, I am studying Kotlin now."
> val n = 1
> ```
> 
> In this case, Kotlin knows that text is a string and n is a number. Kotlin determines the types of both variables automatically. This mechanism is called type inference.
> 
> Please, take a look at the following piece of code. This is how we declare a variable with type inference:
>
> ````kotlin
> val/var identifier = initialization
> ````
> 
> You can also specify the type of a variable when declaring it:
>
> ````kotlin
> val/var identifier: Type = initialization 
> ````
> 
> Let's declare the same variables as in the previous example and specify their types:
>
> ````kotlin
> val text: String = "Hello, I am studying Kotlin now."
> val n: Int = 1
> ````
> The Int type means that the variable stores an integer number (0, 1, 2, ..., 100_000_000, ...). The String type means that the variable stores a string ("Hello", "John Smith"). Further, you will learn more about these and other data types.
>  
> You will see that people use both these forms of variable declaration in practice. When you use type inference, you make your code more concise and readable, but in some cases, it may be better to specify the type. For example, if we need to declare a variable and initialize it later, type inference won't work at all.
>
> ````kotlin
> val greeting // error
> greeting = "hello"
> ````
> The example above is incorrect because Kotlin cannot infer the type of the variable when it is merely declared, while every variable must have a type. On the contrary, the example below does work because the type is specified by the programmer:
>
> ````kotlin
> val greeting: String // ok
> greeting = "hello"
> 
> ````  

- 변수 타입은 변수가 선언될 때 결정된다. 처음 변수에 넣는 값을 보고 코틀린은 타입을 알 수 있는데 이를 Type Inference (타입 추론) 이라고 한다.
- val 키워드로 타입 추론을 사용하는 경우 처음 변수를 선언할 때 값을 넣지 않으면 코틀린이 타입을 알기 어려우므로 즉 타입 추론을 하기 어려우므로 에러가 난다.
- 이렇게 타입 추론 말고 구체적으로 타입을 선언해놓고 해당 타입에 의한 변수만 전달받는 것도 가능한데 이 경우가 더 이해하기가 쉽다. 해당 변수가 어떤 타입인지 아니까. 
- 이렇게 타입 선언을 해놓을 땐 UpperCase 부터 시작한다.

***

## Type mismatch

> One of the most important functions of data types is to protect you from assigning an   unsuitable value to a variable. Take a look at an example of code that doesn't work:
> ```kotlin
> val n: Int = "abc" // Type mismatch: inferred type is String but Int was expected
> ```
>
> So, if you see a type mismatch error, it means you've assigned something unsuitable to a variable. The same problem occurs when you try to assign an unsuitable value to a mutable variable declared with type inference.
> 
> ````kotlin
> var age = 30 // the type is inferred as Int
> age = "31 years old" // Type mismatch
> ```` 

- 타입이 선언된 경우에 해당 타입아 안들어오면 에러가 난다.
- 이미 타입 추론이 되서 해당 타입이 결정난 순간에 다른 타입의 변수를 대입할려는 것도 에러가 난다.
