# Theory: Call stack

> When you write a program, it probably contains several functions invoking each other, either programmer-defined or standard ones, and all of them need to be executed. How does the machine understand the order of the execution? How does it switch between different functions? How does it know when the program execution is over? To shed light on these questions we need to learn about a special data structure — a call stack.

- 여기서는 이것들에 대해서 소개하곘다.
- 머신이 실행 순서를 이해하는 방법에 대해서
- 다른 함수들을 구별하는 방법에 대해서
- 프로그랭의 실행 순서를 결정하는 방법에 대해서
- 이것들을 해주는게 콜스택

***

## Call stack structure

> JVM uses a call stack (or execution stack) to understand which function should be invoked next and to access information regarding it. The call stack is composed of stack frames that store information about functions that have not yet terminated. The information includes the return address of a function, parameters, local variables, intermediate computations, and some other data.
> 
> As a regular stack, the call stack follows the rule Last In First Out (LIFO). It means stack frames are pushed at the top and move everything down. A new stack frame is added when the execution enters the new function. And the stack frame is removed from the call stack if the execution of a function is done.
  
- JVM 은 콜스택을 통해서 다음에 실행할 함수정보를 가져온다.
- 콜스택은 Stack Frame 과 관련이 있는데 여기에는 아직 종료되지않은 함수에 대한 정보가 있다. 함수가 끝난다음에 돌아갈 주소, 함수 파라라미터, 함수 로컬 변수, 함수 이름 등에 대한 정보.
- 콜스택은 역시 스택에 대한 구조를 가지고 있고 새로운 함수가 실행되야하면 콜스택에 추가된다.

***

## Stack frame example

> Let’s consider an example of a call stack for a program that prints the next even number of the given one. For simplicity, we will use the number 99 as the input.
>
> If you have forgotten or did not know, an even number is a number that can be divided exactly by 2. Otherwise, a number is called odd.
>
> Here is the program:
>
> ```kotlin
> fun printNextEvenNumber(n: Int) {
>      val next = if (n % 2 == 0) n + 2 else n + 1
>      println(next)
>  }
>  
>  fun main(args: Array<String>) {
>      val n = 99
>      printNextEvenNumber(n)
>  } 
> ```
> 
> The program declares two functions: printNextEvenNumber and main.
>
> As usual, the first function to be invoked is main. Each time a function is invoked, a new stack frame is created. The stack frame for main is structured the following way:
>
> 1. The function parameters (args) are pushed on the frame.
> 2. The function address (shown in the scheme as the function name — main) is added to the stack frame to keep a reference to where to return from the following function calls.
> 3. The local variables (n) are added to the frame.
>
> The picture below presents the resulting call stack with main stack frame within.
>  
> Actually, the stack stores just a reference to the args array since all reference types are stored in heap memory. But, the stack stores the actual value of n (which is 99 in our example).

- 다음 프로그램을 실행한다고 했을 때 Call Stack 맨 밑에 있는 Stack frame 은 main 함수 파라미터, main 함수 주소, main 함수에서 사용되는 지역변수 n

***

## Stack and functions execution

> The next function to be invoked is printNextEvenNumber. As always, a new stack frame is created. The function parameters (n), address (printNextEvenNumber for simplicity), and local variables (next) are added to the new stack frame.
> 
> We have two complete stack frames for main and printNextEvenNumber functions within the execution stack:
>
> Note, both frames have variables named n, but these variables are not the same since they belong to different functions.
>
> Now the program executes the function at the top of the call stack (printNextEvenNumber). After the execution, the current frame printNextEvenNumber is removed from the call stack and the previous frame main continues the execution.
>
> The standard function println works in a similar way as the functions we have defined — the new stack frame is created and when println finishes its work, the printNextEvenNumber continues the execution.
>
> Any Kotlin or Java program works almost in this way. When the stack is empty, the execution stops. We skip some details to simplify the explanation and give you only the general view.
  
- printNextEvenNumber 함수가 실행되면 그거에 대햔 Stack frame 도 콜스택에 쌓인다. 
- 물론 실행이 다되면 이것도 제거된다.

***

## Stack overflow

> The number of possible function invocations depends on the amount of memory allocated to the stack. When your stack contains too many stack frames, it can be overflowed. It leads to the StackOverflowError that will stop the execution. The stack size can be set with the command line option -Xss for executing a particular program:
> 
> `kotlin YourProgramName -Xss256k`
>
> But we recommend you to be careful with it and read some articles on the Internet before modifying the default stack size. Also, sometimes the StackOverflowError points to an incorrect recursion calls in your program. In this case, increasing the size of the stack will not help you.
  
- 가능한 함수 호출 개수는 Stack 에 할당되어 있는 메모리양에 의해 정해져있다. 
- 그러므로 너무 많은 stack frame 이 잡혀있으면 StackOverflowError 가 발생한다.
