# Theory: Coroutine builders: overview

> As you remember, a regular non-suspending function cannot call a suspending function directly. At the same time, many types of applications start with regular functions, so how then can we use coroutines? The solution for this is coroutine builders.
>
> A coroutine builder is a function that takes a suspending function as its parameter and schedules its execution. The builder can be called from regular code, acting as a bridge between suspending and non-suspending planes. In this topic, we'll discuss the two most common builders and learn how to use them to perform suspending operations, both synchronously and asynchronously.

- 일반 함수는 suspend function 을 호출할 수 없다.
- 근데 대부분의 어플리케이션은 일반 함수로부터 시작한다. 그러면 어떻게 코루틴을 시작할 수 있을까?
- 코루틴 빌더를 통해서 가능하다.

***

## Coroutines usage

> Let's say we need to perform some large operation that suspends in multiple places, for example, get a file from a server, save it to the disk, etc. At each step of this operation, we want to use coroutines to have concise code without callbacks, so we need to build a parent coroutine. We want to wait till the operation is complete before we can notify the user and finish the app.
>
> As we know, calling the suspending function directly won't work:
>
> ````kotlin
> import kotlinx.coroutines.delay // kotlinx.coroutines is the primary package for coroutines
> 
> // pretend we're busy here, there would be some long operation in real-life code
> // but delay() is a suspending function so it's a fair example
> suspend fun doLotsOfWorkWithFile(file: String) = delay(5_000)
> 
> fun main() {
>     println("Preparing for hard work...")
>     doLotsOfWorkWithFile("a") // compilation error here !
>     println("Work is done!")
> }
> ````
> 
> To solve that problem, we can use the runBlocking builder.

- 일반 function 사이에 코루틴을 넣으면 컴파일 에러가 난다. 그냥은 섞일 수 없으므로.
  - 일반 function 인 main 은 그냥 코루틴 함수를 호출할 수 없다.
- 이 문제룰 풀려면 runBlocking() 을 이용하면 된다.

***

## Wait for suspending code: runBlocking

> runBlocking is a regular function that takes exactly one suspending function, executes it, waits until it finishes, and returns its result. This is exactly what we need in our situation! Let's give it a try:
>
> ```kotlin
> import kotlinx.coroutines.delay
> import kotlinx.coroutines.runBlocking
> 
> suspend fun doLotsOfWorkWithFile(file: String) = delay(5_000)
> 
> fun main() {
>   runBlocking {                      // this lambda is our root suspending function
>       println("Starting coroutine.") // it can contain regular functions
>       doLotsOfWorkWithFile("a")      // and suspending functions as well
>   }
>   println("Work is done!")
> }
> ```
> 
> As you can see, our main function is not suspending, but now it compiles and runs properly: the delay between the two outputs is 5 seconds. We can say that we are waiting for the coroutine to finish in the regular code.
>
> Sometimes, all our code is potentially suspending. In that case, we can wrap everything with the runBlocking builder:
>
> ```kotlin
> fun main() = runBlocking {         // here coroutine begins
>     println("Starting coroutine.")
>     doLotsOfWorkWithFile("a")
>     println("Work is done!")
> }
> ```
> 
> In fact, this is a common approach for simple apps or tests. But what if we need to do multiple independent operations, for example, receive two files from two different servers? We can still run them using blocking:
>
> ```kotlin
> fun main() = runBlocking {
>     println("Starting coroutine")
>     doLotsOfWorkWithFile("a")   // there is no limit on how many suspending 
>     doLotsOfWorkWithFile("b")   // functions a suspending function can call
>     println("Work is done!")
> }
> ```
> 
> Does it work faster than regular code? No! Suspending functions are executed sequentially, and we're waiting for the whole coroutine to finish. It will take about 10 seconds. To launch different operations that can be suspended independently we can use another builder — launch.

- runBlocking() 은 하나의 suspend function 을 받아서 그것이 끝날 때 까지 기다리도록 하는 것.
- runBlocking() 에 하나보다 많은 suspend function 을 넣으면 sequential 하게 동작한다.
- 각각의 독립적인 operation 이 필요하다면 launch 를 이용하자.

***

## Fire and forget: launch

> launch is similar to runBlocking in terms of syntax but has a different purpose: it does not wait for the coroutine to finish but immediately returns a special handler to the launched coroutine called a Job. The coroutine itself continues working, but we can check the status or even cancel it through a Job object. We'll talk about scopes later, now we are using GlobalScope for example purposes only. Let's take a look:
>
> ```kotlin
> import kotlinx.coroutines.GlobalScope
> import kotlinx.coroutines.delay
> import kotlinx.coroutines.launch
> 
> fun main() {
>     println("Starting")
>     val importantJob = GlobalScope.launch {
>         doLotsOfWorkWithFile("important_file") // waits for 5s
>         println("Important file processed")    // will only print after 5s
>     }
>     val notImportantJob = GlobalScope.launch {
>         doLotsOfWorkWithFile("optional_file")  // also waits
>         println("Optional file processed")
>     }
>     println("Finishing")
> }
> ```
>
> This code will not print Important file processed or Optional file processed because main doesn't wait for the launched coroutines and returns immediately. The output would be:
>
> ```
> Starting
> Finishing
> ```
> 
> To wait for the result, we still need to block the main function:
>
> ```kotlin
> fun main() {
>     println("Starting")
>     val importantJob = GlobalScope.launch {
>         doLotsOfWorkWithFile("important_file") // waits for 5s
>         println("Important file processed")
>     }
>     val notImportantJob = GlobalScope.launch {
>         delay(500)                            // add extra delay
>         doLotsOfWorkWithFile("optional_file") // so total wait is 5.5s
>         println("Optional file processed")
>     }
>     runBlocking {                             // block main until 6s delay is over
>         delay(6_000)                          // by this time both jobs should finish
>     }
>     println("Finishing")
> }
> ```
>
> Now it will work as expected and print this:
>
> ```
> Starting
> Important file processed
> Optional file processed
> Finishing
> ```
> 
> Notice that we don't have to wait 10 seconds to get both files processed as we did with runBlocking. Moreover, if we decrease the wait time from 6s to 5.1s, the app will process the important file but not the optional one. In real life, we'd actually need to wait for a job to finish, not for a specific time, and we can do that with join().
>
> ```kotlin
> fun main() {
>     println("Starting")
>     val importantJob = GlobalScope.launch {
>         doLotsOfWorkWithFile("important_file")
>         println("Important file processed")
>     }
>     val notImportantJob = GlobalScope.launch {
>         doLotsOfWorkWithFile("optional_file")
>         println("Optional file processed")
>     }
>     // we still have to use runBlocking because join() is a suspending function
>     runBlocking {
>         importantJob.join()  // join() suspends until the job is done
>     }
>     notImportantJob.cancel() // cancel non important job if it's not done yet
>     println("Finishing")
> }
> ```
>
> With this approach, we can launch multiple independent operations simultaneously and wait for their results later, cancel them, or do something else. Job is a powerful tool here, and it provides way more features than we can discuss in this topic: we will consider it in another one, and meanwhile, you can check the official documentation to learn more.

- launch 는 runBlock() 과 비슷하지만 job 이라는 코루틴을 실행하도록 해주는 핸들러를 만들고 즉시 반환한다.
- 코루틴은 job 에서 실행되고 우리는 코루틴의 상태를 체크하거나 중지할 수 있다.
- runBlocking() 과 job.join() 을 통해서 코루틴 실행을 기다릴 수 있고 job.cancel() 을 통해서 중지하는 것도 가능하다.
- 자세한 내용은 레퍼런스 참고 
- https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-job/index.html
