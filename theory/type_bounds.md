# Theory: Type Bounds

> Previously, we have seen that generics can accept any type of parameters and make code reusable. Let's get familiar with another aspect of generics now. Sometimes we need to restrict the type parameter inside a generic function or class. For example, we have a generic class Storage<T> and we want to make it store only books without creating one more class. In such a situation, we should use type bounds.

- generic 에서 들어올 수 있는 타입을 제한할 수 있는게 Type Bounds 이다.

***

## Usage with classes

> We have mentioned a generic class named Storage<T> above. Let's take a look at its code:
>
> ```kotlin
> class Storage<T>() {
>     // some code
> }
> ```
> 
> Before, we wanted to save only books inside this storage. But a "book" is quite a wide concept – it can include magazines, brochures, etc. We can add our limitation by adding a constraint T : Book inside angle brackets:
>
> ```kotlin
> class Storage<T : Book>() {
>       // some code
> }
> ```
> 
> Then we create the classes whose objects we want to store:
>
> ```kotlin
> open class Book {}
> class Magazine : Book() {}
> class Stone {}
> ```
> 
> We've created three classes: Book, Magazine, and Stone, and, as you can see, Magazine inherits Book. Now let's create instances of Storage<T>:
>
> ```kotlin
> val storage1 = Storage<Book>()
> val storage2 = Storage<Magazine>()
> val storage3 = Storage<Stone>() // compile-time error
> ```
> 
> The first two lines will compile without problems. The third one, however, will return an error: Type parameter 'Stone' is not within its bounds. Since this is a compile-time error, we catch this problem before it can appear in a real application. This makes type bounds safe to use.
> 
> By default, all type parameters are constrained by the type Any?. The definition of any generic class, for example, SomeGeneric<T> is the same as SomeGeneric<T : Any?>.
>
> As constraints, we can set not only classes but interfaces, too. Do not try to extend one generic class from another (like Storage<Magazine> : Storage<Book>) — it will lead to an error.

- Type bound 로 <T : Book()> 로 해놓으면 Book 계열의 클래스들만 들어올 수 있다.
- 다른 클래스 타입을 넣으면 컴파일 에러가난다.
- 기본으로 <T> 이런식으로 쓰면 <T: Any?> 와 같다. 즉 어떠한 타입이 와도 상관없다는 의미.
- 클래스 타입 대신에 인터페이스 타입을 넣어도 된다.
- 제네릭끼리의 경우에는 상속하면 에러가 난다.

***

## Usage with functions

> Type bounds can be used with generic functions, too. The principle of usage with functions is the same as with classes.
>
> ```kotlin
> fun <T : Book> sortByDate(list: List<T>) { ... }
> ```
> 
> This function takes List<T> as an argument type. The type Book is specified after a colon: it's the upper bound. It means that only a type that extends Book can be substituted for T. Imagine that we have two lists: the first one is named listOne and it stores values of the type Magazine, which extends Book. The second list listTwo stores values of the type String.
>
> ````kotlin
> /* create instances */
> var listOne: List<Book> = listOf();
> var listTwo: List<String> = listOf();
> 
> /* invoke methods */
> sortByDate(listOne) // OK because Magazine is a subtype of Book
> sortByDate(listTwo) // Error: String is not a subtype of Book
> ````
> 
> As we can see, we have no problems invoking sortByDate() with listOne as an argument. But we do have problems when we try to pass listTwo. String is not a subtype of Book, and that's why we can't pass List<String> to sortByDate().

- <T: Book> 이런식으로 Type bound 를 쓰면 upper bound 를 설정하는 것이다.
  - 즉 Book 보다 상위에 있는 클래스는 제한한다는 뜻으로
  - Book 의 하위 클래스만 들어올 수 있다.

***

## Multiple bounds

> Type variables may have multiple bounds, but only one upper bound can be specified inside the angle brackets. If you need multiple type bounds, you need to use the where-clause to separate them. Imagine that we have an interface Watchable, which is generic, and we want to pass object realizations of this interface to sortByDate (in order to sort films and news by date, for example).
>
> ```kotlin
> fun <T> sortByDate(list: List<T>)
>       where T : Book, T : Watchable<T> {...}
> ```
> 
> Consider the fact that Kotlin (like Java) does not support multiple inheritance. It means that a class can extend only one class. But there is good news — a class can implement an unlimited number of interfaces!
>
> When you use multiple bounds, the first type should be a class or an interface. The following types must be interfaces.

- Type bound 로 여러개를 넣을 수 있는데 이 경우에는 where 절을 통해서 넣으면 된다.

