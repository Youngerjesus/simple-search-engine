# Theory: Thread management

> We've already learned how to start a new thread by simply invoking the start method on a corresponding object. However, sometimes it is necessary to manage the lifecycle of a thread while it's working rather than just start it and leave it be.
> 
> In this topic, we will consider two commonly used methods in multithreading programming: sleep() and join(). Both methods may throw an InterruptedException, which is omitted here for brevity.

- thread 의 라이프 사이클을 관리해주는 메소드인 sleep 과 join 에 대해서 알아보는 시간.

## Sleeping

> The method Thread.sleep() causes the currently executing thread to suspend execution for the specified number of milliseconds. This is an efficient means of making processor time available for the other threads of an application or other applications that might be running on a computer.
> 
> We will often use this method throughout our educational platform to simulate expensive calls and difficult tasks.
>
> ```kotlin
> println("Started")
> 
> Thread.sleep(2000) // suspend current thread for 2000 milliseconds
> 
> println("Finished")
> ```
> 
> Let's see what this code does. At first, it prints "Started". Then, the current thread is suspended for 2000 milliseconds (it may be longer, but not less than indicated). Eventually, the thread wakes up and prints "Finished".
>
> Another way to make the current thread sleep is to use the special class TimeUnit from the package java.util.concurrent:
>
> TimeUnit.MILLISECONDS.sleep(2000) performs Thread.sleep for 2000 milliseconds;
> TimeUnit.SECONDS.sleep(2) performs Thread.sleep for 2 seconds;
> 
> There are more existing periods: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, and DAYS. For example:
>
> ```kotlin
> import java.util.concurrent.TimeUnit
> 
> println("Started")
> TimeUnit.SECONDS.sleep(2) // suspend current thread for 2 second
> println("Finished")
> ```

- Thread 를 정해준 시간동안 재우는 방법인 sleep() 메소드.
- 일반적으로 sleep 메소드에 넘겨진 값은 ms 로 계산된다.
- 이 외에도 재우는 방법으로 TimeUnit 을 이용할 수 있는데 좀 더 정교한 시간 제어가 가능하다.

*** 

## Joining

> The join method forces the current thread to wait for the completion of another thread on which the method was called. In the following example, the string "The end" will not be printed until the thread terminates.
> 
> ```kotlin
> fun main() {
>     val thread: Thread = thread(...)
>     println("The start")
> 
>     thread.start() // start thread
> 
>     println("Do something useful")
> 
>     thread.join()  // waiting for thread to die
> 
>     println("The end")
> }
> ```
> 
> The overloaded version of the join method takes the waiting time in milliseconds:
>
> ```kotlin
> thread.join(2000)
> ```
> 
> This is used to avoid waiting for too long or even infinitely in case the thread is hung.
>
> Let's consider another example. The Worker class is developed to solve "a difficult task" simulated by the sleep:
>
> ```kotlin
> class Worker : Thread() {
>     override fun run() {
>         println("Starting a task")
>         sleep(2000) // it solves a difficult task
>         println("The task is finished")
>     }
> }
> ```
> 
> Here is the main function where the main thread waits for the completion of worker.
>
> ```kotlin
> fun main() {
>     val worker = Worker()
>     worker.start() // start the worker
>     Thread.sleep(100)
>     println("Do something useful")
> 
>     worker.join(3000)  // waiting for the worker
>     println("The program stopped")
> }
> ```
> 
> The main thread waits for worker and cannot print the message The program stopped until worker terminates or the timeout is exceeded. We know exactly only that Starting a task precedes The task is finished and Do something useful precedes The program stopped. There are several possible outputs.
>
> The first possible output (the task is completed before the timeout is exceeded):
>
> ```
> Starting a task
> Do something useful
> The task is finished
> The program stopped 
> ```
> 
> The second possible output (the task is completed before the timeout is exceeded):
>
> ```
> Do something useful
> Starting a task
> The task is finished
> The program stopped
> ```
> 
> The third possible output:
>
> ```
> Do something useful
> Starting a task
> The program stopped
> The task is finished
> ```
> 
> The fourth possible output:
>
> ```
> Starting a task
> Do something useful
> The program stopped
> The task is finished
> ```

- thread.join() 을 통해서 이 메소드를 호출한 스레드가 join() 메소드를 실행한 스레드의 종료를 기다릴 수 있다.
- 인자로 시간값을 줘서 기다리는 시간을 지정하는 것도 가능하다. 