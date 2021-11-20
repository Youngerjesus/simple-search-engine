# Theory: Work with MutableLists

> Kotlin provides many useful functions that can come in handy when you work with lists and modify their contents. In this topic, we'll look at various groups of commonly used functions and show you how to use them with examples.

- MutableList 를 다루는 유용한 메소드들 소개하겠다. 뭐 대충 이런 내용.

***

## Outputting a list

> The first function is joinToString(). It helps us output our list in different ways using the separator attribute.
>
> Use joinToString() to see the resulting list and print its contents:
>
> ````kotlin
> val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
> println(southernCross.joinToString())   //  Acrux, Gacrux, Imai, Mimosa
> ````
> 
> Remember that joinToString() takes elements from a mutable list in the order in which they are stored and presents them as a comma-delimited string line.
>
> You can also use another delimiter to separate elements :
>
> ````kotlin
> println(southernCross.joinToString(" -> "))   //  Acrux -> Gacrux -> Imai -> Mimosa
> ````

- joinToString() 메소드를 통해 list 에 있는 요소를 합쳐서 출력할 수 있다. 
- 인수로 String 값을 전달할 수 있고 이를 전달하면 출력할 때 그 문자가 요소 사이마다 포함된다.

***

## Working with multiple lists

> Now, let’s look at a couple of things you might want to know about when working with several string lists.
>
> - Mutable lists can be joined.
> 
> You can concatenate several lists as shown in the following example:
>
> ```kotlin
> val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
> val stars = mutableListOf("Ginan", "Mu Crucis")
> 
> val newList = southernCross + stars
> println(newList.joinToString())    //  Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis
> ```
>
> - Mutable lists can be compared.
> 
> You can use the operators == and != to compare lists – their contents and sizes:
>
> ```kotlin
> val firstList = mutableListOf("result", "is", "true")
> val secondList = mutableListOf("result", "is", "true")
> val thirdList = mutableListOf("result")
> 
> println(firstList == secondList)  //  true
> println(firstList == thirdList)   //  false
> println(secondList != thirdList)  //  true
> ```
> 
> Note that true is returned only if the elements of the two lists match completely and are arranged in the same order.

- MutableList 끼리 '+' 연산자를 통해 join 하는게 가능하다. 이 경우 하나의 MutableList 로 표현됨.
- MutableList 끼리 '==', '!=' 연산자를 통해 비교하는 것도 가능하다.

***

## Changing the list contents

> The keywords val and var tell you how the value/reference of a variable should be handled.
>
> var – the value/reference assigned to a variable can be changed at any time.
> val – the value/reference can be assigned to a variable only once and cannot be changed later during the execution.
>
> No matter which keyword you're using, val or var, you can still edit the values of the existing elements through their index. This is possible because when we change the contents of a list, we do not create a new list (the link to the list is not changed):
>
> ```kotlin
> val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
> var stars = mutableListOf("Ginan", "Mu Crucis")
> southernCross[1] = "star"
> stars[1] = "star"
> 
> println(southernCross[1]) // star
> println(stars[1]) // star
> ```
> 
> There are ways to remove list elements and add new elements to the list.
>
> You can use the functions add, remove, and clear to change lists:
> 
> ```kotlin
> val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
> val stars = mutableListOf("Ginan", "Mu Crucis")
> val names = mutableListOf("Jack", "John", "Katie")
> val food = mutableListOf("Bread", "Cheese", "Meat")
> val fruits = mutableListOf("Apple", "Banana", "Grape", "Mango")
> 
> southernCross.removeAt(0)
> southernCross.remove("Mimosa")
> 
> stars.add("New star")
> stars.add(0, "First star")
> 
> names.clear()
> 
> food.addAll(fruits)
> 
> println(names) // []
> println(southernCross.joinToString()) // Gacrux, Imai
> println(stars.joinToString()) // First star, Ginan, Mu Crucis, New star
> println(food.joinToString()) // Bread, Cheese, Meat, Apple, Banana, Grape, Mango
> ```
> 
> - add(element) and add(index, element) insert new items at any position in the list. If you don't specify the index, the item will be added to the end of the list.
> - list1.addAll(list2) adds all elements from list2 to the end of the list1.
> - remove(element) and removeAt(index) delete an item from the list. The former function deletes a single instance of the specified element from the list (it returns true if item was successfully removed, otherwise it returns false). The latter function deletes the element at the specified position and returns the element that has been removed.
> - clear() deletes all elements from the list.
> 
> Also, you can use += to add new elements to the list:
>
> ```kotlin
> val vowels = mutableListOf('a', 'o', 'i', 'e', 'u')
> val intList1 = mutableListOf(1, 2, 3, 4, 5)
> val intList2 = mutableListOf(5, 4, 3, 2, 1)
> 
> vowels += 'y'
> intList1 += intList2
> 
> println(vowels)   // [a, o, i, e, u, y]
> println(intList1) // [1, 2, 3, 4, 5, 5, 4, 3, 2, 1]
> ```

- add, addAll() 메소드를 통해서 List 에 값을 추가하는게 가능하다.
- remove, removeAt(), clear() 메소드를 통해서 List 에 값을 지우는게 가능하다. 
- index 로 리스트 요소에 접근해서 값을 변경하는 것도 가능하다.
- '+=' 연산자를 통해서 리스트에 값을 추가하거나 리스트 끼리 합치는 것도 가능하다.

***

## Copy list content

> Kotlin doesn't have any functions to copy existing lists. However, you can do it using the toMutableList() function:
>
> ```kotlin
> val list = mutableListOf(1, 2, 3, 4, 5)
> val copyList = list.toMutableList()
> 
> print(copyList) // [1, 2, 3, 4, 5]
> ```
> 
> This function creates a new MutableList and adds the contents of list to the new list. It works like this:
>
> ```kotlin
> val list = mutableListOf(1, 2, 3, 4, 5)
> val copyList = mutableListOf<Int>()
> copyList.addAll(list)
> 
> print(copyList) // [1, 2, 3, 4, 5]
> ```

- Kotlin 에서 toMutableList() 메소드를 통해 리스트에 있는 요소들을 복사하는게 가능하다. (이는 레퍼런스를 복사하는게 아니다.)

***

## Other useful functions

> There are some operations that can be really useful when you work with lists and their contents:
>
> - list.isEmpty() and list.isNotEmpty() – check whether the list is empty.
> - list.sublist(from, to) – creates a smaller list (sublist), which includes items of the original list with the following indexes: from, from + 1, ..., to - 2, to - 1. The element with the index to is not included.
> 
> ```kotlin
> val numbers = mutableListOf(1, 2, 3, 4, 5)
> val sublist = mutableListOf<Int>()
> if (numbers.isNotEmpty() && numbers.size >= 4) {
>   sublist = numbers.subList(1, 4)
> }
> 
> print(sublist) // [2, 3, 4] 
> ```
> 
> - element in list – checks if an element belongs to the list.
> - list.indexOf(element) – searches for the index of an element in the list. The result of this function is -1 if there is no such element in the list. Otherwise, when we access the list by the calculated index, we get the element.
> 
> ```kotlin
> val numbers = mutableListOf(1, 2, 3, 4, 5)
> 
> if (5 in numbers) {
>   println(numbers.indexOf(5)) // 4
> }
> 
> print(numbers.indexOf(7)) // -1
> ```
> 
> - list.minOrNull() and list.maxOrNull() – search for the minimum and maximum elements in the list.
> - list.sum() – returns the sum of the elements in the list.
> - list.sorted() and list.sortedDescending() – build a sorted list (ascending or descending) from the available list.
> 
> ```kotlin
> val numbers = mutableListOf(1, 2, 3, 4, 5)
> 
> val vowels = mutableListOf('e', 'a', 'y', 'i', 'u', 'o')
> 
> println(numbers.minOrNull()) // 1
> println(numbers.maxOrNull()) // 5
> println(numbers.sum())      // 15
> 
> println(vowels.sorted()) // [a, e, i, o, u, y]
> println(vowels.sortedDescending()) // [y, u, o, i, e, a]
> ```

- 리스트의 유용한 메소드들 (자바에도 다 있는 기능이지만 Java Stream 을 통한 연산인 것들을 그냥 코틀린에서는 리스트에서 제공해주므로 더 유용한듯. 근데 이런 유용한 메소드는 파이썬이 짱이긴 한 듯.)
- List 에서 isEmpty(), isNotEmpty() 와 같은 메소드를 제공해서 값이 비었는지, 안 비었는지 알 수 있는 메소드를 제공해준다.
- subList() 를 통해서 List 의 일부를 가져올 수 있다.
- element in List 를 통해서 리스트 안에 해당 요소가 들어있는지 확인할 수 있다. 
- indexOf() 메소드를 통해서 해당 값이 몇 번 인덱스이 있는지 알 수 있다.
- minOrNull(), maxOrNull() 메소드를 통해서 최소값, 최대값을 바로 알 수 있다.
- sum() 메소드를 통해서 모든 요소들을 합치는게 가능하다.
- sorted(), sortedDescending() 메소드를 통해서 리스트를 정렬하는 것도 가능하다.






