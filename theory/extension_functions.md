# Theory: Extension functions

> Often a developer doesn't write everything from scratch but uses an already written code. It saves them some time. However, there are some downsides such as the inability to edit the used code, especially when the code comes from another developer. Let's look how to optimize your work!

- 개발자들은 모든 코드를 다 스스로 짜지는 않는다. 시간이 많이 걸려서.
- 하지만 이 경우의 단점으로는 다른 사람이 쓴 코드를 편집할 수 없다는 문제가 있다. 
  - 어떤 기능이 잘못되었거나, 
  - 기능 추가가 필요한 경우. 

***

## Problem with existing classes

> To work with classes that you can't modify, you can write a function that takes an object of that class as an argument:
>
> ```kotlin
> fun repeated(string: String): String = string + string
> 
> repeated("ha")  // returns "haha"
> ```
> 
> Do you see an issue here? In Kotlin, standard operations are available as member functions. For example, to get the first symbol of the "ha" string, you can write "ha".first(). It's more convenient to use a single syntax for all operations. So how can we add a member function to the uneditable String class?

- 코드를 수정할 수 없는 클래스를 작업할 때는 그 클래스에 function 을 넣어서 작업할 수 없고 아예 새로운 function 을 만들어서 작업해야한다.
- 그치만 코틀린에서는 extension function 을 통해서 위 작업을 "haha".repeated() 이런식으로 만들어 줄 수 있다.

***

## Defining and calling extension functions

> Kotlin has just the right syntactic sugar for it: extension functions. Let's rewrite the repeated function as an extension one
> 
> ```kotlin
> fun main() {
>     val ha = "ha"
> 
>     println(ha.repeated())
> }
> 
> private fun String.repeated(): String = this + this
> ```
> 
> Now to get the "haha" we can write
>
> ````kotlin
> "ha".repeated()
> ````
> 
> As you can see, the syntax to define an extension function is like defining a simple function. Just write the name of a class that you would like to extend and add a dot before the function name. The class to be extended is called a receiver type.
>
> You can get access to the field of an object in the extension function almost as easily, as in the member function. That object is called a receiver object.
>
> ````kotlin
> class Client(val name: String, val age: Int)
> 
> fun Client.getInfo() = "$name $age" // Client is the receiver type
> 
> 
> val client = Client("John", 32)
> print(client.getInfo()) // client is the receiver object
> ````
> 
> Note, if the developer hides some information (you will know how to do it later) and your code cannot get it, the extension function can't have access too. So, it works more like a simple function, not a member function
>
> Note, that just like other functions, extension functions can take arguments and return a value of any type including the same type as the receiver type.
> 
> So the issue is solved: Kotlin developers can add any functions to any classes they want.
>
> We also need to mention that extension functions are used even in Kotlin standard library. For example, if you look at the String class definition, you will see only necessary member functions. Other functions such as .first() and .toUpperCase() are actually extension functions needed just to simplify the code of the class.

- Extension function 을 통해 다른 개발자가 만든 클래스에 엑세스해서 기능을 쉽게 추가할 수 있다.
  - 그 중에서는 Standard Library 도 포함한다.
- 주의할 건 Extension function Member function 만큼의 엑세스 권한을 얻을 수 없다는 점이다.

***

## Extension function vs member function

> Let's assume we have the following class:
>
> ````kotlin
> class A {
>     fun member() = println("hi from member")
> }
> 
> fun A.extension() = println("hi from extension")
> ````
> 
> Both functions can be called in the same way: A().member() and A().extension(). So we actually can't be sure if it's a member or an extension function just by looking at its calling line. We need to check the implementation.
>
> And what if a developer tries to add an already existing function to a class? The answer is a bit complex here because there can be several different cases.
>
> If we try to define another fun A.extension(), the code won't compile. You cannot define two functions with the same signature, as always.
>
> If we add fun A.member() = println("bye from not member"), the code will compile but calling A().member() will give us "hi from member".
>
> So member functions always win. It helps when somebody wants to change the object behavior intentionally or unintentionally.
>
> If you want to give an extension function the name that already exists, you must change the signature of the function, for example, change its arguments. It won't break the already existing code.

- Extension function 은 같은 signature 를 가지는 함수의 경우에는 컴파일 에러가 난다.
- Extension function 과 Member function 이 같이 존재한다면 member function 이 적용된다.

***

## Idiom

> The extension function is an idiomatic way to add some functionality to an existing class. It is simple to use and shows that your new function is closely related to the class. So use it, with community approval! This idiom is documented on kotlinlang.org.
>
> ````kotlin
> fun String.spaceToCamelCase() { ... }
> 
> "Convert this to camelcase".spaceToCamelCase()
> ````