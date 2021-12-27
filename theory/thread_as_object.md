# Theory: Thread as object

*** 

## Introduction

> When you have already learned the basics of programming in Kotlin and the capabilities of the language, you move on to creating larger and more serious projects to develop your skills. In such projects, you think not only about the correct code execution but also about its effective execution. This is where you need threads, which allow you to execute some actions in your program in parallel instead of sequentially.
>
> In this topic, you will learn what Kotlin threads are and how you can work with them in your code.

- Performance 를 올리기 위해서 병렬적으로 실행한다. 뭐 대충 이런이야기

***

## Threads in Kotlin

> Kotlin was originally designed with built-in multithreading support. Threads are supported on the level of the JVM, the level of the language (special keywords), and the level of the standard library. Every Kotlin program has at least one thread, which is called main; it is created automatically by the JVM process to execute statements inside the main() function. Any Kotlin program has some other default threads as well (for example, a separate thread for the garbage collector).
>
> Throughout all stages of development of the Kotlin language, the approach to multithreading has changed from the use of low-level threads to some high-level abstractions. However, understanding the fundamental concept remains very important for a good developer.

***

## A class for threads

> A thread is a sequence of instructions that a program can execute when it runs. Each thread is represented by an object – an instance of the java.lang.Thread class (or its subclass).
>
> As you know, every program creates at least one thread: the main thread, which runs the main() function, and such a program is called a single thread program. If you create one or more threads that will be performed in parallel, it becomes a multithreaded program. In the following topics, you will learn how to create your own thread, which will perform a certain sequence of actions. But now, let's try to look at the thread that executes at the moment.
>
> The Thread class has a static method named currentThread to obtain a reference to the currently executing thread object:
>
> ```kotlin
> val thread: Thread = Thread.currentThread() // the current thread
> ```
> 
> The Thread class stores basic information about the thread: its name, identifier (long), priority, and some other characteristics that can be obtained through its functions. Let's study them in more detail and take the thread main as an example.

***

## The information on the main thread

> The example below demonstrates how to obtain the characteristics of the main thread by making references to it through an object of the Threadclass.
>
> ```kotlin
> fun main() {
>     val t: Thread = Thread.currentThread() // main thread
> 
>     println("Name: ${t.name}")
>     println("ID: ${t.id}")
>     println("Alive: ${t.isAlive}")
>     println("Priority: ${t.priority}")
>     println("Daemon: ${t.isDaemon}")
> }
> ```
> 
> All statements in this program are executed by the main thread. You can see the general information about this thread:
>
> t.name returns the thread's name;
> t.id returns the thread's unique identifier;
> t.isAlive tells us whether the thread has been started and hasn't died yet;
> t.priority returns the priority of the given thread. Every thread has a priority that determines the order of execution: threads with a higher priority are executed before threads with lower priorities;
> t.isDaemon checks whether the thread is a daemon. A daemon thread (comes from UNIX terminology) is a low priority thread that runs in the background to perform tasks such as garbage collection and so on. The JVM does not wait for daemon threads to stop before exiting, while it does so for non-daemon threads.

- thread 를 나타내는 정보가 어떤 것이 있는지
- thread name, thread id, thread alive, thread priority, thread daemon 여부 등
- thread daemon 같은 경우는 중지될 때까지 멈추지 않는다는 것과 낮은 우선순위를 가진다는 점.
- thread isAlive 는 thread 가 살아 있는지의 여부, thread priority 는 우선순위로 높은 값을 가지고 있으면 더 빨리 실행된다는 점.

