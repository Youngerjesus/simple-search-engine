# Theory: Errors in programs

> Suppose, you're writing a Kotlin program. Different errors may occur during its compilation or execution. We will divide all possible errors into two groups: compile-time errors and run-time errors.

- 에러는 컴파일 에러와 런타임 에러로 나뉜다.

***

## Compile-time errors

> Compile-time errors are errors that prevent a program to compile. For example:
> - syntax errors: incorrect keyword, typo, missing parenthesis or brace;
> - incorrect imported package name;
> - non-existing method invocation.
>
> Consider the following example of compile-time errors. The following program should output the string "Hello!" but it does not compile.
>
> ```kotlin
> fun main(args: Aray<String>) {
>     printn("Hello!")
> }
> ```
> 
> There are two errors in this program:
> - a typo in the class name Array;
> - an incorrect name of the function println.
>
> If you fix these mistakes, it will be possible to compile the program.
>
> To avoid such errors, programmers use modern IDE (Integrated Development Environment) with a static code analyzer. This tool allows programmers to identify compile-time errors before the compilation. In addition, it is able to highlight warnings about more complex errors and weak places in your code, as well as tips on how to improve the code.
>
> Over time, you will write code that contains less or even none of the compile-time errors.
  
- 컴파일 에러는 문법 오류나 패키지에 잘못된 이름의 접근, 없는 메소드의 호출 등이 있다.
- 이런 컴파일 에러는 IDE 의 도움으로 해결할 수 있다.

***

## Run-time errors

> Run-time errors (also known as "bugs") are errors that occur when the program is running. Run-time errors will cause your program to behave unexpectedly or may even stop the execution.
>
> There are two subtypes of run-time errors:
>
> - logic errors – when a program produces a wrong result because the code is not correct (for example, instead of "Hello!", your program outputs "Hi!");
> - unhandled exceptions like division by zero, not found files, and other unexpected cases.
>
> We will learn how to handle exceptional events (exceptions) in further lessons.
>
> Avoiding run-time errors is a more difficult task than avoiding compile-time errors. If your program compiles successfully, there are no guarantees that it does not have bugs. There are different strategies to find such errors
>
> - to debug your program;
> - to write automatic tests for your program;
> - to use code review practice as part of the development process. In general, this practice stands for a case, when one or more developers visually inspect the source code of a program.

- 런타임 에러는 로직 에러와 Exception 발생에 적절하게 핸들링 하지 않는 것에 있다. 
- 런타임 에러는 찾기가 어렵다. 그나마 할 수 있는건 테스트를 잘 짜놓는 것. 코드 리뷰를 받는 것이 있다. 

