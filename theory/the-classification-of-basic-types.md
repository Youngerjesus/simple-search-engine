# Theory: The classification of basic types

> In this topic, we will learn about the classification and properties of basic types in Kotlin. You may know some of them. Basic types can be separated into several groups according to their meaning. The types from the same group operate similarly, but they have different sizes and, as a consequence, represent different ranges of values.

- 기본 타입도 분류가 되고 각 분류마다 비슷하게 작동하지만 데이터 사이즈가 다를 수 있다. 

***

## Numbers

> Kotlin provides several types for integers and fractional numbers.
>
> Integer numbers (0, 1, 2, ...) are represented by the following four types: Long, Int, Short, Byte (from the largest to the smallest). These types have different sizes and may represent different ranges of values. The integer type range can be calculated as −(2n−1) to (2n−1)−1, where n is the number of bits. The range includes 0, that's why we subtract 1 from the upper bound.
> - Byte: 8 bits (1 byte), range varies from -128 to 127;
> - Short: 16 bits (2 bytes), range varies from -32768 to 32767;
> - Int: 32 bits (4 bytes), range varies from −(231) to (231)−1;
> - Long: 64 bits (8 bytes), range varies from −(263) to (263)−1.
>
> The size cannot be changed. It does not depend on the operating system or hardware.
> 
> The most common integer types are Int and Long. Try to stick to Int in practice. If you need more freedom for your numbers, use Long:
>
> ```kotlin
> val zero = 0 // Int
> val one = 1  // Int
> val oneMillion = 1_000_000  // Int
>  
> val twoMillion = 2_000_000L // Long because it is tagged with L
> val bigNumber = 1_000_000_000_000_000 // Long, Kotlin automatically chooses it (Int is too small)
> val ten: Long = 10 // Long because the type is specified
>  
> val shortNumber: Short = 15 // Short because the type is specified
> val byteNumber: Byte = 15   // Byte because the type is specified
> ```
>
> Floating-point types represent numbers with fractional parts. Kotlin has two such types: Double (64 bits) and Float (32 bits). These types can store only a limited number of decimal digits (~6-7 for Float and ~14-16 for Double). The Double type is more common in practice:
> 
> ```kotlin
> val pi = 3.1415  // Double
> val e = 2.71828f // Float because it is tagged with f
> val fraction: Float = 1.51 // Float because the type is specified
> ```
> To display the maximum and minimum value of a numeric type (including Double and Float), you need to write the type name followed by a dot . and then either MIN_VALUE or MAX_VALUE:
>
> ````kotlin
> println(Int.MIN_VALUE)  // -2147483648
> println(Int.MAX_VALUE)  // 2147483647
> println(Long.MIN_VALUE) // -9223372036854775808
> println(Long.MAX_VALUE) // 9223372036854775807
> ````
>
> It is also possible to get the size of an integer type in bytes or bits (1 byte = 8 bits):
>
> ````kotlin
> println(Int.SIZE_BYTES) // 4
> println(Int.SIZE_BITS)  // 32
> ````

- 코틀린은 숫자를 integer 와 fraction 으로 크게 구분한다.
- Integer 는 Byte, Short, Int, Long 으로 구성되어 있고 각 사이즈는 C 와 유사하다.
- Long 타입 같은 경우는 타입 추론 할 때 의도적으로 Long 타입을 표현하기 위해서 L 을 마지막 문자로 붙이면 된다.
- Fraction 은 Double 과 Float 이 있는데 double 이 좀 더 정확하다.
- 그리고 각 타입마다 최고 숫자와 최소 숫자를 출력하는게 가능하고 사이즈도 출력하는게 가능하다.

***

## Characters

> Kotlin has a Char type to represent various letter characters (uppercase and lowercase), digits, and other symbols. Each character is a letter character in single quotes. The size is similar to the Short type (2 bytes = 16 bits):
>
> ```kotlin
> val lowerCaseLetter = 'a'
> val upperCaseLetter = 'Q'
> val number = '1'
> val space = ' '
> val dollar = '$'
> ```
> Characters can represent symbols of many alphabets, including hieroglyphs and some special symbols, which we will consider later.

- Character 타입은 '' 으로 나타낸 한 글자를 말하며 주로 Symbol 을 나타낼 때 많이 사용한다.
- 타입으로 선언할 땐 Char 로 선언하면 되고 사이즈는 Short 와 같다.

***

## Booleans
> Kotlin provides a type called Boolean. It can store only two values: true and false. It represents only one bit of information, but its size is not precisely defined.
>
> ```kotlin
> val enabled = true
> val bugFound = false
> ```
> 
> We will often use this type in conditionals.

- Boolean 타입은 두 가지 종류의 값만 있다. true 와 false.
- 주로 조건절에서 많이 사용된다.
- 사이즈는 1비트다.

***

## Strings
> The String type represents a sequence of characters in double quotes. It is one of the most popular types.
>
> ```kotlin
> val creditCardNumber = "1234 5678 9012 3456"
> val message = "Learn Kotlin instead of Java."
> ```

- String 은 연속된 글자를 나타내며 "" 로 감싸서 표시된다.