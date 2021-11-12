# Theory: Binary numbers

> Binary numeral system or base-2 numeral system is a way of writing numbers using only two digits, 0 and 1. Each digit is referred to as a bit (binary digit). These two digits are enough to represent any number. How is it possible? Let's find out.

***

## Decimal vs Binary

> In everyday life we use the decimal number system, or, simply put, we have 10 digits (0, 1, 2, 3, 4, 5, 6, 7, 8, 9). We don't think about it, but every number is represented as 1 * one of the digits + 10 * one of the digits + 100 * one of the digits etc. (that is, every power of 10 multiplied by some digit).
>
> Let's look at a number in the decimal system, for example, 4251. It is :
> 
> `4∗10^3 + 2∗10^2 + 5∗10^1 + 1∗10^0`
>
> So when we read this number, we just look at each digit starting from the last and multiply each digit by its corresponding power of 10: the rightmost is always 1, then goes 10, 100, 1000, and so on.
>
> In the binary number system, we do exactly the same, except the base is 2, not 10. Let's look at some number in the binary system, for example, 1011.
>
> `1∗2^3 + 1∗2^2 + 1∗2^1 + 1∗2^0`
>

- 대충 10진수 2진수 비교하는 내용. 

***

## Binary counting

> In the decimal numerical system, we have exactly 10 digits (from 0 to 9) to represent any number. We assume you know how to count in decimal: 0, 1, 2, ..., 9, 10, 11, ..., 19, 20, and so on.
>
> As you can see, we start from 0 as before, then comes 1, and then 10. So, binary counting goes like this: when a digit reaches 1, the next number resets this digit to 0 and causes the digit to the left to raise. After some practice it should become more clear.
  

***

## Zero padding

> Sometimes you will need to work with binary numbers of a fixed length. To do this, you can add insignificant zeros to any binary number on the left side, for example: 11 → 0011, 101 → 0101. This operation does not change the number but allows you to format them.
>
> You will often meet the following formats:
>  
> - triads: 000, 001, 010, and so on;
> - tetrads: 0110, 0111, and so on;
> - 8-digits numbers: 00000000, 01010101, and so on.

***

## Why & where

> Almost all modern digital devices use the binary number system. The reason for this lies in the hardware. As technology advanced, the computers started using transistors, which could be used to represent two states and quickly change from one to the other.
>
> If we look closer, even the computer memory is binary: we either have something in the memory cell or not. It is conventional to group information in 8-digits binary numbers, where each 8-digit number is referred to as byte. An 8-digits binary number may represent each of 256 possible values from 0 to 255, and can therefore be used for storing a wide variety of data. Such a way of storing information is called the binary code and is used almost everywhere. For example, an English text is usually encoded with ASCII (American Standard Code for Information Interchange) code, where each character in the text string is represented by 7-digit binary number (lowercase a is 1100001, and so on...).
>
> Colors can also be encoded that way. The RGB (stands for Red, Green, Blue) color encoding system stores 3 binary values for each color, representing the saturation of red, green, and blue color components respectively. The (11111111, 00000000, 00000000) color, for example, is pure red, with no shade of green or blue.
> 
> In fact, everything can be (and is) encoded using the binary code.
  


