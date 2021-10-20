# Theory: Increment and decrement

***

## Assignment operations

> You already know that Kotlin supports basic arithmetic operations such as addition and subtraction:
> 
> ```kotlin
> var a = 3
> a = a + 1 // 4
> a = a - 1 // 3
> ```
> 
> Besides this, there are assignment operations that combine arithmetic operations and assignments. The assignment operator = has several forms that combine it with an operation to avoid repeating the variable twice:
> - += assignment after addition: A += B equals A = A + B 
> - -= assignment after subtraction: A -= B equals A = A - B
> - *= assignment after multiplication: A *= B equals A = A * B
> - /= assignment after division: A /= B equals A = A / B
> - %= assignment of the remainder after division: A %= B equals A = A % B
> 
> Let's take a look at assignment operations performed on a single variable. Here is something very basic:
>
> ```kotlin
> var a = 3
> a += 2 // 5
> a -= 2 // 3
> a *= 2 // 6
> a /= 2 // 3
> a %= 2 // 1
> ```
> 
> Here, we performed calculations with number 2 and our variable a and then assigned the values to it. As you can see, these operations made the code shorter and clearer.

- Kotlin 에서도 일반 프로그래밍 언어에서 지원하는 Assignment Operations 을 지원한다. (대입 연산 + 산술 연산을 합친 것)

## Using increment and decrement

> Another common operation is increasing or decreasing a number by one. Of course, you can use += 1 or -= 1, but Kotlin provides an even better way to do this: increment and decrement operations. Let's look at an example:
> 
> ```kotlin
> var num = 3
> num++  // 4, increment
> num--  // 3, decrement
> ```
> The code above is actually the same as below:
>
> ```kotlin
> var num = 3
> num += 1  // 4
> num -= 1  // 3
> ```
> 
> As you can see, increment ++ does the same as +=1 but in a simpler way. The same is true for decrement --.
>
> `Note that this works only when you are increasing or decreasing a number by one.`
> 
> This looks easy, but increment and decrement operations are more complicated than you might think. Both increment and decrement operators have two forms that are very important to distinguish: prefix and postfix.

- 값 1만 증가시키거나 1만 감소시키고 싶다면 ++ 나 -- 연산자를 이용하면 된다. (이걸 더 추천한다. 더 이해하기가 쉬워서인듯.)
- 이런 연산자에서 중요한 점은 숫자 앞에 붙는지 (prefix) 로 쓰는지, 숫자 뒤에 쓰는지 (postfix) 로 쓰는지가 중요하다.

## Prefix form

> Prefix form changes the value of a variable before it is used. Let's look at some examples.
>
> Prefix increment returns the incremented value:
>
> ```kotlin
> var a = 10
> val b = ++a
> println(a)  // a = 11
> println(b)  // b = 11
> ```
> 
> First, the value of the variable a is increased by one, and then its value is assigned to the variable b. So, a and b are both 11.
>
> Prefix decrement returns the following:
>
> ```kotlin
> var a = 10
> val b = --a
> println(a)  // a = 9
> println(b)  // b = 9
> ```
> 
> Here, you see the same thing happening: the value of the variable a is decreased by one, and then its value is assigned to the variable b.

- Prefix 로 ++ 나 -- 를 사용한다면 실제 사용하기 전에 값이 1이 더해지거나 빼지거나 되어 있다는 점이다.  

## Postfix form

> By contrast, postfix form changes the value of a variable after it is used. Let's look at the examples.
>
> Postfix increment returns the value before incrementing by one:
>
> ```kotlin
> var a = 10
> val b = a++
> println(a)  // a = 11
> println(b)  // b = 10
> ```
> 
> First, the value of the variable a is assigned to the variable b, and then the value of the variable a is increased by one. This way, a is 11 and b is 10.
>
> Similarly, postfix decrement returns the following:
>
> ```kotlin
> var a = 10
> val b = a--
> println(a)  // a = 9
> println(b)  // b = 10
> ```

- Postfix 는 Prefix 와는 반대로 값을 사용하고나서 업데이트를 하는 식으로 사용된다.

## Order of precedence

> Some operations take precedence over others, that is, they are performed first. Take a look at the list of operations in decreasing order of priority:
> 1. Parentheses ( (expr) );
> 2. Postfix increment/decrement ( expr++, expr--);
> 3. Unary plus/minus, prefix increment/decrement ( -expr, ++expr, --expr );
> 4. Multiplication, division, and modulus ( *, /, % );
> 5. Addition and subtraction ( +, - );
> 6. Assignment operations ( =, +=, -=, *=, /=, %= ).
> 
> The priority of operations should be taken into account when executing a set of arithmetic expressions:
>
> ````kotlin
> val a = 2
> var b = 3
> val c = a + 4 * --b  
> println(c)   // this is 10
> ````
> 
> Decrement has a higher priority than multiplication and addition, so --b is calculated first. Like in arithmetic, parentheses can be used to increase the priority of operation. You can also use them for clarity:
>
> ````kotlin
> var a = 5
> val b = 9
> val c = 3
> val d = a++ + (b / 2) - c - 4
> println(d)   // this is 2
> ````

- 연산도 우선순위가 있다라는 것. 
- Postfix 가 2번째의 우선순위를 가지고 있는데 postfix 는 값을 반환하고 나서 업데이트 시키므로 연산식 안에서는 값을 증가시켜 놓지는 않는다. 이를 알아두자.
- 반대로 Prefix 는 값을 업데이트 하는게 먼저이므로 업데이트 된 값을 사용한다.





