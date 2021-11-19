# Theory: Debugging techniques

> Debugging is the process of finding and fixing bugs in a program. Some bugs, like those that prevent the program from compiling, can be fixed easily since the compiler or an IDE can tell you what's wrong. Other bugs are trickier and may require you to put a lot of effort into detecting them.
>
> In this topic, we will consider the most popular ways that programmers use to debug a program:
>
> Logging
> Assertions
> Attaching a debugger

- Debugging 은 소프트웨어의 버그를 찾는 과정. 
- 버그는 컴파일류와 런타임류 두 개가 있고 런타임이 특히 찾기 어려운 문제
- 프로그램을 디버깅 하는 방법은 크게 3가지가 있다.
  - Logging 
  - Assertions
  - Attaching a debugger
  
***

## Logging/'println' debugging

> One way to track the changes in the program state is to insert additional print statements in the code. When executed, they will inform you about what's happening under the hood at runtime.
>
> For example, you can insert a line just before a method returns that will print the return value to the console. This way, in addition to seeing the final result, you will also be able to understand what happens at a certain stage of data processing.
>
> ````kotlin
> fun main() {
>       count(1, 10)
>   }
>   
>   fun count(start: Int, to: Int) {
>       var start = start
>       while (start < to); {
>           println(start)
>           start++
>       }
>   }
> ````
> 
> While the error is not hard to catch, we can still add some print statements that would clearly indicate where the hanging happens:
>
> ````kotlin
> fun main() {
>     println("main() started")
>     count(1, 10)
>     println("main() complete")
> }
> 
> fun count(start: Int, to: Int) {
>     println("count() started")
>     var start = start
>     while (start < to); {
>         println(start)
>         start++
>     }
>     println("count() complete")
> }
> ````
> 
> Now, instead of just hanging, the program will output:
>
> ```
> main() started
> count() started
> ```
> 
> This output shows us that the program reaches the start of the count() method, but never reaches its end, which means that the problem is in the while loop. After we take a closer look at the construct, we see that there is an extra semicolon, and the loop 'body' is actually an unused lambda expression.
>

- Logging 은 프로그램의 상태를 출력하도록 해서 런타임중에 어떠한 일이 진행중인지 알 수 있도록 하는것. 
- 이를 통해서 문제가 어디쯤에 생겼는지를 알 수 있다. 

***

## Assertions

> In order to detect bugs in the program at earlier development stages, you can use assertions. The assertion is a mechanism that monitors the program state, but unlike additional print statements, it terminates the program in a fail-fast manner when things go wrong.
>
> Fail-fast is an approach when errors that could otherwise be non-fatal are forced to cause an immediate failure, thus making them visible.
>
> You may wonder why one would want to crash the production code. That's because failing immediately is much more safer than doing the wrong thing.
>
> Let’s take a look at the following program:
>
> ```kotlin
> fun main() {
>      val casper = Cat("Casper", -1)
>  }
>  
>  class Cat(val name: String, val age: Int)
> ```
>
> This code creates a Cat object. This would be fine if it weren't for the negative age value that makes no sense. Naturally, in a more complex program, this may lead to various bugs. Such an object may be passed around for a long time before we see a problem, and when a problem arises, it is not always obvious what was the cause.
>
> To prevent that from happening, we can check 'age' parameter to be positive and 'name' is non-empty:
>
> ```kotlin
> class Cat(val name: String, val age: Int) {
>      val enoughCat = false // Of course, it's a false, there are never enough cats!
>      init {
>          check(!enoughCat) { "You cannot add a new cat" } // IllegalStateException
>          require(age >= 0) { "Invalid age: $age" }        // IllegalArgumentException
>      }
> }
> ```
> 
> The first parameter is the boolean expression that should be checked, and when it evaluates to false, any exception is thrown. The second parameter is a function which generates a message that describes this error. You should use require when you are validating the argument passed to the function and check when you are checking the state of the object, as in this case.
>
> Now, if we run the code, the program will throw an error and terminate right in the Cat constructor:
>
> ```kotlin
> Exception in thread "main" java.lang.IllegalArgumentException: Invalid age: -1
>   at Cat.<init>(brokenInvariants.kt:7)
>   at BrokenInvariantsKt.main(brokenInvariants.kt:3)
> ```
> 
> You may have noticed that we used the word invariants and are curious what it means. Invariants are constraints that must be met for a program to function properly. In the code above, positive age is an example of an invariant. Using a negative age is asking for a problem. Enforcing invariants is exactly why we need assertions.
>
> We can also use assertions to check method preconditions and postconditions, that is conditions that must be met before or after a method is invoked.
  
- Assertion 은 프로그램의 상태를 사전에 검사해서 올바르지 않은 상태인경우 실패하도록 하는 방법이다. 
- 이는 Fail Fast 라고 불리는데 일이 더 커지기 전에 미리 막는다는 취지다.
- Object 의 상태를 검사할 땐 check() 메소드를 사용하면 되고, 메소드의 아규먼트가 유효한지 검사할려면 require() 메소드를 이용해서 검사하면 된다.

***

## Attaching a debugger

> A debugger is a tool that interferes with the normal program execution allowing you to get runtime information and test different scenarios to diagnose bugs. This is the most popular use of debuggers. However, when you grow more experienced with them, you'll see that they can be helpful in various situations, not necessarily related to bugs.
>
> Modern debuggers provide a vast variety of tools that can be used to diagnose the most intricate failure conditions, so they definitely warrant a section of their own. In the next topics, we will get started with IntelliJ IDEA and Android Studio debugger and learn how to debug simple code.

- Debugger 를 사용하면 런타임 정보를 가지고 와서 볼 수 있고, 이를 통해 다양한 시나리오를 적용해보는 것도 가능하다.



 