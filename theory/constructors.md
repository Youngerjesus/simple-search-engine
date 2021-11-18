# Theory: Constructors

***

## Default constructor

> Constructors are class members that initialize a new object of the class. In other words, constructors set a new object state by defining its properties. So, when you create an object, you invoke a constructor.
> 
> For further examples, let's use the class Size:
>
> `````kotlin
> class Size {
>     var width: Int = 1
>     var height: Int = 1
> }
> `````
> 
> Let's remember for a second how to create objects. We write the class name and empty parentheses after it:
>
> ````kotlin
> val size = Size()
> ````
> 
> This is actually a constructor call, and it's like calling a function with no arguments. Every class needs to have a constructor, so if it isn't explicitly defined, the compiler automatically generates a default constructor, which only creates an object and doesn't have any logic inside.

- 생성자를 통해서 객체를 만들 때 객체의 State 를 정의한다. Property 에 값을 넣는 걸 통해서 
- 기본 생성자는 컴파일러에 의해 자동으로 생성된다. (생성자가 없다면)

***

## Primary constructor

> Often you know the object's properties before you create it. To make your code more concise, you can set the properties in the constructor: just make the constructor receive the arguments you need.
>
> The primary constructor is the right tool for that. It does not contain any code, it just initializes an instance of a class and its properties. To define a primary constructor, you should put class initialization arguments in the parentheses after the class name.
>
> The primary constructor for the class Size will look like this:
>
> ```kotlin
> class Size(width: Int, height: Int) {
>     val width: Int = width
>     val height: Int = height
>     val area: Int = width * height
> }
> ```
>
> Usually, to define a constructor, you should put the keyword constructor before its parameters. Kotlin's primary constructor allows you to omit the keyword.
>
> In any way, another legitimate way to define the primary constructor looks like this:
>
> ```kotlin
> class Size constructor(width: Int, height: Int) {
>     val width: Int = width
>     val height: Int = height
>     val area: Int = width * height
> }
> ```

- 객체를 생성할 때 꼭 필요한 Property 나 파라미터가 있다면, 이를 받을 수 있다. 
- 이 경우 Primary Constructor 를 통해서 코드없이 클래스의 프로퍼티를 초기화하는게 가능하다.
- constructor 키워드는 생략해도 된다. 

***

## Property declarations

> You can put simple property declarations inside the primary constructor. To declare a read-only property, put the keyword val in the parentheses before the argument name. For a mutable property, use the keyword var.
>
> For example, let's move the property width from the class body:
>
> ```kotlin
> class Size(val width: Int, height: Int) {
>     val height: Int = height
>     val area: Int = width * height
> }
> ```
>
> Now let's put the remaining property height inside the primary constructor:
>
> ````kotlin
> class Size(val width: Int, val height: Int) {
>     val area: Int = width * height
> }
> ````

- Primary Constructor 에서 선언된 변수를 프로퍼티로 만들 수 있다. val 이나 var 키워드로 선언하면 내부에 프로퍼티를 선언하지 않아도 객체가 프로퍼티를 자동으로 가지게 된다.

***

## Default and named arguments

> Default values in primary constructors are set in the same way as in the class body. You declare the property with a keyword val or var and place the default value after the assignment operator:
>
> ```kotlin
> class Size(var width: Int = 1, var height: Int = 1) {
>     val area: Int = width * height
> }
> ```
> 
> When creating an object of a class with default values in the primary constructor, you can use the default values by omitting the arguments:
>
> ```kotlin
> val size = Size() // width == 1, height == 1
> ```
> 
> You can either provide values without property names or use named arguments when creating instances of a class:
>
> ```kotlin
> val size1 = Size(3, 5) // width == 3, height == 5
> val size2 = Size(width = 3, height = 5) // width == 3, height == 5
> val size3 = Size(height = 5, width = 3) // width == 3, height == 5
> ```
> 
> You can also omit some of the properties with default values when creating an object. Keep it in mind though, if you break the order of the arguments in the primary constructor, you should always use named arguments:
> 
> ```kotlin
> val sizeWide = Size(10) // width == 10, height == 1
> val sizeHigh = Size(height = 10) // width == 1, height == 10
> ```

- Primary Constructor 에서도 함수와 같이 Named Argument 와 Default Argument 를 사용하는게 가능하다. 

***

## Single line classes

> If there are no other class members left except the ones in the primary constructor, we can omit empty curly braces. Imagine that the area property is missing in our example:
>
> ```kotlin
> class Size(val width: Int, val height: Int)
> ```
> 
> You can see such classes frequently in real life. For example, data classes—classes whose main utility is storing data—are defined in this way. You will learn about them later on.

- Primary Constructor 에서 선언한 프로퍼티 말고 다른 프로퍼티가 없다면 클래스를 한 줄로만 만드는 것도 가능하다. 
- 주로 Data Class 에서 이런 일이 많다. 

***

## Init

> Primary constructors cannot contain any code: they only set the values of class properties based on the passed arguments. Sometimes, we want to set some of our properties based on other properties' values or other sources of information. In such cases, we would use initializer blocks, which are prefixed with the keyword init:
>
> ```kotlin
> class Size(_width: Int, _height: Int) {
>     var width: Int = 0
>     var height: Int = 0
> 
>     init {
>         width = if (_width >= 0) _width else {
>             println("Error, the width should be a non-negative value")
>             0
>         }
>         height = if (_height >= 0) _height else {
>             println("Error, the height should be a non-negative value")
>             0
>         }
>     }
> } 
> ```
> 
> The keyword init signifies a block of code that serves as an extension of the primary constructor. For example, the code below prints a message after the object properties have been set in the primary constructor:
>
> ```kotlin
> class Size(val width: Int, val height: Int) {
>     init {
>         println("Initializer block that prints the width ($width) and the height ($height)")
>     }
> }
> ```
> 
> There may be several initializer blocks in the class body. In this case, property initializers and init blocks are executed in the order of their appearance:
>
> ```kotlin
> class Size(val width: Int, val height: Int) {
>     init {
>         println("Initializer block that prints the width ($width) and the height ($height)")
>     }
> }
> ```
> 
> There may be several initializer blocks in the class body. In this case, property initializers and init blocks are executed in the order of their appearance:
>
> ```kotlin
> class Size(_width: Int, _height: Int) {
>     // 1: the width property is initialized
>     val width = _width
> 
>     // 2: 1st init block is executed
>     init {
>         println("First initializer block that prints the width $width")
>     }
> 
>     // 3: the height property is initialized
>     val height = _height
> 
>     // 4: 2nd init block is executed
>     init {
>         println("Second initializer block that prints the height $height")
>     }
> 
>     // 5: the area property is initialized
>     val area = width * height
> }
> ```
>
> In the examples above, the parameter names begin with underscores (_width, _height) to distinguish them from class members (width, height). It is a useful coding convention widely accepted in various programming languages.

- Primary Constructor 는 단순히 값을 넣어주는 역할만 한다. 코드 블락은 딱히 없다.
- 만약에 Primary Constructor 에서 받은 프로퍼티로 어떠한 로직을 통해서 다른 프로퍼티에 값을 넣어주는게 필요한 경우에는 init {} 블락을 이용하면 된다.
- init 블락은 여러개 넣을 수 있고 각 프로퍼티 값 세팅을 포함해서 순서대로 실행된다.
- 그리고 Coding Convention 으로 Primary Constructor 에서 받은 파라미터는 앞에 _ 를 붙여주자. 

