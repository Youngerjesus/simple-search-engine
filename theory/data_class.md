# Theory: Data class

> How to make a simple class for storing data? In addition to storing information, it should be able to compare and copy objects. Also, it would be very convenient to output data immediately. Normally, for this functionality the class must have some methods: equals() and hashCode() for comparison, copy() for copying, and toString() for the string representation of the object. But in Kotlin you don't need to implement all of these functions, you can simply use the data class. Let’s take a closer look at this type of class.

- Data class 는 데이터를 저장하고 데이터를 비교하고 복사하는 작업을 위해서 할 수 있다.
- 그래서 기본적으로 메소드를 지원한다. 비교를 위해서 equals(), hashcode() 그리고 데이터 복사를 위해서 copy(), 데이터 출력을 위해서 toString() 을 지원해준다.

***

## Data class

> First of all, we need a class, so here is a nice Client class:
> 
> ```kotlin
> class Client(val name: String, val age: Int, val gender: String)
> ```
> 
> Right now it has 3 properties, so far so good! But in order to properly compare the objects (i.e., by their properties) we need to implement equals() and hashCode() functions:
>
> ```kotlin
> class Client(val name: String, val age: Int, val gender: String) {
>     override fun equals(other: Any?): Boolean {
>         if (this === other) return true
>         if (javaClass != other?.javaClass) return false
> 
>         other as Client
> 
>         if (name != other.name) return false
>         if (age != other.age) return false
>         if (gender != other.gender) return false
> 
>         return true
>     }
> 
>     override fun hashCode(): Int {
>         var result = name.hashCode()
>         result = 31 * result + age
>         result = 31 * result + gender.hashCode()
>         return result
>     }
> }
> ```
> 
> Why do we need such a long piece of code just for standard stuff? That's the right question because with the data class we can simplify it like this:
>
> ```kotlin
> data class Client(val name: String, val age: Int, val gender: String)
> ```
> 
> Wait! Where are all my functions now? Actually, with the data keyword, you don't need them anymore. It will magically work as if you have already implemented them all. This keyword will also provide toString() and copy() functions with default behavior. We'll look at copy() a bit later, but right now you need to remember several rules here:
>
> 1. You can only count on properties that are inside the constructor. For example, this modified Client class:
>
> ```kotlin
> data class Client(val name: String, val age: Int, val gender: String) {
>     var balance: Int = 0
> }
> ```
> 
> All those functions won't consider balance field, because it isn't inside the constructor.
>
> 2. You can override all those functions, except for copy():
>
> ```kotlin
> data class Client(val name: String, val age: Int, val gender: String) {
>     var balance: Int = 0
> 
>     override fun toString(): String {
>         return "Client(name='$name', age=$age, gender='$gender', balance=$balance)"
>     }
> }
> ```
> 
> Now balance field is involved in the toString() function.
>
> 3. The primary constructor of a data class must have at least one parameter and all of those parameters must be val or var.

- 데이터 클래스가 아닌 경우에는 hashcode(), equals(), copy(), toString() 같은 메소드를 모두 오버라이딩 해서 구현해야한다.
  - 이런 경우 작성해야 하는 코드가 엄청 많아질 수 있다.
- 데이터 클래스의 경우 메소드들을 지워해준다. 하지만 copy() 를 제외하고는 따로 오버라이딩 할 수 있다.
- 데이터 클래스에서는 Primary constructor 에서 무조건 하나의 변수를 받아야한다.

***

## Copy

> To be honest, there isn't really a convenient way to copy an object in Java, but Kotlin is different. For example, what if we have an instance of our Client class and we want the exact same client, just with a different name? Easy!
>
> ````kotlin
> fun main() {
>     val bob = Client("Bob", 29, "Male")
>     val john = bob.copy(name = "John")
>     println(bob)
>     println(john)
> }
> ````
>
> As you may see, we just used our copy() function, which will be provided automatically with the data keyword. And the output will be the following:
>
> ````kotlin
> Client(name='Bob', age=29, gender='Male', balance=0)
> Client(name='John', age=29, gender='Male', balance=0)
> ````

- 코틀린에서 복사하는 방식은 Java 보다 훨씬 쉽다. copy() 메소드를 통해서 복사가 되고 copy 할 때 변경할 부분만 따로 입력하는 것도 가능하다.
- 코틀린에서 copy() 는 기본형이 아닌 경우는 shallow 카피를 한다.

***

## Idiom

> As we've demonstrated, the data class is a convenient way to organize data. So use it, with community approval!
>
> ```kotlin
> data class Customer(val name: String, val email: String)
> ```