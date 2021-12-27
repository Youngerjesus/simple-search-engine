# Theory: Custom threads

> As you remember from the previous topic, each program has at least one thread — the main thread. The main thread is a starting place from which you may spawn new threads to perform your tasks. To do that, you have to create your own threads, write code to be executed in a separate thread, and then start it.

- 모든 프로그램은 무조건 최소한 하나의 스레드인 main 스레드로부터 시작된다는점.
- 여기서 여러개의 스레드를 만들어 나가면 된다는 점.

## Create custom threads with inheritance

> Two primary ways to create a new thread that performs a task you need are the following:
>
> extending the Thread class and overriding its run method;
> implementing the Runnable interface and passing the implementation to the constructor of the Thread class.
>
> The code below gives an example of extending the Thread class and overriding its run method:
>
> ```kotlin
> class HelloThread : Thread() {
>     override fun run() {
>         val helloMsg = "Hello, i'm $name"
>         println(helloMsg)
>     }
> }
> ```
> 
> And the following code shows how to implement the Runnable interface and pass the implementation to the constructor of the Thread class:
>
> ````kotlin
> class HelloRunnable : Runnable {
>     override fun run() {
>         val threadName = Thread.currentThread().name
>         val helloMsg = "Hello, i'm $threadName"
>         println(helloMsg)
>     }
> }
> ````
> 
> In both cases, you should override the run method, which is a regular method and contains code to perform a task. Which approach to choose depends on the task and on your preferences. If you extend the Thread class, you can accept fields and methods of the base class but you cannot extend other classes, since Kotlin doesn't have multiple inheritance of classes.
>
> As you may know, the Thread class has a lot of constructors. You may find a full list here. We will use some of them to demonstrate custom thread creation:
>
> ````kotlin
> val t1 = HelloThread() // a subclass of Thread
>
> val t2 = Thread(HelloRunnable()) // passing runnable
> ````
> 
> And here's another way to specify the name of your thread by passing it to the constructor:
>
> ````kotlin
> val myThread = Thread(HelloRunnable(), "my-thread")
> ````
> 
> If you want to specify the name of the thread in the HelloThread class, you should override the constructor. So, the Runnable interface provides you a more versatile way to work with threads.
>
> If you are already familiar with lambda expressions, you may do the whole thing like this:
>
> ````kotlin
> val t3 = Thread {
>        println("Hello, i'm ${Thread.currentThread().name}")
>    }
> ````

- thread 를 실행하는 두 가지 방업에 대해서 소개.

***

## Easy way to create a thread

> But why do we need to implement an interface or extend a class to create an almost standard thread?
>
> You may create a thread with the function thread(...): Thread. In this case, the executing code is passed in the block argument:
>
> ```kotlin
> import kotlin.concurrent.thread
> 
> 
> val t4 = thread(start = false, name = "Thread 4", block = {
>     println("Hello, I'm ${Thread.currentThread().name}")
> })
> ```
>
> This function may have a lot of parameters that will describe your custom thread:
>
> start – if true, the thread is immediately started (then the thread will be created);
> isDaemon – if true, the thread is created as a daemon thread (we will talk about them later);
> contextClassLoader – a class loader for loading classes and resources in this thread (you will learn more about this later);
> name – the name of the thread;
> priority – the priority of the thread;
> block – thread's execution code.
> 
> The function thread() is from the kotlin.concurrent package, don't forget to import it!
>
> Now you've created objects for threads, but you're not done yet. To perform the tasks you need, you'll have to start your thread.

- thread 를 간단하게 만드는 방법에 대해서 소개. kotlin.concurrent package 에 있는 thread() 함수를 통해서 만드는게 가능.
- start 에 true 를 설정하면 만들자마자 시작.
- block 에 실행할 코드를 넣어주면 됨.

***

## Starting threads

> The class Thread has a method called start(), which is used to start a thread. At some point, after you invoke this method, the method run will be invoked automatically, but it won't happen immediately.
>
> Let's suppose that inside the main function, you create a thread named t using the thread() function and then start it.
> 
> ```kotlin
> fun main() {
>     val t = thread(start = false, block = {
>         println("Hello, I'm ${Thread.currentThread().name}")
>     })
>     t.start()
> }
> ```
>
> Also, if you set the value of the start parameter to true (it's the default value), you can start the thread without invoking the method start():
>
> ```kotlin
> fun main() {
>     val t = thread(block = {
>         println("Hello, I'm ${Thread.currentThread().name}")
>     })
> }
> ```
>
> Eventually, in both cases the result will be:
>
> ```
> Hello, i'm Thread-0
> ```
> 
> We've looked at how you can start a thread to run. Now, let's take a deeper look and see how starting a thread works from the inside.

- thread 를 만들고 start 파라미터로 false 를 주면 (기본값은 true) start() 함수를 명시적으로 호출해야 시작한다.

***

## Thread working

> Here's a picture that explains how a thread actually starts and why it is not happening immediately.
>
> By default, a new thread runs in the non-daemon mode. Reminder: the difference between the daemon and the non-daemon mode is that the JVM will not terminate a running program while there're still non-daemon threads left, while the daemon threads won't prevent the JVM from terminating. So, daemon threads usually do some background job.
>
> Do not confuse the methods run and start. You must invoke start if you'd like to execute your code inside run in another thread. If you invoke run directly, the code will be executed in the same thread.
>
> If you try to start a thread more than once, start throws IllegalThreadStateException.
> 
> Despite the fact that within a single thread all statements are executed sequentially, it is impossible to determine the relative order of statements between multiple threads without additional measures that we will not consider in this lesson
> 
> Consider the following code:
>
> ```kotlin
> fun main() {
>     val t1 = HelloThread()
>     val t2 = HelloThread()
>     t1.start()
>     t2.start()
> 
>     println("Finished")
> }
> ```
> 
> The order of displaying messages may be different. Here is one example:
>
> ```kotlin
> Hello, i'm Thread-1
> Finished
> Hello, i'm Thread-0
> ```
> 
> It is even possible that all threads may print their text after the main thread prints "Finished":
>
> ```kotlin
> Finished
> Hello, i'm Thread-0
> Hello, i'm Thread-1
> ```
> 
> This means that even though we call the start method sequentially for each thread, we do not know when the run method will be actually called.

- daemon 스레드와 non-daemon 스레드의 차이는 프로그램 종료에도 있다. 
- daemon 스레드만 jvm 에 남아있다면 종료되지만 non-daemon 스레드가 하나라도 남아있다면 프로그램은 종료되지 않는다.
- run() start() 구별해야한다. 다른 스레드에서 실행하고 싶다면 start() 를 명시적으로 호출해야한다. (이미 호출한 스레드에서 또 start() 를 호출하면 IllegalThreadStateException 예외가 발생한다.)
- 여러개의 스레드를 실행할 경우 순서에 의존하지 않도록 설계하는 것이 중요하다.

## A simple multithreaded program

> Let's consider a simple multithreaded program with two threads. The first thread reads numbers from the standard input and prints out their squares. At the same time, the main thread occasionally prints messages to the standard output. Both threads work simultaneously.
>
> Here is the thread that reads numbers in a loop and squares them. It has a break statement to stop the loop if the given number is 0.
>
> ```kotlin
> class SquareWorkerThread(name: String) : Thread(name) {
>     override fun run() {
>         while (true) {
>             val number = readLine()!!.toInt()
>             if (number == 0) {
>                 break
>             }
>             println(number * number)
>         }
>         println("$name's finished")
>     }
> }
> ```
> 
> Inside the main function, the program starts an object of the SquareWorkerThread class, which writes messages to the standard output from the main thread.
>
> ```kotlin
> fun main() {
>     val workerThread = SquareWorkerThread("square-worker")
>     workerThread.start() // start a worker (not run!)
> 
>     for (i in 0 until 5_555_555_543L) {
>         if (i % 1_000_000_000 == 0L) {
>             println("Hello from the main!")
>         }
>     }
> }
> ```
> 
> Here is an example of inputs and outputs with comments:
>
> ```kotlin
> Hello from the main!   // the program outputs it
> 2                      // the program reads it
> 4                      // the program outputs it
> Hello from the main!   // outputs it
> 3                      // reads it
> 9                      // outputs it
> 5                      // reads it
> Hello from the main!   // outputs it
> 25                     // outputs it
> 0                      // reads it
> square-worker finished // outputs it
> Hello from the main!   // outputs it
> Hello from the main!   // outputs it
> 
> Process finished with exit code 0
> ```
> 
> As you can see, this program performs two tasks "at the same time": one in the main thread and the other one in the worker thread. It may not be "the same time" in the physical sense; however, both tasks are given some time to be executed.

