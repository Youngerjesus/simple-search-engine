# Theory: Secondary constructor

> You already know how to work with primary constructors. However, they have their limitations. For example, you may need to create several different constructors for the same class but you can't do that with a primary constructor alone. That's where secondary, or custom, constructors come in handy.

- Primary constructor 이외에 다른 생성자를 만들려면 Secondary constructor 를 이용하면 된다.

***

## Custom constructor

> You can declare custom constructors for a class along with a primary constructor or without one.
>
> To declare a secondary constructor, write the keyword constructor inside the class body and parentheses with the constructor's parameters after the keyword. Then, put curly braces with the constructor logic inside:
>
> ```kotlin
> class Size {
>     var width: Int = 0
>     var height: Int = 0
> 
>     constructor(_width: Int, _height: Int) {
>         width = _width
>         height = _height
>     }
> }
> ```
> 
> Now you can create objects in one line, just as if you were using a primary constructor:
>
> ```kotlin
> val size1 = Size(3, 4)
> val size2 = Size(5, 1)
> ```
> 
> Be careful: you have to either use an implicit constructor or declare your own, but you cannot use both at the same time:
> 
> ````kotlin
> class Size {
>     var width: Int = 0
>     var height: Int = 0
> 
>     constructor(_width: Int, _height: Int) {
>         width = _width
>         height = _height
>     }
> }
> 
> val size = Size() // Error! No values passed for parameters _width and _height
> ````
> 
> What you can do is create a replica of the default constructor explicitly (empty curly braces can be removed):
>
> ````kotlin
> // preferable solution
> class Size() {
>   var width: Int = 0
>   var height: Int = 0
> }
> 
> // or this way
> 
> class Size {
>   var width: Int = 0
>   var height: Int = 0
> 
>     constructor() {
>     }
> }
> ````

- primary constructor 대신에 class 내부에서 constructor 를 이용해서 생성자를 만들 수 있다. 
  - 이게 Secondary constructor
- Primary constructor 이 없다면 내부에서 만든 constructor 를 무조건 사용해야한다. 
- 둘 다 쓸려면 다음과 같이 하면 된다.

```kotlin
class Size() {
    var width: Int = 0
    var height: Int = 0

    constructor(_width: Int, _height: Int) : this() {
        width = _width
        height = _height
    }
}
```

***

## Multiple constructors

> Creating several constructors for a class is almost as simple as creating just one, but there is a particular constraint you need to keep in mind. Every secondary constructor has to have a unique signature. You cannot use the same signature for the primary or any other constructor.
>
> The constructor signature consists of the number, the types, and the order of the parameters. To create a valid constructor, you need to make sure it has a unique list of parameters. As an example, look at the following constructors for the class Size:
>
> ```kotlin
> class Size {
>     var width: Int = 0
>     var height: Int = 0
> 
>     constructor(_height: Int) {
>         height = _height
>     }
> 
>     constructor(_width: Int, _height: Int) {
>         width = _width
>         height = _height
>     }
> 
>     constructor(_width: Int, _height: Double) {
>         width = _width
>         height = _height.toInt()
>     }
> 
>     constructor(_height: Double, _width: Int) {
>         width = _width
>         height = _height.toInt()
>     }
> }
> ```
> 
> The code below will create four Size objects with the same property values using different constructors:
>
> ```kotlin
> val size1 = Size(7) // uses 1st constructor
> val size2 = Size(0,7) // uses 2nd constructor
> val size3 = Size(0, 7.0) // uses 3rd constructor
> val size4 = Size(7.0, 0) // uses 4th constructor
> ```
> 
> Remember that signatures are defined by the types of the parameters, not by their names. For example, the compiler can not tell these two constructors apart, even if they look different for a person:
>
> ```kotlin
> constructor(width: Int, height: Int) {}
> constructor(x: Int, y: Int) {}
> ```
> 
> So, implemented in the same class, these constructors will cause an error.

- 클래스 내부에 다양한 생성자를 만드는게 가능

***

## this keyword

> Inside the class code, you can also access the object members using a special keyword this that represents the current object.
>
> For example, you can use it to name the constructor parameters the same as the class properties. Let's change the class Size:
>
> ```kotlin
> class Size {
>     var width: Int = 0
>     var height: Int = 0
> 
>     constructor(width: Int, height: Int) {
>         this.width = width
>         this.height = height
>     }
> }
> ```
> 
> In the code above, you will get an error without the keyword this, since the names will be interpreted as the immutable constructor parameters and not the class members.

***

## Omitting default values

> As you remember, if a property value is assigned in the constructor, you don't have to provide a default value:
>
> ```kotlin
> class Size (var width: Int, var height: Int) {
>     // whatever you want
> } 
> ```
> 
> This is also true for secondary construction. Let's change var to val in the Size class so the properties cannot be reassigned. For the sake of demonstration, let's add another property area that will be calculated based on the constructor parameters:
>
> ```kotlin
> class Size {
>     val width: Int
>     val height: Int
>     val area: Int
> 
>     constructor(width: Int, height: Int) {
>         this.width = width
>         this.height = height
>         this.area = width * height
>     }
> }
> ```
> 
> It looks like a reassignment, but you are just initializing the values, so nothing wrong.
>
> Note that you cannot use the val and var keywords in the secondary constructor.
>
> ```kotlin
> class Size {
>     constructor(val width: Int, val height: Int) { // error, val is not allowed
>     }
> }
> ```

- 생성자로 인해 값을 넣어줄 수 있는 property 는 기본값을 설정하지 않아도 된다.
  - primary constructor property 나 
  - secondary constructor 로 무조건 넣어줄 수 있는 property
- secondary constructor 에서는 val 과 var 키워드를 넣을 수 없다.

***

## Constructors delegation

> If a class has a primary constructor, each secondary constructor needs to call the primary one, either directly or indirectly through another secondary constructor(s). This is called delegation.
>
> Delegation to another constructor of the same class is done with the keyword this placed after the constructor arguments and before the constructor body:
>
> ```kotlin
> class Size(val width: Int, val height: Int) {
>     var area: Int = width * height
> 
>     constructor(width: Int, height: Int, outerSize: Size) : this(width, height) {
>         outerSize.area -= this.area
>         println("Updated outer object's area is equal to ${outerSize.area}")
>     }
> }
> ```
> 
> Delegation to the primary constructor becomes the first statement of a secondary constructor, so the properties are initialized before the secondary constructor code is executed. Initializer blocks, if present, are also executed before the secondary constructor. If a class has no primary constructor, the delegation happens implicitly.

- Primary constructor 과 secondary constructor 이 모두 있다면 Secondary constructor 에서는 Primary constructor 를 호출하는 위임 과정이 필요하다.
  - 이떄 객체의 내부 생성자에 접근할려면 this 를 이용하면 된다.
- Secondary constructor 는 Primary constructor 이 호출되고 init {} 초기화 블록이 호출된 후에 실행된다.

***

## Constructor execution

> Let's look at the example and see in which order the class code is executed:
>
> ```kotlin
> class Size(val width: Int, val height: Int) {
>     var area: Int = width * height
> 
>     init {
>         println("Object with area equal to $area is created")
>     }
> 
>     constructor(width: Int, height: Int, outerSize: Size) : this(width, height) {
>         outerSize.area -= this.area
>         println("Updated outer object's area is equal to ${outerSize.area}")
>     }
> }
> 
> fun main() {
>     val outerObject = Size(5, 8)
>     val innerObject = Size(2, 3, outerObject)
> } 
> ```
> 
> When creating outerObject, the primary constructor is directly called, the properties are initialized and the init block is executed. In case of innerObject, the secondary constructor first calls the primary, the properties initialization and the initialization block happen, and finally, the secondary constructor code is executed.
>
> It results in the following output:
>
> ```kotlin
> Object with area equal to 40 is created
> Object with area equal to 6 is created
> Updated outer object's area is equal to 34
> ```

