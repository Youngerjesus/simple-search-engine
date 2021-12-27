# Theory: Creating custom exceptions

> The most valuable error handling mechanism in Kotlin is exceptions. However, there are numerous cases when we need to implement a more precise error handling technique than the built-in exception classes provide. Here, custom exceptions come into play.

***

## Throwing an exception

> As you are aware, an exception can be raised with the help of the throw keyword followed by an exception object, that is, either the Exception object itself or any of its subtypes. This can take various forms depending on the programming needs as the following examples illustrate.
>
> Throwing an exception without any parameters. This isn't a really useful case because there is no information about the error here.
> 
>````kotlin
> throw Exception()
> ````
>
> Throwing an exception with a message.
> 
> ````kotlin
> throw Exception("My error message")
> ````
> 
> Throwing an exception with a message and a cause, which usually is another exception.
> 
> ````kotlin
> throw Exception("My error message", cause)
> ````
> 
> In the example, ArithmeticException is thrown with the message "/ by zero". We capture this exception and throw a new one with a different message and with the ArithmeticException instance as the cause parameter.
>
> ````kotlin
> fun testFunction(a: Int, b: Int): Int {
>     return a / b
> }
> 
> fun main() {
>   try {
>       testFunction(1, 0)
>   } catch (e: Exception) {
>       throw Exception("testFunction() failed", e)
>   }
> }
> ````
> 
> The cause information is also printed in the exception stack trace output as you can see in the following output of the above program (after Caused by:).
>
> ```
> Exception in thread "main" java.lang.Exception: testFunction() failed
>     at ExceptionTestKt.main(ExceptionTest.kt:9)
>     at ExceptionTestKt.main(ExceptionTest.kt)
> Caused by: java.lang.ArithmeticException: / by zero
> at ExceptionTestKt.testFunction(ExceptionTest.kt:2)
> at ExceptionTestKt.main(ExceptionTest.kt:7)
> ... 1 more
> ```
> 
> Throwing an exception with the cause parameter only.
>
> ````kotlin
> throw Exception(e)  // where e is another exception
> ````
> 
> Throwing a subtype of the exception object. In the following example, we throw NullPointerException with our custom message.
> 
> ````kotlin
> throw NullPointerException("NPE at Alpha point")
> ````
> 
> A subtype of the Exception has a subtype specific cause parameter.

- Exception 을 던지기 위해서는 `throw` 키워드와 함께 `Exception` 클래스의 하위 타입이 함께 오면 된다.
- Exception 을 쓸 땐 최소한 Message 를 무조건 넣어주도록 하자. 왜 Exception 이 발생했는지 알려주는 용도로 Exception 을 사용하니까. 더 추가적인 정보를 주기 위해선 Exception 파라미터로 cause 도 넣어주자. 
- cause 는 원인이 되는 다른 Exception 을 말하며 Exception 이 발생할 때 출력되는 stack trace 의 caused by 뒤에 오는 출력을 맗나다.

***

## Creating custom Exceptions

> We can create our own exception classes as mere subclasses of the Exception class. In the following example, we create 2 custom exceptions named LessThanZero and GreaterThanTen.
>
> ```kotlin
> class LessThanZero: Exception("Parameter less than zero")
> 
> class GreaterThanTen: Exception("Parameter greater than ten")
> 
> 
> fun myFunction(par: Int) {
>   if (par < 0) throw LessThanZero()
>   else if (par > 10) throw GreaterThanTen()
>   ...
>   ...
> }
> 
> fun main() {
>   myFunction(-3)
> }
> ```
> 
> The function named myFunction() takes one parameter. Based on the parameter value, it might throw a custom exception: either LessThanZero or GreaterThanTen. The stack trace output of the above example is the following:
>
> ```
> Exception in thread "main" LessThanZero: Parameter less than zero
>     at ExceptionTestKt.myFunction(ExceptionTest.kt:6)
>     at ExceptionTestKt.main(ExceptionTest.kt:11)
>     at ExceptionTestKt.main(ExceptionTest.kt)
> ```
>
> Note that a custom exception can be a subclass of any preexistent exception subclass, like in the following example.
>
> ```kotlin
> class MyException: ArithmeticException("My message")
> ```
> 
> Also, if we want to be able to create subclasses of our custom exception, then it should be defined as open, as in the following example:
>
> ```kotlin
> open class MyException: ArithmeticException("My message")
> class MySubclassException: MyException()
> ```

***

## Catching custom Exceptions

> Custom exceptions are handled in exactly the same way as normal exceptions. In the following example, 2 custom exceptions are created and a try-catch statement is used for handling them.
>
> ```kotlin
> class BetweenOneAndFive: Exception("Value between 1 and 5")
> class BetweenSixAndTen: Exception("Value between 6 and 10")
> 
> fun myFunction() {
>   val randomInteger = (1..10).shuffled().first()  // Get a random integer between 1 and 10
>   if (randomInteger <= 5) throw BetweenOneAndFive()
>   else throw BetweenSixAndTen()
> }
> 
> fun main() {
>   try {
>       myFunction()
>   } catch (e: BetweenOneAndFive) {
>       println("BetweenOneAndFive was thrown")
>   } catch (e: BetweenSixAndTen) {
>       println("BetweenSixAndTen was thrown")
>   }
> }
> ```
> 
> The function myFunction() creates a random integer within the range 1 to 10 using:
>
> ```kotlin
> val randomInteger = (1..10).shuffled().first()
> ```
> 
> This is an easy way to get a random integer number. Integers in the range 1..10 are shuffled, and then we take the first one.
>
> Based on its value, the function throws one of the 2 custom exceptions. The try-catch statement catches the relevant exception and prints the appropriate message.

***

## Multiple constructors

> In the previous sections we created custom exceptions by implementing subclasses of an exception class. In all those cases we only used the class constructor with a message parameter. However, the Exception class has 4 different constructors, while other exception subclasses may have at least two. If we aim to create exception subclasses for a library, then we may want them to have multiple constructors.
> 
> In the following example, we implement multiple constructors by using the keyword super. This calls the constructor of the base type. In order to use this method, the derived exception should not have any primary constructor. For each constructor, the relevant base exception constructor is initialized (or delegated to the new constructor). The syntax for each secondary constructor is illustrated in the following example code. The new constructor is followed by : and then by the super keyword with the appropriate parameters. Note that Throwable is the base class for all errors and exceptions.
>
> ```kotlin
> class MyCustomException: Exception {
>     constructor() : super()  // No parameters
>     constructor(message: String?) : super(message)  // Only the String parameter
>     constructor(message: String?, cause: Throwable?) : super(message, cause) // Both parameters
>     constructor(cause: Throwable?) : super(cause)  // Only the exception parameter
> }
> ```
>
> Our new exception has 4 constructors and can be thrown in the following ways:
>
> ```kotlin
> throw MyCustomException()
> 
> throw MyCustomException("My exception message")
> 
> throw MyCustomException("My exception message", otherException)
> 
> throw MyCustomException(otherException)
> ```
> 
> In the following example, we create a custom exception derived from ArithmeticException. It has only 2 constructors:
>
> ```kotlin
> class MyArithmeticException: ArithmeticException {
>     constructor() : super()
>     constructor(message: String?) : super(message)
> }
> ```

- Exception 을 할 때 부모에 있는 Constructor 를 이용할 수 있다.
- 이 경우 Primary Constructor 를 쓰는게 아니다. Secondary Constructor 를 쓰느 것. 