# Theory: Boolean and logical operations

> In this topic, we'll talk about Booleans. Boolean values are often used in programming. Basically, they represent two opposite states. For example, a boolean value can indicate:
> - whether a store is open;
> - whether a plane is up in the sky;
> - whether traveling is allowed;
> - whether an option is enabled, and so on.

- boolean 을 사용하는 경우는 요렇게 있다. 

***

## Boolean variables

> Boolean is a special data type that has only two possible values — true and false:
>
> ```kotlin
> val t = true  // t is true
> val f = false // f is false
> 
> println(t) // true
> println(f) // false
> ```
> 
> You cannot assign an integer value to a Boolean variable. In Kotlin, 0 is not the same as false.

- boolean 값은 true 와 false 이렇게 있다. 
- 그리고 Integer 값을 Boolean 변수에 저장하는건 불가능하다. (예로 자바스크립트는 0 값이 false 를 나타내기도 했는데 이런게 불가능하다. 라는 뜻)

***

## Reading Boolean values

> Since Kotlin 1.4, you can read a Boolean value like this:
> 
> ````kotlin
> val b: Boolean = readLine().toBoolean()
> ````
> 
> toBoolean() returns true if the input is "true", case insensitive. If otherwise, it will return false.
> 
> So, suppose you have the following input:
>
> ```
> true -> true 출력 
> TRue -> true 출력
> T -> false 출력 
> false -> false 출력
> ```
> 
> If your Kotlin is 1.3 or older, use readLine()!!:
> ```kotlin
> val b: Boolean = readLine()!!.toBoolean()
> ```
> 
> You can use readLine()!!.toBoolean() with any compiler version. Meanwhile, you can omit it in Kotlin 1.4 or higher.
> 
> Since Kotlin 1.5, you can use other functions to convert String to Boolean. The function toBooleanStrict() returns true if the string is equal to the word "true", case sensitive, and false if the string is equal to "false"; otherwise, your program will crash with the java.lang.IllegalArgumentException error. The function toBooleanStrictOrNull() returns true if the string is equal to the word "true", case sensitive, and false if the string is equal to "false"; otherwise, it returns a special value null. We will discuss it later.
>
> ````kotlin
> println("true".toBooleanStrict())     // true
> // println("True".toBooleanStrict())  // program crashes
> println("false".toBooleanStrict())    // false
> // println("faLse".toBooleanStrict()) // program crashes
>
> println("true".toBooleanStrictOrNull())  // true
> println("false".toBooleanStrictOrNull()) // false
> println("faLse".toBooleanStrictOrNull()) // null
> ````

- Kotlin 1.4 부터는 i/o 를 통해 Boolean 값을 읽어오는게 가능하다. 
- readLine.toBoolean() 함수를 통해 Boolean 값을 읽어오는게 가능한데 true 가 들어간 문자면 true 값으로 읽어오지만 그 외는 false 로 읽어온다.
- Kotlin 1.3 이하부터는 문법이 조금 다른데 readLine()!!.toBoolean() 이 함수로 읽어오면 된다. 이건 어떤 버전에서든 읽는게 가능하다.
- Kotlin 1.5 버전에 String 을 Boolean 타입으로 변환해주는 함수가 등장했는데 toBooleanStrict() 함수를 통해 가능하다. 이 함수의 경우에는 엄격해서 오로지 소문자의 true 만 Boolean 값으로 변경이 가능하다. 그 이외에는 java.lang.IllegalArgumentException 예외를 던진다.
- toBooleanStrictOrNull() 이라는 함수를 통해서도 String 을 Boolean 으로 변환하는게 가능한데 이 경우에는 예외를 던지지 않고 대신에 널값이 들어간다. 

***

## Logical operators

> Boolean type variables construct logical statements with the help of logical operators. Kotlin has four logical operators: NOT, AND, OR, and XOR:
> - NOT is a unary operator that reverses the Boolean value. It can be denoted with !.
> 
> ```kotlin
> val f = false // f is false
> val t = !f    // t is true
> ```
> 
> - AND is a binary operator that returns true if both operands are true. Otherwise, it returns false. It can be denoted with &&.
>
> ```kotlin
> val b1 = false && false // false
> val b2 = false && true // false
> val b3 = true && false // false
> val b4 = true && true  // true 
> ```
> 
> - OR is a binary operator that returns true if at least one operand is true. Otherwise, it returns false. It can be denoted with ||.
>
> ````kotlin
> val b1 = false || false // false
> val b2 = false || true  // true
> val b3 = true || false  // true
> val b4 = true || true   // true
> ````
> 
> - XOR (exclusive OR) is a binary operator that returns true if the Boolean operands have different values. Otherwise, it is false.
>
> ````kotlin
> val b1 = false xor false // false
> val b2 = false xor true  // true
> val b3 = true xor false  // true
> val b4 = true xor true   // false
> ````
>
> The XOR operator is not as popular as other logical operators. But you can still use it, just in case.

- Boolean 값은 논리 연산자와 같이 이용하는게 가능하다. 
- 즉 NOT, AND, OR, XOR 과 같이 사용하는게 가능하다. (이건 다른 프로그래밍 언어와 똑같아서 뭐 XOR 이 조금 특이한데 이 부분만 보면 될 것 같다.) 

***

## Logical operator precedence

> Take a look at the precedence of logical operations in Kotlin below. Precedence determines how other variables are grouped in the absence of parentheses:
> - ! for NOT
> - xor for XOR
> - && for AND
> - || for OR
> 
> So, the variable below is true:
>
> ```kotlin
> val bool = true && !false // true because !false is evaluated first
> ```
> 
> You can use parentheses (...) to change the order of execution.
>
> For example, let's write a Boolean expression that determines the possibility of going on a hike during the summer and in other seasons:
>
> ```kotlin
> val cold = false
> val dry = true
> val summer = false // suppose it is autumn now
> 
> val hiking = dry && (!cold || summer) // true, let's go hiking!
> ```
> 
> Do not get carried away by the expression above. A good programmer should understand not only arithmetic rules but also logical operations. Otherwise, you can end up hiking in bad weather.
  
- 그냥 뭐 괄호를 통해서 순서를 바꿀 수 있고 ! (NOT) 연산이 먼저 수행된다 라는 것. 