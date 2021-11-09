# Theory: The concept of patterns

> If you are reading this, you must be really interested in programming. It doesn't matter whether you are an experienced developer, just starting your career, or still working on the basics; what really matters is that you are curious, so welcome.
>
> To begin with, let's talk about code design. In general, the design of your code is about expressing your ideas clearly to your teammates, colleagues, and clients. We can compare code to text: if you put the lines in the right order and make the structure clear, it will be much easier to explain and understand the text later. From an engineering point of view, your code is well-designed if you can agree with the following statements:
>
> 1) When you make a small change, it does not produce a ripple effect elsewhere in the code.
> 2) Your code is easy to reuse.
> 3) It is easy to maintain your code after release.

- 코드가 잘 짜였다는 기준. 
- 작은 변화를 만들기 쉽다.
- 재사용하기 쉽다.
- 유지보수하기 쉽다.

***

## Design patterns

> In application development, the design of code has to match the problem and be general enough in order to fit all the requirements that may arise in the future. Everyone tries to find more elegant, suitable and flexible solutions that can also be reused. Here is where design patterns come into play: these are repeatable solutions to common problems that developers face. Design patterns even have names! For example, if you want to confine yourself to just one instance of a class, Singleton pattern is going to be the best choice; if you see family relations between objects and you want to encapsulate creational process, you should use AbstractFactory, etc.
> 
> As a rule, examples of well-structured object-oriented architecture make use of patterns a lot. When a suitable pattern is used, it tells us that the developer has really paid attention to typical interactions between elements in the system. As a result, the architecture of an application becomes easier to understand.
>
> Being so useful, design patterns have made it onto many programmers' bookshelves: one of the most famous examples is the book Design Patterns: Elements of Reusable Object-Oriented Software. You probably heard about its authors, "Gang of Four", which is frequently abbreviated as "GoF". Today it is considered one of the classic books on software design and programming. You may check it out to deepen your understanding or proceed directly to practical learning here.
> 
> Note that in this topic we will only consider object-oriented design patterns.

- 어플리케이션 개발에더 design 과 관련된 영역으로는 design pattern 도 있다. 개발자들이 반복되는 문제에 대한 솔루션을 녹여낸 것으로 Reusable 이 가장 큰 특징

***

## Software design patterns and related concepts

> A great thing about patterns is that they help you not to waste your time reinventing the wheel so you can spend it on developing cool features instead. The structure of design patterns is strict: describe the problem, the solution, when to apply the solution, and its consequences. Theoretically, you can combine a few patterns and create your own monster pattern that contains, for example, Builder, Abstract Factory and Decorator simultaneously. However, as you will see from the following topics, it's better to avoid such monsters because patterns have already been well-grouped for you. In other words, don't get too excited, it's really better to use them one at a time.
> 
> Using patterns does not require any specific programming language skills or striking imagination. Patterns are also language-independent: even though they can be implemented differently in different languages, the general idea of each pattern is common for all of them. That means that it's possible for you to speak the language of architecture with your colleagues even if they work with different technologies.

- 디자인 패턴은 언어에 종속되지는 않는다.
- 여러 디자인 패턴을 합쳐서 자신만의 패턴을 만들 수도 있는데 이렇게는 하지말자. (뭘 하는지 알기 어렵기 떄문에.)

***

## Why should I know design patterns?

> Here is a list of quite convincing reasons to get familiar with design patterns:
> 
> - Patterns provide tested and commonly used solution templates for design problems; you don't have to invent anything!
> - Patterns improve flexibility and maintainability of object-oriented systems, which makes it easier to react to changing requirements.
> - Patterns can speed up the development process.
> - Patterns are a universal vocabulary that allows developers to describe a program design using a set of well-known identifiable concepts.
> - Patterns are often used in standard libraries and frameworks.
> - You can find patterns in the source codes of many applications and quickly understand how they work, instead of reading thousands of lines of code.

- 디자인 패턴을 알아야하는 이유.
  - 공통의 문제에 대한 솔루션, 템플릿을 제공해준다. 그러므로 구조를 잡는데 시간을 쓰지 않아도 된다. (개발 속도에 도움을 줄 수도 있겠지.)
  - 이러한 패턴은 좀 더 확장가능한 설계이다.
  - 많은 어플리케이션이나 라이브러리, 프레임워크에 사용되기도 해서 디자인 패턴을 알면 구조를 알기 쉽다. 
  - 개발자들이 사용하는 보편적인 단어이자 개념이다. (말을 이해하기가 쉬울 것.)   

***

##  Caveats

> In order to achieve flexibility, design patterns usually introduce additional levels of indirectness, which in some cases may complicate the resulting designs and hurt application performance. In other words, even though patterns are supposed to make things easier for you, they may also become an unnecessary complication if applied unwisely. Beginner developers may try to apply patterns everywhere, even in situations where a simpler code would do just fine. Look how design patterns can complicate even the simplest "Hello, World" program.
>
> To avoid misusing the patterns, you should apply them wisely and be able to correctly adapt them to your problem and language.

- 패턴을 너무 남용하지 말자. 디자인 패턴은 이후 미래의 확장성을 위해 좀 더 복잡한 구조를 가진다. 
- 간단한 문제를 위해서 디자인 패턴을 적용하는 실수를 하지말자. (YAGNI)

