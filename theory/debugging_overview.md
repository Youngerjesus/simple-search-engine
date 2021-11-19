# Theory: Debugging overview

> Imagine that you have written a program but it does not work for some reason. In order to understand what might be wrong with it and fix errors, there is a separate development stage called 'debugging'. Debugging can be done manually by simply printing the intermediate results of the program on the screen. However, this is not always convenient. A more technical way is to use a special tool called a debugger. Let's figure out what this tool is and how it works.
  
- 대충 Debugger 를 사용하는 방법에 대해서 소개하곘다. 

***

## What is debugger?

> So, a debugger is a program for finding errors or bugs in the code, which automates the debugging process. It allows the programmer to observe the execution of the program for detecting the exact location of the error.
>
> Earlier debuggers had a command line interface, where a programmer had to enter special commands to start working. Modern debuggers already have a graphical interface, which makes working with them a lot easier. Almost all modern IDEs now have built-in debuggers. That is, you can use the same development environment for both writing code and debugging it instead of constantly switching between different programs.
> 
> The basic functionality is the same for all debuggers. They usually differ only in the way this functionality and access to it are organized. Also, they may differ in hotkeys and additional features.
>
> We will analyze the simplest and most basic principles and methods of working with debuggers.

***

## How debuggers work

> The main principle of debugging is that it can freeze the program execution, i.e. suspend it. This way one can examine the program in this frozen state.
>
> There are two ways to suspend the running code on debugging:
>
> - set breakpoints in the code that you want to examine and wait until one of them is hit.
> - break program execution by pressing hotkeys or the stop button if you are working in a graphical interface. The debugger will finish the statement that is executing at the moment and then will stop the program.
> 
> So, the main idea of using a debugger is that one can test a program in parts. For this one may interrupt the execution or use breakpoints. Now let's discuss the second way in more detail.

- 디버거릉 사용할 때 Breakpoint 를 걸어서 프로그램을 특정한 지점에 정지시켜놓고 내가 예상한대로 정상적으로 잘 작동하는지 검사하는 게 중요.


***

## Breakpoints

> A breakpoint stands for a deliberate interruption of program execution. It is set at the point in the program at which you want to check its operation. After the program reaches this point, it will terminate. Then you will have the opportunity to examine the state of the program, for example, logs, memory state, processor registers, stack, and so on.
>
> In contrast to a complete stop, with the help of a break, in the debugger the program can be terminated or continued from the same place where the break occurred.
>
> It is also worth mentioning that for the line of code with the breakpoint the result of this line operation is still unknown. So after the code is broken at the breakpoint, you can see only the results of all the previous lines before the breakpoint.
>
> For example, consider such a pseudocode program that takes two numbers, for example, 15 and 10, calculates the doubled sum of these numbers, multiplies the sum by 2, and returns the result. The expected result is 100. Let's say the pseudocode is written with an error and when implemented its result will not be 100 but 80.
>
> ```
> BEGIN
>     NUMBER A, B
>     result = 2 * A + B
>     result = result * 2
>     RETURN result
> END
> ```
>
> To understand what went wrong, you can set a breakpoint in the second result calculation. The program will run exactly until this moment and it will be possible to see that the first result is 40, not 50 as expected, so it is not the sum of the numbers A and B that is doubled, but only the number A. And after that, it is added to B. Therefore, the result is incorrect and it is necessary to replace the line with 2 * (A + B). Then the code will work correctly.
  


