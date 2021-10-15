# Theory: Values and variables

***

## What is a variable?

> A variable is a storage for a value, which can be a string, a number, or something else. Every variable has a name (or an identifier) to distinguish it from other variables. You can access a value by the name of the variable.
>
> Variables are one of the most often used elements in programs; therefore, it is important to understand how to use them.
  
- 그냥 뭐.. 변수는 값이 담기는 저장소다 이런 이야기.

***

## Declaring variables

> Before you can start using a variable, you must declare it. To declare a variable, Kotlin provides two keywords:
>
> val (for value) declares an immutable variable (just a named value or a constant), which cannot be changed after it has been initialized (this is ctually not entirely true, we will discuss this issue in more detail later);
> 
> var (for variable) declares a mutable variable, which can be changed (as many times as needed).
>
> When you declare a variable, you must add its name after one of these two keywords. Be careful: the name of a variable cannot start with a digit. Usually, it starts with a letter. You should choose meaningful and readable names for variables to make your code easy to understand.
>
> To assign a certain value to a variable, we should use the assignment operator =.
  
- 코틀린은 두 가지 타입을 지원한다. val 과 var 
- 차이는 val 은 변하지 않는 값이 담기고 var 은 변하는 값이 담긴다.
- 변수를 선언할 때 숫자가 먼저 이름에 나오면 안된다. 
- 이름 지을 때는 의미있는 이름으로 하자.

***

## Storing different types of values

> We've already mentioned that variables can store different types of values: strings, numbers, characters, and other data types, which we will encounter later.
> 
> There is one restriction for mutable variables (the ones declared with the keyword var), though. When reassigning their values, you can only use new values of the same type as the initial one. So, the piece of code below is not correct:
  
- Mutable variable 에는 한 가지 제약이 있는데 (즉 var 키워드로 선언한 변수들) 중간에 값을 변경할 때 처음에 선언한 타입과 다르다면 문제가 생긴다. 
- 즉 다음과 같은 경우에 문제가 생긴다.

```kotlin
var number = 10
number = 11 // ok
number = "twelve" // an error here!
``` 
