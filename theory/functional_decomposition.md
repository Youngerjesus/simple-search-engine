# Theory: Functional decomposition

> You already know how to create simple functions in Kotlin. This is a very useful skill that makes the code shorter, improves its readability, and allows you to reuse previously written parts of the code.
> 
> As your programming tasks are becoming more complex, so are your functions. Though you can create a complex program that is wrapped in one solid function or even in a main function, it is better to divide a program into more specific parts that are easy to read and understand. The approach of dividing a complex program into a number of functions is called functional decomposition.
>
> In this topic, we'll see how to decompose the solution of a particular problem into separate functions.

***

## Solving complex tasks

> The idea of decomposing a big problem into several subproblems is quite intuitive. If you want to cook a pizza, you don't just put all the ingredients in the oven: instead, you break the process up into separate tasks — from making the dough to actual cooking. Functional decomposition is not about cooking pizza, but it is based on the same principle of breaking a big problem down into smaller pieces associated with functions.
> 
> Let's consider an example. Think of a program that simulates the Smart home app. This app is used to control home devices that can be remotely accessed: wireless speaker systems, lights, home security, door locks, and even robots. Imagine that we have a simple Smart home app that can perform three actions: turn the music on or off, switch the light on and off, and control the door lock. Let's consider these actions as parts of our computer program.
>
> The general algorithm of operating the Smart home app can be broken down into the following steps:
>
> 1. Parse the input data (the entered password);
> 2. Check that the password is correct;
> 3. Ask the user what they want to do;
> 4. If the action is supported, perform it.
>
> Imagine that you wrapped this program in code, but without a single additional function. That's how its structure would look like:
>
> ```kotlin
> fun main() {
>     // ...
>     val password = "76543210"
>     var speakersState: String
>     var lampState: String
>     var doorState: String
>     // ...
> 
>     // reading the password
>     println("Enter password: ")
>     val passwordInput = readLine()
> 
>     // checking if the password is correct
>     if (passwordInput != password) {
>         println("Incorrect password!")
>     } else {
>         // asking the user what they want to do
>         println("Choose the object: 1 – speakers, 2 – lamp, 3 – door")
>         val action = readLine()
> 
>         when (action) {
>             "1" -> {
>                 // asking the user about the speakers
>                 when (speakersState) {
>                     "on" -> {
>                         // ...
>                     }
>                     "off" -> {
>                         // ...
>                     }
>                     else -> {
>                         // ...
>                     }
>                 }
>             }
>             "2" -> {
>                 // asking the user about the lights...
>             }
>             "3" -> {
>                 // asking the user about the door...
>             }
>             else -> {
>                 // ...
>             }
>         }
>     }
> }
> ```
>
> Though you see a truncated version of a real program, the code still looks overloaded. At the same time, it works perfectly fine for our problem and we could leave it like that. However, we might want to adjust it for our needs or extend its functionality late
> 
> What if we want this code to work for multiple users? Or to expand the number of actions and make them more complex? Some parts of the code would still be used, and some of them would probably be deleted. To make this code less specific and more flexible, we can use functional decomposition.

- 큰 문제를 쪼개서 여러가지의 subProblem 으로 만들어서 해결하는게 중요하다.
- 하나의 거대한 함수는 이해하기 어렵다. 

***

## Decomposing a program into functions

> Functional decomposition is the process of decomposing a problem into several functions. Each function does a particular task which we can perform in a row to get the results we need. Considering a problem, we need to identify the actions that will be repeated multiple times or, alternatively, performed separately. This is how we get the desired functions that are easier to read, understand, reuse, test, and debug.
> 
> Let's look at our Smart home app again and figure out which steps can be turned into separate functions. First of all, we can separate the user actions and create the corresponding functions: one to control the music, another one to turn the lights on and off, and the third one to operate the door lock.
>
> Take a look at the function controlMusic() that controls the music. Functions controlLight() and controlDoor() follow the same algorithm.
>
> ```kotlin
>  // turns the music on and off
> fun controlMusic() {
>   println("on/off?")
>   val tumbler = readLine()
>   when (tumbler) {
>       "on" -> println("The music is on")
>       "off" -> println("The music is off")
>       else -> println("Invalid operation")
>   }
> }
> ```
> These controlling functions perform the main actions that our app provides. The actions are greatly simplified and only used to illustrate the functionality revision process.
> 
> Another function that can be separated is the password checker:


