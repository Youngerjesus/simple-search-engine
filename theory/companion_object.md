# Theory: Companion object

> You already know how to create singletons associated with classes. However, in many cases, you need only one singleton for a class, and using its full name may seem wordy. For example, you might need to store only one common property. In this case, you can use another Kotlin feature, the companion object.

- 싱글톤 패턴을 사용하는 대부분의 케이스에서는 클래스와 연결시켜서 사용하는 경우가 있다.
- 대표적인 경우가 클래스의 공통적인 property 속성을 싱글톤으로 저장시키는 경우.
- 이 경우에는 Kotlin 에서 제공해주는 기능 중에 Companion object 기능을 사용하는게 낫다.

***

## Companion object

> An object declaration inside a class can be marked with the companion keyword:
>
> ````kotlin
> class Player(val id: Int) {
>     companion object Properties {
>         /* Default player speed in playing field - 7 cells per turn */
>         val defaultSpeed = 7
> 
>         fun calcMovePenalty(cell: Int): Int {
>             /* calc move speed penalty */
>         }
>     }
> }
> 
> /* prints 7 */
> println(Player.Properties.defaultSpeed)
> ````
> 
> A companion object is a singleton attached to an outer class, and hence it cannot be accessed without accessing the outer class. It allows us to understand that the current object is somehow connected with the outer class. For example, we can store the default speed for all players in the Player companion object. That also means that every Player instance contains a reference to the companion object and will return its instance every time.
> 
> Until now, we've worked with a named companion object. However, unlike the case of a nested object, the name can be omitted. Let's try it:
>
> ````kotlin
> class Player(val id: Int) {
>     companion object {
>         /* Default player speed in playing field - 7 cells per turn */
>         val defaultSpeed = 7
> 
>         fun calcMovePenalty(cell: Int): Int {
>             /* calc move speed penalty */
>         }
>     }
> }
> 
> /* prints 7 */
> println(Player.defaultSpeed)
> ````
> 
> As you can see, if we omit the name of a companion object, we can still access it through the outer class declaration. If we want to somehow use it, we can define it manually. If a companion object doesn't have a name, we can also use the default name Companion:
>
> ````kotlin
> /* prints 7 too */
> println(Player.Companion.defaultSpeed)
> ````

- class 내부에 있는 singleton 클래스는 companion 을 붙일 수 있다.
- companion 이 붙은 싱글톤의 경우는 싱글톤과 마찬가지로 outer class 에서만 접근이 가능하고 내부에서 위부로는 접근이 안된다.
- 그리고 이름을 생략할 수 있다는 특징이 있다. 이름을 생략해도 outer class 와 붙어 있을 수 있기 떄문에 이름이 Companion 인듯.
- 접근은 그냥 일반 property 에 접근하는 것처럼 하면 된다.
- 만약 companion object 에 명시적으로 접근하고 싶으면 `Companion` 을 붙이고 접근하면 된다.

***

## Companion object and outer class

> A companion is really closely associated with the outer class. You may freely use properties and functions from the companion object in the outer class. For example:
>
> ```kotlin
> class Deck {
>     companion object {
>         val size = 10
>         val height = 2
>         fun volume(bottom: Int, height: Int) = bottom * height
>     }
> 
>     val square = size * size             //100
>     val volume = volume(square, height)  //200
> }
> ```
> 
> But what happens if the outer class has a property with the same name as the companion object? Well, in this case, the properties from the class will shadow the properties of the companion.
>
> ```kotlin
> class Deck {
>     companion object {
>         val size = 10
>     }
>     val size = 2
>     val square = size * size // 4
> }
> ```
> 
> In this case, if you want to use a property from the companion, you must use the companion's name, or, if it wasn't named, the default name Companion:
>
> ```kotlin
> class Deck {
>     companion object {
>         val size = 10
>     }
>     val size = 2
>     val square = Companion.size * Companion.size // 100
> }
> ```
> 
> Similar to the case of nested objects, you cannot use the properties and the functions of the outer class in the inner one. For example, you cannot do something like that:
>
> ```kotlin
> class Deck() {    
>     val size = 2
>     object Properties {
>         val defaultSize = size // you cannot get this variable
>     }
> }
> ```

- 이전에 말했듯이 companion object property 와 function 들은 outer class 에서 접근이 가능하다.
- 만약에 outer class 의 property 이름과 companion object 의 property 이름이 같다면 어떻게 될까?
- 이 경우에 똑같은 이름을 사용하고 있다면 outer class property 를 먼저 인식하게 된다. companion object 의 property 를 이용하고 싶다면 Companion.property 를 통해서 접근이 가능하다.

***

## Limitations of companion objects

> Only one companion object is available for each class. That means you can't create multiple companion objects for a class because Kotlin does not support this behavior, even if they have different names. If we try to do it, an error will occur:
>
> ```kotlin
> class BadClass {
>     companion object Properties {
>     
>     }
> 
>     companion object Factory {
>     
>     }
> }
> 
> // Compilation error
> // Error: Only one companion object is allowed per class
> ```
> 
> However, we can create one companion object and several nested objects:
>
> ```kotlin
> class Player(val id: Int) {
>     companion object Properties {
>         /* Default player speed in playing field - 7 cells per turn */
>         val defaultSpeed = 7
> 
>         fun calcMovePenalty(cell: Int): Int {
>             /* calc move speed penalty */
>         }
>     }
> 
>     /* creates a new instance of Player */
>     object Factory {
>         fun create(playerId: Int): Player {
>             return Player(playerId)
>         }
>     }
> }
> 
> /* prints 7 */
> println(Player.Properties.defaultSpeed)
> 
> /* also prints 7 */
> println(Player.defaultSpeed)
> 
> /* prints 13 */
> println(Player.Factory.create(13).id)
> ```
> 
> There is one more limitation: we cannot create a companion object inside another singleton (or a companion object) because that violates the global access principle.
>
> ```kotlin
> object OuterSingleton {
>     companion object InnerSingleton { // Modifier 'companion' is not applicable inside 'object'  
>   
>     }
> }  
> ```

- companion object 는 하나의 클래스에서 한 개만 만들 수 있다. 여러개를 만들려고 하면 컴파일 에러가난다.
- 그냥 object 의 경우에는 클래스에서 여러개를 nested 로 만들 수 있다.
- 그리고 싱글톤 안에서는 companion object 를 만들지 못한다.

***

## Analogue in other languages

> If you come from another programming language, you may be a little confused by companion objects. The closest concept to it is static members. The keyword static means that fields and methods with this modifier are common for all objects of the class and can be used without creating an instance of the class. You may encounter this keyword in several languages.
> 
> For example, in Java, the usage of static will look like this:
>
> ```kotlin
> class Dog {
>     public static int numOfPaws = 4;
> 
>     public static String createSound() {
>         return "WUF-WUF";
>     }
> }
> /*prints WUF-WUF*/
> System.out.println(Dog.createSound());
> ```
> 
> As you may know, Kotlin doesn’t have the static keyword. If you need something common to all instances of a class, you can use a companion object:
>
> ```kotlin
> class Dog {
>     companion object {
>         val numOfPaws: Int = 4
>         fun createSound(): String = "WUF-WUF"
>     }
> }
> /*prints WUF-WUF*/
> println(Dog.createSound())
> ```
> 
> As you can see, when you use a companion object you also don't need to create a class instance to get this function! Remember, a companion object is not equal to a Java static initializer. In Kotlin, it is a single nested object that wraps all methods and fields which are common for the whole class.

- 다른 언어에서는 'static' 이라는 keyword 가 있는데 이는 method 나 property 를 인스턴스를 선언하지 않고 사용할만한, 모든 클래스가 있어야 할 요소들을 static 을 통해서 정의했다.
- 코틀린에서는 static 을 지원하진 않는다. 대신에 이런 기능이 필요하다면 companion object 를 적극적으로 쓰자.

