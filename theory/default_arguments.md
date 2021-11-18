# Theory: Default arguments

> In any programming language, functions are really powerful instruments. Sometimes you don't need to use all the arguments of a function, as some of them may be stored as preselected values. In this topic, you will know how to do it.

***

## Functions with default arguments

> Kotlin can assign default values to function parameters in the function declaration. To invoke this function, you can omit the arguments with the default values, or you can invoke it in a usual way.
>
> Here is a function named printLine with two parameters. The first parameter defines a line, the second parameter is a string that ends this line. Both parameters have default values: an empty line ("") and a new line ("\n").
>
> ```kotlin
> fun printLine(line: String = "", end: String = "\n") = print("$line$end")
> ```
> 
> Take a look at this example — we assign values to the parameters using the = operator after the types.
>
> Take a look at a full code snippet. It has the following functions: printLine and main.
>
> ````kotlin
> fun printLine(line: String = "", end: String = "\n") = print("$line$end")
>
> fun main() {
>   printLine("Hello, Kotlin", "!!!") // prints "Hello, Kotlin!!!"
>   printLine("Kotlin") // prints "Kotlin" with an ending
>   printLine() // prints an empty line like println()
> }
> ````
> 
> During the first call, two arguments are passed to the function ("Hello, Kotlin" and "!!!"). During the second call, only one argument is passed ("Kotlin"), the value of the second parameter is default ("\n"). During the third call, we pass no arguments at all, but it still works because both parameters have default values.
>
> The program outputs:
>
> ```
> Hello, Kotlin!!!Kotlin
> ```

- function 을 선언할 때 Default Value 를 선언할 수 있다. 그리고 Default Value 파라미터는 함수 호출에서 생략해도 된다.

***

## Mixing default and regular arguments

> You can also mix default and regular parameters during declaration. For example, the function below finds the max of two integer arguments. It has a special parameter that determines whether it needs to compare numbers by their absolute values. The default value of this parameter is false.
>
> Default arguments allow programmers to create optional or special-case behavior for their functions.

***

## 