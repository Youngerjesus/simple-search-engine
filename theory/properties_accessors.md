# Theory: Properties accessors

> As you already know, each class in Kotlin has zero or more properties. You will be using properties in almost all of your classes. In this topic, we will take a closer look at how to work with properties such as changing them and getting their values

***

## Property getter

> Suppose you have a simple class Client with one property name:
>
> ````kotlin
> class Client {
>     val name = "Unknown"
> }
> 
> val client = Client()
> ````
>
> You already know how to retrieve a property name: just type in the dot and the property name after the object name:
>
> ````kotlin
> client.name
> ````
> 
> This looks very simple, but in fact, when you want to get the value of some property, you call a special get() function called getter. This is what it actually looks like:
>
> ````kotlin
> class Client {
>     val name = "Unknown"
>         get() {
>             return field
>         }
> }
> 
> // or with omitted curly brackets and the body of the get() function
> 
> class Client {
>     val name = "Unknown"
>         get() = field
> }
> ````
> 
> This function takes nothing (you only ask a value, nothing more) and returns one value. When you try to retrieve a value, you will get the result of the get() function. So, what is field? Every property in Kotlin has its own backing field, which contains a property value that can be accessed with the special keyword field.
>
> In this case, your getter just returns the value of the name variable. This is the expected behavior, so Kotlin generates this function for us, and you don't need to write it. If you want to change the logic of the getter, you should write your own get() function.

- kotlin 클래스에서 property 를 만들면 자동으로 get() = field 메소드를 만들어준다. 이를 통해서 property 에 접근이 가능하다.
- return field 에서 field 는 properrt 를 나타내는 값이다.

***

## Custom getter

> Let's print the customer's name every time we access name:
>
> ```kotlin
> class Client {
>     val name = "Unknown"
>         get() {
>             println("Somebody wants to know $field name")
>             return field
>         }
> }
> 
> val client = Client()
> 
> val name = client.name // prints Somebody wants to know Unknown name
> println(name)          // prints Unknown
> ```
> 
> Another use for a custom getter is if you want to return something else. For example, your task could be to store complete customer information in a variable. If you change some information about one person, you will have to change this variable as well. If you are using a custom getter, you can generate information on-demand. In the example below, the Client class gets an age property that stores the age of the client, and info property that returns the information about them:
>
> ```kotlin
> class Client {
>     var name: String = "Unknown"
>     var age: Int = 18
>     val info: String
>         get() {
>             return "name = $name, age = $age"
>         }
> }
> 
> val client = Client()
> println(client.info) // name = Unknown, age = 18
> client.name = "Lester"
> client.age = 20
> println(client.info) // name = Lester, age = 20
> ```

- property 에 접근할 때 값을 커스텀하게 이용하고 싶다면 get() 을 재정의하면 된다.
- 여기서 get() 을 재정의 할 때 초기화 값이 없는 property 만 가능하다.

***

## Property setter

> Now you know that you can customize the process of getting the property value. It is also possible to modify the process of changing the property value! Let's take a look at a simple example:
>
> ```kotlin
> class Client {
>     var name = "Unknown" // default value
> }
> 
> val client = Client()
> client.name = "Ann"      // name property now stores "Ann"
> ```
> 
> When you want to set the value of some property, you should call a special set() function called setter. This is what it looks like:
>
> ```kotlin
> class Client {
>     var name = "Unknown"
>         set(value) {
>             field = value
>         }
> }
> ```
> 
> This function takes one argument (it is named value by convention, but you can use a different name) and returns nothing. As you know, field contains the current value of the property and you can change it by reassigning a different value.
>
> In this case, your setter will simply change the value of the name variable to the received value. This is the expected behavior and Kotlin generates this function for us, you don't need to write the setter yourself.

- property 의 값을 바꾸려면 그냥 대입하면 되는데 이는 내부적으로 setter 가 만들어져있어서 그렇다.

***

## Custom setter

> The set() function is a powerful instrument and it's possible to customize the logic of a setter. For example, let's print the customer's name every time we change the name property:
>
> ```kotlin
> class Client {
>     var name = "Unknown"
>         set(value) {
>             println("The name is changing. Old value is $field. New value is $value.")
>             field = value
>         }
> }
> 
> val client = Client()
> client.name = "Ann"   // The name is changing. Old value is Unknown. New value is Ann.
> ```
> 
> As you could notice, the setter is only called when you're trying to change the property, not when initializing it.
>
> Another way to use a custom setter is if you wanted to assign a different value. Let's add an age property that stores the age of the client. Of course, age cannot be negative. If you want to take it into account, you can add a custom setter:
> 
> ```kotlin
> class Client {
>     var name = "Unknown"
>     var age = 18
>         set(value) {                      
>             field = if (value < 0) {
>                 println("Age cannot be negative. Set to $defaultAge")
>                 defaultAge
>             } else
>                 value
>         }
>     val defaultAge = 18
> }
> 
> val client = Client()
> client.age = -1      // Age cannot be negative. Set to 18.
> println(client.age)  // 18
> ```

- setter 도 커스텀화 하는게 가능하다. 
  - 값을 변경하려고 호출될 때 다른 작업을 하도록 하던지
  - 복잡한 setter 를 만들던지.
  - 값을 초기화 할 때는 setter 가 호출되지는 않는다.

***

## Additional features

> You may implement both a setter and a getter for your property:
>
> ```kotlin
> class Client {
>     var name = "Unknown"
>         get() {
>             println("Somebody wants to know $field name")
>             return field
>         }
>         set(value) {
>             println("The name is changing. Old value is $field. New value is $value.")
>             field = value
>         }
> }
> ```
>
> If you want to add a getter and/or a setter to a property in a constructor, just "move" the property out. Remember that in this case, you need to use another variable, not the property from the constructor:
>
> ```kotlin
> class Client(name: String, age: Int) {
>     var fullName: String = name
>         set(value) {
>             println("The name is changing. Old value is $field. New value is $value.")
>             field = value
>         }
>     var age: Int = age   // this is a new property, not a property from the constructor
>         set(value) {
>             println("The age is changing. Old value is $field. New value is $value.")
>             field = value
>         }
> }
> ```
> 
> Keep in mind that when initializing your property, the setter will not be called. This is also true for constructors since they initialize properties. Let's take a closer look:
>
> ```kotlin
> class Client(name: String) {
>     var name: String = name
>         set(value) {
>             println("The name is changing. Old value is $field. New value is $value.")
>             field = value
>         }
> }
> 
> val client = Client("Annie")  // without output
> client.name = "Ann"           // The name is changing. Old value is Annie. New value is Ann.
> ```
> 
> You cannot use a setter for val variables: the set() function reassigns the variable, which is not possible for val. Of course, you can change the internal state of the val property another way, for example, with its own setters.
>
> ```kotlin
> class Passport(number: String) {
>     var number = number
>     set(value) {
>         println("Passport number has changed.")
>         field = value
>     }
> }
> 
> class Client {
> val passport = Passport("1234567")
> }
> 
> val client = Client()
> println(client.passport.number)       // 1234567
> /*
> client.passport = Passport("2345678") // This will not work.
> */
> client.passport.number = "2345678"    // This will change the passport number
> // prints Passport number has changed
> println(client.passport.number)       // 2345678
> ```

- 생성자에 있는 property 에 getter/setter 를 커스텀화 하고싶다면 이를 밖으로 빼내야한다. 그래야 추가할 수 있다.
  - 다른 변수를 선언하고 생성자에 있는 Property 를 이용하는 식으로 하면 됨.
- setter 의 작업은 초기화 할 때는 호출되지 않음.