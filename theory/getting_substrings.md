# Theory: Getting substrings

> You already know what a String type in Kotlin is and how to do basic operations with strings. In this topic, we're going to discuss several methods of getting a new string from the original one.

***

## Getting a part of a string

> Oftentimes, you need to get only a certain part of a string. Kotlin provides the substring function for this.
>
> The substring function accepts startIndex (inclusive) and lastIndex (exclusive) as arguments and returns a string that starts at the startIndex and ends right before the lastIndex.
>
> ````kotlin
> val greeting = "Hello"
> println(greeting.substring(0, 3)) // "Hel"
> println(greeting.substring(1, 3)) // "el"
> println(greeting.substring(2))    // "llo"
> println(greeting.substring(4, 5)) // "o"
> ````
> 
> The parameter lastIndex can be omitted; then you will get a substring from the startIndex element to the end of the original string.
>
> The expression greeting.substring(0, 3) returns "Hel" instead of "Hell" because substring returns characters from the one at startIndex to the one right before lastIndex.
>
> Don't forget that indexes in strings have to start with 0; otherwise, your program may crash. Also, keep it in mind that lastIndex must not be greater than the string length.
>
> The substring method is not the only way to get part of a string. You can also use the substringAfter and substringBefore functions:
>
> ````kotlin
> // greeting = "Hello"
> println(greeting.substringAfter('l'))  // "lo"
> println(greeting.substringBefore('o')) // "Hell"
> println(greeting.substringBefore('z')) // "Hello"
> ````
> 
> These functions accept delimiter as an argument and return a string before/after the first occurrence of a specified delimiter. If the string does not contain any occurrences of the delimiter argument, the function returns the whole string.
> 
> Just keep it in mind that as a second argument, you can specify the message to be returned if the delimiter argument is not present in the string. For example, .substringBefore('z', "can't find a character").
>
> The functions substringBeforeLast and substringAfterLast have a logic similar to substringBefore and substringAfter but return a string before or after the last occurrence of the delimiter.
>
> ````kotlin
> // greeting = "Hello"
> println(greeting.substringAfterLast('l'))  // "o"
> println(greeting.substringBeforeLast('l')) // "Hel"
> ````

- String 에서 subString() 메소드를 이용하면 subString 을 얻을 수 있다. 여기서 startIndex 와 endIndex 를 인자로 넘겨줄 수 있고 이 사이에 있는 값이 전달된다. (주의할 점은 endIndex 는 이전까지만 된다라는 것.)
- subString 에서 endIndex 를 생략할 수도 있다. (이 경우에는 startIndex 부터 String 의 끝까지의 subString 이 리턴된다.)
- 또 유용한 메소드로 subStringBefore, subStringAfter 같은 메소드가 있다. 인자로 delimiter 역할을 해주는 걸 넘겨주면 된다. 이때 두 번째 인수로 String 값을 넘기면 못찾았을 때 전달될 메시지가 리턴된다. 
- 이 외에도 subStringBeforeLast, subStringAfterLast 같은 메소드도 있다.

***

## Replacing parts of a string

> You've probably been in a situation when you need to replace just one word in a string. The replace function replaces all occurrences of the first argument in the string with the second argument.
>
> ```kotlin
> val example = "Good morning..."
> println(example.replace("morning", "bye")) // "Good bye..."
> println(example.replace('.', '!'))         // "Good morning!!!"
> ```
> 
> As you know, strings are immutable, so the replace function returns a new string without changing the original string. So, if you run this code:
>
> ```kotlin
> val example = "Good morning"    
> example.replace("morning", "bye")
> println(example) // Good morning
> ```
> 
> If you need to replace only the first occurrence of an argument, use replaceFirst.
>
> ```kotlin
> val example = "one one two three"
> println(example.replaceFirst("one", "two")) // "two one two three"
> ```

- String 의 매칭되는 문자열을 바꿔주는 메소드로 replace 메소드가 있다.
- replace 는 매칭되는 모든 문자열을 바꿔준다. 한 번만 바꿔주길 원한다면 replaceFirst() 메소드를 사용하자.
- 그리고 String 같은 경우는 Immutable 하니까 replace 해도 원본은 바뀌지 않는다.

***

## Changing the case

> What if you need to replace all capital letters in a word with lowercase letters? Try to imagine how you would do it with the replace function. Now, that's too much code, right? Fortunately, in Kotlin you can use the lowercase function:
>
> ```kotlin
> val example = "UPPERCASE String"
> println(example.lowercase()) // uppercase string
> ```
> 
> If you need to do the opposite, then use the uppercase function:
>
> ```kotlin
> val example = "Lowercase String"
> println(example.uppercase()) // LOWERCASE STRING
> ```
> 
> If you work with the old version of the Kotin language (earlier than 1.5), you may use the functions toLowerCase() and toUpperCase(). However, since Kotlin 1.5, you should use the lowercase() and uppercase() functions.

- 코틀린에서 uppercase, lowercase 와 같은 메소드를 이용해서 전부 대문자, 소문자로 바꿀 수 있다.



