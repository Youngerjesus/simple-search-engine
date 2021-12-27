# Theory: Exceptions in threads

> As you know, programs can throw exceptions if there are mistakes in code. When you write your own custom threads, they can also throw different exceptions. In this topic, we will see how various threads behave when they have unhandled exceptions in code blocks.

***

## Threads and Exceptions

> If one of the threads in your program throws an exception that is not caught by any method within the invocation stack, the thread will be terminated. If such an exception occurs in a single-threaded program, the entire program will stop because the JVM terminates the running program as soon as there are no more non-daemon threads left.
>
> Here is a tiny example:
> 
> ````kotlin
> fun main() {
>    print(2 / 0)
> }
> ````
> 
> This program outputs:
>
> ````kotlin
> Exception in thread "main" java.lang.ArithmeticException: / by zero
>     at ExampleKt.main(example.kt:6)
>     at ExampleKt.main(example.kt)
> 
> Process finished with exit code 1
> ````
>
> The code 1 means that the process was finished with an error.
>
> If an error occurs inside a new thread we've created, the whole process will not be stopped:
>
> ````kotlin
> fun main() {
>     val thread = CustomThread()
>     thread.start()
>     thread.join() // wait for the thread with an exception to terminate
>     println("I am printed!") // this line will be printed
> }
> 
> 
> class CustomThread : Thread() {
>     override fun run() {
>         println(2 / 0)
>     }
> }
> ````
> 
> Despite the uncaught exception, the program will be successfully completed.
>
> ```
> Exception in thread "Thread-2" java.lang.ArithmeticException: / by zero
>     at CustomThread.run(example.kt:14)
> I am printed!
> 
> Process finished with exit code 0
> ```
> 
> The code 0 means that the process is successfully finished.
>
> What will happen if there is an error in the main thread while the custom thread code is correct? Let's see:
>
> ````kotlin
> fun main() {
>     thread(block = {
>         println("Hello from the custom thread!")
>     })
>     print(2 / 0)
>     println("Hello from the main thread!")
> }
> ````
> 
> The output of the program will be the following:
>
> ```
> Exception in thread "main" java.lang.ArithmeticException: / by zero
>     at Thread_excKt.main(thread_exc.kt:7)
>     at Thread_excKt.main(thread_exc.kt)
> Hello from custom thread!
> 
> Process finished with exit code 1
> ```
> 
> As a result, the process was finished with an error (exit code 1). The code after print(2 / 0) did not execute, but the block of code in the custom thread did. So, despite an exception in the main thread, custom threads always work correctly, even if the program finishes with an error.
>
> As you can see, exceptions in different threads are handled independently. While the process has a live non-daemon thread, it won't be stopped in case an uncaught exception occurs. Still, it is a good practice to handle exceptions in threads.

- 여러 스레드에서 작업을 하는 경우 각 스레드의 예외처리는 독립적으로 해야한다. 
- 여러 스레드에서 예외가 나서 작업이 종료되더라도 하나의 non-daemon 스레드가 정상적으로 돌아간다면 프로그램은 종료되자 않는다.