# Theory: Advanced debugger features

> Line breakpoints are useful, but there are several other places where it can be helpful to stop execution:
>
> - When the primary constructor is invoked.
> - When a particular method is invoked. Including one that's been overridden or one with incorrect or missing source code.
> - When an exception of a specific type is thrown.
> - The next line of the current method, when program execution has already been stopped.
> - The first line of the method that's going to be invoked and added to the call stack next.
> - The next line of the caller method after the currently executing method is popped from the call stack.
>
> The next line of the current method could be reached with another breakpoint, although there's a simpler way to do this. But the other places listed above cannot easily be reached with a line breakpoint. So, in this topic, you will learn about some additional tools that make this advanced kind of debugging possible.

- Line Breakpoint 말고도 멈춰야 할 유용한 곳은 많다
- Primary Constructor 이 호출될 때
- 특정한 메소드가 호출될 때
- 특정한 Exception 이 던져질 때
- 현재의 메소드에서 다음 줄
- 메소드 호출해서 실행될 때의 첫 번째 행
- 메소드 호출이 끝나고 호출자의 입장에서 실행할 다음 메소드 
- 여기서 Line Breakpoint 를 통해 쉬운 부부도 있지만 그렇지 않은 부분도 있다. 
 
***

## Constructor and method breakpoints

> A primary constructor might not contain any statements and may not even have any property declarations or parentheses.
>
> To set a constructor breakpoint, click in the gutter, like with ordinary line breakpoints. You will see a square instead of a circle, and the execution will stop right inside the constructor, which is called <init> in the bytecode:
  
- class 에서 breaking point 를 걸면 초기화 메소드가 되기 전의 상태를 볼 수 있고, 초기화 되고나서 프로퍼티의 값을 봅 수 있다. 


***

## Exception breakpoints

> When an application crash occurs, you can see its stack trace, but that's not always enough. Walking through stack frames and observing application state just before the crash could be very helpful.
>
> Pressing Run → View Breakpoints... enables you to see all the current breakpoints and to set exception breakpoints:
> 
> Kotlin uses the same exception machinery as Java, so click the Java Exception Breakpoints option. Having done this, you can choose any of the exception types available in the current project and configure whichever details you want. For example, you can opt to stop on caught exceptions, uncaught exceptions, or both. You can also add a condition or log a message if you wish:
  
- 특정한 Exception 이 났을 때 Stack trace 를 쫒는 것보다 Exception 이 나기전에 멈추는게 어디서 났는지에 대한 더 많은 정보를 제공해줄 수 있다.   
- 미리 지정해둔 Exception 이 발생하기 전에 Debugger 를 통해 멈추는것도 가능하다. 
- Run -> VIew Breakpoint -> + 버튼을 눌러서 Java Exception 을 누른 후 내가 찾고자 하는 Exception 을 넣으면 된다.

***

## Stepping

> There are also three tools highlighted in the above screenshot:
>
> - Step Over
> - Step Into
> - Step Out
>
> Step Over will resume execution to the next line. This can be useful when you want to determine which branch of an if or when is executed, for example.
>
> Step Into will peek into the next method called by the current method. There's also Force Step Into (which has the same icon as Step Into but with a red arrow instead of a blue one). This tool makes it easy to step into library code instead of staying at the level of your own code. Force Step Into will work even without source code, and for runtime-generated classes without bytecode available. In this case, you won't see the code being executed, but step frames will still be visible, giving you an idea about what that method does.
>
> Step Out will suspend execution after the current method ends and return you to the context of the caller method.
  



