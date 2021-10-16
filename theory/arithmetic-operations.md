# Theory: Arithmetic operations

***

## Binary operators

> Kotlin has five arithmetic operators:
> - addition +
> - subtraction 
> - multiplication *
> - integer division /
> - modulus %
>
> These operators are binary, which means they take two values as operands.
> 
> The piece of code below prints the results of addition, subtraction, and multiplication:
>
> ```kotlin
> println(13 + 25) // prints 38
> println(20 + 70) // prints 90
> 
> println(70 - 30) // prints 40
> println(30 - 70) // prints -40
> 
> println(21 * 3)  // prints 63
> println(20 * 10) // prints 200
> ```
> 
> The / operator divides the integer parts of two numbers; the fractional part is discarded. You may read about modulo division in our [topic](https://hyperskill.org/learn/step/10586).
>
> ```kotlin
> println(8 / 3)  // prints 2
> println(41 / 5) // prints 8
> ```
>
> The % operator finds the remainder of a division:
>  
> ````kotlin
> println(10 % 3) // prints 1 because 10 divided by 3 leaves a remainder of 1
> println(12 % 4) // prints 0 because 12 divided by 4 leaves no remainder
> ````
> 
> As you may know, division with negative numbers is different. You may read our topic to find more. Let's look at how it works in Kotlin:
>
> Example 1.
> - Expression: 11 / -4 
> - Quotient: -2
> - Remainder: 3
> - The result : 11 = -4 * -2 + 3 
>
> Example 2.
> - Expression -11 / 4
> - Quotient: -2
> - Remainder: -3
> - The result: -11 = 4 * -2 + (-3)
>
> ````kotlin
> println(11 / -4)   // prints -2
> println(11 % -4)   // prints 3
> println(-11 / 4)   // prints -2
> println(-11 % 4)   // prints -3
> println(-11 / -4)  // prints 2
> println(-11 % -4)  // prints -3
> ````
> 
> Since Kotlin 1.5, you may also use another type of division. All you need is to use floorDiv instead of / and mod instead of %:
>
> Division examples in Kotlin:
>
> ````kotlin
> println(11.floorDiv(-4))    // prints -3
> println(11.mod(-4))         // prints -1
> println((-11).floorDiv(4))  // prints -3
> println((-11).mod(4))       // prints 1
> println((-11).floorDiv(-4)) // prints 2
> println((-11).mod(-4))      // prints -3
> ````

- Binary Operator 란 피연산자 (operand) 가 두 개 있는 걸 의미한다.
- +, -, * 같은 경우는 특별한게 없다.
- /, % 가 중요한데 / 같은 경우 정수끼리 계산에서 fractional (소수) 부분은 버린다.
- / 와 % 는 음수 연산할 때 좀 더 다른데 결과를 만드는데 주목하면 쉽다.
- 11 / -4 를 계산한다고 해보면 몫은 -2 이고 나머지는 3이다. 몫과 나머지를 통해서 11을 만든다고 생각하면 계산이 편하다.
- -11 / 4 는 목은 -2 이고 나머지는 -3 이다. 이도 똑같다.
- Kotlin 1.5 에서 부터는 / 대신 floorDiv() 라는 메소드를 사용하면 되고 % 같은 경우는 mod 라는 메소드를 사용하면 된다. 이게 더 가독성이 있다.

***

## Complex expressions

> You can combine arithmetic operations to write complex expressions:
> 
> ```kotlin
> println(1 + 3 * 4 - 2) // prints 11
> ```
> 
> The calculation order coincides with the rules of arithmetic operations. Multiplication has a higher priority than addition or subtraction, so 3 * 4 is calculated first.
> 
> Consider an expression as a part of code that produces a value (for example, 14 + 5 or 15 - 3 * 4). Further, we will take a closer look at expressions.
>
> Use parentheses to specify the order of execution. Let's take a look at the example below:
> 
> ````kotlin
> println((1 + 3) * (4 - 2)) // prints 8
> ````
> 
> Parentheses can be nested. You can also use them to simplify the notation.
> 
> For example, here is a program that prints all digits of the number 54 in reverse order. We will use arithmetic operations to extract the digits.
>
> ```kotlin
> fun main() {
>     println(54 % 10) // it prints 4
>     println((54 / 10) % 10) // it prints 5
> }
> ```
> 
> The program outputs:
>
> ```
> 4
> 5
> ```

- 복잡한 연산인 경우에는 () 를 통해서 연산의 우선순위를 지정해주면 된다. 

***

## Unary operators

> A unary operator takes a single value as the operand.
> - A unary plus just gives you a value. It is an optional operator, so you omit it in practice:
> ```kotlin
> println(+5) // prints 5
> println(+(-5)) // prints -5
> ```
> 
> - A unary minus negates a value or expression:
>
> ```kotlin
> println(-8)  // prints -8
> println(-(100 + 4)) // prints -104
> ```
>
> They both have higher precedence than the multiplication and division operators.

- Unary Operators 는 하나의 피연산자만으로 할 수 있는 연산을 말하며 + 와 - 를 숫자에 붙이는게 있다.
- `+` 같은 경우는 생략해도 된다. 

***

## Precedence order

> They both have higher precedence than the multiplication and division operators.
> 1. Parentheses;
> 2. Unary plus/minus;
> 3. Multiplication, division, and modulus;
> 4. Addition and subtraction.
>
> Mind this order: it's important for correct calculations.
  
- 연산의 숫자는 이 순서대로 진행한다고 한다. 딱히 특별한건 없다. 

