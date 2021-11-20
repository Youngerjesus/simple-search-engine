# Theory: For loop and lists

> In Kotlin, the for loop is a handy tool that allows you to iterate through an entire mutable list. Let's take a look at several ways of using it.

***

## Iterating through a MutableList

> The simplest way to process each mutable list element is to use the following template:
>
> ````kotlin
> for (element in mutList) {
>     // body of loop
> }
> ````
> 
> Suppose we have a mutable list that includes weekdays. Let's print each day of the week:
>
> ````kotlin
> fun main() {
>     val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")
>     
>     for (day in daysOfWeek){
>         println(day)
>     }
> }
> ````
> 
> After that, the program will print the following:
>
> ```
> Sun
> Mon
> Tues
> Wed
> Thur
> Fri
> Sat
> ```
> 
> In the same way, you can process a mutable list of integers, characters, or any other data type.

- List 에서 in 을 사용해서 for loop 에서 순회할 수 있다.

***

## Iterating by indexes

> It is possible to access elements by their index directly from the loop. To do that, you must use the mutList.indices property, which represents a range of valid mutList indexes.
>
> Take a look at the daysOfWeek mutable list:
>
> ```kotlin
> fun main() {
>     val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")
> 
>     for (index in daysOfWeek.indices){
>         println("$index: ${daysOfWeek[index]}")
>     }
> }
> ```
> 
> The program will print the following:
> 
> ```
> 0: Sun
> 1: Mon
> 2: Tues
> 3: Wed
> 4: Thur
> 5: Fri
> 6: Sat
> ```

- List.indices 를 통해서 index 를 가져와서 for loop 에서 사용하는 것도 가능하다.

***

## Iterating by range indexes

> We have discussed two ways of iterating through a mutable list. They are useful when you need to process each list element. Sometimes, however, you may need to access a particular sublist. In such case, you can specify the range of the indexes you need.
>
> The first element of a mutable list always has index 0.
> 
> Take a look at the program below:
>
> ```kotlin
> fun main() {
>     val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")
> 
>     for (index in 1..5) {
>         println("$index: ${daysOfWeek[index]}")
>     }
> }
> ```
> 
> It will print only the workdays:
>
> ```kotlin
> 1: Mon
> 2: Tues
> 3: Wed
> 4: Thur
> 5: Fri
> ```
> 
> To use the last index of a mutable list in ranges, you need to access mutList.lastIndex. So, we can modify the code this way:
>
> ```kotlin
> for (index in 1 until daysOfWeek.lastIndex) {
>     println("$index: ${daysOfWeek[index]}")
> }
> ```
> 
> It displays the same days as before:
>
> ```kotlin
> 1: Mon
> 2: Tues
> 3: Wed
> 4: Thur
> 5: Fri
> ```
> 
> If you want to iterate through a mutable list in reverse order, use downTo in a range. You can also specify the offset between indexes using step.
> 
> The program below will print days in reverse order with a step of 2:
> 
> ```kotlin
> fun main() {
>     val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")
> 
>     for (index in daysOfWeek.lastIndex downTo 0 step 2) {
>         println("$index: ${daysOfWeek[index]}")
>     }
> }
> ```
> Output:
>
> ```kotlin
> 6: Sat
> 4: Thur
> 2: Tues
> 0: Sun
> ```
> 
> So, you can iterate through an entire mutable list or a part of it in both direct and reverse order with any step you need.

- List 의 index 요소와 range 표현식을 통해서 루프를 순회하는 것도 가능하다. 
- 주로 list 를 순회할 때 lastIndex 와 step 같은 요소를 사용할 때 이 방법을 쓰지 않을까 싶다.

***

