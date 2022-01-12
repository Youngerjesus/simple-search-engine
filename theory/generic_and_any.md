# Theory: Generics and Any

> As you know, generics enable us to parameterize types when defining classes (or interfaces) and methods. Parameterized types make it possible to reuse the same code while processing different concrete types

- generic 을 사용할 경우 Parameterized type 에 따라서 같은 메소드를 실행할 수 있도록 해준다.  
- 즉 코드의 재사용성을 높여준다.

***

## Reusing code with generics

> Let's consider a generic class named GenericType that stores a value of "some type".
>
> ```kotlin
> class GenericType<T>(val t: T) {
>     fun get(): T {
>         return t
>     }
> }
> ```
>
> It is possible to create an object with a concrete type (e.g., String):
>
> We can also create instances with other types (Int, Char) and then invoke the get method to access the internal field. In this manner, generics allow us to use the same class and methods for processing different types.

- 가장 일반적인 generic function 을 사용하는 경우 

***

## Reusing code with Any

> However, there is also another way to reuse code. If we declare a field of type Any, we can assign a value of any reference type to it.
>
> The following class demonstrates this concept:
>
> ```kotlin
> class NonGenericClass(val value: Any) {    
>     fun get(): Any {
>         return value
>     }
> }
> ```
>
> Now we can create an instance of this class with the same string as in the previous example (see GenericType).
>
> ```kotlin
> val anyInstance: NonGenericClass = NonGenericClass("abc")
> ```
> 
> It is also possible to create an instance by passing in a value of type Int, Char, or any other reference type.
>
> Using the Any class this way allows us to reuse the same class to store different data types.

- 재사용이 가능한 코드를 위해서 제네릭이 아닌 Any 타입으로 받고 실행하는 메소드를 만들 수도 있다. 
  - 이건 문제가 있다. 아래서 설명.

***

## The advantage of generics: from run-time to compile-time

> After an invocation of the get() method, we obtain an Any, not a String or an Integer. We cannot get a string directly from the method.
>
> ```kotlin
> val nonGenericInstance: NonGenericClass = NonGenericClass("abc")
> val str: String = nonGenericInstance.get() // Compile-time error: Type mismatch
> ```
> 
> To get the string back, we must perform an explicit type-cast to the String class.
>
> ````kotlin
> val str: String = nonGenericInstance.get() as String // "abc"
> ````
> 
> This works because a string was passed into instance2. But what if the instance does not store a string? If this is the case, the code throws an exception. Here is an example:
>
> ````kotlin
> val instance: NonGenericClass = NonGenericClass(123)
> val string: String = instance.get() as String // throws java.lang.ClassCastException
> ````
> 
> Now we can see the main advantage of generics over the Any class. Because there is no need to perform an explicit type-cast, we never get a runtime exception. If we do something wrong, we can see it at compile-time.
>
> ````kotlin
> val stringInstance: GenericType<String> = GenericType<String>("abc")
> 
> val str: String = stringInstance.get() // There is no type-casting here
> val num: Int = stringInstance.get() // It does not compi
> ````
>
> A compile-time error will be detected by the programmer, not a user of the program. Because generics let the compiler take care of type casting, generics are both safer and more flexible compared with the Any class.

- 제네릭을 안쓰고 Any 를 쓰는 경우에 명시적인 type cast 가 필요해진다.
  - 이 경우 올바른 타입 변환이 가능한 경우는 문제가 없겠지만 
  - 타입변환이 안되는 타입을 던지는 경우 예외가 발생한다. 
  - 이는 컴파일 시점에 잡을 수 없는 예외다. 
  - 제네릭을 쓰면 이런 문제를 컴파일 시점에서 잡을 수 있다.

***

## Multiple Type Parameters

> In many situations, it is much more convenient to have several parameters in a class, which can be of arbitrary type. Kotlin allows us to define not only one parameter of arbitrary type but also two, three, etc. In this case, you can specify several type parameters, separating them with a comma.
>
> ```kotlin
> class MultipleGenerics<T, P>(var valueT: T, var valueP: P)
> ```
> 
> This way is much better and safer than declaring all parameters as type Any. Let's see an example to understand the differences between these two methods of declaring parameterizing classes:
>
> We have two classes: a generic class PairGeneric and a non-generic class PairNonGeneric. Both of them have two fields of arbitrary type first and second:
>
> ```kotlin
> class PairGeneric<T, P>(var first: T, var second: P) {
>     fun changeFirst(newValue: T) {
>         first = newValue
>     }
> 
>     fun changeSecond(newValue: P) {
>         second = newValue
>     }
>     fun printData() {
>         println("Value:")
>         println("first = $first")
>         println("second = $second")
>     }
> }
> 
> class PairNonGeneric(var first: Any, var second: Any) {
>     fun changeFirst(newValue: Any) {
>         first = newValue
>     }
> 
>     fun changeSecond(newValue: Any) {
>         second = newValue
>     }
>     fun printData() {
>         println("Value:")
>         println("first = $first")
>         println("second = $second")
>     }
> }
> ```
>
> Now, let's do some wrong actions with the class fields and see the difference:
>
> ```kotlin
> fun main() {
>     val genericPair: PairGeneric<String, Int> = PairGeneric("John", 8)
>     val nonGenericPair: PairNonGeneric= PairNonGeneric("Kate", 18)
> 
>     genericPair.changeFirst(8) // It does not compile
>     nonGenericPair.changeSecond("Smith") // It works
> 
>     nonGenericPair.printData()
> }
> ```
>
> Here is the result for the object of PairNonGeneric class:
> 
> ```
> Value:
> first = Kate
> second = Smith 
> ```
> 
> As you can see, if the field type in the class is Any, you can easily and with no errors assign values of different types to the field, which is not good. When you write small programs, this might not be a problem for you, as you will remember what field type you defined. But when you go to code large programs and applications, this can lead to errors that are very hard to find. In this case, it is best to use generics: if you try to assign a value with a different type to a field, it won't compile and you will easily find the problem


