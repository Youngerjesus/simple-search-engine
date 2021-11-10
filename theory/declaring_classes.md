# Theory: Declaring classes

***

## Declaring new classes

> In order to declare a new class, you need to write the class keyword and the class name after it. First, let's declare a class named Emptiness:
>
> ````kotlin
> class Emptiness {
>     // empty body
> }
> ````
> 
> In Kotlin, when a class has an empty body, curly braces can be omitted. So the same class can be defined in the following way:
> 
> You can declare classes in .kt files. Usually, it's better to declare them at the top level of a file but you can declare them in other places, inside the function, as well.

- 클래스 선언은 'class' 키워드와 클래스 이름이 붙는 구조.
- 클래스 내부가 비어있다면 {} 를 생략해도 괜찮다.
- 클래스 선언은 kotlin 파일에서 제일 위에 하는게 좋다. (코딩 컨벤션인듯.)

***

## Object creation

> What's the purpose of declaring a class? Well, shortly speaking, each defined class introduces a new type. So you can create objects of a class and store them as variables and values. Sometimes standard types are not enough, so this comes in handy. There will be a few examples later on to make it clear.
> 
> To create an instance of a class, simply write the class name and empty parentheses. In other words, the syntax is similar to calling a function. For example, let's do that for the Emptiness class:
>
> ```kotlin
> val empty: Emptiness = Emptiness()
> ```
> 
> We have just assigned a new object of the Emptiness class to the empty variable. This variable has the Emptiness type so you can't reassign an object of any other type to it. As a general rule in Kotlin the explicit type directive can be omitted:
>
> val empty = Emptiness()

- 객체 생성의 방법에 대해 알려줌.

***

## Class member

> A class body can include class members. For now, we will discuss only properties that replace fields in Kotlin: they can store data, too. We will discuss other advantages of properties and other class members in further topics.

- 클래스에는 클래스 바디에 member 를 넣고 거기에 데이터를 넣을 수 있다. (property)

***

## Writing properties

> Properties are pretty similar to variables and values. If you want to assign a value to a property during runtime, you declare it as a var, otherwise, a val is your choice.
>
> Also, any property has a strict type. It can be a standard type, like a number or a string, or a custom type. So a property type can be your own class and even the same class where the property is declared.
>
> A property that just stores data must somehow receive an initial value. For example, you can set the property in the class body.
>
> A class can have as many properties as you need.
>
> Now let's declare a class for representing a patient in a hospital information system:
>
> ```kotlin
> class Patient {
>     var name: String = "Unknown"
>     var age: Int = 0
>     var height: Double = 0.0
> }
> ```
> 
> Here we see that the Patient class has three properties that you can reassign: name, age, and height.
>
> Each object of the class has the same set of fields, but the values of the fields can differ from object to object.

- 클래스의 property 로 런타임에 값을 할당할 것이라면 var, 그렇지 않고 초기값만 가지고 세팅할것이라면 val 키워드를 사용하면 된다.
- property 로는 다양한 타입이 올 수 있고 개수에 제한이 있지는 않다. 대신에 초기값을 넣어줘야한다.

***

## Accessing properties

> Now we will learn how to access object properties. First, we need to create an object:
>
> ```kotlin
> var patient = Patient()
> ```
> 
> We haven't changed the object properties yet, so they have initial values now. To get those properties' values, type in a dot and the property name after the object name:
>
> ```kotlin
> println(patient.name) // prints "Unknown"
> println(patient.age)  // prints "0"
> ```

- 클래스 인스턴스에 . 을 찍어서 property 에 접근하는게 가능하다.

***

## Changing properties

> Take a look at the example below. This program creates two patients and sets their properties, then prints them.
>
> ```kotlin
> class Patient {
>     var name: String = "Unknown"
>     var age: Int = 0
>     var height: Double = 0.0
> }
> 
> fun main() {
> val john = Patient()
> john.name = "John"
> john.age = 30
> john.height = 180.0
> 
>     val alice = Patient()
>     alice.name = "Alice"
>     alice.age = 22
>     alice.height = 165.0
> 
>     println("${john.name}: ${john.age} yrs, ${john.height} cm")
>     println("${alice.name}: ${alice.age} yrs, ${alice.height} cm")
> }
> ```
>
> The output is:
>
> ```kotlin
> John: 30 yrs, 180.0 cm
> Alice: 22 yrs, 165.0 cm
> ```
> 
> Also, you need to understand that the val before alice means that we can't reassign a Patient to alice. But we can reassign properties of alice because they are marked as var inside the Patient class

- val 키워드로 property 를 선언하면 불변성을 줄 수 있다. (final 과 같이.)