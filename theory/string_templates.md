# Theory: String templates

> Sometimes you need to put values of variables in a text. Lucky for you, Kotlin can help you with that. Meet the string templates. In this topic, we will discuss their purpose.
> 
> Suppose we need to display a message about today's temperature in Celsius:
>
> `Now, the temperature in ... is ... degrees Celsius.`
> 
> Instead of `...` we need to display certain values.
>
> If we have two variables city and temp, we can build the resulting string with concatenations:
>
> ````kotlin
> val city = "Paris"
> val temp = "24"
>
> println("Now, the temperature in " + city + " is " + temp + " degrees Celsius.")
> ````
> 
> It is a simple solution. But perfect? No. It's rather awkward.
>
> Kotlin provides a more convenient way to do the same thing using string templates. How do they work? To add a variable value to a string, write the dollar sign $ before a variable name:
>
> ````kotlin
> val city = "Paris"
> val temp = "24"
> 
> println("Now, the temperature in $city is $temp degrees Celsius.")
> ````
>
> The code becomes more readable. Both code snippets print the same message:
>
> `Now, the temperature in Paris is 24 degrees Celsius.`
> 
> If we do not want to print a string, we can create a variable:
>
> ````kotlin
> val value = "55"
> val currency = "dollars"
> val price = "$value $currency" // "55 dollars"
> ````
> 
> We recommend using string templates to build strings with variable values. Try using it instead of string concatenation.

- String 사이에 변수를 끼워넣고 싶을 때 자바에서는 '+' 와 같은 연산을 통해 문자열을 이어주는 식으로 사용한다.
- 이 방법은 읽기에 약간 불편하다 코틀린은 $변수이름 이 방식을 통해서 변수 사이에 데이터를 출력하는게 가능하다. 읽는데 많은 도움을 준다.
***

## Templates for expressions

> You can use string templates to put the result of an arbitrary expression in a string. To do that, include the entire expression in curly braces {...} after the dollar sign $. For example:
> 
> ```kotlin
> val language = "Kotlin"
> println("$language has ${language.length} letters in the name")
> ```
> 
> It prints:
>
> ```kotlin
> Kotlin has 6 letters in the name
> ```
> 
> Here {language.length} is an expression that will be evaluated. If you skip the braces, it will output something different:
> 
> ```kotlin
> Kotlin has Kotlin.length letters in the name
> ```
> 
> So, always use curly braces for expressions in string templates to avoid these mistakes. Do not add them if you want to output only a variable value even though it does work.

- String template 안에서 단순히 변수 출력이 아니라 표현식을 사용하고 싶다면 ${} (괄호까지 포함된 식) 을 이용하면 된다. 

***

## Idiom

> Idioms are templates for clear and readable code. These patterns clarify the code for other people, so it is a good idea to use them. All idioms are endorsed by the community, so using them will bring you closer to the genuine Kotlin-style code. You can find an exhaustive list of idioms at Kotlin docs.
>
> The idiom we'll look at is the string interpolation:
>
> ```kotlin
> val language = "Kotlin"
> println("Have a nice $language!")        // nice code
> println("Have a nice " + language + "!") // bad practice
> ```

- 관용구를 사용하자. 