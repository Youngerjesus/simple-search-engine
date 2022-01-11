# Theory: Lazy initialization

> You can declare a variable by putting an equal sign followed by a value after its name
> 
> ````kotlin
> var a = "I love Hyperskill!"
> ````
> 
> Creating a String object like this isn't a very resource- or time-consuming operation for the compiler. But creating instances of more complex classes can be much more expensive. In this topic, you will learn how to tackle this issue by delaying the creation of objects until they are needed using lazy initialization.

- 객체를 필요한 시점에 초기화를 시켜서 좀 더 리소스를 효율화 하는 방법인 lazy initialization 에 대해서 알아보겠다.

***

## How it works

> Lazy initialization lets us create an object at the exact point when the first reference to it occurs.
>
> This means that we don't need to waste time by immediately using our program's resources to allocate memory to objects that aren't required from the outset.
> 
> If we allow objects to be initialized when they're needed, we can save a lot of time by redistributing the allocation of resources over the life cycle of our program.

- Lazy initialization 은 처음 참조하는 시점에 객체를 초기화 시킨다.
- 이룰 통해서 미리 객체에 필요한 메모리를 할당하지 않으니까 리소스를 다루는 측면에서 효율적이다.

***

## Implementation

> This goal can be achieved in different ways in different languages and frameworks.
>
> For example, the Spring backend framework has the special property spring.main.lazy-initialization=true. This can reduce an application's startup time by creating fewer components at the beginning. However, in the context of Spring, this feature has some disadvantages that are beyond the scope of our topic.
>
> Let's see how to use lazy initialization without frameworks.
>
> Kotlin has a special lazy() function that accepts a lambda. The first call executes this lambda and remembers the result. Subsequent calls simply return this value.
>
> You can see a simple example below:
>
> ```kotlin
> fun main() {
>     val a: String by lazy {
>         print("Variable a is initialized. )
>         "I love Hyperskill!"
>     }
> 
>     println("Initializing a! ") // Initializing a!
>     println(a) // Variable a is initialized. I love Hyperskill!
>     println(a) // I love Hyperskill!
> }
> ```
> 
> So, why did we get this output? Before the value of a became "I love Hyperskill!", the lambda body was called with print(). This all happened the first time we called println(a) — no sooner, no later. When we printed a again, no calculation occurred, so only a's value was displayed.
>
> When using lazy initialization in Kotlin, you must declare variables with the val keyword because the value can only be initialized once.

- lazy initialization 은 Framework 의 도움으로도 할 수 있다.
- 스프링 프레임워크에서 `spring.main.lazy-initialization=true` 옵션을 키면 lazy initialization 을 할 수 있다.
- 물론 이것도 단점이 있다.
  - 처음 요청을 처리하는 시간이 길어진다던지.
  - 모든 빈을 초기화하면 사용 가능한 메모리가 없다라던지.
  - 대신에 처음 어플리케이션이 뜨는 시간은 절약할 수 있다.
- 코틀린 자체에서 제공해주는 lazy initialziation 은 `lazy` 라는 키워드를 통해서 가능하다.
- 주의할 건 초기화는 딱 한번만 호출되야하므로 (값이 바뀌면 안된다는 뜻) val 키워드를 써야한다.

***

## Synchronization problems

> If your programs take advantage of multithreading, you need to know about the lazy() function's mode parameter.
>
> - `LazyThreadSafetyMode.SYNCHRONIZED` means that the value is only computed in one thread, and all threads will get the same value. It's the default option, so you can omit it if you wish:
> 
> ```kotlin
> val a: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
> ```
> 
> - LazyThreadSafetyMode.PUBLICATION specifies that the lambda can be called several times with an uninitialized lazy object value, but the value that is returned first will be used:
>
> ```kotlin
> val a: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
> ```
> 
> - LazyThreadSafetyMode.NONE means there's no synchronization at all, so if we call the variable from different threads, its value can't be uniquely defined. Using this option isn't recommended if your program allows a lazy object to be called for the first time from more than one thread:
> 
> ```kotlin
> val a: String by lazy(LazyThreadSafetyMode.None) {
> ```
> 
> You may be wondering why the keyword by is used before lazy? Well, it's to do with delegates. This is how we delegate the implementation of the corresponding property to a lambda. A detailed explanation about this is provided in the delegates topic.

- lazy 초기화를 하는 스레드가 하나 이상이 필요한 경우에는 Synchronization 문제를 생각해봐야한다.
  - 기본이 LazyThreadSafetyMode.SYNCHRONIZED 인데 이는 하나의 스레드만 lazy 연산을 수행할 수 있다는 뜻이다. 다른 스레드들은 값만 가져올 수 있다는 뜻.
  - LazyThreadSafetyMode.PUBLICATION 은 lazy 초기화를 여러 스레드에서 호출할 수 있다. 초기화 되지 않았더라면. 그치만 값은 제일 처음 연산이 끝난 걸 사용한다.
  - LazyThreadSafetyMode.NONE 은 동기화를 고려하지 않겠다는 뜻으로 다른 스레드에서 lazy 연산을 부를 수 있다. 만약 두 개 이상의 스레드에서 초기화 작업을 수행하게 되는 경우라면 이걸 추천하지는 않는다.

***

## lateinit

> Another delayed initialization feature in Kotlin that's worth mentioning is lateinit. This is a keyword rather than a function like lazy().
>
> Normally, if a class field's value isn't null, we should either initialize the property immediately or do it in the constructor. But there are often situations where, at the time we create an instance of a class, we can't initialize the property, and we don't want to make it nullable.
>
> We can't use the following approach because the default value of the field must be initialized:
>
> ```kotlin
> class A {
>   var a: String
> ```
> 
> We could make a nullable, but we don't want it to be!
>
> ```kotlin
> class A {
>   var a: String? = null
> ```
> 
> Fortunately, lateinit can be used to solve this problem:
>
> ```kotlin
> class A {
>     lateinit var a: String
> 
>     fun initA(a: String) {
>         this.a = a
>     }
> }
> ```
>
> Note that lateinit variables must be declared with var, unlike those declared with lazy().
>
> We can also check whether the property has already been initialized. (Under the hood, this is achieved through reflection, but that's not something you need to understand right now.) To see how this works, let's add a function to our class. As shown below, isInitialized can be called on the current object's field via this::a, returning either true or false:
> 
> We can also check whether the property has already been initialized. (Under the hood, this is achieved through reflection, but that's not something you need to understand right now.) To see how this works, let's add a function to our class. As shown below, isInitialized can be called on the current object's field via this::a, returning either true or false:
>
> ````kotlin
> class A {
>     lateinit var a: String
> 
>     fun initA(a: String) {
>         this.a = a
>     }
> 
>     fun doSmth() {
>         if (::a.isInitialized)
>             println("a is Initialized")
>         else
>             println("a isn't Initialized")
>     }
> }
> ````
>
> If you try to access a property before the binding has been initialized, an error will be thrown:
>
> Caused by: kotlin.UninitializedPropertyAccessException: lateinit property binding has not been initialized

- 클래스 필드에서 lazy 초기화를 할 수 있는 방법은 lateinit 을 쓰는 것이다. 이건 lazy() 와 동일하다.
  - 이걸 쓸 때는 이 필드가 절대 널은 아닌데 그렇다고 지금 당장 초기화 할 필요는 없다고 판단될 때 사용한다.
- lateinit 의 필드는 var 을 통해서 넣어야하고 초기화되지 않았을 떄 사용할려고 하면 에러가 발생한다.

