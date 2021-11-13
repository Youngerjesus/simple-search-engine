# Theory: Hexadecimal numbers

## Why HEX-a-decimal?


> For years before the invention of computers, people used the decimal (base-1010) system for counting – because it's convenient when you have 1010 fingers and 1010 toes.
> 
> In computers, however, there are only 22 options: on and off, which created the idea of a binary digit or bit, for short.
> 
> For convenience, computer engineers tended to group bits. In the 1960s, they could group 33 bits at a time: a group of 33 bits is base 2*2*2=2∗2∗2= base-88 number.
> 
> As computers got more powerful, people learned to cluster bits by 44 instead of 33. A group of 44 bits, written as one symbol, can have 1616 values instead of 88 – in other words, two times more than a group of 33 bits. So, this system is more compact than decimal, octal (base-88), and binary systems!
  
***

## Hexadecimal digits

> The hexadecimal number system uses numbers 0,1\dots90,1…9 and first six Latin letters: A, B, C, D, E, FA,B,C,D,E,F (corresponding to decimals 10,11\dots1510,11…15), as hexadecimal digits.
>
> The table below compares how numbers
>
> So, as you see, in HEX, when we run out of digits, we start using letters. How is the decimal number 1616 represented in HEX? The answer is 1010!
>
> It's better to write numbers with their base as a lower index, so you don't confuse decimal 1010 with a hexadecimal 1010: 10_{16}10 
>  
> If you are quick-thinking, you have already noticed those lower indices in the table above.
> 
> Other ways to avoid confusion are writing a HEX number with h after it or 0x before it. For instance, 63h, 0x63 and 63_{16}63 are three different ways to indicate that 6363 is a hexadecimal number.
  
***

## Binary to HEX and vice versa

> HEX is widely used in computer science because we can easily translate binary numbers into HEX. Moreover, HEX is (and has been created) as a simplified way to represent binary numbers.
>
> That means we can split (starting from the right, or, in other words, from the end) any binary number into a sequence of 44-digit binary numbers. These numbers are then mapped to HEX digits using the table above.
>
> So, if the leftmost number in our split sequence of 44-digit binary numbers contains less than 44 digits, we add leading zeroes to it until it is a 44-digit binary number and then match it, along with the rest in the sequence, to the corresponding HEX digit using the table. The resulting sequence is ready to be mapped to HEX digits using the table above.
>  
> Converting a hexadecimal number into a binary is even easier. Each HEX digit corresponds to the 44-digit binary sequence. All you have to do is map digits to sequences with the table.
  
***

## Applications of HEX

> We use the hexadecimal system to record error codes during the work of various software products. For example, operating system errors are encoded in this way. If you decode your error code, you'll find out the exact error that occurred. Besides, in URLs, character codes are written as hexadecimal pairs prefixed with %. You can see for yourself by googling a symbol @. The link in the address bar of your browser would look like that:
>
> The HEX numbers are also used for writing programs in low-level languages and in some encodings. For example, in Unicode (a computer standard for symbols encoding), every symbol is represented as a hexadecimal number. Even color schemes are encoded by HEX numbers. Thus, in RGB encoding, every color can be represented as 33 hexadecimal numbers, each for Red, Green, or Blue color components respectively. As you can see, HEX is used in many ways, so there is no doubt that this information will be of use to you in the future!
  

