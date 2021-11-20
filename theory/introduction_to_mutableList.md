# Theory: Introduction to MutableList

> In previous topics, you learned how to declare variables to store and manipulate data. But what can we do if we want to save and process not one single value but multiple data of the same type? In such cases, we resort to using a list, which allows us to process multiple values of the same type as a single unit. In this topic, we will see what MutableList is and how we can use it to store and manipulate data. It is convenient in cases when you don't know exactly how many elements the program will process during its runtime.

- 대충 하나의 요소만 다루는게 아니라 같은 타입의 많은 요소를 다루기 위해선 MutableList 를 통해서 처리할 수 있다는 뜻.

***

## Introduction to MutableList

> The Kotlin Standard Library provides many ways to organize data and to group multiple values. Now we will consider one of them – the Mutable List.
>
> MutableList is an ordered set of variables of the same type. You can access the list items by their indexes.
>
> ```kotlin
> val numbers = mutableListOf(10.8, 14.3, 13.5, 12.1, 9.7)
> 
> println(numbers) // [10.8, 14.3, 13.5, 12.1, 9.7]
> ```
> 
> The picture below illustrates a mutable list of five floating-point numbers. Each element has an integer index (0-4), so you can access an element by referring to its index. The first element always has the index 0, and the last element has the index that equals the list size minus one.

- Kotlin Standard Library 에서는 데이터를 조직하고 그룹핑해서 다룰 수 있는 방법을 제공해주는데 그 중 하나가 바로 MutableList
- MutableList 에서는 Index 로 요소에 접근하는게 가능하다.

***

## Creating a MutableList with specified elements

> In Kotlin, the mutableListOf() function is used to create an object of the MutableList class.
>
> Kotlin can handle any types of MutableList you want: for example, Int, Long, Double, Float, Char, String, Byte, or Boolean.
>
> Here is an example of creating a mutable list in cases when we know the content type. In angle brackets <>, you may specify the type of data that will be stored in the list. You will learn more about <> in the following topics.
>
> ````kotlin
> //declaring a mutable list of integers
> val mutableListA = mutableListOf<Int>(1, 2, 3, 4, 3)
> println(mutableListA)
> 
> //declaring a mutable list of strings
> val mutableListB = mutableListOf<String>("Kotlin", "JetBrains")
> println(mutableListB)
> 
> //declaring an empty mutable list of booleans
> val mutableListC = mutableListOf<Boolean>()
> println("Empty list $mutableListC")
> ````
> 
> The above code snippet prints three lists:
>
> ````kotlin
> [1, 2, 3, 4, 3]
> [Kotlin, JetBrains]
> Empty list []
> ````
> 
> Also, Kotlin allows you to not explicitly specify what type of data the list stores:
>
> ````kotlin
> //declaring a mutable list of integers
> val mutableListA = mutableListOf(1, 2, 3, 4, 5)
> 
> println(mutableListA) // [1, 2, 3, 4, 5]
> ````

- mutableListOf() 메소드를 통해서 MutableList 클래스를 만들 수 있다.
- 들어올 수 있는 구체적인 타입을 지정하고 싶다면 <> 을 쓰고 거기에 해당 타입을 넣으면 된다. (<> 를 안쓰면 MutableList 에 타입을 섞어서 넣는 것도 가능.)

***

## Reading list from input

> You don't need to figure out all the snippets right now, just use them as a template in your projects!
>
> To read a list of a certain size from the console, we first need to create a MutableList of some type with a known size. Inside the parentheses, we should place readLine()!!, with the help of which we can read input from the console. The readLine() function returns a string, so don’t forget to convert the input string into the type of the created list.
>
> ```kotlin
> val numbers = MutableList(5) { readLine()!!.toInt() } // on each line single numbers from 1 to 5
> println(numbers) // [1, 2, 3, 4, 5]
> ```
> 
> This code allows you to read 5 numbers, each number on a separate line.
>
> If you want to read a list in a single line, use the following approach. You can read the list with the readLine() function. You’ll get a string, which you should split.
>
> ```kotlin
> // here we have an input string "1 2 3 4 5"
> val numbers = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
> println(numbers) // [1, 2, 3, 4, 5]
> ```
> 
> Let’s have a look at this code snippet. We read a string from input and then use split(). We divide our string into smaller ones by space, then we use the map function to convert every element to Int, and then we convert the result to MutableList. Here you can read more about mapping transformation.
>
> There is also a way that allows you to ignore line breaks and extra spaces in the input string. You can do this with the help of regular expressions, which are often used in text searching and editing.
>
> ```kotlin
> val regex = "\\s+".toRegex()  // 1 or more whitespace character (space, tabs etc.)
> val str = "1 2\t\t3  4\t5  6"
> val nums = str.split(regex).map { it.toInt() }.toMutableList()
> println(nums.joinToString()) // 1, 2, 3, 4, 5, 6
> ```
>
> With this regular expression, you can ignore spaces and tabs in the input string. You can learn more about regular expressions in our topics.

- readLine()!! 을 통해서 input 으로 받은 데이터를 MutableList 로 변환하는 것도 가능.

***

## MutableList size

> To create a mutable list of a specified size n, we use the MutableList(n) function:
>
> ```kotlin
> val list = MutableList(5) {0}
> println(list) // [0, 0, 0, 0, 0]
> ```
> 
> In curly braces, we write the object that will make up our list. For example, if you specify "a", the list will contain 5 elements equal to "a":
>
> ```kotlin
> val list = MutableList(5) {"a"}
>
> println(list) // [a, a, a, a, a]
> ```
> 
> A mutable list always has a specified size, that is, the number of elements. To obtain it, we need to take the value of the size property. It is a number of the Int type.
>
> ```kotlin
> val numbers = mutableListOf<Int>(1, 2, 3, 4, 5)
>
> println(numbers.size) // 5
> ```

- MutableList 를 만들 때 구체적인 사이즈를 선언하는 것도 가능. 
- 사이즈를 선언해놓고 한 개의 값만 넣으면 해당 값으로 사이즈 개수만큼 채워짐. (e.g MutableList(5) {"a"} )
- 그리고 size 프로퍼티를 통해 MutableList 의 사이즈를 보는것도 가능.

***

## Accessing elements

> You can change the values of mutable list elements. Use index to set a value in the list.
>
> Setting the value of an element using the element's index:

- MutableList 에서도 first(), last() 메소드 존재. 그리고 lastIndex 도 존재한다.

