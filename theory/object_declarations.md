# Theory: Object declarations

***

## Singleton

> Singleton is a design pattern that ensures that a class has only one instance with global access to it. This means we can get an instance of a singleton class anywhere in the code. Consider a simple analogy: when playing a board game, all players act within the field of the game. This is a specific single field where the global state of the game is stored.
>
> Before we move forward, let's quickly remind ourselves of the main singleton features:
>
> - Singleton class has only a single instance.
> - Singleton class provides a global access point.

- Singleton 의 간략한 정의를 보여준 것. 

***

## Object declaration

> Singleton is a really useful pattern, and Kotlin provides a specific structure to declare singletons: object declaration. This is a special class with an object keyword that creates a singleton. This keyword hides all complicated steps so you don't have to think about the ways to implement this pattern: just use object declaration.
>
> Let's take a look at this example:
>
> ````kotlin
> object PlayingField {
> 
>     fun getAllPlayers(): Array<Player> {
>         /* ... */
>     }
>     
>     fun isPlayerInGame(player: Player): Boolean {
>         /* ... */
>     }
> 
> }
> ````
> 
> When you use object declaration, the constructor is not available because Kotlin does it itself. To get an instance of our playing field, use PlayingField declaration. We can use it anywhere and it will return the same object every time.
>
> ````kotlin
> fun startNewGameTurn() {
>     val players = PlayingField.getAllPlayers()
>     if (players.length < 2) {
>         return println("The game cannot be continued without players")
>     }
>     for (player in players) {
>         nextPlayerTurn(player)
>     }
> }
> 
> fun nextPlayerTurn(player: Player) {
>     if (!PlayingField.isPlayerInGame(player)) {
>         return println("Current player lost. Next...")
>     }
>     /* Player actions here */
> }
> ````

- 코틀린에서 Singleton 객체를 만드는 방법은 간단하다. 그냥 Object 선언을 넣으면 된다. 이러면 싱글톤을 만들기 위해서 해야하는 구현을 생략해도 된다. (코틀린의 유용함을 나타내는 측면.) 

***

## Nested object

> Often you need to create a singleton that is somehow related to another class. For example, you create a Player class to store information about different characters in the game. All these characters can share some characteristics, for example, speed. How would we store such information?
> 
> Of course, you may use an object declaration and create something like that:
>
> ```kotlin
> object PlayerProperties {
>     /* Default player speed in playing field – 7 cells per turn */
>     val defaultSpeed = 7
> 
>     fun calcMovePenalty(cell: Int): Int {
>         /* calc move speed penalty */
>     }
> }
> ```
>
> However, there can be many classes and related singletons, which makes the code confusing and difficult to read. Another way to store this information is by using a nested object.
>
> Object declaration can be nested in a class declaration. A nested class is created inside another class; it cannot be accessed without an outer class declaration.
>
> ```kotlin
> class OuterClass {  
>    //outer class code  
>     class NestedClass {  
>       //nested class code  
>     }  
> }  
> ```
> 
> Now, let's take a closer look at a nested object construction:
>
> ```kotlin
> class Player(val id: Int) {
>      object Properties {
>          /* Default player speed in playing field – 7 cells per turn */
>          val defaultSpeed = 7
>  
>          fun calcMovePenalty(cell: Int): Int {
>              /* calc move speed penalty */
>          }
>      }
> }
>  
>  /* prints 7 */
>  println(Player.Properties.defaultSpeed)
> ```
>
> The object Properties has the scope Player, which means we can access it only through Player.Properties. That's how you can create a singleton connected to a special class.
>
> You can also use properties and functions from a nested object in the outer class. This can be useful for storing some data common to all instances of a class and for initializing variables. For example:
>
> ```kotlin
> class Player(val id: Int) {
>      object Properties {
>          val defaultSpeed = 7
>      }
>      
>      val superSpeed = Properties.defaultSpeed * 2 // 14
> }
> ``` 
>
> The opposite is not true. You cannot use the properties and the functions of the outer class in the inner. For example, you cannot do something like that:
>
> ```kotlin
> class Player(val id: Int) {    
>      val speed = 7
>      object Properties {
>          val defaultSpeed = speed // you cannot get this variable
>      }
> }
> ```
> 
> As you can see, it's similar to static in the other languages. Kotlin doesn't provide static members by default, but you may use nested objects if you need something related to the class.
  
- 클래스들끼리 밀접한 관련이 있다면 서로 독립적인 클래스를 만드는 것 보다 Nested Class 를 만드는게 좋다.
- Nested Class 도 Singleton 처럼 사용하는게 가능한데 주로 OuterClass 의 공유 정보 같은 것들에 사용하면 좋다. (딱 하나만 있으면 되고, Outer class 와 밀접한 관련이 있는 것을 말함.)  
- Nested Class 는 Outer class 의 property 와 function 을 이용하는게 가능하지만 그 역은 안된다.

***

## Objects and nested objects

> Let's discuss additional features. Sometimes you want to create more than one singleton associated with a class. You can declare any number of objects inside another class:
>
> ```kotlin
> class Player(val id: Int) {
>     object Properties {
>         /* Default player speed in playing field – 7 cells per turn */
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
> 
> /* prints 13 */
> println(Player.Factory.create(13).id)
> ```
> 
> In this example, we've created an additional singleton that can create a new instance of the class. This pattern is called Factory and can be really useful for complex cases. The usual way to use this pattern is through nested objects.
>
> Another useful feature of nested objects is that you can declare any number of objects inside another object.
>
> ```kotlin 
> object Game {
>      object Properties {
>          val maxPlayersCount = 13
>          val maxGameDurationInSec = 2400
>      }
>  
>      object Info {
>          val name = "My super game"
>      }
>  }
> ```
> 
> This is helpful for organizing the data in the singletons.
  
- 하나의 클래스안에 싱글톤 객체를 여러개 넣을 수 있다. (Nested 방식으로)
- Nested 를 활용하는 예로 객체를 생성하는 Factory 를 Nested Class 의 싱글톤으로 선언해놓고 거기서 객체를 만들도록 하는 것이다. (생성자보다 팩토리 메소드를 사용하는게 좀 더 적합한 경우가 있는데 그런 경우에 사용하면 좋을듯.) 
- 또 다른 사용예는 객체에서 사용되는 공통적인 정보들을 Singleton Nested Class 로 가져가놓으면 괜찮겠다.

  