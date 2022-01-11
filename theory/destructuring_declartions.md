# Theory: Destructuring declarations

> Sometimes it is convenient to destructure an object into a number of variables. For example, to better manipulate it, or to make a piece of code more concise. In this topic, we'll see how this can be done.

- 때로는 객체를 여러가지 벼수들로 분해하는게 더 나을 수 있다. 그거에 대해서 알아보는 시간.
  - 더 조작하기 쉬워서 그렇다는듯.

***

## Basic destructuring

> Suppose you have a User data class that stores user information. It has fields such as String name, Int age, and Boolean isAdmin.
>
> ```kotlin
> data class User(val name: String, val age: Int, val isAdmin: Boolean)
>
> val anonim = User("Anonim", 999, false)
> ```
> 
> Well, that's all that we need! Now we can separate all variables from the class and work with them as separate objects:
>
> ```kotlin
> val (userName, userAge, isAdmin) = anonim
> println(userName)  // prints Anonim
> println(userAge)   // prints 999
> println(isAdmin)   // prints false
> ```

- 데이터 클래스의 경우에 destructuring 을 사용할 수 있다.

***

## Destructuring without data classes

> Destructuring can be used without data classes as well. We simply need to define a componentN operator manually. Operators are similar to functions but use special symbols that carry out operations on operands/values. For example, + is an operator that performs addition. That's it! Just think of it as a function. Now let's try to override some operators for destructuring:
>
> ````kotlin
> class User(val name: String, val age: Int, val isAdmin: Boolean){
>     operator fun component1(): String = name
>     operator fun component2(): Int = age
>     operator fun component3(): Boolean = isAdmin
> }
> 
> // now we can use default destructuring syntax
> fun checkIsAdmin(suspiciousUser: User) {
> // destructuring
> val (name, age, isAdmin) = suspiciousUser
> 
>     if (isAdmin)
>         println("Have a nice day!")
>     else
>         println("Sorry, you should not be here.")
> }
> ````
> 
> componentN functions work by relying on the position of each class variable. That is a problem because a class is not meant to be positional, so it is very easy to make a mistake here.
>
> Note that we can't override componentN operator in data classes because Kotlin does it for us:
>
> ````kotlin
> // Error: Conflicting overloads: public final operator fun component1(): String defined in StoreClass
> data class StoreClass(val info: String) {
>   operator fun component1() = info
> }
> ````

- data class 가 아닌데 Destructuring 을 사용하고 싶다면 operator keyword 와 componentN() 키워드를 사용하면 된다.
  - componentN operator 에서는 분해해서 주고싶은 필드를 주면 된다.
- data class 는 operator + componentN 을 사용할 수 없다. 충돌이 되기 떄문에.

***

## Destructuring with lists and loops

> Destructuring declarations also work with lists and loops because List is a class with the implemented componentN operator. Now, let's extract the first 3 elements:
>
> ```kotlin
> fun processList(customerInfo: MutableList<String>) {
>     if (customerInfo.size < 3) return
>     val (firstName, lastName, city) = customerInfo
>     showCustomerName(firstName, lastName)
>     findPopularSellersInCity(city)
> }
> ```
>  
> If the list has more than 3 elements, they will not be processed and the program will continue its work. In the same way, if the list has less than 3 elements, there will be an error and the program will crash. To avoid that, we add an if-check.
> 
> Note that we can get the first N elements from a list or class with more than N components. This might be useful in some tasks.
>
> Destructuring in for-loops also involves a componentN operator. Now, let's send to the analysts in our company all the data on non-admin users:
>
> ```kotlin
> fun processAnalytics(usersData: MutableList<User>) {
>     for ((name, age, isAdmin) in usersData) {
>         if (!isAdmin)
>             sendAnalyticsToCompany(name, age)
>     }
> }
> ```
>
> This way each element in MutebleList<User> will be destructured.

- list 의 경우도 분해해서 한번에 꺼내는게 가능하다.
- for loop 의 경우도 분해해서 꺼내는것ㄷ 가능하다.

***

## Underscoring for variables

> When we start using destructuring declarations, the Kotlin compiler may warn us about unused variables in the destructuring declaration. The default IDE solution is to rename unused variables as "_" (underscore), though it has some drawbacks. For example, let's try to copy-paste some code from somewhere else:
>
> ```kotlin
> val usersData = mutableListOf<User>()
> for ((_, _, isAdmin) in usersData) {
>    // /~
> }
> ```
> 
> Looks familiar, doesn't it? In the example above, the componentN operator skipped name and age properties, so they cannot be used in the cycle.
>
> Another useful feature is the trailing comma. You can add a comma at the end of the parameter list and it will work. It's really convenient because you can copy and paste an additional argument without adding commas.
>
> ````kotlin
> val usersData = mutableListOf<User>()
> for ((name, age, ) in usersData) {
> // /~
> }
> ````

- 분해해서 안쓰는 변수의 경우에는 ',' 를 이용해서 생략해놓자.

