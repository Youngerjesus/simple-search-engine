# Theory: Member functions

***

## Writing member functions

> Sometimes you need to store in objects not only the data itself but also a behavior. Member functions implement a common behavior for the whole set of objects which belong to the same class.
>
> Member functions look like functions placed in the class body. In the example below, we declare a class with one function print():
>
> ````kotlin
> class MyClass {
>     fun print() = println("Hello from print")
> }
> ````
>
> This function is called a member function because it works with a specific object of a class and can access its fields. It's a class member:
>
> ````kotlin
> class MyClassWithProperty(var property: Int) {
>     fun printProperty() {
>         println(this.property)
>     }
> }
> ````
>
> As you may remember, the keyword this represents the current instance of the class. In the example above, it's an optional keyword, so you can omit it.
>  
> Just like functions, member functions can take arguments and return a value of any type including the same type as the defined class.

- Member Function 에 대한 정의는 그냥 뭐 메소드와 같은듯

***

## Calling member functions

> Let's take a look at the example below. It prints the value of the field of the particular object:
>
> ```kotlin
> val myObject = MyClassWithProperty(10)
> myObject.printProperty()  // prints "10"
> ```
> 
> So to call a member function, you need to create an object of the class. Then, put a dot after the object name and write the function name with the arguments that you need in parentheses.
  
***

## An example with cats

> As a more complex example, let's consider a class that represents cats.
> 
> A cat can sleep. Also, a cat can make one of the two sounds: "meow" or "zzz". It depends on its state. Finally, a cat can be awakened.
>
> Here we've added comments for class members. Read them to better understand the logic of the class.
>
> ```kotlin
> import kotlin.random.Random // library for getting random numbers
> 
> class Cat(val name: String) {
> 
>     /** The current state of the cat (by default a cat isn't sleeping). */
>     var sleeping: Boolean = false
> 
>     /**
>      * A cat says "meow" if it is not sleeping, otherwise, it says "zzz".
>      * After a cat says "meow", it can sometimes fall asleep.
>      */
>     fun say() {
>         if (sleeping) {
>             println("zzz")
>         } else {
>             println("meow")
> 
>             if (Random.nextDouble() < 0.5) { //generates a double value between 0 and 1.0 
>                 sleeping = true
>             }
>         }
>     }
> 
>     /** The function wakes the cat. */
>     fun wakeUp() {
>         sleeping = false
>     }
> }
> ```
> 
> Now, we can create an instance of a class and invoke its functions. Do not forget that a cat that you have just created is not sleeping.
>
> ```kotlin
> fun main() {
>      val pharaoh = Cat("Pharaoh")  // Create a cat named "Pharaoh"
>  
>      repeat (5) {
>          pharaoh.say()  // it says "meow" or "zzz"
>      }
>  
>      pharaoh.wakeUp()  // wake the cat up
>      pharaoh.say()  // it says "meow"
>  }
> ```
> 
> The output of the program can be different because of Random.nextDouble() inside the say function. Here is an example of a possible output:
>
> ```
> meow
> meow
> meow
> zzz
> zzz
> meow
> ```
