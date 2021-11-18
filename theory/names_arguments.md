# Theory: Named arguments

> When we invoke a function that has some parameters, we can pass arguments by the names of these parameters. This approach can improve the readability of your code, especially if a function has lots of parameters. Also, it is a convenient way to change the order of arguments passed in a function call.

- 함수 호출에서 argument name 과 argument 를 같이 넘길 수 있다는 것. 이로 인해서 코드의 가독성을 증진 시킬 수 있다. 
- 물론 많은 파라미터를 가진 함수에서 특히나 더 효과적이겠지만, 함수 이름 + 파라미터만 보고 함수가 제대로 설명되지 않은 경우에 이 방법을 쓰면 훨씬 효과적일 것 같다.

***

## Improving code readability

> Imagine a cashier who sells cinema tickets, and the ticket price remains the same over the course of a day. You need to calculate how much money our cashier will have at the end of the workday. We can do it with a function that has three parameters:
> 
> ```kotlin
> fun calcEndDayAmount(startAmount: Int, ticketPrice: Int, soldTickets: Int) =
>         startAmount + ticketPrice * soldTickets
> ```
> 
> - startAmount is an initial sum in the cash desk.
> - ticketPrice is the price of a ticket.
> - soldTickets is the number of tickets sold on this day.
>
> It is a regular function, so we can invoke it like this:
>
> ```kotlin
> val amount = calcEndDayAmount(1000, 10, 500)  // 6000
> ```
> 
> This would work fine, although there is one problem: unclear arguments. Of course, we can declare standard variables and pass them on, but sometimes you have to work with literals, not variables. Named arguments can make our code more readable. To fix this problem, you can name each argument of this function:
>
> ```kotlin
> val amount = calcEndDayAmount(
>     startAmount = 1000,
>     ticketPrice = 10,
>     soldTickets = 500
> )  // 6000
> ```
> 
> Now, the code is easy to understand!

- Named Argument 를 쓰면 전달해주는 Arguement 가 명확해진다는 특징이 있다. 
- 단점은 한 화면에서 읽을 수 있는 코드의 전체 개수가 줄어든다는 점.

***

## Reordering arguments

> You can change the order of arguments in a function call with the help of named arguments. All you need to do is to specify the names in any order you want:
>
> ```kotlin
> val amount = calcEndDayAmount(
>     ticketPrice = 10,
>     soldTickets = 500,
>     startAmount = 1000
> )  // 6000
> ```

- Named Argument 의 또 다른 특징으로는 순서를 재정렬 하는게 가능하다. 관련있는 Argument 끼리 묶는다면 좀 더 코드의 이해를 도와줄 거라고 생각된다.

***

## Named and positional arguments

> You can also call a function with named and regular (positional) arguments, as long as named arguments are placed after positional ones:
>
> ```kotlin
> calcEndDayAmount(1000, ticketPrice = 10, soldTickets = 500)  // 6000
> ```
> 
> Kotlin 1.4 or later allows you to use positional arguments after named arguments, but you need to maintain their order. For example:
> 
> ```kotlin
> calcEndDayAmount(ticketPrice = 10, 500, 1000)   // Incorrect invocation!
> calcEndDayAmount(startAmount = 1000, 10, 500)   // OK
> 
> calcEndDayAmount(soldTickets = 500, ticketPrice = 10, startAmount = 500) // OK
> calcEndDayAmount(soldTickets = 500, ticketPrice = 10, 500)  // Incorrect invocation!
> ```

- Kotlin 에서 Position Argument 와 Named Argument 를 같이 쓴다고 했을 때, Position 뒤에 Named 를 쓰는 것 가능.
- 그리고 Named Argument 뒤에 Position Argument 쓰는 것도 가능. (Reorder 안됨 대신에, 순서대로 파라미터를 써야함.)

***

## Default and named arguments

> You can also use named and default arguments together. As you probably know, default arguments are sometimes confusing as Kotlin may not understand which parameters to assign.
> 
> Let's modify the previous function and make the first parameter optional:
>
> ```kotlin
> fun calcEndDayAmount(startAmount: Int = 0, ticketPrice: Int, soldTickets: Int) =
>         startAmount + ticketPrice * soldTickets
> ```
> 
> Suppose we would like to invoke this function with only two last parameters. But it won't work:
> 
> ```kotlin
> val amount = calcEndDayAmount(10, 500)  // Won't work —
> ```
> 
> Here 10 is assigned to the first optional argument startAmount, not to the second parameter ticketPrice.
>
> To invoke this function, use named arguments:
>
> ```kotlin
> val amount = calcEndDayAmount(ticketPrice = 10, soldTickets = 500)  // 5000
> ```

- Default Argument 를 사용할 땐 조심하자. Default Argument 와 Positional Argument 를 같이 사용하면 어디에 값을 넣어주는지 컴파일러가 이해하기 힘들 수 있다.
- 이런 경우 이해할 수 있게 Named Argument 를 같이 쓰도록 하자. (Default Argument 가 먼저 있는 경우가 문제다.)
- (Default, Position) 첫 번째 자리에 값을 너흐면 Default 인지 Position 인지 헷갈린다.
- (Position, Default) 라면 첫 번째 값은 Position 임이 명확하다. 

***

## Named arguments and default values

> The default values for function parameters may or may not be constant. They can also be another named argument or a function.
>
> For example:
>
> ```kotlin
> fun sum2(a: Int, b: Int = a) = a + b
> 
> sum2(1)    // 1 + 1
> sum2(2, 3) // 2 + 3
> ```
> 
> It won't work since the b parameter is not initialized:
>
> ```kotlin
> fun sum2(a: Int = b, b: Int) = a + b
> ```

- Position Argument 가 먼저오는 경우는 괜찮다. 
