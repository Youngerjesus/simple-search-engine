# Theory: Design principles

> Creating software is like engineering: if a crucial part breaks, everything fails. How can we prevent such a disaster? Of course, we can test our programs, but is it sufficient? A program that passes all the tests might still have other problems:
>
>It can have a bad design, so no one uses it
> We cannot extend any part of it and add new features, because it's hard to understand how it works
> In this topic, we will talk only about the inner design of the applications and what helps us to improve and evolve it over time.

- 어플리케이션의 내부 디자인에 대해서 이야기하는 Theory (확장가능한 설계에 대해서)

***

## Program design

> All programs manipulate data, and although all the programs are different, let's think of them as pipelines with data: a program receives some input, processes it, and produces some output. A program can be like a maze:
>
> The data comes from one function to another, and so on, and in the end, we get the result. It seems like we can control the data, but if there is an obstacle in our way, we are facing a complex problem. Moving only by straight paths doesn't save us from the growing complexity.
>
> However, a program can have a different structure:
> 
> We keep the diversity of data paths but organize the code the other way. We can say that we have another design for the program. The design of a program is the way to organize the code structure to achieve its primary goals.
>
> Making a good design from scratch is not that simple, and we often don't know all its requirements in the very beginning. What we surely can do is follow guidelines or principles to make the design more effective and clear.

- 모든 프로그램들이 하는 동작은 데이터를 받아서 processing 하고 result 를 만드는 일이다. 
- 이 과정이 미로처럼 복잡하다면 어떻게 동작하는지 이해하기 어렵고, 확장하기 힘들자.
- 반대로 데이터 플로우가 트리처럼 구성되어 있다면 (어떤 기준으로 path 가 나뉘는지, 추상화가 잘되어있다는지) 이러면 데이터가 어떻게 처리되는지 이해하기 쉬울것.
- 그리고 좋은 디자인을 한번에 하기는 힘들다. (많은 요구사항을 한번에 모두 이해하기도 힘들고, 요구사항이 변경될 가능성이 있으니까.) 그러므로 좋은 디자인을 따르기 위해서는 계속해서 좋은 디자인 쪽으로 변경해 나가는 것 이라고 생각한다. 규칙과 원칙을 가지고. 

*** 

## Design principles

> As we already know, applications have a design, but what can help us to make it better?
>
> Design principles are rules that guide you to better decisions for the design of your program. You can refer to them when you want to add or update any part of the code.
> 
> Some of them come almost from common sense:
> - Don't Repeat Yourself (DRY)
> - You Ain't Gonna Need It (YAGNI)
> - Keep It Simple, Stupid (KISS)
> 
> As you can guess, the DRY principle means, it's better to reuse code instead of copying it from one place to another. YAGNI is the principle of doing only the work that you need and not doing anything else. KISS stands for making the code simpler for better understanding.
>
> Not all principles are easy to learn. Some of them, like GRASP (General Responsibility Assignment Software Patterns) is a whole ecosystem with many design patterns included and mostly adhere to object-oriented programming.
> 
> The other principles do not involve any additional knowledge, but it takes time to understand their meaning and significance. Let's look at another five software design principles hiding by the SOLID acronym.

- 디자인 원칙들에 대해서 DRY, YAGNI, KISS
- 객체지향에서 사용하는 원칙 GRASP
  - https://github.com/Youngerjesus/object-oriented-programming/blob/master/documents/grasp.md
- SOLID 원칙 등

***

## SOLID

> There is no one design principle to follow when designing your program. Why? Because as your program grows, it becomes more complex. You will need to familiarize yourself with different approaches to help manage your program through different kinds of complexities. To make the path to our goals smooth, we can rely on SOLID design principles.
>
> Each letter in SOLID refers to a distinct design principle:
> - Single Responsibility Principle (SRP)
> - Open-Closed Principle (OCP)
> - Liskov Substitution Principle (LSP)
> - Interface Segregation Principle (ISP)
> - Dependency Inversion Principle (DIP)
> 
> That's a whole world behind this term! Each principle is independent of others, but applying them together works as a synergy for your design.
>
> SOLID principles help you to organize your code in a way that any other developer familiar with these principles can use and extend it. Applying them, you make your code more structured and clean, so it doesn't look like a maze anymore.

- SOLID 원칙을 프로그램에 적용시켜서 코드의 복잡도를 낮춰보자. 




