# Theory: Arrays

***

## Introduction to arrays

> Arrays are useful when you need to process multiple values of the same type. You can save and process them together in an array as a single unit. It is convenient if you don't know how many elements the program will process during its runtime.
>
> You may consider an array as a collection of elements of one type. All elements are stored in the memory sequentially.
> 
> The collection provides one name for all elements. Once an array is created, it cannot be changed. However, you can modify a stored element at any time.
>
> The picture below illustrates an array of five floating-point numbers. Each element has an integer index (0-4), so you can access it. The first element always has the index of 0, the last element has the index that equals array size - 1.
> 
> We hope you got the general idea of what arrays are. Now, let's see, how we can use them in Kotlin.

***

## Creating an array with specified elements

> Kotlin can handle many types of arrays: IntArray, LongArray, DoubleArray, FloatArray, CharArray, ShortArray, ByteArray, BooleanArray. Each array stores elements of the corresponding type (Int, Long, Double, and so on). Note that Kotlin doesn't have default StringArray type. You can store String in the array, but we talk about it on another topic.
>
> To create an array of a specified type, we need to invoke a special function and pass all elements to store them together:
>
> - intArrayOf creates IntArray;
> - charArrayOf creates CharArray;
> - doubleArrayOf creates DoubleArray;
>
> For example, let's create three arrays:
>
> ````kotlin
> val numbers = intArrayOf(1, 2, 3, 4, 5) // It stores 5 elements of the Int type
> println(numbers.joinToString()) // 1, 2, 3, 4, 5
> 
> val characters = charArrayOf('K', 't', 'l') // It stores 3 elements of the Char type
> println(characters.joinToString()) // K, t, l
> 
> val doubles = doubleArrayOf(1.25, 0.17, 0.4) // It stores 3 elements of the Double type
> println(doubles.joinToString()) // 1.15, 0.17, 0.4
> ````
>
> This code snippet above prints three arrays:
>
> ```
> 1, 2, 3, 4, 5
> K, t, l
> 1.25, 0.17, 0.4 
> ```
> 
> The joinToString() function converts an array into a string.
>
> When you initialize an array (or anything else) with a sequence of arguments, you can add a trailing comma. It can be useful if you want to add or change some values:

- Kotlin 에서는 다양한 기본 타입의 array 를 제공해준다. (e.g IntArray, LongArray, DoubleArray, CharArray, FloatArray, ShortArray, ByteArray, BooleanArray)
- StringArray 는 기본적으로 제공해주지 않는다.
- Array 를 만들고 싶다면 intArrayOf(), charArrayOf(), doubleArrayOf() 과 같은 메소드를 사용하면 된다. 이 메소드에다가 array 의 초기화 요소를 넣어서 생성해줄 수 있다.
- joinToString() 메소드를 사용하면 array 의 모든 요소는 string 으로 변환된다.

***

## Creating an array of a specified size

> To create an array of a certain size, we need to write its type and pass it after the type name in round brackets (the constructor):
>
> ```kotlin
> val numbers = IntArray(5) // an array of 5 integer numbers
> println(numbers.joinToString())
> 
> val doubles = DoubleArray(7) // an array of 7 doubles
> println(doubles.joinToString())
> ```
> 
> These arrays are going to have a predefined size. They are filled by the default values of the corresponding types (0 for numeric types):
>
> ```kotlin
> 0, 0, 0, 0, 0
> 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
> ```
> 
> You cannot change the size of an array, but you can modify the elements.

- 처음 Array 를 선언할 때 구체적인 사이즈만 명시해서 생성하고 싶다면 IntArray(size), DoubleArray(size) 를 통해서 생성하는게 가능하다.
- 이렇게 생성하면 기본적으로 0 이 들어가있다.

***

## Reading array from input

> You don't need to figure out all the snippets right now, just use them as a template in your projects!
>
> To read an array of a certain size from the console, we first need to create an array of some type with a known size. Inside the parentheses, we should place readLine()!!, with the help of which we can read input from the console. The readLine() function returns a string, so don’t forget to convert the input string into the type of the created array.
>
> ````kotlin
> val numbers = IntArray(5) { readLine()!!.toInt() } // on each line single numbers from 1 to 5
> println(numbers.joinToString()) // 1, 2, 3, 4, 5
> ````
> 
> This code allows you to read 5 numbers, each number on a separate line.
>
> If you want to read an array in a single line, use the following approach. You can read the array with the readLine() function. You’ll get a string, which you should split.
>
> ````kotlin
> // here we have an input string "1 2 3 4 5"
> val numbers = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
> println(numbers.joinToString()) // 1, 2, 3, 4, 5
> ```` 
> 
> Let’s have a look at this code snippet. We read a string from input and then use split(). We divide our string into smaller ones by space, then every element with map function we convert to Int and we return an integer array. Here you can read more about mapping transformation.
>
> There is also a way that allows you to ignore line breaks and extra spaces in the input string. You can do this with the help of regular expressions, which are often used in text searching and editing.
>
> ````kotlin
> val regex = "\\s+".toRegex()
> val str = "1 2\t\t3  4\t5  6"
> val nums = str.split(regex).map { it.toInt() }.toTypedArray()
> println(nums.joinToString()) // 1, 2, 3, 4, 5, 6
> ````
> 
> With this regular expression, you can ignore spaces and tabs in the input string. You can learn more about regular expressions in our topics.

- input 을 통해서 Array 를 만드는 다양한 방법을 소개
  - 처음에 어떤 타입의 Array 인지 보여주고 람다식을 통해서 Array 의 요소를 채우는 `IntArray(5) { readLine()!!.toInt() }` 제일 가독성이 좋은듯.
- split() 메소드 안에 정규표현식을 넣어서 쪼갤 수 있다는게 신기했다.
- 그리고 일반 String 을 toRegex() 메소드를 통해 정규표현식 객체로 바꿔줄 수 있다는 것도.

***

## Array size

> An array always has a size, that is, the number of elements. To obtain it, we need to take the value of the size property. It is a number of the Int type.
>
> ```kotlin
> val numbers = intArrayOf(1, 2, 3, 4, 5)
> println(numbers.size) // 5
> ```
> 
> You cannot change the size of an array after it has been created.

- 한번 Array 를 선언하면 사이즈는 변경 X

***

## Accessing elements

> You can change the values of array elements. Use the index to set a value in the array.
>
> Setting the value by the index:
>
> ````kotlin
> array[index] = elem
> ````
> 
> Getting the value by the index:
>
> ````kotlin
> val elem = array[index]
> ````
> 
> Array indexes are numbers from 0 (the first element) to array.size-1 (the last element).
>
> Here is an example of a three-element array of integers:
>
> ````kotlin
> val numbers = IntArray(3) // numbers: 0, 0, 0
> 
> numbers[0] = 1 // numbers: 1, 0, 0
> numbers[1] = 2 // numbers: 1, 2, 0
> numbers[2] = numbers[0] + numbers[1] // numbers: 1, 2, 3
> 
> println(numbers[0]) // 1, the first element
> println(numbers[2]) // 3, the last element
> ````
> 
> Let's take a closer look at the code above. First, we have an array with three elements. By default, all elements are equal to 0. Then, the value 1 is assigned to the first element of the array by the index of 0. Then, the value 2 is assigned to the second element of the array by the index of 1. After that, the value 3 (the sum of 1 and 2) is assigned to the last element of the array by the index of 2. Then, we print the first and the last element of the three-element array.
>
> If we try to access a non-existing element by the index, the program will throw an exception. Let's try to get the fourth element with index of 3 of the considered numbers array:
>
> ````kotlin
> val elem = numbers[3]
> ````
> 
> The program will throw ArrayIndexOutOfBoundsException.
>
> As you may already know, the last element has an index equal to array.size - 1. Let's access the last element and the one before last:
>
> ````kotlin
> val alphabet = charArrayOf('a', 'b', 'c', 'd')
> 
> val last = alphabet[alphabet.size - 1]    // 'd'
> val prelast = alphabet[alphabet.size - 2] // 'c'
> ````
>
> Kotlin provides several convenient ways to access the first and the last elements of an array as well as to access the last index:
>
> ````kotlin
> println(alphabet.first())   // 'a'
> println(alphabet.last())    // 'd'
> println(alphabet.lastIndex) // 3
> ````
> 
> Use this approach to make your code more readable and prevent accessing the non-existent indexes.

***

## Comparing arrays

> To compare two arrays, invoke the contentEquals() function of an array and pass another array as the argument. This function returns true when two arrays contain the same elements in the same order. Otherwise, it returns false:
>
> ````kotlin
> val numbers1 = intArrayOf(1, 2, 3, 4)
> val numbers2 = intArrayOf(1, 2, 3, 4)
> val numbers3 = intArrayOf(1, 2, 3)
> 
> println(numbers1.contentEquals(numbers2)) // true
> println(numbers1.contentEquals(numbers3)) // false
> ````
>
> Beware, the operators == and != do not compare the contents of arrays, they compare only the variables that point to the same object:
>
> ````kotlin
> val simpleArray = intArrayOf(1, 2, 3, 4)
> val similarArray = intArrayOf(1, 2, 3, 4)
> 
> println(simpleArray == simpleArray)  // true, simpleArray points to the same object
> println(simpleArray == similarArray) // false, similarArray points to another object
> ````

- Array 의 내부 요소들이 모두 같은지 비교할려면 contentEquals() 메소드를 이용하면 된다.
- 주의할 게 == 연산자를 통해서 비교하는 것도 가능한데 이 경우에는 동일한 객체인지를 비교하는 것으로 쓰인다. Array 의 내부 요소와 비교할 수 없다. (이 부분은 List 와 다르네 List 는 == 연산자를 통해서 비교하는게 가능한데.)

