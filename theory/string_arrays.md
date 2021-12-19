# Theory: String arrays

> We can use arrays to process a bunch of data of the same type, and String is no exception. In this topic, we will take a close look at string arrays and cover the essential basics from initializing an array to changing its contents. Note, you can do the same with any other types.

***

## Initialization

> Kotlin does not provide a special function to create an array of strings, so you need to use the function arrayOf which is already familiar to you. Take a look:
>
> ````kotlin
> val stringArray = arrayOf("array", "of", "strings")
> ````
> 
> Basically, the function arrayOf is universal: you can use it to collect any type of data in an array, including String.
>
> If you want to achieve strict behavior by explicitly defining the type, you can do it like this:
>
> ````kotlin
> val stringArray = arrayOf<String>("array", "of", "strings")
> ````
> 
> You can also initialize an empty array to be filled with strings later. For this, you need the function emptyArray:
>
> ````kotlin
> val newEmptyArray = emptyArray<String>()
> ````
> 
> The same actually applies to other types: an array created with emptyArray() can be filled with elements of any type that is defined.

- arrayOf() 메소드를 통해서 선언라고 여기에다가 같은 타입의 요소를 넣으면 Array 를 만들 수 있다. 여기에다가 String 값을 연속적으로 넣으면 StringArray 가 된다.
- arrayOf() 메소드에서 들어올 타입을 명시적으로 선언하는 것도 가능하다.
- emptyArray() 로 빈 어레이를 만드는 것도 가능하다. 

***

## Accessing elements

> Since everything you already know about arrays still applies, you can access a certain element by its index:
>
> ```kotlin
> val stringArray = arrayOf("sagacity", "and", "bravery")
> print(stringArray[2])   // bravery
> ```
> 
> Remember that indexing starts with 00. The index of the last element will equal length - 1.
>
> You can set an array element in the same way:
>
> ````kotlin
> stringArray[0] = "smart"
> print(stringArray[0])   // smart
> ````

***

## Outputting an array

> Now you know how to create and fill a string array and access its elements.
>
> To see what we get as a result, and, for example, print a string array, use the familiar function joinToString():
>
> ````kotlin
> val southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
> println(southernCross.joinToString())   //  Acrux, Gacrux, Imai, Mimosa
> ````
> 
> Keep it in mind that joinToString() processes a single string of elements listed orderly and separated by a comma.

***

## Working with multiple arrays

> Let’s look at a couple of things you might want to know about working with several string arrays.
>
> - String arrays can be added
> 
> You can concatenate several arrays as shown in the following example:
>
> ````kotlin
> val southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
> val stars = arrayOf("Ginan", "Mu Crucis")
> 
> val newArray = southernCross + stars
> println(newArray.joinToString())    //  Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis
> ````
>
> - String arrays can be compared
> 
> You cannot use the operators == and != to compare arrays because they simply do not compare their contents. With arrays, use the function contentEquals() instead:
>
> ````kotlin
> val firstArray = arrayOf("result", "is", "true")
> val secondArray = arrayOf("result", "is", "true")
> val thirdArray = arrayOf("result")
> 
> println(firstArray.contentEquals(secondArray))  //  true
> println(firstArray.contentEquals(thirdArray))   //  false
> ````
>
> Note that it returns true only if the elements of the two arrays match completely and are arranged in the same order.

- array 끼리 + 연산자를 통해서 합칠 수 있다. (이건 여기서 나오는 String Array 뿐 아니라 Int Array 도 포함.)
- 그리고 이전에 Array 끼리 contentEquals() 를 통해서 어레이의 요소가 같은지 비교하는게 가능했는데 String Array 에서도 이게됨.

***

## Changing the array contents

> No matter if you're using val or var, you can edit the values of the existing elements through their index:
>
> ```kotlin
> val southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
> var stars = arrayOf("Ginan", "Mu Crucis")
> southernCross[1] = "star"
> stars[1] = "star"
> 
> println(southernCross[1]) // star
> println(stars[1]) // star 
> ```
>
> However, there is a great difference between val and var when it comes to reassignment. When you have a var array, you can change it by adding new elements to it.
>
> Suppose we created an empty string array:
>
> ```kotlin
> var southernCross = emptyArray<String>()
> ```
> 
> What good is an empty array? Let's fill it:
>
> ```kotlin
> southernCross += "Acrux"
> southernCross += "Gacrux"
> southernCross += "Imai"
> println(southernCross.joinToString())   // Acrux, Gacrux, Imai
> ```
>
> Even if your array is not empty to begin with, you can still add elements in the same way:
>
> ```kotlin
> var southernCross = arrayOf("Acrux", "Gacrux", "Imai")
> southernCross += "Mimosa"
> println(southernCross.joinToString())  //  Acrux, Gacrux, Imai, Mimosa
> ```
> 
> Just like that, we’ve changed the content of the array by adding new elements. However, there’s one very important point to be made.
>
> In Kotlin, the arrays are in a way unchangeable. Even if the array is declared with var, it cannot really be edited. In both examples, the array southernCross was actually re-created. In fact, we literally deleted the array and created another one instead.
>
> So, we can add new elements if the array is declared as var. If you're using val, that is not possible:
>
> ```kotlin
> val southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
> southernCross += "Ginan" // will not compile
> ```

- array 에서 '+' 연산자를 통해서 새로운 요소를 추가하는게 가능하다. 이전에 한번 array 를 선언하면 사이즈를 변경하는게 불가능하다고 했는데 왜 이게 되지? 라고 생각할 수 있다. 
- 어레이는 한번 요소의 사이즈가 정해지면 변경이 안된다. 근데 '+' 연산자를 통해서 넣을 수 있었던 이유는 기존의 어레이를 지우고 새로운 어레이를 만들고 있기 때문이다. (크게 좋은 방식의 프로그래밍은 아니라고 생각한다.)
- 이게 가능할려면 val 대신에 var 키워드로 어레이를 선언해야한다. 매번 새로운 어레이를 만들어서 대입하고 있으므로 val 은 안된다.

