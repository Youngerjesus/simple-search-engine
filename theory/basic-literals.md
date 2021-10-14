# Theory: Basic literals

> Regardless of their complexity, all programs essentially perform operations on numbers, strings, and other values. These values are called literals i.e. in the most basic sense or meaning of the symbol. Before we start writing our first programs, let's learn the basic literals in Kotlin: integer numbers, characters, and strings. You can meet these literals everywhere in everyday life.

- 모든 프로그래밍에서 지원하는 타입들 (e.g string, number, characters 등) d에 대해서 알려주는 Theory 

***

## Integer numbers

> If an integer value contains a lot of digits, we can add underscores to divide the digits into blocks to make this number more readable: for example, 1_000_000 is much easier to read than 1000000.

- 숫자가 크다면 읽기 쉽게 _ 를 이용해서 연결하는게 가능하다. __(코틀린 언어의 특징중 실용적이다 라는게 이런 뜻인가?)__
- 대신에 _ 이 숫자보다 먼저오는건 당연히 안된다. 그리고 _ 가 마지막에 오는것도 당연히 안된다. 

***

## Characters

>  single character can represent a digit, a letter, or another symbol. To write a single character, we wrap a symbol in single quotes as follows: 'A', 'B', 'C', 'x', 'y', 'z', '0', '1', '2', '9'. Character literals can represent alphabet letters, digits from '0' to '9', whitespaces (' '), or some other symbols (e.g., '$').
>
> A character cannot include two or more digits or letters because it represents a single symbol. The following two examples are incorrect: 'abc', '543' because these literals have too many characters.

- character 를 사용하고 싶다면 '' 이걸로 감싸면 된다.
- character 는 한 글자만 의미하기 때문에 'abc' 같은 건 안된다. '543' 도 안됨.

***

## Strings

> To write strings, we wrap characters in double quotes instead of single ones. Here are some valid examples: "text", "I want to learn Kotlin", "123456", "e-mail@gmail.com". So, strings can include letters, digits, whitespaces, and other characters.

- string 을 사용하기 위해선 "" 이걸로 감싸면 된다.
- string 은 한 글자도 지원한다. 즉 "a" 같은게 가능하다.


