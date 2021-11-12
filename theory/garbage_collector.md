# Theory: Garbage Collector

> As you already know, when a JVM language program creates a new object, a part of the heap memory is being used. What happens when there is no available heap memory left? How does the JVM know what parts of memory may be reused for something else? In this topic, we will tackle these questions and learn about garbage collection — a way to perform automatic memory management.

- 자동 메모리 관리 해주는 JVM 내의 요소인 GC 에 대해서 알아보자. 

***

## Memory management strategies

> The heap memory, even if big enough for most programming tasks, is still limited, as it takes part of the physical memory (RAM) on the computer. So a program taking too much memory will eventually lead to crashes. Most programs have objects that at some point of the execution won't be used anymore, which means the memory may be freed and reused later.
>
> Some programming languages (for example, C or C++) require programmers to allocate and free memory manually. Although this provides more control over the resources, manual memory management may be a challenging task, especially for beginners, resulting in errors and memory leaks.
>
> The JVM utilizes automated memory management, which allows developers not to worry about memory while writing code and prevents possible programming mistakes. Memory is allocated in the JVM heap every time a program creates a new object and is freed using the garbage collection process.
  
- 대부분의 프로그램에선 일부 객체를 어떤 특정한 실행 순간에서만 사용하고 더 이상 사용하지 않기도 한다. 그러므로 이를 잘 이용하면 메모리를 재사용 할 수 있다.
- 재사용하는 방법은 수동 기법 vs 자동 기법이다. 
- 수동 기법은 개발자가 다 해줘야하기 때문에 이를 놓치는 문제가 있을 수 있고 이로인해 memory leak 이 발생할 수 있다.
- 자동 기법은 개발자가 신경쓰지 않아도 된다.

***

## What is Garbage Collection?

> The Garbage Collector (or GC) is a part of the JVM that frees up the memory in runtime for further use. There are many different garbage collection algorithms and implementations, but their work may be simplified into two common steps. The first step is to determine which parts of memory the program no longer uses (i.e., "garbage"), and the second step is to free these parts of memory.
>
> Additionally, a compacting operation may be performed after the deletion step — all currently used objects are moved next to each other to free a big contiguous memory region and avoid fragmentation.
>
> In order to identify garbage, the JVM goes through all the objects and checks whether they are still reachable in the program. All objects that can't be reached from the program or from other reachable objects are considered "garbage", and the corresponding memory is freed up.
> 
> Some algorithms take into account additional information about objects, for example, the time since the object was created. Such algorithms are called generational garbage collection algorithms. It has been noticed that most objects in programs are used only for a short time after creation. Thus, the garbage collector doesn't need to examine every object in the heap on every run and focuses mainly on recently created objects (the "younger generation"), which reduces the garbage collection time.
  
- GC 알고리즘은 구현체마다 다를 수 있다. 
- 그치만 크게는 이 작업들에서 벗어나지 않는다. 가비지를 인식하고 지운다음에 메모리를 압축하는 작업.
- 가비지를 인식하는 방법은 메모리에서 살아있는 객체를 표시해두는 것으로 가비지를 인식한다.
- GC 알고리즘은 대게 객체가 생성된 이후의 시간을 기반으로 작업을 한다. 그래서 Young Generation 에서 gc 가 많이 일어난다. 

***

## Running GC

> Garbage collection is performed automatically while a program is running. The JVM handles all the dirty work itself, including the decision when to run the GC. It may happen, for example, in fixed time intervals or when there is no free heap memory left.
>
> In most cases, developers don't need to think about how the garbage collector works and how to customize it. However, in modern high-load applications, this knowledge may be useful.
>
> In your programs, you may use the following ways to request the GC to perform the job:
> 
> - calling System.gc();
> - calling Runtime.getRuntime().gc().
>
> Programmers aren't supposed to run the garbage collector manually, and these calls don't even guarantee the GC invocation. We strongly recommend using them only in a test environment.
  
- GC 는 추천만 할 수 있지 강제할 수 있진 않다. 
- 테스트하는 환경이 아니라면 gc 를 수동적으로 호출하지 말자. 

***

## Example 

> Let's say that we have a code to check the used memory size (you can do it using Runtime.getRuntime().totalMemory() and Runtime.getRuntime().freeMemory()), and we put it in a program that works the following way:
> 
> 1. Print the used memory information before performing any operations.
> 2. Create a bunch of new objects in a cycle for further use.
> 3. Print the used memory information after the objects' creation.
> 4. Perform the necessary operations (without creating new objects) so that the objects are no longer used in the code.
> 
> The value from step 3 will be greater than the value from step 1, since each new object takes some part of the available memory. After step 4, the objects become unreachable from the code and the memory may be freed up by calling System.gc() or Runtime.getRuntime().gc(). Printing the used memory information after the garbage collector invocation will show a value less than the value from step 3 if garbage collection was really performed.
  



