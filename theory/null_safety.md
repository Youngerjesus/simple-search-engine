# Theory: Null safety

> As you may know, there are two types of references in Kotlin: nullable and non-nullable. What you don't really know is how to use them properly and what benefits they may give you, so let's take a closer look at these types.
  
- Kotlin 에서는 Nullable 타입과 Non-nullable 타입이 있다. 이를 어떻게 사용할 수 있는지 알아보자. 

***

## Safe Calls

> Let's start with an example: there is a city object with plenty of nested objects. We want to access the name of a building from this city like this:
>
> ```kotlin
> if (city != null &&
>     city.address != null &&
>     city.address.street != null &&
>     city.address.street.building != null
> ) {
>     print(city.address.street.building.name)
> } else {
>     print(null)
> }
> ```
> 
> Looks pretty bad, doesn't it? You have to call too many if-checks in order to avoid a NullPointerException (NPE). Can we work around it? Yes! For this, Kotlin provides safe calls:
>
> ```kotlin
> print(city?.address?.street?.building?.name)
> ```
> 
> That's it! Just add a ? sign every time right after a nullable reference. ? will compare its value to null and return null if that reference is null. In other words, these two lines are equal:
>
> ```kotlin
> city?.address
> (if (city == null) null else city.address)
> ```
> 
> As you can see from the example above, it's even more convenient for chains. Here is an example of two safe calls in a row:
>
> ```kotlin
> city?.address?.street
> ((if (city == null) null else city.address)?.street)
> ```

- Safety Call 은 ? 를 통해서 사용할 수 있다. 
- 의미는 널이 아닐 경우에 해당 객체를 가지고 오도록 하며, 널일 경우에는 무시하도록 하는 것. 

***

## Elvis Operator

> Kotlin has another interesting way of handling nullable variables. Let's take a look at this snippet:
>
> ```kotlin
> var name: String? = "Kotlin"
> val length: Int? = name?.length
> print(if (length != null) length else 0)
> ```
> 
> Now we have our own length variable. As you see, it will be null in case of null in the name variable. However, we can simplify the code with the Elvis operator:
>
> ```kotlin
> var name: String? = "Kotlin"
> val length: Int? = name?.length
> print(length ?: 0)
> ```
> 
> The Elvis operator works like this: if the left-hand side of the expression is not null (name?.length), return it; otherwise, the right-hand side (0) is to return. You can also use return and throw expressions in the right part:
>
> ```kotlin
> val length: Int = name?.length
>         ?: throw Exception("The name is null")
> ```
> 
> You may ask, but why is it called Elvis? Look: there he is!
  
- Elvis Operator 는 널이 될 수 있는 객체앞에 ?: 를 통해서 사용할 수 있다.
- 의미는 널일 경우에는 ?: 의 오른쪽 값을 가져오거나 실행하도록 하고, 널이 아닌 경우는 해당 객체를 사용하도록 한다.

***

## The !! Operator

> There is an easy way to invoke an NPE: the !! operator. The code won't crash only if you're a 100% sure that your variable won't be null:
>
> ```kotlin
> var name: String? = "Kotlin"
> print(name!!.length)
> ```
> 
> The code above looks like it's screaming, trying to scare the compiler. The piece of code above is almost equal to the one below:
>
> ```kotlin
> var name: String? = "Kotlin"
> val length: Int = name?.length
>     ?: throw Exception("The name is null")
> print(length)
> ```
>
> This operator is used to stop the program when null is met.
>
> Do you remember that we read an input every time like readLine()!!? Now you understand why: the readLine() returns a nullable string. The null is returned when the user doesn't enter a line. If this happens, we don't want to continue the program, so here we ask to check the input for null using the !! operator.
  
- !! 연산자를 통해서 해당 변수가 절대 널이 아니라고 명시하는게 가능하다.
- 이렇게 했는데도 널이면 NPE 가 난다.
- readLine()!! 이렇게 주로 쓰는 경우가 많은데 이 경우에 사용자가 아무런 입력을 하지 않으면 NPE 가 될 수 있다.
 
***

## Idioms

> At first glance, safe calls and Elvis operators may seem complicated, but these functions allow you to write less code when dealing with nullable variables. It's an idiomatic way to write Kotlin code. Here we demonstrate to you some idioms from the official documentation. Almost everything you've learned in this topic is an idiom, so we briefly recall the material.
> 
> The first idiom in our list is the safe call (they use the term "if-not-null"):
>
> ```kotlin
> val nullString: String? = null
> println(nullString?.length)    // null
> val emptyString: String? = ""
> println(emptyString?.length)   // 0
> ```
> 
> The next idiom is the Elvis operator with a safe call ("if-not-null-else") :
>
> ```kotlin
> val nullString: String? = null
> println(nullString?.length ?: -1)   // -1
> val emptyString: String? = ""
> println(emptyString?.length ?: -1)  // 0
> ```
> 
> The third idiom is the ability to throw exceptions with the Elvis operator. Take the opportunity to try it in your project. Just use the following code in place of readLine()!!. If a program can't read a line, instead of an NPE you will get a more specific exception. You can test this by typing Ctrl+D in Intellij IDEA. When debugging, it's nice to know what's going on in your programs rather than pulling your hair out over NPE's.
>
> ```kotlin
> readLine() ?: error("No lines read")
> ```
> 
> The last idiom is working with nullable Boolean. This is how it works:
>
> ```kotlin
> val b: Boolean? = ...
> if (b == true) {
>       ...
> } else {
>       // `b` is false or null
> }
> ```

- 사용하는 방법들에 대해서
- 첫 번째는 safety call 을 이용하는 것.
- 두 번째는 safety call 과 elvis Operator 를 이용하는 것
- 세 번째는 !! 과 elvis operator 를 이용해서 NPE 인 경우네는 구체적인 Exception 을 던저주도록 하는 것 (NPE 보다 이게 더 낫다.)
- 네 번째는 java 처럼 진짜 Null Check 를 하는 것. 