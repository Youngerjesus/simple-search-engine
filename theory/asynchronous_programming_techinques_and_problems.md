# Theory: Asynchronous programming techniques & problems

> Users expect programs to be fast and responsive. Meanwhile, many operations are naturally slow and may require a lot of CPU, memory, disk, and network resources. The solution to that controversy is asynchronous programming: async programs are not sequential but rather react to events (e.g., when the computation is done, or a resource becomes available, or the user clicks a button). But there is a price to pay — async code is hard to wire and understand. Let's see what the most common approaches are.

- 시스템 자원을 많이 먹는 대부분의 느린 작업들의 해결책은 비동기 프로그래밍이다.
- 비동기 프로그래밍은 sequential 하지 않다. event 에 반응을 하는 식의 프로그래밍이다.
- 대신에 비동기 프로그래밍은 이해하기가 어렵다.

***

## Problem example and Threads

> Assume this simple code sends some large piece of data to the Internet:
>
> ```kotlin
> fun sendData() {
>     val data = prepareRequest() // long-running operation
>     val result = submitRequest(data) // another long-running operation
>     processResult(result)
> }
> ```
> 
> The `sendData` function has two long-running operations inside, so it's a long operation itself. If we call `sendData` from the main thread, it will completely block the UI until it's done, so one common solution is to run it on a separate parallel thread. However, now we need to deliver the result back to the main UI thread; moreover, threads consume extra memory, so we can create only a limited number of them. Delivering the result back to the main thread is not a trivial task either, and we won't get into such details here.

- 대량의 데이터를 전송하는 sendData() 라는 메소드를 실행한다고 가정해보자.
- 하나의 메인 스레드에서 이게 실행된다면 엄청나게 많은 시간이 걸릴 것이고 이로인해 UI 응답이 느려질 수 있다. (이게 다 끝나야 반응을 할 것이므로.)
- 물론 이걸 병렬 프로그래밍을 통해서도 풀 수 있는데 이는 결과의 완료 이벤트를 전달해주지 못하고 추가적인 스레드 생성 비용이 있다.

## Callbacks

> A different solution is to let one function call another function back when it's done. We pass the continuation function to the first one as an argument. This argument is called a callback.
>
> ```kotlin
> fun sendData() {
>     // first call inside `sendData` is the same, it executes `prepareRequest` immediately
>     prepareRequest { data ->
>         // code inside this lambda by convention will be executed by `prepareRequest` when it's done 
>         submitRequest(data) { result ->
>             // another lambda is nested inside `submitRequest` and will be called when it's done
>             processResult(result)
>         }
>     }
> }
> ```
> 
> The last parameter of `prepareRequest` is now the callback lambda that calls the `submitRequest` function with prepared data as the first argument and another callback lambda that calls processResult as the last argument. When prepareRequest is done, it calls the given lambda, so does submitRequest when it's done. An important difference is that the top-level sendData function now returns immediately, and the nested code will be executed when the data is ready. So now we have a proper asynchronous code and the operations are executed when the data is ready.
> 
> Note that this fairly simple code is already deeply nested and we don't even have error handling in place. In real life, this tends to grow out of control pretty fast. We can pass callback functions as parameters (callback lambdas are just parameters), but that obscures the logic of the code and also become messy when more than one operation is performed.
>
> ```kotlin
> fun sendData() {
>     prepareRequest { data ->
>         // `procressResult` callback can be passed directly if the input arguments match
>         // but we can't pass `submitRequest` the same to `prepareRequest` 
>         // because it doesn't know which callback `submitRequest` should call when done
>         // only root function `sendData` knows that 
>         submitRequest(::processResult)
>     }
> }
> ```
>
> It would be much nicer if we could have the same async behavior expressed in a more linear way.

- 위 문제의 다른 솔루션은 하나의 함수가 완료되었을 때 다른 함수를 실행하도록 해주면 된다. 이것을 콜백이라고 부른다.
- 위 함수의 실행을 생각해보면 sendData() 를 호출했을 때 즉시 리턴된다. 
- 비동기적으로 prepareRequest 를 실행하고 이게 완료되었을 때 가지고온 데이터와 함께 콜백 함수인 submitRequest() 를 실행시칸다.
- 위 코드의 문제점은 콜백 코드가 nested 형식으로 중첩되어 있어서 코드 파악이 어렵다는 특징과 에러 처리를 하기 어렵다는 특징이 있다.
- 이걸 linear 하게 표현하면 좀 더 코드를 이해하기 좋을 것 같다.

***

## Futures and Reactive extensions

> There are multiple libraries and SDKs that do just that with so-called Futures/Promises or Reactive Extensions (we won't dive into details here, check out the links if you want to learn more). A typical promise code would look like that:
>
> ```kotlin
> fun sendData() {
>     prepareRequest()
>         .thenCompose { data ->  // this line means "excecute this lambda" when done without errors
>             submitRequest(data)
>         }
>         .thenAccept { result -> // this is similar but also means it's the final operation
>             processResult(result)
>         }
> }
> ```
> 
> Now submitRequest and processResult are on the same level again (even if we still have an extra nesting), but we can now add more then steps in between without going deeper. It looks nicer, but it has its own problems: errors are still not easy to handle and traditional if/else and loops are not supported out of the box. RX libraries (RxJava, RxJS) partially solve that last problem by treating each result as a stream of values and providing a rich set of helper functions (called operators) to work with that stream, but that adds even more complexity.

- Futures/Promises 와 Reactive Extensions 를 이용하면 다음과 같이 `then` 을 이용한 step 별로 처리를 할 수 있다.
- 이를 통해서 코드를 읽기가 더 쉬워진다. 
- 물론 아직도 예외 처리를 하기 어렵다는 문제도 있는데 이는 RxJava 를 알면 이 문제를 풀 수 있다.

***

## Coroutines and Suspending functions

> Here is where coroutines come into play. A coroutine may be thought of as a lightweight thread that performs suspendable computations.
> 
> It means the function can suspend its execution on some blocking operation and resume later when the operation is done, just like with callbacks.
> 
> ```kotlin
> suspend fun sendData() {
>     val data = prepareRequest() // suspending function
>     val result = submitRequest(data) // also suspending function
>     processResult(result)
> }
> ```
> 
> Our example now looks exactly like in the beginning, except for the extra suspend keyword, which tells compile that this function may suspend itself.
>
> Only suspending functions can call other suspending functions.
> 
> We can use all familiar keywords like if/else/for/try/catch again, but the main thread blocking is not an issue anymore. Moreover, this solution doesn't depend on any 3rd party library or even the platform anymore (it will work even with JS backend, which doesn't have threads), and the paradigm is very similar to the well-known goroutines (Go) or async/await (C# and others).

- 이 문제를 코루틴을 이용해서 풀어보자.
- 코루틴은 스레드의 경량화 버전 + 실행을 멈춰서 양보할 수 있는 것 이라고 생각하면 된다. 이는 멈췄다가 다시 재개한다. 마치 콜백과 같이.
- 코루틴을 쓸려면 suspend 키워드를 붙이면 된다.
- 이러면 이제 멈춰야 할 때 멈추고 다시 시작해야 할 때 다시 시작할 수 있다.
- 그리고 추가로 if/else 와 같은 프로그래밍 언어의 수단을 쓸 수도 있고 3rd party 라이브러리를 사용하지 않아도 된다.

