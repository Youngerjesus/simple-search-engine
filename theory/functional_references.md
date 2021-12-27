# Theory: Function references

> As you know, lambda expressions allow you to use code as data and pass it as a function's arguments. Another way to do it is to use function references. They are often even more readable than corresponding lambda expressions. Besides, function references force developers to decompose a program into a set of short functions with clear areas of responsibility.

- functional reference 의 목적은 readability 를 올릴 수 있다는 점.
- 그리고 프로그램을 여러 함수들의 조합으로 생각할 수 있도록 해준다는 점이 있다.

***

## Make code clearer with function references

> A quick reminder: a function reference is a special link that refers to a certain function by its name and can be called at any time whenever we need it. Let’s look at an example of how we can do that:
>
> ```kotlin
> fun isOdd(x: Int) = x % 2 != 0
> 
> fun isEven(x: Int) = x % 2 == 0
> 
> fun printNumbers(numbers: MutableList<Int>, filter: (Int) -> Boolean) {
>   for (number in numbers) {
>       if (filter(number))
>           print("$number ")
>   }
> }
> 
> fun main() {
>   val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
>   val oddFunction = ::isOdd
>   print("Odd numbers: ")
>   printNumbers(numbers, oddFunction)
>   print("\nEven numbers: ")
>   printNumbers(numbers, ::isEven)
> }
> ```
> 
> As you can see, we can call functions isOdd() and isEven() either directly or by passing their value using `::`
> 
> The result of the program will be:
> 
> ```
> Odd numbers: 1 3 5 7 9 
> Even numbers: 2 4 6 8 10
> ```

- Functional Reference 는 존재하는 특정 함수를 참조하는 링크와 같은 것. 
- 사용할 땐 '::' 키워드와 함수 이름을 붙여서 사용하면 된다.

***

## Reference by class

> Also, you can reference functions which belong to a class. The base syntax in such cases looks like this:
>
> ```kotlin
> objectOrClass::functionName
> ```
> 
> Here, objectOrClass can be a class name or a particular instance of a class.
>
> Let's take a look at an example with the class Person:
>
> ```kotlin
> class Person(val name: String, val lastname: String) {
> 
>     fun printFullName(): String {
>         return("full name: $name $lastname")
>     }
> }
> ```
>
> Here, we create a function reference:
>
> ```kotlin
> val person: Person = Person("Sara", "Rogers")
> val personFun: () -> String = person::printFullName
> ```
> 
> And now, we call the function by using a special function invoke:
>
> ```kotlin
> print(personFun.invoke())
> ```
> 
> Actually, you can also call the function without the function invoke:
>
> ````kotlin
> print(personFun())
> ````
> 
> And here is the result:
>
> ````kotlin
> full name: Sara Rogers
> ````
> Now you see how you can easily turn a functions into an object by using a reference to it. This is a very useful skill in programming, and when you start working on serious projects, it will help you with many problems.
> 
> Let's see some other possibilities of function references.

- Functional reference 를 이용할 때 className::FunctionName 이런식으로도 사용이 가능하다.
- 인스턴스 메소드의 경우에는 인스턴스를 만든 후 변수이름::FunctionName 으로 사용이 가능하고 싱글톤의 경우에는 className::FunctionName 으로 바로 사용이 가능
- 참조하고 사용할려면 invoke() 메소드를 호출하거나 functionalReferenceName() 이런식으로 사용이 가능하다.

***

## Standard classes and function reference

> Function references also work with functions from Kotlin standard classes. Let's see an example.
>
> We create a reference to the standard function dec of the Int class. The function dec decreases the number by one (decrement).
>
> ```kotlin
> val dec: (Int) -> Int = Int::dec
> ```
> 
> Here, Int::dec is a reference to a function.
>
> This code works because the definition of the function operator fun dec(): Int fits the type (Int) -> Int: they both mean taking one integer argument and returning an integer value.
>
> Now we have the dec object that can be used as a function. Let's invoke it!
>
> ```kotlin
> print(dec(4)) // 3
> ```
> 
> So, once assigned to an object, a function reference works in the same way as a lambda expression.
>
> Here is an alternative way to create the same object using a lambda expression:
>
> ```kotlin
> val dec: (Int) -> Int = {x -> x.dec()}
> ```
> 
> It is recommended to use function references rather than lambda expressions if you just need to invoke a standard function without other operations. Your code will be shorter, more readable, and easier to test.
>
> Note that we can refer to both standard and our custom functions using function references.

- Standard class 에 있는 함수들도 functional reference 를 사용하는게 가능. 물론 람다식으로도 사용이 가능하지만 람다식 보다는 functional reference 가 더 나은듯.

***

## Kinds of function references

> In general, there are four kinds of function references:
>
> reference to a function;
> reference by Class;
> reference by Object;
> reference to a constructor
> 
> #### 1. Reference to a function
>
> This reference has the following declaration:
>
> ```
> ::functionName
> ```
> 
> Let's see an example of using a reference to functions multiply and add:
>
> ````kotlin
> fun multiply(x: Int, y: Int) = x * y
> 
> fun add(x: Int, y: Int) = x + y
> 
> fun main() {
>     val operatorMultiply: (Int, Int) -> Int = ::multiply
>     val operatorAdd: (Int, Int) -> Int = ::add
> }
> ````
> 
> Now we can invoke both functions operatorMultiply and oparetorAdd for double values and see the result:
>
> ````kotlin
> operatorMultiply(10, 5) // 50
> operatorAdd(5, 4) // 9
> ````
> 
> The operatorMultiply and oparetorAdd functions can be also written using the following lambda expression:
>
> ````kotlin
> val operatorMultiply: (Int, Int) -> Int = {x: Int, y: Int -> x * y}
> val operatorAdd: (Int, Int) -> Int = {x: Int, y: Int -> x + y}
> ````
> 
> #### 2. Reference by Class
>
> The general form is the following:
>
> ````kotlin
> ClassName::functionName
> ````
> 
> Let's take a look at a reference to the function and of the class Int, which allow us to do logical AND with two numbers:
>
> ````kotlin
> val and: (Int, Int) -> Int = Int::and
> ````
> 
> Now we can invoke the and function for double values:
>
> ```
> and(1, 3) // the result is 1
> ```
> 
> The and function can be also written using the following lambda expression:
>
> ```
> val and: (Int, Int) -> Int = {a: Int, b: Int -> a.and(b)}
> ```
> 
> #### 3. Reference by Object
>
> The general form looks like this:
>
> ```
> objectName::functionName
> ```
> 
> Let's check out an example of a reference to the indexOf function from a particular string; the function finds the index of the first occurrence of an element in the text. This function takes a string to find, an index from which we start the search, and a Boolean that determines whether the case will be ignored when matching a character (by default it is false).
>
> ````kotlin
> val whatsGoingOnText: String = "What's going on here?"
> val indexWithinWhatsGoingOnText: (String, Int, Boolean) -> Int = whatsGoingOnText::indexOf
> ````
> 
> Here is the result of applying it to different arguments:
>
> ````kotlin
> println(indexWithinWhatsGoingOnText("going", 0, true)) // 7
> println(indexWithinWhatsGoingOnText("Hi", 0, true))  // -1
> println(indexWithinWhatsGoingOnText("what's", 0, false))  // -1
> println(indexWithinWhatsGoingOnText("what's", 0, true))  // 0
> ````
> 
> As you can see, we actually always work with the whatsGoingOnText object captured from the context.
>
> The following example of a lambda expression is a full equivalent of the above reference and can help you better understanding the situation:
>
> ````kotlin
> val indexWithinWhatsGoingOnText: (String, Int, Boolean) -> Int =
>         { string: String, startIndex: Int, ignoreCase: Boolean ->
>             whatsGoingOnText.indexOf(string, startIndex, ignoreCase)
>         }
> ````
> 
> #### 4. Reference to a constructor
>
> This reference has the following declaration:
>
> ```
> ::ClassName
> ```
> 
> For example, let's consider our custom class Person with a single field name.
>
> ````kotlin
> class Person (val name: String){
> }
> ````
> 
> Here is a reference to the constructor of this class:
>
> ````kotlin
> val personGenerator: (String) -> Person = ::Person
> ````
> 
> This function produces new Person objects based on their names.
>
> ````kotlin
> val johnFoster:Person = personGenerator("John Foster")
> ````
> 
> Here is the corresponding lambda expression that does the same:
>
> ````kotlin
> val personGenerator: (String) -> Person = {string -> Person(string)}
> ````
> 
> Further, we will use lambda expressions and function references together.

- Functional Reference 를 사용하는 방법은 다음과 같이 크게 4가지. 
- 그냥 함수 참조, Standard class 에 있는 함수 참조, Instance 의 함수 참조, 생성자 참조 이렇게