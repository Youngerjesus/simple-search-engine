# Theory: Unicode

> As you know, computers operate in binary code so, naturally, all different kinds of symbols that we use need to be transformed into numbers. For this purpose, different encodings were created and implemented over the years.
>
> symbols based on the English alphabet. It wasn't perfect for everyone for several reasons. First, computers started to use 8-bit sequences, bytes, for storing information and ASCII strings had extra memory that wasn't being used. Second and most important, 128 symbols just wasn't enough for everyone, not even for the English script itself. There was a clear need for new, improved encodings and many of them started to appear after ASCII. There were extensions of the ASCII (like ISO-8859-1) or encodings for specific scripts (for example, Windows-1251 for Cyrillic). However, in different encodings, the same number could represent different symbols and that would complicate the communications. The solution to all these problems had to be a unified system and that is when Unicode comes in.

- ASCII 코드의 문제점을 해결하기 위해서 Unicode 가 등장했다. (bit 낭비와 표현할 수 있는 Symbol 개수를 다 표현하지 못함.)

***

## What is Unicode?

> Unicode is a standard for encoding and representing texts. It is not an encoding per se since it doesn't determine how symbols are converted to bytes. It is simply a specification: a table that defines the mapping between symbols and numbers.
>
> The Unicode Standard was proposed in 1991 by Unicode Consortium. As the name suggests, Unicode was intended as a universal standard and it's safe to say that now it is.
>
> Unicode can also be viewed as an extension of the ASCII table: in fact, the first 128 numbers in the Unicode represent ASCII symbols. All in all, Unicode can accommodate 1 112 064 code units, but as of May 2019, only 137 994 are occupied. The fact that most code units aren't designated yet is also one of the Unicode's advantages. It means that for years and years to come, we can add new letters, scripts, punctuation marks and pictograms to the standard without running out of space.

***

## How does Unicode look?

> Unicode consist of two parts: Universal character set, UCS and Universal transformation format, UTF.
> 
> UCS is essentially an index of all symbols supported by the Unicode and codes for those symbols. Let's take a look at a segment of this index. This is a part of Basic Latin, the symbols that have traveled from ASCII:
>
> In Unicode, every symbol corresponds to a hexadecimal number — a code point. The code for the symbol starts with U+ followed by the corresponding code point value. The hexadecimal number in the code has from 4 to 6 digits depending on its place in the standard. For example, the code for the Latin Capital Letter Q is U+0051.
> 
> By looking at the table, you can see that Q is at the intersection of row 0050 and column 1 which is where the code number comes from. Most Unicode codes are easily transformed into HTML codes: you just need to convert the hexadecimal number to decimal and write it in an HTML format. The HTML code for the letter Q is then &#81;. You can check if hexadecimal 51 equals decimal 81.
>
> Unicode code points are divided into 17 planes with numbers from 0 to 16. Each plane is a continuous group of 65 536 (2^{16}) code points. The plane with the number 0 is called Basic Multilingual Plane (BMP) and it contains characters for most modern writing systems and languages as well as many symbols. They have codes from U+0000 to U+FFFF. The ASCII part of the BMP includes the first 128 characters, from U+0000 to U+007F.
> 
> The rest of the planes (1 through 16) are called "supplementary planes". Most of the supplementary planes are unassigned and empty which leaves room for additions.
>
> The Supplementary Multilingual Plane (SMP) (codes from U+10000 to U+1FFFF) is next plane after BMP. It includes many historic scripts and, what is quite interesting, special characters and symbols. SMP has musical notations, alchemical symbols, geometric shapes, and even emojis! If your favorite programming language supports Unicode strings, chances are you can put emojis or other interesting characters in your strings!

- Unicode 는 두 가지 부분으로 이뤄진다. UCS (Universal character set) 와 UTF (Universal transformation format) 
- Unicode 는 그리고 HTML 에서 표현이 가능하다. (&#81 여기서 81은 10진수를 나타냄.)
- Unicode 는 그리고 0 ~ 16 가지의 Plane 으로 쪼개져있다. (Plane 이 그룹핑을 말하는 듯.)
- 기본 0 Plane 은 Basic Multilingual Plane (BMP) 로 표시되며 일반적인 언어에서 쓰는 심볼들이 모두 다 있다. (아스키코드도 포함.)
- SMP 는 BMP 다음으로 오는 Unicode plane 으로 특수하 문자들, 기하하적 문자, emoji 등이 포함되어있다.

***

## Unicode Implementation

> We've already mentioned that along with UCS Unicode has UTF — Universal transformation format. UTF is a set of encodings that support Unicode. Encodings describe how symbols (or, rather, their code points) are transformed into bytes according to a particular character set and vice versa. There are several UTF encodings, but the most popular are UTF-8 and UTF-16. In addition to that, UCS-2 encoding is sometimes used. However, this encoding isn't defined in the Unicode Standard and it doesn't cover all of UCS: only the BMP part.
> 
> UTF-8 is the most commonly used encoding in the world as around 94% of the Internet is encoded in UTF-8. UTF-8 uses from 1 to 4 bytes and is capable of representing all code points of the Unicode. UTF-8 is also backward compatible with ASCII. UTF-16 is similar and the difference between the two is mostly technical. You could use UTF-16, of course, but we recommend to stick to UTF-8 like most of the Internet.

- UTF 는 Symbol 을 UCS 에 해당하는 바이트로 변환하는 방법(?) 을 나타냄. 
- 주로 사용하는게 UTF-8 이고 이는 1 ~ 4 바이트까지의 가변 인코딩을 지원한다 라는 것. 
- UTF-8 은 아스키코드와 호환이 되지만 UTF-16 은 그렇지 않은듯. 그래서 UTF-8 사용을 권장하고. 





