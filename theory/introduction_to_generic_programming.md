# Theory: Introduction to generic programming

> Sometimes methods and classes that we use do not depend on the data on which they operate. For example, arrays can store values of different types: String, Int, Char, etc. However, the algorithm of finding an element in an array doesn't depend on the type of values the array stores.
> 
> For these cases, Kotlin supports generic programming. Generics represent parameterized types. Generic methods and classes can handle different types in the same general way. The type should be determined when you create an instance of the class or invoke a method. Generic programming allows writing more abstract and reusable code. Let's take a closer look at Generics!

***

## Generic classes

> A generic class represents a class that is parameterized over types. To declare such a class, we should specify the type parameter in angle brackets after the class name. Let's take a look at the example below.
>
> Here you can see a class with a single type parameter named T. T represents "some type", and the declaration of our class doesn't depend on this type.
>
> ````kotlin
> class Box<T>(t: T) {
> 
>     /*Constructor accepts
>     * a variable of "some type"
>     * and sets it to a field*/
> 
>     var value = t  // A field of "some type"
> 
>     fun changeObjectInBox(t: T): T {
>         value = t
>         return value
>     }
> 
>     /* Returns the value of the field of "some type"*/
>     fun showObjectInBox(): T {
>         return value
>     }
> }
> ````
> 
> After the class has been declared, the type parameter can be used as an ordinary type inside the class body. In the example above, the type parameter T is used as:
> 
> - a type for a field;
> - a constructor argument type;
> - an instance method argument and a return type.

- Generic 을 쓰는 클래스 만들기.
- 제네릭은 생성자 아규먼트로, 메소드 아규먼트와 리턴타입으로, 필드로 쓰인다.

***

## Generic and several type parameters

> In many situations, it is much more convenient to have several parameters in a class, which can be of arbitrary type. Kotlin allows us to define not only one parameter of arbitrary type but also two, three, etc. In this case, you can specify several type parameters, separating them with a comma:
>
> ```kotlin
> class Three<T, U, V>(var first: T, var second: U, var third: V)
> ```
> 
> Let's see where this skill can be useful.
>
> We can create a class Pair that will store two parameters first and second of arbitrary type and methods which allow to process of these values separately or together.
>
> ````kotlin
> class Pair<T, P>(var first: T, var second: P) {
>     fun changeFirst(newValue: T) {
>         first = newValue
>     }
> 
>     fun changeSecond(newValue: P) {
>         second = newValue
>     }
> 
>     fun printData() {
>         println("Value:")
>         println("first = $first")
>         println("second = $second")
>     }
> } 
> ````
> 
> The example of how we can work with this class:
>
> ````kotlin
> val nameLastname: Pair<String, String> = Pair("Johh", "Smit")
> val nameAge: Pair<String, Int> = Pair("Kite", 18)
> 
> nameLastname.changeFirst("John")
> nameLastname.changeSecond("Smith")
> 
> nameAge.changeFirst("Kate")
> nameAge.changeSecond(19)
> 
> nameLastname.printData()
> nameAge.printData()
> ````
> 
> The result:
>
> ````kotlin
> Value:
> first = John
> second = Smith
> Value:
> first = Kate
> second = 19
> ````

***

## Naming convention for type parameters

> The type parameter is named with a single letter according to the convention in order to distinguish it from an ordinary class name.
>
> The most commonly used type parameter names are:
>
> - `T` – Type;
> - `S`, `U`, `V` etc. – 2nd, 3rd, 4th types;
> - `E` - Element (often used by different collections);
> - `K` - Key
> - `V` - Value
> - `N` - Number

***

## Creating objects of generic classes

> When we create an instance of a generic class, we need to provide a concrete type as a type argument:
>
> ````kotlin
> val obj1: Box<Int> = Box<Int>(123)
> val obj2: Box<String> = Box<String>("abc")
> ````
> 
> But if the type is a standard one like Int, String, Double, etc., you can omit the type argument, as the compiler infers it:
>
> ````kotlin
> val obj1 = Box(123)
> val obj2 = Box("abc")
> ````
> 
> After we have created an object of the generic class and specified the type argument, we can invoke methods of the class:
>
> ````kotlin
> println(obj1.showObjectInBox()) // 123
> println(obj2.showObjectInBox()) // "abc"
> ````
> 
> If the class has more than one type parameter, we should specify all of them:
>
> ````kotlin
> val obj = Three<String, Int, Int>("abc", 1, 2)
> ````

***

## Creating your own collection

> Let's create a generic class called RandomCollection. It stores a list of items of some type, a constructor to set the items, and a method to get an element of the list by its index. The collection we are creating is immutable.
> 
> ````kotlin
> class RandomCollection<T>(val items: List<T>) {
>     fun get(index: Int): T {
>         return items[index]
>     }
> 
>     fun length(): Int {
>         return items.size
>     }
> }
> ````
> 
> This class has two methods: get(index:Int), which has T as a return type, and length(), which doesn't use the parameter type.
>
> The following code creates an instance of RandomCollection for storing three strings in it.
>
> ````kotlin
> var nums = RandomCollection(listOf(1, 2, 3, 4))
> for (i in 0 until nums.length()) {
>     print("${nums.get(i)} ") // "1 2 3 4 "
> }
> ````
> 
> You can parametrize RandomCollection with any standard type, standard classes, and your own classes.

