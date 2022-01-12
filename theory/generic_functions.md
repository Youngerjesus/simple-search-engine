# Theory: Generic functions

> Previously, we talked about classes named generic, which can have type parameters, and learned how we can use these classes. However, not only classes can be generic – there are generic functions, too. Type parameters can be passed to the function or be defined as its return type. Generic functions can be declared on their own or be class members of a class, no matter generic or non-generic.
>
> Generic functions are used in algorithms which do not depend on the types they operate on. For example, searching through an array does not depend on the type of values the array stores. That is why there is no need to declare several realizations of the same algorithm for different types.
>
> Let's take a closer look at generic functions now!

- generic 는 클래스에서만 사용하는게 아니라 함수를 선언할 때도 사용하는게 가능하다.
- 주로 타입에 의존하지 않는 알고리즘적인 요소에 많이 사용한다.

***

## Declaring generic functions

> The following function is declared as generic and does not belong to any class.
>
> ```kotlin
> fun <T> doSomething(t: T): T {
>     return t
> }
> ```
> 
> Here we can see that the type parameter T is passed to the function and declares its return type. Note that we need to specify the type parameter T both inside parentheses and angle brackets.
>
> Generic functions can also take or return values of non-generic types. Take a look at a function which calculates the length of a list:
>
> ```kotlin
> fun <T> calculateLength(list: List<T>): Int {
>     return list.size
> }
> ```
> 
> Let's pass a list of strings to this function:
>
> ```kotlin
>  var list = listOf("hello", "from", "hyperskill")
> println(calculateLength<String>(list)) // 3
> ```
> 
> To call a generic function, we need to specify the type arguments in angle brackets right after the name of the function. However, if the type parameters of a function can be inferred from the context (for example, if we use standard types), they can be omitted. So, we can rewrite the last line from the above example as follows:
>
> ```kotlin
> println(calculateLength(list)) // 3
> ```
> 
> Just like generic classes, generic functions can have several type parameters. They are separated by commas inside angle brackets:
>
> ```kotlin
> fun <T,U> multipleDoSomething(t: T, u:U){
>   // do something
> }
> ```

- function 도 먼저 generic 을 선언하면 매개변수와 리턴타입으로 generic 을 선언핳 수 있다.
- 사용할 땐 `<>` 로 명시적인 타입을 넣어줘야하지만 타입추론이 되는 경우에는 문제가 없다.
- 제네릭 function 도 여러가지 타입을 받을 수 있다.

***

## Generic methods

> As we said, generic functions can be members of classes. They can operate with other members of a class just like ordinary class methods. Let's take a look at an example with a non-generic class:
>
> ```kotlin
> class NonGenericClass {
>     fun <T> someGenericMethod(t: T): T {
>         //...//
>         return t
>     }
> }
> ```
>
> We declared a class named NonGenericClass with a generic method someGenericMethod(). The type parameter T is the type of the single argument and the return type. Let's create an instance of this class, invoke the method, and see what happens.
>
> ```kotlin
> fun main() {
>     var item = NonGenericClass();
>     var value = item.someGenericMethod("Hello!")
>     println(value)// Hello!
> }
> ```
> 
> We invoke the method from the instance and it returns a value that has the same type as the value that was passed in. Note that here we don't need to specify type arguments because we have a standard type String.
>
> More often, generic methods belong to classes that are also generic. Take a look at the example below:
>
> ```kotlin
> class GenericClass<T> {
>     fun <U> someGenericMethod(t: T, u: U): T {
>         //...//
>         return t
>     }
> }
> ```
>
> This method receives arguments of the class's type T and the method's own type U. The class has been already declared in the class header, so we do not need to declare it again in the method.

- Generic 클래스가 아닌 경우에도 제네릭 메소드를 넣는게 가능하다.
- 제네릭 클래스의 경우 그 클래스가 받는 타입 이외 타입을 사용하는 제네릭 메소드를 넣는 것도 가능하다.

***

## Extension functions

> Kotlin provides the ability to extend existing classes without inheritance or using design patterns. You can use extension functions, which allow adding some functionality to a class while not being a member of it.
>
> ```kotlin
> class BiggerBox<T>(var value1: T, var value2: T) {}
> 
> fun <T> BiggerBox<T>.changeBoxes() {
>     val tmp = this.value1
>     this.value1 = this.value2
>     this.value2 = tmp
> }
> 
> fun main() {
>     var box = BiggerBox("hyperskill", "kotlin")
>     println("${box.value1} and ${box.value2}")// hyperskill and kotlin
>     box.changeBoxes()
>     println("${box.value1} and ${box.value2}")// kotlin and hyperskill
> }
> ```
> 
> We have a generic class BiggerBox, which stores two values of the same type T. Also, we have an extension generic function, which swaps the two values. As you can see, changeBoxes() is not a member of the class and it can be invoked from an instance. Such approach is useful when we should not or even cannot modify the existing class written, for example, by another developer.

- Generic function 의 경우 extension function 에서도 사용이 가능하다.
- extension function 은 클래스에 기능을 추가하기 위해서 클래스의 상속과 디자인 패턴을 이용하지 않고 기능을 추가하는 방법이다.