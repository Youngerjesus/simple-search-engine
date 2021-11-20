# Theory: Processing strings

> In some sense, a string looks like a list of characters. You can iterate both over strings and lists. However, sometimes you need to turn a string into a list.

- String 을 list 로 바꿔야하는 경우와 순회하는 방법에 대해서 논의하겠다. 

***

## Splitting the string

> A string can be separated by delimiters to a list of strings. To perform this, call the method split() , it divides a string into substrings by a separator. In the previous example, we used the " " delimiter, which splits a string into separate words by spaces. Notably, the delimiter itself is not included in any of the substrings.
>
> The method returns a List of all the substrings. The List is similar to MutableList, but you cannot reassign elements in the List and you cannot resize the List. You can easily convert List to MutableList and vice versa with toMutableList() and toList() functions.
>
> ````kotlin
> val sentence = "a long text"
> val wordsList: List<String> = sentence.split(" ") // ["a", "long", "text"]
>
> val mutableWordList = sentence.split(" ").toMutableList() // MutableList ["a", "long", "text"]
> ````
> 
> Let's try to split an American phone number into country code, area code, central office code, and other remaining digits:
>
> ````kotlin
> val number = "+1-213-345-6789"
> val parts = number.split("-") // ["+1", "213", "345", "6789"]
> ````
> 
> Note that all the parts are still strings no matter how they look!
> 
> Choose your delimiter wisely, otherwise, you can receive some sentences that start with a space:
> 
> ````kotlin
> val text = "That's one small step for a man, one giant leap for mankind."
> val parts = text.split(",") // ["That's one small step for a man", " one giant leap for mankind."]
> ````
> 
> You can choose any delimiter you prefer, even the combination of spaces and words:
> 
> ````kotlin
> val text = "I'm gonna be a programmer"
> val parts = text.split(" gonna be ") // ["I'm", "a programmer"]
> ````
> 
> As you can see, the split method is also a good tool to get rid of something you don't need or don't want to use.

- String 에서 split(str) 메소드를 이용하면 해당 인수로 전달한 문자열을 기준으로 잘린 List 가 반환된다.
- 이 List 의 경우 해당 요소에 resize 와 reassign 이 안된다. 그러고 싶다면 toMutableList() 메소드를 호출해서 바꿀 수 있도록 변환해주면 된다.

***

## Iterating over a string

> It's possible to iterate over characters of a string using a loop.
> 
> See the following example of iterating with range indices.
> 
> ```kotlin
> val scientistName = "Isaac Newton"
> 
> for (i in 0 until scientistName.length) {
>     print("${scientistName[i]} ") // print the current character
> }
> ```
>
> The code outputs:
>
> ```kotlin
> I s a a c   N e w t o n
> ```
> 
> Also. you can iterate through a string:
>
> ```kotlin
> val str = "strings are not primitive types!"
> 
> var count = 0
> for (ch in str) {
>     if (Character.isWhitespace(ch))
>         count++
> }
> 
> println(count) // 4
> ```
> 
> The code above counts and prints the number of spaces in str. The result is 4.
>
> Example of iterating through an array by indices:
> 
> ```kotlin
> val rainbow = "ROYGCBV"
> 
> for (index in rainbow.indices){
>     println("${index+1}: ${rainbow[index]}")
> }
> ```
>
> The code above prints the colors of the rainbow with their numbers. The output is:
>
> ```kotlin
> 1: R
> 2: O
> 3: Y
> 4: G
> 5: C
> 6: B
> 7: V
> ```

- String 을 순회하는 방법은 Range 표현식을 이용하거나 in 을 통해서 해당 요소에 직접적으로 접근하거나, indices 를 통해서 인덱스로 접근하는 방법이 있다.

***

