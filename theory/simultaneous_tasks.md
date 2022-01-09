# Theory: Simultaneous tasks

> Applications often need to do multiple tasks at the same time. For example, when your browser is loading the Hyperskill page, it can show an animated "loading" icon for the tab. How do you do that? At this point, you probably understand the meaning of concurrency and parallelism. In this topic, we will see how Kotlin supports them. With this knowledge as a basis, you will eventually be able to run your own Kotlin application that handles multiple tasks simultaneously!

- 코틀린에서 Concurrency 와 Parallelism 을 어떻게 제공해주는지 파악해보자.

***

## Processes

> In computers, the biggest entities that can be run at the same time are called processes, which usually represent different applications. However, Kotlin developers rarely work with processes because they are quite heavy, and usually programmers want their apps to be more compact. For this reason, we will not cover them here in detail; if you want to know how to work with them, research it yourself, for instance, on Stack overflow.
> 
> Processes are relatively heavy. A modern computer can handle hundreds of processes.
>
> If you want a metaphor, think of processes as enterprises (firms) in a country. Some of them work in totally different fields, others compete in the same field. When you talk about both processes and enterprises, you usually mean what they do in general. However, they are actually big, complex, and have many nuances.


***

## Threads

> A more convenient way of running simultaneous tasks in a single program is threading. It is supported by almost all programming languages including Kotlin.
> 
> Every thread is bound to a process, and a process can create its threads. For example, applications often use a special thread for drawing graphics on the screen, while the logic of the program is executed in another one. Threads share some memory, so the communication between them is relatively simple.
> 
> Threads are lighter than processes, and today a casual computer can execute tens of thousands of them.
>
> A thread in a process is like an employee in a firm. A person and a thread are responsible for their own role.
> 
> In Kotlin, threads are platform-dependent, which means that you have to use different threads for different environments, for example, Java Threads for Kotlin/JVM and Posix Threads for Kotlin/Native. Still, threads are used frequently because it's easy to define their communication and run them.
> 
> However, if you have a popular web site and a web server to host it, this might be not enough: the number of simultaneous connections to your site can easily exceed tens of thousands.

- 수만 트래픽을 받을 정도의 대규모를 생각한다면 스레드 이상을 알아야한다.

***

## Coroutines

> Another way of supporting processing multiple tasks is called internal concurrency. In Kotlin, the official and most popular way to do it is the coroutines library (`kotlinx.coroutines`). It is similar to threading, except coroutines are even more light-weight. Also, the library is specially designed to make the code similar on different platforms.
>
> A coroutine is a piece of code that can be suspended and resumed. The idea here is that a piece of code can wait for something, for example, for the user's click. While it's waiting, we say that it is in a suspended state, and it doesn't overload the processor.
>
> Let's go back to the analogy with a firm. We can compare a coroutine with a usual task that can be done by an employee. First, the task is created, and then assigned to a person. When the person is ready, they decide what to do: start handling the task or transfer it to another person. When someone starts working on the task, there's no guarantee it will be done right away. For example, say the task was to call another department, and the person called but nobody answered. Then that person can "suspend" the task, that is, postpone it for a while. During this gap, the person can take another task and start working on it, or, if there are no more assigned tasks, they can take a break.
>
> The advantage here is that a person is expensive since you have to pay them, but a task is cheap. If a person can handle multiple tasks, why not do just that?
>
> Since a thread can be used to run coroutines, you can have more coroutines than threads. The number of coroutines scheduled for execution can be more than a million!
>
> You might suspect a flaw here: not everybody can do multiple tasks simultaneously. Often, we work on one task, and only then take up another one. Actually, the same is true for coroutines: in a single thread, only a single coroutine is processed at a time. That's why it's called internal concurrency. However, the concept of suspending tasks is really strong and we can say that this false simultaneity just works. Let's show it.
>
> Remember the web server example? We have only a limited number of executors, but we want to serve a huge number of clients. The solution is to have a task for each client and gradually allocate the waiting tasks to the available executors. Some clients will have to wait longer because there will be queues, but at least the server won't crash.

- Multitask 를 처리하는 또 다른 방식이 코루틴을 이용하는 것. 코루틴은 Internal concurrency 라고도 불린다. 
  - 하나의 스레드에서 코루틴의 실행이 concurrency 하게 일어나는 것. 
- 코루틴은 코드의 일부분을 말하며 실행하거나 멈춰있거나 두 가지 상태만을 가질 수 있다. 근데 중요한건 멈춰있을 때 프로세서에게 부하를 주지 않는다.
  - 멈춰있는것 보다는 다른 코루틴이 실행하도록 양보하는 걸 말한다.
- 스레드는 코루틴을 실행할 수 있고 스레드를 많이 가지는 것보다 코루틴을 많이 가지는게 훨씬 싸다.
  - 컨택스트 스위칭도 안들고.
  - 코루틴은 코드의 일부일 뿐이니까.
  - 물론 코루틴도 큐에 넘치도록 쌓이면 장애가 나겠지. 