# Theory: Working with strings

> A string is just a sequence of characters enclosed in double-quotes. In Kotlin, strings are represented by the String type. It is one of the most widely used data types in practice. In this topic, we will learn some operations with strings.

***

## Accessing characters

> The elements of a string are individual characters that can be accessed by their index. The first element of a string has an index of 
> 
> ```kotlin
> val greeting = "Hello"
> 
> val first = greeting[0]  // 'H'
> val second = greeting[1] // 'e'
> val five = greeting[4]   // 'o'
> ```
> 
> The last element has the index that equals the length of the string minus 1. For the string "Hello", the last element is 'o'. Its index is 4 because the string's length is 5.
> 
> ```kotlin
> val last = greeting[greeting.length - 1] // 'o'
> val prelast = greeting[greeting.length - 2] // 'l'
> ```
> 
> Kotlin provides several convenient ways to access the first and the last character of a string:
>
> ```kotlin
> println(greeting.first())   // 'H'
> println(greeting.last())    // 'o'
> println(greeting.lastIndex) // 4
> ```
> You can use this feature to write more readable code.

- 코틀린에서 String 은 인덱스를 통해서 각 Character 에 접근하는게 가능하다.
- 원래 마지막 문자 같은 경우는 length - 1 이런식으로 일반적인 언어에서는 접근하는데, last() 라는 메소드를 제공해줌으로써 코드 읽기가 쉽다.

***

## Empty string

> Sometimes you need a fast way to check if the String is empty. For example, you need the first element of the string and want to check for its existence. Of course, you can use the length and check if it's greater than 0. But a much more elegant way is using the function isEmpty():
>
> ```kotlin
> val emptyString = ""
> println(emptyString.length == 0) //true
> println(emptyString.isEmpty()) //true
> ```

- 코틀린에서 String 값이 비었음을 나타내는 메소드를 제공해준다. isEmpty() 와 같은. 

***

## Immutability

> Strings are immutable, meaning that once created, the string stays the same. You cannot modify an element of a string. So, the example below would not work:
>
> ```kotlin
> val valString = "string"
> valString[3] = 'o' // an error here!
> var varString = "string"
> varString[3] = 'o' // an error here too!
> ```
> 
> If you need to change the string, you can reassign it:
>
> ```kotlin
> var varString = "string"
> varString = "strong" // legal
> val valString = "string"
> valString = "strong" // error, you cannot reassign val
> ```

- String 은 Immutable 하기 때문에 특정 요소에 접근해서 바꾸는건 에러가난다. 
- 하지만 reassign 을 하는 경우는 괜찮다.

***

## Comparing strings

> To compare two strings, use == (equals) and != (not equals) operators. Both operators take two strings as their operands and return a value of the Boolean type (true or false).
>
> ```kotlin
> val first = "first"
> val second = "second"
> var str = "first"
> 
> println(first == str)    // true
> println(first == second) // false
> println(first != second) // true
> ```

- String 비교를 할 땐 == 연산자를 이용하면 된다. (equals 보다 == 을 권장하는듯.)