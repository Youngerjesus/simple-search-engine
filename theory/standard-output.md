# Theory: Standard output

> Standard output is the basic operation that displays information on a device. Not every program generates such output. By default, the standard output displays the data on the screen, but it is possible to redirect it to a file. On Hyperskill, you will often write programs that send data, for example, strings and numbers, to the standard output.
>
> On Hyperskill, you will often write programs that send data, for example, strings and numbers, to the standard output.

- Standard Output 은 정보를 디바이스에 표시하기 위한 것. 

***

## Printing text

> Kotlin has two functions that send data to the standard output: println and print.
>
> The println function (print line) displays a string followed by a new line on the screen. For example, the code snippet below prints four lines:
>
> ```kotlin
> println("I")
> println("know")
> println("Kotlin")
> println("well.")
> ```
> 
> Output 
> ```
> I
> know
> Kotlin
> well.
> ```
> As you can see, all strings are printed without double quotes.
> You can also print an empty line:
>
> ```kotlin
> println("Kotlin is a modern programming language.")
> println() // prints an empty line
> println("It is used all over the world!")
> ```
>
> Output:
> ```
> Kotlin is a modern programming language.
>  
> It is used all over the world!
> ```
> 
> The print function displays a value and places the cursor after. Let's look at the example below. This piece of code outputs all strings in a single line:
>
> ````kotlin
> print("I ")
> print("know ")
> print("Kotlin ")
> print("well.")
> ````
> 
> Output:
> ```
> I know Kotlin well.
> ```

- Kotlin 에서 제공하는 Standard Output 함수는 크게 두 가지다. print 함수와 println 함수. 
- println 함수는 print line 이라는 뜻으로 문자열 다음에 줄바꿈이 수행된다.
- print 함수 같은 경우에는 값을 출력하고 커서를 문자 다음으로 옮기는 식으로 진행된다. (즉 줄바꿈 같은건 없다.) 

***

## Printing numbers and characters

> With println and print functions, a program can print not only strings but also numbers and characters.
>
> Let's print two secret codes:
>
> ```kotlin
> print(108)   // prints a number
> print('c')   // prints a character
> print("Q")   // prints a string
> println('3') // prints a character that represents a digit 
>
> print(22)
> print('E')
> print(8)
> println('1')
> ```
> 
> Output:
> ```
> 108cQ3
> 22E81
> ```

- print 와 println 함수 같은 경우는 String 만 출력하는게 아니라 숫자와 Character 타입도 출력이 가능하다. 
 
