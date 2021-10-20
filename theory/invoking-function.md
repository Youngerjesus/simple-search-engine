# Theory: Invoking functions

> As you remember, we have discussed functions before. What is a function, though? How can we tame them? A function is a sequence of instructions, we can invoke it from a program by calling its name. Functions represent subprograms, and they perform some actions, for example, printing data to the standard output, calculating a square root, and so on.
 
- 함수의 정의에 대해 간단히 소개하면 Arguments 를 받아서 결과를 낼 수 있는 것으로 (안내도됨.) 그냥 이름을 가진 작은 프로그램이라고 생각하면 됨. 

***

## Functions arguments

> When we want to use a function, we can invoke (or call) it using its name followed by parentheses. If a function takes one or more arguments (input data), they should be passed in the parentheses.
>
> In the example below, we invoke the println function with a single-string argument:
>
> ```kotlin
> val text = "Hello"
> println(text)
> ```
> 
> This function can also take no arguments at all to print a new line:
>
> ```
> function1() // invokes function1 without an argument
> function2(arg1) // invokes function2 while passing an argument
> function3(arg1, arg2) // invokes function3 while passing two arguments
> // ... and so on
> ```

- 함수의 호출에 있어서 Argument 는 필요할 수도 있고 필요없을 수도 있다.

## Producing a result

> Some functions not only take arguments but also produce (return) some results. You can also assign it to a variable:
> 
> ```kotlin
> val result = function(arg)
> ```
> 
> Functions that take arguments and produce a result look like regular math functions.
>
> For example, let's take a look at a math function that returns the absolute value of a number:
> 
> ````kotlin
> val number = -10
> val nonNegNumber = Math.abs(number) // it takes -10 and returns 10
> ````
> 
> A benefit of using functions is that you don't need to implement anything, just invoke a function and it will work.
>
> All functions return a result, even the println function.
>
> ````kotlin
> val result = println("text")
> println(result) // kotlin.Unit
> ````
> 
> The result is a special value called Unit that practically means no result.

- 함수의 결과를 변수로 받아오는게 가능하다. 
- 하나의 클래스에서 여러개의 함수를 그룹처럼 가지고 있는게 가능하다. (static function 으로 가지고 있는걸 말하는듯)
- 코틀린에서는 함수가 반환을 하지 않더라도 변수로 함수를 호출한 결과를 받아오면 값이 들어간다고 한다. `kotlin.Unit` 이라는 값이 전달되고 의믜는 No Result 이다.


