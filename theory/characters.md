# Theory: Characters

> In this topic, you will learn how to work with characters in Kotlin. This is a pretty fundamental concept, and being familiar with it will help you better understand how to work with texts.
  
***

## What is a character

> Each character is just a symbol enclosed in single quotes. The Char type represents letters (both uppercase and lowercase), digits, and other symbols:
> 
> ````kotlin
> val lowerCaseLetter: Char = 'a'
> val upperCaseLetter: Char = 'Q'
> val number: Char = '1'
> val space: Char = ' '
> val dollar: Char = '$'
> ````
> 
> This type can represent any symbol including hieroglyphs, as well as some special symbols.
>
> A character can also be represented by its hexadecimal code in the Unicode table. The code starts with \u:
>
> ````kotlin
> val ch = '\u0040' // it represents '@'
> println(ch) // @
> ````
> 
> Although we use a sequence of characters to represent such code, the code itself represents exactly one character.
>
> For example, Latin capital letters have hexadecimal codes from '\u0041' to '\u005A', and Latin lowercase letters have codes ranging from '\u0061' to '\u007A'.
>
> You can also convert numbers to characters and vice versa. Let's take a look at how it works:
>
> ````kotlin
> val ch = 'a'
> println(ch.toInt())   // 97
> val num = 97
> println(num.toChar()) // a
> ````

- Char 는 하나의 symbol 을 나타낼 때 주로 쓰인다.
- '\u' 와 16진수 숫자로도 Char 를 나타낼 수 있다. 이때는 Unicode Table 에 있는 숫자와 매핑된다.
- Char 의 각 Symbol 은 Unicode 의 문자와 매핑되고 이 문자를 가리키는 숫자가 있다. 그래서 문자와 숫자간의 서로 변환이 된다.

***

## How to read characters

> Kotlin does not provide a convenient function to read a Char. However, you can do it another way: if you need to read one Char in a whole line, use this construction:
> 
> ```kotlin
> val ch: Char = readLine()!!.first()
> ```
> 
> You just read a String and get its first element, which will be a Char. Strings are composed of characters, but we will discuss this in more detail a little later.
  
- Kotlin 에서는 Char 만을 읽는 편리한 함수는 제공해주지 않지만 그와 유사한게 있다.
- 이는 readLine()!!.first() 를 통해서 첫 글자만 읽어오는 함수다. 
- Kotlin 에서 String 은 Character 의 연속적인 집합으로 구성되어있는 관계다. 

***

## Retrieving subsequent characters

> There are two operators for adding (+) and subtracting (-) integer numbers in order to get the next and previous characters according to the Unicode order
>
> ```kotlin
> val ch1 = 'b'
> val ch2 = ch1 + 1 // 'c'
> val ch3 = ch2 - 2 // 'a'
> ```
> 
> Remember that you cannot add a symbol to a number as it will cause an error.
>
> ```kotlin
> val ch = 'a'
> val ch1 = 1 + ch // Error
> ```
> 
> You also cannot sum up two characters:
>
> ```
> val charsSum = 'a' + 'b' // Error
> ```
> 
> It is possible to use the increment (++) and decrement (--) operators in their prefix and postfix forms. The assignment operator combined with + or - also works for characters, as well as += and -=.
  
- Character 에 숫자를 더해서 다음 Unicode 문자를 가져오는 건 가능하다. (이때 +,- 연산자 뿐 아니라 ++, --, +=, -= 같은 연산자 모두 가능)
- Character + 숫자 해서 Unicode 문자를 가져오는 건 가능하지만, 숫자 + 문자 는 안됨. (직관에 맞지 않아서 그런) 

***

## Escape sequences

> There are some special characters starting with a backslash \, which are known as escape or control sequences. Most of them do not have corresponding symbols, and you cannot find them on your keyboard. 
>
> '\n' is the newline character;
> '\t' is the tab character;
> '\r' is the carriage return character;
> '\\' is the backslash character itself;
> '\'' is the single quote mark;
> '\"' is the double quote mark.
>
> Here are a few examples:
>
> ```kotlin
> print('\t') // makes a tab
> print('a')  // prints 'a'
> print('\n') // goes to a new line
> print('c')  // prints 'c'
> ```
> 
> The above code will print:
>
> ```
>   a
> c
> ```

- \ 로 시작하는 특별한 의미를 가진 special character 들이 있다. 이것들을 escape or control sequence 라고 한다. 

***

## Relational operations with characters

> You can compare characters using relational operations (==, <, >, <=, >=, and !=) according to their position in the Unicode table.
>
> ```kotlin
> println('a' < 'c')  // true
>  println('x' >= 'z') // false
>  
>  println('D' == 'D') // true
>  println('Q' != 'q') // true because capital and small letters are not the same
>  
>  println('A' < 'a')  // true because capital Latin letters are placed before small ones
> ```  
> 
> Using relational operations and codes, we can check whether a Char is a digit: all ten digits have codes from '\u0030' to '\u0039'.
>
> Here is a program that does it:
>
> ```kotlin
> fun main() {
>     val ch = readLine()!!.first()
>     val isDigit = ch >= '\u0030' && ch <= '\u0039'
> 
>     println(isDigit)
> }
> ```
>
> If the input is a digit '0', '1', '2', ..., '9' (without quotes), the program prints true. Otherwise, it prints false.
  
- Character 문자들도 관계 연산자들 (<,>,=,!= 등) 을 사용할 수 있다. 이것들을 사용할 땐 Unicode Table 에서 매핑하는 숫자들 기반으로 사용한다.

***

## Processing characters

> There's a variety of useful functions to work with characters. You can use these functions instead of dealing with character codes.
>
> - isDigit() returns true if the given character represents a digit ('1', '2', etc); otherwise, false;
> - isLetter() returns true if the given character represents a letter ('a', 'B', 'm', etc); otherwise, false;
> - isLetterOrDigit() returns true if the given character represents a letter or a digit; otherwise, false;
> - isWhitespace() returns true if the given character represents a whitespace (' ', or '\t', or '\n'); otherwise, false;
> - isUpperCase() returns true if the given character is an uppercase character; otherwise, false;
> - isLowerCase() returns true if the given character is a lowercase character; otherwise, false;
> - toUpperCase() returns the uppercase form of the given character (before Kotlin 1.5; you shouldn't use it nowadays);
> - uppercaseChar() returns the uppercase form of the given character (since Kotlin 1.5);
> - uppercase() returns a String with the uppercase form of the given character (since Kotlin 1.5);
> - toLowerCase() returns the lowercase form of the given character (before Kotlin 1.5; you shouldn't use it nowadays);
> - lowercaseChar() returns the lowercase form of the given character (since Kotlin 1.5);
> - lowercase() returns a String with the lowercase form of the given character (since Kotlin 1.5).
>
> Let's take a look at some examples of the functions listed above:
>
> ```kotlin
> val one = '1'
> 
> val isDigit = one.isDigit()   // true
> val isLetter = one.isLetter() // false
> 
> val capital = 'A'
> val small = 'e'
> 
> val isLetterOrDigit = capital.isLetterOrDigit() // true
> 
> val isUpperCase = capital.isUpperCase() // true
> val isLowerCase = capital.isLowerCase() // false
> 
> val capitalEString = small.uppercase() // "E"
> val capitalE = small.uppercaseChar()   // 'E'
> ```

- Character 를 다루는 유용한 메소드가 있다.
- isDigit(), isLetter(), isWhitespace(), isLetterOrDigit()
- uppercaseChar(), uppercase()
- lowercaseChar(), lowercase()

