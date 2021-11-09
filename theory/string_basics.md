# Theory: String basics

***

## The length of a string

> You will often need to get the length of a String. To do this, simply use .length which gives a value of the Int type:
>
> ````kotlin
> val language = "Kotlin"
> println(language.length) // 6
> 
> val empty = ""
> println(empty.length) // 0
> ````
 
- length 출력은 바로 가능하다. String 클래스에 프로퍼티로 제공해준다.

***

## Concatenating strings

> Another common operation with String is concatenation. It is used to construct one string out of other strings.
>
> Two strings can be concatenated with the +:
>
> ```kotlin
> val str1 = "ab"
> val str2 = "cde"
> val result = str1 + str2 // "abcde"
> ```
> 
> When we concatenate two strings, a new string is created.
>
> ```kotlin
> val one = "1"
> val two = "2"
> val twelve = one + two
> println(one)      // 1, no changes
> println(two)      // 2, no changes
> println(twelve)   // 12
> ```
> 
> You can concatenate multiple strings in the same expression:
>
> ```kotlin
> val firstName = "John"
> val lastName = "Smith"
> val fullName = firstName + " " + lastName
> ```

- String 끼리 합치는 건 '+' operation 을 통해서 가능하다.
- '+' 한다고 해서 기존의 string 값이 바뀌는 건 아니다. (Immutable 한 특성)

***

## Appending values to strings

> The + also works for appending values of different types to a String. The value is automatically converted to a String and then concatenated to the target String:
> 
> ```kotlin
> val stringPlusBoolean = "abc" + 10 + true
> println(stringPlusBoolean) // abc10true
> 
> val code = "123" + 456 + "789"
> println(code) // 123456789
> ```
> 
> An expression must start with a String.
>
> Take a look at the example below. It wouldn't work because the first operand is a number:
>
> ```kotlin
> val errorString = 10 + "abc" // an error here!
> ```
> 
> Let's consider a different situation:
>
> ````kotlin
> val stringAndNumbers = "abc" + 11 + 22
> println(stringAndNumbers) // abc1122
> ````
> 
> Why did that work? First, it appends 11 to the string "abc", and then it appends 22 to the string "abc11".
>
> You may concatenate a character with a String to get a new String:
>
> ````kotlin
> val charPlusString = 'a' + "bc"
> println(charPlusString) // abc
> val stringPlusChar = "de" + 'f'
> println(stringPlusChar) // def
> ````
> 
> Also, you may append any value to the result, because characters plus a string gives you a String:
>
> ````kotlin
> val charPlusStringPlusInt = 'a' + "bc" + 123
> println(charPlusStringPlusInt) // abc123
> ````
> 
> We will discuss how to work with characters later, but for now, just remember that you can concatenate characters and strings to get a String value. If you are interested in how characters operate with integers, look at this topic.

- 다른 타입과 String 이 concatenate 가 가능함.
- 근데 String 타입이 먼저와야됨.
- 근데 Character 는 먼저와도 상관없음.

***

## Repeating the string

> If you need to repeat one string two and more times, then hold your loops: Kotlin provides the repeat function:
>
> ```kotlin
> print("Hello".repeat(4)) // HelloHelloHelloHello
> ```
> 
> Now, imagine your friend senior developer gave you a secret on how to become the best programmer:
>
> Let's try to transform this piece of paper to a code snippet that prints your schedule for every day of the week:
>
> ```kotlin
> println("Eat. Sleep. Code.\n".repeat(7)) // \n gives you a line feed (new line)
> ```
> And here goes your week schedule:
> 
> ```kotlin
> Eat. Sleep. Code.
> Eat. Sleep. Code.
> Eat. Sleep. Code.
> Eat. Sleep. Code.
> Eat. Sleep. Code.
> Eat. Sleep. Code.
> Eat. Sleep. Code.
> ```

- repeat 메소드를 통해서 반복하는게 가능하다.

***

## Raw string

> Sometimes you need some special symbols like tabs or quote marks in your string. You can do it with the help of escape sequences. For example:
> 
> ```kotlin
> // prints 'H' is the first letter of "Hello world!" string.
> println("\'H\' is the first letter of \"Hello world!\" string.")
> ```
> 
> This looks a little heavy. If you need to write a fairly large text with newlines and special characters, it can be difficult to read.
>
> For these cases, you can use a raw string. A raw string can contain newlines and any other characters. You just need to wrap the text in triple quotes ("""):
>
> ```kotlin
> val largeString = """
>     This is the house that Jack built.
>       
>     This is the malt that lay in the house that Jack built.
>        
>     This is the rat that ate the malt
>     That lay in the house that Jack built.
>        
>     This is the cat
>     That killed the rat that ate the malt
>     That lay in the house that Jack built.
> """.trimIndent() // removes the first and the last lines and trim indents
> print(largeString)
> ```
> 
> This text prints:
>
> ```kotlin
> This is the house that Jack built.
> 
> This is the malt that lay in the house that Jack built.
> 
> This is the rat that ate the malt
> That lay in the house that Jack built.
> 
> This is the cat
> That killed the rat that ate the malt
> That lay in the house that Jack built.
> ```
> 
> As you see, we also used the function .trimIndent(). It cut off all the lines of the common minimum indent and removed the first and last lines if they are empty. For example:
>
> ```kotlin
> val unevenString = """
>         123
>          456
>           789""".trimIndent()
> print(unevenString)
> println()
> 
> val rawString = """123
>           456
>             789
> """.trimIndent()
> print(rawString )
> ```
> 
> This code prints:
>
> ````kotlin
> 123
>   456
>     789
> 
> 123
>           456
>             789
> ````

- String 에서 특수한 문자를 넣고 싶다면 "" 나 '' 와 같이 escape sequence (\) 의 도움이 필요하다.
- 근데 escape sequence 가 String 사이에 있다면 문자열을 읽는데 방해가 된다.
- 그래서 코틀린에서는 """ 를 통해서 Raw String 을 표시할 수 있도록 해준다.
- """ 안에서는 escape sequence 의 도움이 필요없다.
- 그리고 문자열 출력에 도움을 주는 메소드 중에 trimIndent() 라는 메소드가 있는데 문자열 라인 사이에 공통적으로 indent (들여쓰기) 된 부분을 제거해주는 역할을한다. (조금 유용한듯.)
