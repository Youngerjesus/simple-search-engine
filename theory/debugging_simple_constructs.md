# Theory: Debugging simple constructs

> In this topic, we are going to learn how to use a debugger to test and debug simple constructs like if statements and loops. Of course, the functionality that we'll cover is not limited to just loops: you will be able to apply these tools to solve a wide range of problems.
  
***

## If statements

> First of all, we might want to test if the program visits a branch of an if statement at all.
>
> It happens from time to time that we assume the boolean expression in an if statement to evaluate to true, and for some reason get unexpected results. In such a situation, it is sometimes useful to test if the code inside if is really executed.
>
> You can use this technique to debug any code, not only if statements. For example, if you want to test if a certain method gets executed, just put a breakpoint to see if you stop there. If you don't, then you know that the program hasn't executed this line and hasn't called the method.
>
> This might seem very simple, and you may ask why we need a debugger for that. The answer is that in real life you sometimes have to deal with very convoluted code that leads to subtle bugs. This is where even the most basic debugger features like this one can save you a lot of time.
  
***

## Loops

> Let's learn how we can debug loops. In this example, we are going one step further and will add some breakpoint conditions and examine the state of the program. Sounds thrilling, doesn't it?
>
> Just like with if statements, you can set a breakpoint inside a loop, and the program will suspend it each time it executes the line, that is, with each iteration of the loop. While this may still be useful for short loops, the problem arises when a loop is going to iterate, say, 1000 times, and we are only interested in some specific iteration. It would take a very determined person to continuously resume a program 1000 times. We have a better way, though.
>

- Loop 에 있는 Breakpoint 에서 내가 원하는 조건을 찾을 때까지 매번 내가 반복을 실행하지 않아도 된다.
- 단순히 멈출 라인을 정하는 Breakpoint 에서 추가로 멈출 조건을 정해줄 수 있다. (예로 변수의 값이 이 값이면 그때 멈추겠다.)


   