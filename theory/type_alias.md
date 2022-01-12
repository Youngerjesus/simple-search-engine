# Theory: Type aliases

> In previous topics, we discussed generic classes. We have mentioned that generics can accept any type of parameter and make it possible to reuse some code. But sometimes, the names of generics may get excessively long, which makes it harder to read the code.
>
> In such situations, type aliases may help us improve code readability. Let's take a look at what they are and how they work.

- Generic 의 경우에 타입 파리머트를 받다보면 이름이 지나치게 길어질 수 있다. 
- 이를 도와주기 위해서 type alias 를 지원한다. 
  - 이걸로 인해서 코드를 읽기 쉬워질 것이다.

***

## Usage of type aliases

> Type aliases provide alternative names for existing types – both standard types and custom ones. If the type name is too long, it's a good idea to introduce a different shorter name and use the new one instead.
>
> ```kotlin
> class ClassWithVeryLongName{}
> typealias SomeClass = ClassWithVeryLongName
> ```
> 
> Also, type aliases can be used if you want to emphasize the type, for example:
>
> ```kotlin
> typealias Password = String
> val myPassword: Password = "hyperskill"
> ```
> 
> Here we point out that "hyperskill" is a specific kind of string (a password), not just a common String.
>
> Remember that type aliases should be top level! You cannot place them inside classes.
>
> ```kotlin
> class Pet {
>     typealias Kitten = Pet.Kitten
>     class Kitten {
>         // compile error: nested and local type aliases are not supported
>     }
> }
> ```
> 
> An alternative to type aliases are import aliases. If you're working with a long class name (especially, if you have package names within the class name), you can use import aliases to shorten it:
> 
> ```kotlin
> import Pet.Kitten as Kitten
> ```

- typealias 를 통해서 대안적인 이름을 제공해줄 수 있다.
  - typealias 는 클래스 내부에서 사용할 수 없다. top-level 에서만 사용하는게 가능하다.
- typealias 말고도 import alias 를 통해서도 대안 이름을 제공하는게 가능하다.

***

## The principle of usage

> You should remember that type aliases don't introduce new types. They are equivalent to the corresponding original types.
>
> With type aliases, you can still use the fields and methods of the original type. For example:
>
> ```kotlin
> typealias Kitten = Pet.Kitten
> class Pet {
>     class Kitten(name: String) {
>         var kittenName = name
>         fun getName(): String {
>             return kittenName
>         }
>     }
> }
> 
> fun main() {
>     var kitten: Kitten = Kitten("Fluffy")
>     println(kitten.getName()) //Fluffy
>     println(kitten.getName().length) // 6
> }
> ```
> 
> You don't need to be worried that using type aliases can lead to some errors during runtime: compile time checks take care of that.
>
> ```kotlin
> var kitten: Kitten = Kitten(6)/* compile-time error: The integer literal does not conform to the 
 >                                 expected type String */
> ```
> 
> Thus, you will be warned that the type of the passed argument (Integer) doesn't match the expected type (String).
>
> Also, you should always make sure that you really need type aliases and that they will really make your code more understandable.

- typealias 의 사용 예중 하나가 innerclass 의 참조가 너무 이름이 길어서 사용할 수 있다.

***

## Usage with generics

> You can provide type aliases for generic classes as well as non-generic ones. And of course, you can use the original type fields and methods without any restrictions.
>
> In generic programming, type aliases can be useful in shortening long generic types. For example:
>
> ```kotlin
> typealias DessertBox<T> = BoxForSomeDessert<T>
> 
> class BoxForSomeDessert<T>(var dessert: T) {
>     fun getDessertFromBox(): T {
>         return dessert
>     }
> }
> 
> class Tart(var name: String) {}
> 
> fun main() {
>     var tartBox = DessertBox(Tart("tastytart"))
>     println(tartBox.getDessertFromBox().name) // tastytart
> }
> ```
> 
> When you declare a type alias for a generic type, don't forget to add <T> after the type alias name!

- typealias 는 non-generic 뿐 generic 에서도 사용이 가능하다.

***

## Naming type aliases

> Try to define readable and meaningful type aliases so that other programmers can understand your code. Let's take a look at two examples: a bad one and a good one:
>
> ```kotlin
> /*bad example*/
> typealias SomeClass = HashMap<Int, List<String>>
>
> /*good example*/
> typealias FileTable = MutableMap<Int, MutableList<File>>
> ```
> 
> In the first example, we can't really understand the use of SomeClass and the type name is too vague. The second case is much better because we see that FileTable is a synonym of a class that defines a list of some files.

- typealias 를 사용할 땐 의미있는 이름을 주자. 
- 여러 컬렉션을 겹쳐서 사용하는 경우 이 타입이 어떤 의미인지 설명해주는 용도로 typealias 를 사용하는게 좋다.

